package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.util.Wait;

public class Page {
	
	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;

	
	protected WebDriver driver; 
	/* obratite paznju na protected rec - omogucava svim kalasama koje nasledjuju ovu da kroiste driver,
	 * tako da im njihov atribut private WebDriver driver; vise ne treba.
	 */
	
	public Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	/**
	 * Get text form login info label
	 * @return {String}
	 */
	public String getTextFromLoginInfoLabel(){
		return loginInfoLabel.getText();
	}
	
	public LoginPage clickOnLogOutLink(){
		logOutLink.click();
		return new LoginPage(driver);
		
	}
	
	/**
	 * Wait for page to be loaded
	 * @param driver {WebDriver}
	 * @param byWebElement {By}
	 * @param time {int}
	 */
	public void waitForPageToBeLoaded(WebDriver driver, By byWebElement, int time){	
		System.out.println("waitForPageToBeLoaded(driver, webElement,"+ time +")");
		WebElement identifierElement = null;
		long baseTime = System.currentTimeMillis() + (time * 1000);
		// Trenutak ulaska u metodu [System.currentTimeMillis() - vraca trenutno vreme u milisekundama] uvecan za time * 1000 (milisekunde)
		
		boolean b = false;
		while (!b && ((baseTime - System.currentTimeMillis()) > 0)) {
			try {			
				identifierElement = driver.findElement(byWebElement);
				b = true;
			} catch (Exception e) {
			}
			Wait.untilWebElementVisible(driver, identifierElement, time);
		}
	}
}