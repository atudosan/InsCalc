package uiTestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.TestBase;

public class ErrorTest_motorcycle extends TestBase {
	@Test
	public void errorMessage_CylinderCapacity() {
		
		homePage.clickOnMotorcycleLink();
		vehData.enterCylinderCapacity("3333");
		
		String actualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Actual Error Message is not as Expected");
		
	}

}
