package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurantData;
import pageObjects.EnterProductData;
import pageObjects.EnterVehicleData;
import pageObjects.HomePage;
import pageObjects.SelectPriceOption;
import reusableUtilities.CommonMethods;

public class MyObjectsRepo {
	
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static HomePage homePage;
	public static EnterVehicleData vehData;
	public static EnterInsurantData insData;
	public static EnterProductData prodData;
	public static SelectPriceOption priceOption;
	public static CommonMethods commonMethods = new CommonMethods();
}
