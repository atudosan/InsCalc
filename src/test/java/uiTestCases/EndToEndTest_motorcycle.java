package uiTestCases;

import org.testng.annotations.Test;

import testBase.TestBase;

public class EndToEndTest_motorcycle extends TestBase {
	
	@Test
	public void getTitle() {
		LaunchBrowserAndNavigate();
		System.out.println(driver.getTitle());
	}

}
