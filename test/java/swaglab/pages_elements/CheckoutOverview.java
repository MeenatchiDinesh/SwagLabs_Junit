package swaglab.pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab.utilities.SwagLabsUtilities;

public class CheckoutOverview extends SwagLabsUtilities{

	
	public CheckoutOverview() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div.subheader")
	private WebElement pageTitle;
	
	@FindBy(linkText="FINISH")
	private WebElement finishButton;
	
	@FindBy(css="div.inventory_item_name")
	private WebElement productName;

	public WebElement getFinishButton() {
		return finishButton;
	}
	
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getPageTitle() {
		return pageTitle;
	}
}
