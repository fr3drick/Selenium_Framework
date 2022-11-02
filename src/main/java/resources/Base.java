package resources;


import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	public WebDriver driver;
	public Properties prop;
	public String browserName="";

	
		public WebDriver initializeBrowser() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		//load path to properties file into properties object
		prop.load(fis);
//		String browserName="";
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
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("latest");
				Map<String, Object> sauceOptions = new HashMap<>();
				sauceOptions.put("build", "1.0");
				sauceOptions.put("name", "E2E Framework");
				browserOptions.setCapability("sauce:options", sauceOptions);

				URL url = new URL("https://oauth-fredrickirubor-e8012:23138aef-0998-4d9a-86ac-99eb9d95a212@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
				driver = new RemoteWebDriver(url, browserOptions);
			}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	public String getURL(String urlKey) throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	//load path to properties file into properties object
	prop.load(fis);
	return prop.getProperty(urlKey);
	
	
	}
	
	public void takeScreenshot(String testMethodName, WebDriver driver) throws IOException
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\screenshots\\"+testMethodName+".png";
		FileUtils.copyFile(src, new File(path));
		
	}
	

	public void takeScreenshot(WebDriver driver) throws IOException //overloading the takeScreenshot method, this can be used freely
	{
		Random rand = new Random();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\screenshots\\error"+rand.nextInt(100)+".png";
		FileUtils.copyFile(src, new File(path));
		
	}
	
	
}
