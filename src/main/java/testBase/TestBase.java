package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantData;
import pageObjects.EnterProductData;
import pageObjects.EnterVehicleData;
import pageObjects.HomePage;
import pageObjects.SelectPriceOption;
import reusableUtilities.ConfigPropExtractData;

public class TestBase extends MyObjectsRepo {
	
	
	
	public void LaunchBrowserAndNavigate() throws Exception {

		String browser = ConfigPropExtractData.getPropValueByKey("browser");
		String url = ConfigPropExtractData.getPropValueByKey("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(url);

	}

	@BeforeMethod
	public void setUp() throws Exception {
		LaunchBrowserAndNavigate();
		//after we initilized the driver we should initialie every
		// object of pageObjects because in their contructor they need
		// a driver instance in order to be created
		homePage = new HomePage();
		vehData = new EnterVehicleData();
		insData = new EnterInsurantData();
		prodData = new EnterProductData();
		priceOption = new SelectPriceOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
