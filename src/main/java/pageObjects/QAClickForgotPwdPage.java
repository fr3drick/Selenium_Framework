package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAClickForgotPwdPage {
	
	public WebDriver driver;
	
	private By emailAddress = By.cssSelector("input#user_email");
	private By sendMeInstruction = By.cssSelector("input.btn-md");
	
	public QAClickForgotPwdPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement emailAddress()
	{
		return driver.findElement(emailAddress);
	}
	
	public void sendMeInstruction()
	{
		driver.findElement(sendMeInstruction).click();
		
		//return
	}

}
