package seleniumTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.QAClickLandingPage;
import resources.Base;

public class QAClickCheckTitle extends Base {

	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(QAClickCheckTitle.class.getName());
	
	@Test
	public void checkTitle() throws IOException
	{
		driver = initializeBrowser();
		log.info("driver is initialized");
		driver.get(getURL("qaClick"));
//		driver.findElement(By.cssSelector("input[name='unknow']")).click(); //fails

		QAClickLandingPage QAClandP = new QAClickLandingPage(driver);
		System.out.println(QAClandP.navBarLinks().get(0).getText());
		
	//	takeScreenshot(driver);
		
		Assert.assertTrue(driver.getTitle().contains("a"),"title not validated");
		log.info("page title is validated ok");
	
}
	
	@AfterTest
	public void cleanUp() {
		if(driver != null)
		{
			driver.quit();
		}
	}

	
}
