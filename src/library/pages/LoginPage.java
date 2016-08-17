package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.data.Property;

public class LoginPage extends Page{
	
	@FindBy(id = "username")
	private WebElement usernameInputField;
	
	@FindBy(id = "password")
	private WebElement passwordInputField;
	
	@FindBy (id = "loginbtn")
	private WebElement loginButton;
	
	@FindBy(className = "error")
	private WebElement errorLabel;
	
	public LoginPage(WebDriver driver){
		super(driver);
		driver.manage().window().maximize();
		driver.get(Property.URL);
	}
	
	/**
	 * Type username into username input field
	 * @param username {String}
	 * @return {LoginPage}
	 */
	public LoginPage typeUsername(String username){
		usernameInputField.sendKeys(username);
		return this;
	}
	
	/**
	 * Type password into password input field
	 * @param password {String}
	 * @return {LogiPage}
	 */
	public LoginPage typePassword(String password){
		passwordInputField.sendKeys(password);
		return this;
	}
	
	/**
	 * Click on Login button
	 * @return {HomePage}
	 */
	public HomePage clickOnLoginButton(){
		loginButton.click();
		return new HomePage(driver);
	}
	
	/**
	 * Get text from error label
	 * @return {String}
	 */
	public String getErrorMessage(){
		return errorLabel.getText();
	}
	
	/**
	 * Click on login button when invalid data provided
	 * @return {LoginPage}
	 */
	public LoginPage clickOnLoginButtonInvalidData(){
		loginButton.click();
		return this;
	}
	/**
	 * Clear username and password fields
	 * @return {LoginPage}
	 */
	public LoginPage clearUsernameAndPasswordFields(){
		usernameInputField.clear();
		passwordInputField.clear();
		return this;
	}

}