package seleniumTests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.QAClickForgotPwdPage;
import pageObjects.QAClickLandingPage;
import pageObjects.QAClickLoginPage;
import resources.Base;

public class QAClickForgotPwd extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(QAClickForgotPwd.class.getName());

	@BeforeTest
	public void launch() throws IOException 
	{
		log.info("launch");
		//driver = initializeBrowser();

	}
	
	@Test(dataProvider="getData", enabled=true, groups="QAClick")
	public void QAClickForgotPassword(String user, String password) throws IOException
	{
		driver = initializeBrowser();
		log.info("driver is initialized");
		
		driver.get(getURL("qaClick"));
		//takeScreenshot(driver);
		
		log.info("getURL(\"QAClickLogin\") fetches url from global properties file");
		//driver.findElement(By.cssSelector("input[name='unknow']")).click(); //fails
		QAClickLandingPage QAClandP = new QAClickLandingPage(driver);
		log.info("page object is initialized");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//		log.warn("explicitly wait for loginBtn to be clickable for 90s");
		
//		wait.until(ExpectedConditions.elementToBeClickable(QAClandP.noThanksBtn()));
//		log.info("explicitly wait until noThanksBtn is clickable");
//		QAClandP.noThanksBtn().click();
		
		QAClickLoginPage QAClogin= QAClandP.login();
		log.info("loginBtn is clicked");

		
		QAClogin.userEmail().sendKeys(user);
		QAClogin.password().sendKeys(password);
		QAClickForgotPwdPage QACfp = QAClogin.forgotPassword();
		
		QACfp.emailAddress().sendKeys("fredo@mail.com");
		QACfp.sendMeInstruction();
		
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0] = "fred@example.com";
		data[0][1] = "password1";
		//2nd set of details
//		data[1][0] = "efe@example.com";
//		data[1][1] = "password2";
		
		return data;
		
	}
	
	

	
	@AfterTest
	public void cleanUp() {
		if(driver != null)
		{
			driver.quit();
		}
	}


}
