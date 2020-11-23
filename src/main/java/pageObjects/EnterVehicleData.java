package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(id = "numberofseats")
	WebElement dd_numberofseats;

	@FindBy(id = "listprice")
	WebElement txt_listprice;

	@FindBy(id = "annualmilage")
	WebElement txt_annualmilage;

	@FindBy(id = "nextenterinsurancedata")
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
		 return method.getDropdownOptions_model(dd_model);
		//return actualOptions;
	}

}
