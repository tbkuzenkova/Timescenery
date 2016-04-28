package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfilePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ProfilePage profilePage;
	WebDriverWait wait;
	
	@BeforeClass
	public void testInit() {
		driver.get(baseUrl);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		profilePage = PageFactory.initElements(driver, ProfilePage.class);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void editProfileTest() {
		homePage.clickOnSignInButton();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("screen__header")));
		
		loginPage.performLogin("tanya.shalaeva@gmail.com", "testpa$$w0rd");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("screen__header")));
		

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", homePage.profileButton);
		homePage.openProfileSettings();
		
		profilePage.editUserInfo("Test", "User", "Moscow", "tanya.shalaeva@gmail.com");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='btn btn--primary']")));
		
		Assert.assertEquals(profilePage.fullName.getText(), "Test User");
		Assert.assertEquals(profilePage.city.getText(), "Moscow");
		Assert.assertEquals(profilePage.email.getText(), "tanya.shalaeva@gmail.com");
	}
}
