package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
	
	@FindBy(xpath = "//form[contains(@class,'popup-form--signin')]/div[contains(@class,'fields')]/div[1]//input")
	private WebElement emailField;
	
	@FindBy(xpath = "//form[contains(@class,'popup-form--signin')]/div[contains(@class,'fields')]/div[2]//input")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	public LoginPage(WebDriver webDriver)
	{
		super(webDriver);
	}
	
	public void performLogin(String userEmail, String userPassword)
	{
		emailField.sendKeys(userEmail);
		passwordField.sendKeys(userPassword);
		submitButton.click();
	}
}
