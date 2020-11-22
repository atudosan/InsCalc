package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterVehicleData {

	@FindBy(id = "make")
	WebElement dd_make;

	@FindBy(id = "model")
	WebElement dd_model;

	@FindBy(xpath = "//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;

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

}
