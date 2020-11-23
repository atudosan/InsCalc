package reusableUtilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	public List<String> getDropdownOptions_model(WebElement dropDown) {
		Select select =new Select(dropDown);
		List<WebElement> modelsDropdown = select.getOptions();
		List<String> actualOptions = new ArrayList<String>();
		for (WebElement ref : modelsDropdown) {
			actualOptions.add(ref.getText());
		}
		return actualOptions;
	}
	

}
