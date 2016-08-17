package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.data.Property;

public class InternalSystemPage extends Page{
	
	@FindBy(className = "no-overflow")
	private WebElement categoryDescription;
	
	private By byCategoryDescription = new By.ByClassName("no-overflow");

	public InternalSystemPage(WebDriver driver){
		super(driver);
		waitForPageToBeLoaded(driver, byCategoryDescription, Property.TIME_SHORT);		
	}
	
	/**
	 * Get text from paragraph
	 * @return{String}
	 */
	public String getParagraphDescription(){
		return categoryDescription.getText();		
	}
	
}