package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterVehicleData;
import pageObjects.HomePage;
import reusableUtilities.ConfigPropExtractData;

public class TestBase extends MyObjectsRepo {

	public static WebDriver driver;

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
		homePage = new HomePage();
		vehData = new EnterVehicleData();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
