package uiTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SelectPriceOption;
import testBase.TestBase;

public class EndToEndTest_motorcycle extends TestBase {
	
	@Test
	public void insuranseCalculate() throws Exception{	
		homePage.clickOnMotorcycleLink();
		vehData.enterVehicleData();
		vehData.clickOnNextBtn();
		insData.enterInsuranData();
		insData.clickOnNextBtn();
		prodData.enterProductData();
		prodData.clickOnNextBtn();
		
		String expectedSilverPlanPrice = "240.00";
		String actualSilverPlanPrice = priceOption.getPriceForSelectedPlan("Silver");
		Assert.assertEquals(expectedSilverPlanPrice, actualSilverPlanPrice);
		
		priceOption.selectRadioBtnAccordingToSelectedPlan("Silver");
		priceOption.clickOnNextBtn();
	}

}
