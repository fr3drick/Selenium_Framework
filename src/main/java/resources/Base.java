package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	
	
	public WebDriver driver;
	public Properties prop;
	public String browserName="";

	
		public WebDriver initializeBrowser()  {
		
		SeleniumManager.getInstance();
			
//		SeleniumManager handles webDriver management internally, no need for wdm		
//		WebDriverManager.chromedriver().setup();
		
		prop = new Properties();
		
		try
		{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		//load path to properties file into properties object
		prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FIS class cannot reach properties file, check file system\n"		
		+ "However browser has been defaulted to chromeheadless");
			prop.setProperty("browser", "chromeheadless");
			
		}
		catch(IOException e)
		{
			System.out.println("FIS cannot load properties file, check file system access\n"
					+ "However browser has been defaulted to chromeheadless");
			prop.setProperty("browser", "chromeheadless");
		}
		
		
		
//		String browserName="";
		
// 		System.getProperty("browser") allows tester to specify the browser to be used directly on the Maven CLI
		if(System.getProperty("browser")!=null) 
		{
			browserName = System.getProperty("browser");
		}
		else
		{
			browserName = prop.getProperty("browser");
		}
		
//	browser information can be provided in data.properties or as arguments when initiating test
		
			if(browserName.contains("chrome")) 
			{
				ChromeOptions options = new ChromeOptions();
				options.setAcceptInsecureCerts(true);
				if(browserName.contains("headless")) options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			else if(browserName.contains("firefox"))
			{
				//firefox code
			}
			else if(browserName.contains("edge"))
			{
				EdgeOptions options = new EdgeOptions();
				options.setAcceptInsecureCerts(true);
				
				if(browserName.contains("headless")) options.addArguments("--headless");
	
				driver = new EdgeDriver(options);
			}
			else if(browserName.contains("remote"))
			{

			}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
				
		return driver;
		
		
	}
	
	public String getURL(String urlKey) {
	Properties prop = new Properties();
	FileInputStream fis;
	try
	{
	
	fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	}
	catch(FileNotFoundException e)
	{
		System.out.println("FIS class cannot reach properties file, check file system");
		
	}
	catch(IOException e)
	{
		System.out.println("FIS cannot load properties file, check file system access");
	}
	//load path to properties file into properties object
	
	return prop.getProperty(urlKey);
	
	
	}
	
	public void takeScreenshot(String testMethodName, WebDriver driver)
	{
		try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\screenshots\\"+testMethodName+".png";
		FileUtils.copyFile(src, new File(path));
		}
		catch(NullPointerException e)
		{
			System.out.println("cannot take screenshot as driver is null");
			
		} catch (IOException e) {
			
			System.out.println("IO exception while saving screenshot");
			e.printStackTrace();
		}

		
	}
	

	public void takeScreenshot(WebDriver driver) //overloading the takeScreenshot method, this can be used freely
	{
		try
		{
			Random rand = new Random();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\screenshots\\error"+rand.nextInt(100)+".png";
		FileUtils.copyFile(src, new File(path));
		}
		
		catch(NullPointerException e)
		{
			System.out.println("cannot take screenshot as driver is null");
			
		} catch (IOException e) {
			
			System.out.println("IO exception while saving screenshot");
			e.printStackTrace();
		}
		
	}
	
	
}
