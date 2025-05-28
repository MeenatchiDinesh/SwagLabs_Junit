package swaglab.pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab.utilities.SwagLabsUtilities;

public class Checkout extends SwagLabsUtilities{
	
	public Checkout() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first-name")
	private WebElement firstNameTextBox;
	
	@FindBy(id="last-name")
	private WebElement lastNameTextBox;
	
	@FindBy(id="postal-code")
	private WebElement postalCodeTextBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getPostalCodeTextBox() {
		return postalCodeTextBox;
	}



}
