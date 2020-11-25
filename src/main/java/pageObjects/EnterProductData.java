package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductData extends TestBase {

	@FindBy(id="startdate")
	WebElement date_startdate;	
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chk_optionalProducts;
	
	@FindBy(id = "nextselectpriceoption")
	WebElement btn_Next;
	
	
	public EnterProductData() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductData(HashMap<String, String> testData) throws Exception {
		commonMethods.sendText(date_startdate, testData.get("Product_startdate"));
		commonMethods.selectDropdownOptionByVisibleText(dd_insurancesum, testData.get("Product_insurancesum"));
		commonMethods.selectDropdownOptionByVisibleText(dd_damageinsurance, testData.get("Product_damageinsurance"));
		commonMethods.selectCheckboxeValues(chk_optionalProducts, testData.get("Product_OptionalProducts"));
	}
	
	public void clickOnNextBtn() {
		commonMethods.clickOnBtn(btn_Next);
		 }
	
}
