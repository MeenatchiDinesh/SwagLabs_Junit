package swaglab.testcases;
import org.junit.Assert;
import org.junit.Test;
import swaglab.pages_elements.Cart;
import swaglab.pages_elements.Login;
import swaglab.pages_elements.Products;
import swaglab.utilities.SwagLabsUtilities;

public class TC_03CartPageValidationTestCase extends SwagLabsUtilities {

	@Test
	public void tc_03CartPageValidationTestCase() throws InterruptedException {

		// Login
		Login login = new Login();
		Assert.assertTrue(login.getPageTitle().isDisplayed());
		enterText(login.getUserNameTextBox(), getData("Sheet1", 1, 1));
		enterText(login.getPasswordTextBox(), getData("Sheet1", 1, 2));
		clickButton(login.getLoginButton());
		Thread.sleep(3000);

		// Select product
		Products products = new Products();
		clickButton(products.getAddToCartButton());
		Thread.sleep(2000);
		String productName = pagetext(products.getProductName());
		clickButton(products.getCartIcon());

		//Validate cart page and checkout
		Cart cart = new Cart();
		String cartProduct = pagetext(cart.getcartProductName());
		Assert.assertEquals(productName, cartProduct);
		clickButton(cart.getcheckoutButton());
		Thread.sleep(3000);

	}
}
