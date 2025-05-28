package swaglab.pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab.utilities.SwagLabsUtilities;

public class Login extends SwagLabsUtilities{
	
	public Login() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.login_logo")
	private WebElement pageTitle;

	@FindBy(id="user-name")
	private WebElement userNameTextBox;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordTextBox;
	
	@FindBy(id="login-button")
	private WebElement loginButton;

	public WebElement getUserNameTextBox() {
		return userNameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getPageTitle() {
		return loginButton;
	}
	
	
	
}
