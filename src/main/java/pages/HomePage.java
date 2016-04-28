package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

	private final String H1_TAG = "h1";
	
	@FindBy(how = How.TAG_NAME, using = H1_TAG)
	@CacheLookup
	private WebElement h1Element;
	
	@FindBy(xpath = "//a[contains(@class,'enter-popup')]")
	WebElement signInButton;
	
	@FindBy(xpath = "//div[@class='scroll-area__helper']/div[last()-1]")
	public WebElement profileButton;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getH1() {
		return h1Element.getText();
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}

	public void openProfileSettings(){
		profileButton.click();
	}
	
}
