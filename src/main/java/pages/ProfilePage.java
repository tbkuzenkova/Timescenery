package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page{

	@FindBy(xpath = "//div[@class='profile__info-block']/div[1]/div[2]")
	public WebElement fullName;
	
	@FindBy(xpath = "//div[@class='profile__info-block']/div[2]/div[2]")
	public WebElement city;
	
	@FindBy(xpath = "//div[@class='profile__info-block']/div[3]/div[2]")
	public WebElement email;
	
	@FindBy(xpath = "//a[@ng-click='profile.toEdit()']")
	private WebElement editProfileLink;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//input[@name='fakecity']")
	private WebElement cityField;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//button[@class='btn btn--primary']")
	private WebElement saveButton;
	
	public ProfilePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void editUserInfo(String firstName, String lastName, String city, String email) {
		clickOnEditProfile();
		
		firstNameField.click();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		
		cityField.clear();
		cityField.sendKeys(city);
		
		emailField.clear();
		emailField.sendKeys(email);
		
		saveButton.click();
	}
	
	private void clickOnEditProfile() {
		editProfileLink.click();
	}
}
