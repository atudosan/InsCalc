package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterVehicleData;
import pageObjects.HomePage;

public class MyObjectsRepo {
	
	public static ExtentTest test;
	public static ExtentReports extent;
	public static HomePage homePage;
	public static EnterVehicleData vehData;
}
