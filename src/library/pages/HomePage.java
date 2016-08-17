package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.data.Property;
import library.util.Wait;

public class HomePage extends Page {

	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;

	// @FindBy(css = "input[type= 'submit'][value= 'Go']")
	@FindBy(xpath = "//input[contains(@value, 'Go') and contains(@type, 'submit')]")
	private WebElement goButton;

	@FindBy(xpath = "//a[contains(@title, 'My Account')]")
	private WebElement myAccountLink;

	@FindBy(css = "a[title = 'My Profile']")
	private WebElement myProfileLink;

	@FindBy(css = "a[title = 'Endava University']")
	private WebElement endavaUniversityLink;

	@FindBy(css = "a[title = 'Internal systems self help']")
	private WebElement internalSystemSelfHelpLink;

	private By goBtn = new ByXPath("//input[contains(@value, 'Go') and contains(@type, 'submit')]");
	private By bySearchInputField = new By.ById("shortsearchbox");

	public HomePage(WebDriver driver) {
		super(driver);
		waitForPageToBeLoaded(driver, goBtn, Property.TIME_SHORT);
		/*
		 * Verovatno se pritate gde su one linije koda??? Kada nasledimo Page.java
		 * klasu nasledjujemo i konstruktor kao sti smo i uradili: pozvali smo :
		 * super(driver); Ako odete u Page.java klasu videcete da smo tamo
		 * stavili u konstruktor PageFactory.initElements(driver, this); - sto
		 * ce inicijalizovati sve elemente pod klase gde je konstruktor super
		 * klase pozvan.
		 * 
		 * Pogledajte i LoginPage.java konstruktor.
		 */
	}

	/**
	 * Type search value into search field
	 * 
	 * @param value
	 *            {String}
	 * @return {HomePage}
	 */
	public HomePage typeSearchValueIntoSearchField(String value) {
		System.out.println("typeSearchValueIntoSearchField(" + value + ")");
		Wait.untilWebElementPresent(driver, bySearchInputField, Property.TIME_SHORT);
		searchInputField.sendKeys(value);
		return this;
	}

	/**
	 * Click on go button
	 * @return {SearchResultPage}
	 */
	public SearchResultPage clickOnGoButton() {
		System.out.println("clickOnGoButton()");
		// goButton.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
	}

	/**
	 * Click on dropdown menu my account
	 * 
	 * @return {HomePage}
	 */
	public HomePage clickOnMyAccount() {
		myAccountLink.click();
		return this;

	}

	/**
	 * Click on dropdown menu my profile
	 * 
	 * @return {MyProfilePage}
	 */
	public MyProfilePage clickOnMyProfile() {
		myProfileLink.click();
		return new MyProfilePage(driver);

	}

	/**
	 * Click on dropdown menu endava university
	 * 
	 * @return{HomePage}
	 */
	public HomePage clickOnEndavaUniversity() {
		endavaUniversityLink.click();
		return this;

	}

	/**
	 * Click on dropdown menu internal system self help
	 * 
	 * @return{InternalSystemPage}
	 */
	public InternalSystemPage clickOnInternalSystemSelfHelpLink() {
		internalSystemSelfHelpLink.click();
		return new InternalSystemPage(driver);
	}

}