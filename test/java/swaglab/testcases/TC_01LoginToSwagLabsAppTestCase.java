package swaglab.testcases;

import org.junit.Assert;
import org.junit.Test;

import swaglab.pages_elements.Login;
import swaglab.utilities.SwagLabsUtilities;

public class TC_01LoginToSwagLabsAppTestCase extends SwagLabsUtilities {

	@Test
	public void tc_01LoginToSwagLabsAppTestCase() throws InterruptedException {
		
		
		Login login = new Login();
		Assert.assertTrue(login.getPageTitle().isDisplayed());
		enterText(login.getUserNameTextBox(),getData("Sheet1", 1, 1));
		enterText(login.getPasswordTextBox(), getData("Sheet1",1,2));
		clickButton(login.getLoginButton());
		Thread.sleep(3000);
				
	}
	
	
}