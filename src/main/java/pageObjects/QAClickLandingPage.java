package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAClickLandingPage {
	
	 WebDriver driver;
	
	public QAClickLandingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	private By login = By.cssSelector("a[href*='sign_in']");
	private By noThanksBtn = By.xpath("//button[text()='NO THANKS']");
	private By navBarLinks = By.cssSelector("ul.navbar-right a");
	
	public QAClickLoginPage login() {
		driver.findElement(login).click();
		return new QAClickLoginPage(driver);
	}
	
	public WebElement noThanksBtn() {
		return driver.findElement(noThanksBtn);
	}
	
	public List<WebElement> navBarLinks() {
		return driver.findElements(navBarLinks);
	}
	
}
