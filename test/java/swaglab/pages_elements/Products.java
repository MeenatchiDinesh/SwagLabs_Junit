package swaglab.pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab.utilities.SwagLabsUtilities;

public class Products extends SwagLabsUtilities{
	public Products() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='inventory_item_name'])[2]")
	private WebElement productName;
	
	@FindBy(xpath="(//button[@class='btn_primary btn_inventory'])[2]")
	private WebElement addToCartButton;
	
	@FindBy(css="div.shopping_cart_container")
	private WebElement cartIcon;
	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	
}
