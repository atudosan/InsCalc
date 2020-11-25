package pageObjects;

import java.util.HashMap;
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
	
	public void enterInsuranData(HashMap<String, String> testData) throws Exception {
		commonMethods.sendText(txt_firstname, testData.get("Insurant_FirstName"));
		commonMethods.sendText(txt_lastname, testData.get("Insurant_LastName"));
		commonMethods.sendText(date_birthdate, testData.get("Insurant_birthdate"));
		commonMethods.selectRadioBtnValue(rdo_gender, testData.get("Insurant_gender"));
		commonMethods.selectDropdownOptionByVisibleText(dd_country, testData.get("Insurant_country"));
		commonMethods.sendText(txt_zipcode, "Insurant_zipcode");
		commonMethods.selectDropdownOptionByVisibleText(dd_occupation, testData.get("Insurant_occupation"));
		commonMethods.selectCheckboxeValues(chk_hobbies, testData.get("Insurant_Hobby"));
	}
	
	public void clickOnNextBtn() {
		commonMethods.clickOnBtn(btn_Next);
	}
	
	}
