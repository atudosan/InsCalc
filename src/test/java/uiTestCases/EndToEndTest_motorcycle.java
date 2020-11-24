package uiTestCases;

import org.testng.annotations.Test;

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
	}

}
