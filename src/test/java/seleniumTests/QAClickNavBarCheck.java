package seleniumTests;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.QAClickLandingPage;
import resources.Base;

public class QAClickNavBarCheck extends Base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(QAClickNavBarCheck.class.getName());
	
	@Test
	public void navBarCheck() throws IOException
	{
		driver = initializeBrowser();
		log.info("driver is initialized");
		//driver is returned by initializeBrowser()
		driver.get(getURL("qaClick"));
//		driver.findElement(By.cssSelector("input[name='unknow']")).click(); //fails

		QAClickLandingPage QAClandP = new QAClickLandingPage(driver);
		System.out.println(driver.getTitle());
//
//		List<WebElement> displayedNavLinks = QAClandP.navBarLinks().stream().filter(s->s.isDisplayed()).collect(Collectors.toList());
//		log.info("collect only links that are displayed");
//		Assert.assertEquals(displayedNavLinks.size(), QAClandP.navBarLinks().size());
//		log.info("check if num of displayed links equal to num of links");
		
	}	
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}

}
