package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterVehicleData extends TestBase {

	@FindBy(id = "make")
	WebElement dd_make;

	@FindBy(id = "model")
	WebElement dd_model;

	@FindBy(xpath = "//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;
	
	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement errmsg_cylindercapacity;

	@FindBy(id = "engineperformance")
	WebElement txt_engineperformance;

	@FindBy(id = "dateofmanufacture")
	WebElement date_dateofmanufacture;

	@FindBy(id = "numberofseatsmotorcycle")
	WebElement dd_numberofseats;

	@FindBy(id = "listprice")
	WebElement txt_listprice;

	@FindBy(id = "annualmileage")
	WebElement txt_annualmilage;

	@FindBy(id = "nextenterinsurantdata")
	WebElement btn_next;

	public EnterVehicleData() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterCylinderCapacity(String cylinderCapacity) {
		txt_cylindercapacity.sendKeys(cylinderCapacity);
	}
	
	public String getErrorMessageOnCylinderCapacity() {
		return errmsg_cylindercapacity.getText();
	}
	
	public List<String> getDropdownOptions_model() {
		 return commonMethods.getDropdownOptions(dd_model);
		
	}
	
	public void enterVehicleData() throws Exception {
		
		commonMethods.selectDropdownOptionByVisibleText(dd_make, "BMW");
		commonMethods.selectDropdownOptionByVisibleText(dd_model, "Moped");	
		commonMethods.sendText(txt_cylindercapacity, "333");
		commonMethods.sendText(txt_engineperformance, "555");
		commonMethods.sendText(date_dateofmanufacture, "12/12/2008");
		commonMethods.selectDropdownOptionByVisibleText(dd_numberofseats, "2");
		commonMethods.sendText(txt_listprice, "4440");
		commonMethods.sendText(txt_annualmilage, "888");
	}
	
	public void clickOnNextBtn() {
		commonMethods.clickOnBtn(btn_next);
		
	}

}
