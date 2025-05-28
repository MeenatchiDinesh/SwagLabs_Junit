package swaglab.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import swaglab.testcases.TC_01LoginToSwagLabsAppTestCase;
import swaglab.testcases.TC_02AddToCartTestCase;
import swaglab.testcases.TC_03CartPageValidationTestCase;
import swaglab.testcases.TC_04CheckOutInformationTestCase;
import swaglab.testcases.TC_05ValidateOrderConfirmationTestCase;

@RunWith(Suite.class)
@SuiteClasses({
	TC_01LoginToSwagLabsAppTestCase.class,
	TC_02AddToCartTestCase.class,
	TC_03CartPageValidationTestCase.class,
	TC_04CheckOutInformationTestCase.class,
	TC_05ValidateOrderConfirmationTestCase.class})

public class TestCasesRunner {
	
}
