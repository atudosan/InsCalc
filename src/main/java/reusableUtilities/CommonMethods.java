package reusableUtilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.MyObjectsRepo;


public class CommonMethods extends MyObjectsRepo {
	

	// common method to extract all the values from dropdown list for compare them
	// with expected one
	public List<String> getDropdownOptions(WebElement dropDown) {
		Select select = new Select(dropDown);
		List<WebElement> modelsDropdown = select.getOptions();
		List<String> actualOptions = new ArrayList<String>();
		for (WebElement ref : modelsDropdown) {
			actualOptions.add(ref.getText());
		}
		return actualOptions;
	}

	// common method to select an option from dropdown list
	public void selectDropdownOptionByVisibleText(WebElement dropdown, String option) throws Exception {
		Select select = new Select(dropdown);
		try {
			select.selectByVisibleText(option);
		} catch (Exception e) {
			throw new Exception("Value [" + option + "] is not present in dropdown list");
			// test.log(Status.FAIL, "Value ["+option+"] is not present in dropdown list");
		}
	}

	// common method to fill a textbox with a String
	public void sendText(WebElement element, String text) {
		//element.clear();
		element.sendKeys(text);
	}

	public void clickOnBtn(WebElement btn) {
		btn.click();
	}

	public void selectRadioBtnValue(List<WebElement> element, String value) {
		for (WebElement ref : element) {
			if (ref.getText().equalsIgnoreCase(value)) {
				ref.click();
				//break;
			}
		}
	}

	//seleting values for checkboxes
	public void selectCheckboxeValues(List<WebElement> element, String values) {
		//we will get all the values from spreadsheet and all the values will be
		//separated by comma. we will take this String and will split it those commas
		String[] checksArray = values.split(",");
		
		for (String str : checksArray) {
			for (WebElement ref : element) {
				if (ref.getText().equalsIgnoreCase(str)) {
					ref.click();
					break;
				}
			}
		}
	}

}
