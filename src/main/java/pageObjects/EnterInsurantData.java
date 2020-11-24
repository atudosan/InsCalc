package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsurantData extends TestBase {
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(id="birthdate")
	WebElement date_birthdate;	

	@FindBy(xpath="//input[@name='Gender']/parent::label")
	List<WebElement> rdo_gender;
	
	@FindBy(id="streetaddress")
	WebElement txt_streetaddress;
	
	@FindBy(id="country")
	WebElement dd_country;
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(xpath="//input[@name='Hobbies']/parent::label")
	List<WebElement> chk_hobbies;
	
	@FindBy(id="website")
	WebElement txt_website;
	
	@FindBy(id = "open")
	WebElement btn_PictureOpenButton;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	@FindBy(id = "nextenterproductdata")
	WebElement btn_Next;
	
	public EnterInsurantData() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterInsuranData() throws Exception {
		commonMethods.sendText(txt_firstname, "Lion");
		commonMethods.sendText(txt_lastname, "Adams");
		commonMethods.sendText(date_birthdate, "02/05/1999");
		commonMethods.selectRadioBtnValue(rdo_gender, "Male");
		commonMethods.selectDropdownOptionByVisibleText(dd_country, "Canada");
		commonMethods.sendText(txt_zipcode, "255050");
		commonMethods.selectDropdownOptionByVisibleText(dd_occupation, "Farmer");
		commonMethods.selectCheckboxeValues(chk_hobbies, "Spedding,Other");
	}
	
	public void clickOnNextBtn() {
		commonMethods.clickOnBtn(btn_Next);
	}
	
	}
