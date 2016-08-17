package library.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	/**
	 * Wait until web element become visible.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementVisible(WebDriver driver, WebElement webElement, int time) {
		System.out.println("Wait.untilWebElementVisible(driver, webElement," + time + ")");
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	/**
	 * Wait until web element become visible.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param byWebElement
	 *            {By}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementVisible(WebDriver driver, By byWebElement, int time) {
		WebElement element = driver.findElement(byWebElement);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait until web element become clickable.
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param webElement
	 *            {WebElement}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementClickable(WebDriver driver, WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	/**
	 * Wait until web element become present
	 * 
	 * @param driver
	 *            {WebDriver}
	 * @param by
	 *            {By}
	 * @param time
	 *            {int}
	 */
	public static void untilWebElementPresent(WebDriver driver, By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
}