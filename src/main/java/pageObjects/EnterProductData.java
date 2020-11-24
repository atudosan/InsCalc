package pageObjects;

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
	
	public void enterProductData() throws Exception {
		commonMethods.sendText(date_startdate, "12/05/2021");
		commonMethods.selectDropdownOptionByVisibleText(dd_insurancesum, " 3.000.000,00");
		commonMethods.selectDropdownOptionByVisibleText(dd_damageinsurance, "Full Coverage");
		commonMethods.selectCheckboxeValues(chk_optionalProducts, "Euro Protection");
	}
	
	public void clickOnNextBtn() {
		commonMethods.clickOnBtn(btn_Next);
		 }
	
}
