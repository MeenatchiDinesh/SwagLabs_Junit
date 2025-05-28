package swaglab.pages_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab.utilities.SwagLabsUtilities;

public class OrderConfirmation extends SwagLabsUtilities{
	
	public OrderConfirmation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//div[@class='complete-text']")
	private WebElement orderConfirmationMessage;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement menuIcon;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutLink;

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getOrderConfirmationMessage() {
		return orderConfirmationMessage;
	}

	public WebElement getMenuIcon() {
		return menuIcon;
	}

}
