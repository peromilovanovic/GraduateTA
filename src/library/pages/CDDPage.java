package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

import library.data.Property;

public class CDDPage extends Page{

	@FindBy(xpath = "//input[contains(@title, 'CDD Animation Scripts')]")
	private WebElement firstCheckBox;
	
	private By byFirstCheckBox = new By.ByXPath("//input[contains(@title, 'CDD Animation Scripts')]");

	public CDDPage(WebDriver driver) {
		super(driver);
		waitForPageToBeLoaded(driver, byFirstCheckBox, Property.TIME_SHORT);
	}

	/**
	 * Check on first check box
	 * 
	 * @return {CDDPage}
	 */
	public CDDPage checkFristCheckBox() {
		if (!isFirstCheckBoxSelected()) {
			firstCheckBox.click();
			Sleeper.sleepTightInSeconds(2);
		}		
		return this;
	}
	
	/**
	 * Uncheck on first check box
	 * 
	 * @return {CDDPage}
	 */
	public CDDPage uncheckFristCheckBox() {
		if (isFirstCheckBoxSelected()) {
			firstCheckBox.click();
			Sleeper.sleepTightInSeconds(2);
		}		
		return this;
	}

	/**
	 * Is first check box selected
	 * 
	 * @return {boolean}
	 */
	public boolean isFirstCheckBoxSelected() {
		String attributeValue = firstCheckBox.getAttribute("title");
		if (attributeValue.contains("Mark as not complete")) {
			return true;
		} else
			return false;
	}

}
