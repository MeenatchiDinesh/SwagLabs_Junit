package swaglab.pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab.utilities.SwagLabsUtilities;

public class Cart extends SwagLabsUtilities {
	
	public Cart() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='inventory_item_name']")
	private WebElement cartProductName;
	
	@FindBy(linkText="CHECKOUT")
	private WebElement checkoutButton;
	
	public WebElement getcartProductName() {
		return cartProductName;
	}

	public WebElement getcheckoutButton() {
		return checkoutButton;
	}

}
