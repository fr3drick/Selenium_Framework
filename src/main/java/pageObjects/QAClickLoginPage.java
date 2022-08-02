package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAClickLoginPage {
	
	WebDriver driver;
	
	public QAClickLoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

	By userEmail = By.cssSelector("input#user_email");
	By password = By.cssSelector("input#user_password");
	By loginBtn = By.cssSelector("input[type='submit']");
	By forgotPassword = By.xpath("//a[text()='Forgot Password?']");
	
	public WebElement userEmail() {
		return driver.findElement(userEmail);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public void login() {
		driver.findElement(loginBtn).click();
		
	}
	
	public QAClickForgotPwdPage forgotPassword() 
	{
		driver.findElement(forgotPassword).click();
		return new QAClickForgotPwdPage(driver);
	
	}
	
}
