package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOption extends TestBase{
	
	@FindBy(id="nextsendquote")
	WebElement btn_Next;
	
	
	public SelectPriceOption() {
		PageFactory.initElements(driver, this);
	}
	
	//creating dynamic Xpath for prices, by passing the plan we can exctract price 
	//according to the selected plan
	public String getPriceForSelectedPlan(String plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
	}
	
	public void selectRadioBtnAccordingToSelectedPlan(String plan) {
		String dataXpath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
		//String dataXpath = "//th[@class='group']//input[@value='"+plan+"']";
		driver.findElement(By.xpath(dataXpath)).click();
	}	
	
	public void clickOnNextBtn() {
		btn_Next.click();
	}

}
