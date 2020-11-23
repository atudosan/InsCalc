package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterVehicleData;
import pageObjects.HomePage;
import reusableUtilities.CommonMethods;

public class MyObjectsRepo {
	
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static HomePage homePage;
	public static EnterVehicleData vehData;
	public static CommonMethods commonMethods;
}
