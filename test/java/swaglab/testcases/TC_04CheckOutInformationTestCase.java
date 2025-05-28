package swaglab.testcases;

import org.junit.Assert;
import org.junit.Test;
import swaglab.pages_elements.Cart;
import swaglab.pages_elements.Checkout;
import swaglab.pages_elements.CheckoutOverview;
import swaglab.pages_elements.Login;
import swaglab.pages_elements.Products;
import swaglab.utilities.SwagLabsUtilities;

public class TC_04CheckOutInformationTestCase extends SwagLabsUtilities {

	@Test
	public void tc_04CheckOutInformationTestCase() throws InterruptedException {

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

		// Validate cart page and checkout
		Cart cart = new Cart();
		String cartProduct = pagetext(cart.getcartProductName());
		Assert.assertEquals(productName, cartProduct);
		clickButton(cart.getcheckoutButton());
		Thread.sleep(3000);

		// Filling chekout information
		Checkout checkout = new Checkout();
		enterText(checkout.getFirstNameTextBox(), getData("Sheet1", 1, 3));
		enterText(checkout.getLastNameTextBox(), getData("Sheet1", 1, 4));
		enterText(checkout.getPostalCodeTextBox(), getData("Sheet1", 1, 5));
		Thread.sleep(2000);
		clickButton(checkout.getContinueButton());
		Thread.sleep(2000);

		// CheckoutOverview validation

		CheckoutOverview checkoutoverview = new CheckoutOverview();
		String CheckoutProduct = pagetext(checkoutoverview.getProductName());
		Assert.assertEquals(CheckoutProduct, productName);
		clickButton(checkoutoverview.getFinishButton());
		Thread.sleep(2000);

	}

}
