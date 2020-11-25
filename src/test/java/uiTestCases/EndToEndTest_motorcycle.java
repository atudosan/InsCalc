package uiTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableUtilities.ExcelOperation;
import testBase.TestBase;

public class EndToEndTest_motorcycle extends TestBase {

	ExcelOperation excel = new ExcelOperation("InsurancePremium");

	@Test (dataProvider = "vehicleData")
	public void insuranseCalculate(Object obj1) throws Exception {
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		
		
		homePage.clickOnMotorcycleLink();
		vehData.enterVehicleData(testData);
		vehData.clickOnNextBtn();
		insData.enterInsuranData(testData);
		insData.clickOnNextBtn();
		prodData.enterProductData(testData);
		prodData.clickOnNextBtn();

		Assert.assertEquals(priceOption.getPriceForSelectedPlan("Gold"), testData.get("PriceValidation_Gold"), "Pricing for Gold plan is not matching");
		Assert.assertEquals(priceOption.getPriceForSelectedPlan("Silver"), testData.get("PriceValidation_Silver"), "Pricing for Silver plan is not matching");
		Assert.assertEquals(priceOption.getPriceForSelectedPlan("Platinum"), testData.get("PriceValidation_Platinum"), "Pricing for Platinum plan is not matching");
		Assert.assertEquals(priceOption.getPriceForSelectedPlan("Ultimate"), testData.get("PriceValidation_Ultimate"), "Pricing for Ultimate plan is not matching");

		priceOption.selectRadioBtnAccordingToSelectedPlan("Silver");
		priceOption.clickOnNextBtn();
	}

	@DataProvider (name="vehicleData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.rowCount()][1];
		for (int i = 1; i <= excel.rowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataIntoMap(i);
			obj[i - 1][0] = testData;
		}
		return obj;
	}

}
