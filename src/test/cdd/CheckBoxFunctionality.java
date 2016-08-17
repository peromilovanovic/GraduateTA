package test.cdd;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;
import library.util.Prepare;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class CheckBoxFunctionality {

	private WebDriver driver;

	boolean b = false;
	boolean isCheckd = false;

	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CDDPage cddPage;
	String message;

	@BeforeClass
	public void beforeClass() {

		driver = Prepare.chromeDriver();
		System.out.println("Step: Go to app url.");
		loginPage = new LoginPage(driver);
	}

	@Test(groups = {"checkbox"})
	public void login() {

		try {
			System.out.println("Step: Login.");
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();

			System.out.println("Step: Verify successful login.");
			message = homePage.getTextFromLoginInfoLabel();
			System.out.println(message);			
			assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

			System.out.println("Step: Search app for 'career'.");
			homePage.typeSearchValueIntoSearchField("career");
			searchResultPage = homePage.clickOnGoButton();
			
			System.out.println("Step: Click on cdd link.");
			cddPage = searchResultPage.clickOnCDDLink();

			System.out.println("Step: check first checkbox.");
			cddPage.checkFristCheckBox();
			isCheckd = true;

			System.out.println("Step: Log out.");
			loginPage = cddPage.clickOnLogOutLink();

			System.out.println("Step: Login.");
			loginPage.typeUsername(Property.username).typePassword(Property.password);
			homePage = loginPage.clickOnLoginButton();

			System.out.println("Step: Verify successful login.");
			message = homePage.getTextFromLoginInfoLabel();
			System.out.println(message);
			assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

			System.out.println("Step: Search app for 'career'.");
			homePage.typeSearchValueIntoSearchField("career");
			searchResultPage = homePage.clickOnGoButton();
			
			System.out.println("Step: Click on cdd link.");
			cddPage = searchResultPage.clickOnCDDLink();

			System.out.println("Step: Verify checkbox is checked.");
			assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";

			System.out.println("Step: Log out.");
			loginPage = cddPage.clickOnLogOutLink();

			b = true;
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		System.out.println("AfterClass: Kill the driver.");
		driver.quit();

		if (isCheckd) {
			try {
				System.out.println("AfterClass: Revert to default.");
				driver = Prepare.chromeDriver();
				loginPage = new LoginPage(driver);
				loginPage.typeUsername(Property.username).typePassword(Property.password);
				homePage = loginPage.clickOnLoginButton();
				message = homePage.getTextFromLoginInfoLabel();
				System.out.println(message);
				assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";
				homePage.typeSearchValueIntoSearchField("career");
				searchResultPage = homePage.clickOnGoButton();
				cddPage = searchResultPage.clickOnCDDLink();
				assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
				cddPage.uncheckFristCheckBox();
				loginPage = cddPage.clickOnLogOutLink();
				driver.quit();
			} catch (Exception e) {
				throw e;
			}
		}

		if (b) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
	}
}