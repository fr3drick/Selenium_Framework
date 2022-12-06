package seleniumTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Check {
    
    public static void main(String[] args) throws IOException{

       Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		//load path to properties file into properties object
		prop.load(fis);
        System.out.println(prop.getProperty("browser"));

        // WebDriver driver;
        // SeleniumManager.getInstance();
        // ChromeOptions browserOptions = new ChromeOptions();
        // browserOptions.setPlatformName("Windows 10");
        // browserOptions.setBrowserVersion("latest");
        // Map<String, Object> sauceOptions = new HashMap<>();
        // sauceOptions.put("build", "<your build id>");
        // sauceOptions.put("name", "<your test name>");
        // browserOptions.setCapability("sauce:options", sauceOptions);

        // URL url = new URL("https://fr3do:2e07255f-ce0a-4c65-81e8-79a400398bcb@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        // driver = new RemoteWebDriver(url, browserOptions);

        // driver.get("http://qaclickacademy.com/");
        // // System.out.println(QAClandP.navBarLinks().get(0).getText());
        // System.out.println(driver.findElements(By.cssSelector("ul.navbar-right a"))
        // .get(0).getText());

        // driver.quit();

    }

}
