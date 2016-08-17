package test.test.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Login {

	private WebDriver driver;

	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CDDPage cddPage;

	String message;

	@Test
	public void login() {

		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homePage = loginPage.clickOnLoginButton();

		message = homePage.getTextFromLoginInfoLabel();
		// driver.findElement(By.id("password")).sendKeys(password);
		// driver.findElement(By.id("loginbtn")).click();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in.";

		homePage.typeSearchValueIntoSearchField("Career");
		searchResultPage = homePage.clickOnGoButton();
		cddPage = searchResultPage.clickOnCDDLink();
		loginPage = cddPage.clickOnLogOutLink();

		assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";

		System.out.println("Test passed");

	}

	@Test
	public void career() {
		homePage.typeSearchValueIntoSearchField(Property.textCareer);

	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		loginPage = new LoginPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
