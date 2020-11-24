package uiTestCases;


import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTest_motorcycle extends TestBase {
	@Test
	public void errorMessage_CylinderCapacity() {
		
		homePage.clickOnMotorcycleLink();
		vehData.enterCylinderCapacity("3333");
		//test.log(Status.PASS, "Cylinder capacity is filled with data 3333");
		String actualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Actual Error Message is not as Expected");
		
	}
	
	@Test
	public void errorMessage_CylinderCapacity1() {
		
		homePage.clickOnMotorcycleLink();
		vehData.enterCylinderCapacity("3333");
		//test.log(Status.PASS, "Cylinder capacity is filled with data 3333");
		String actualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 3000";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Actual Error Message is not as Expected");
		
	}
	
	@Test
	public void verifyModelDropdownOptions() {
		
		homePage.clickOnMotorcycleLink();
		 //get dropdown options
		List<String> actualOptions = vehData.getDropdownOptions_model();
		test.log(Status.INFO, "Actuals options of Model DD are "+actualOptions);
		// list expected options
		List<String> expectedOptions = Arrays.asList("– please select –", "Scooter",
				"Three-Wheeler", "Moped", "Motorcycle");
		test.log(Status.INFO, "Expected options of Model DD are "+expectedOptions);

		//compare
		Assert.assertEquals(actualOptions, expectedOptions, "The options from model dropdown"
				+ " list are not matching");
		
	}

}
