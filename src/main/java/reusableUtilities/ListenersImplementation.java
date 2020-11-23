package reusableUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.MyObjectsRepo;


//!!! To invoke our listeners we should stipulate them in our testng.xml
public class ListenersImplementation extends MyObjectsRepo implements ITestListener {

	@Override
	//create a node for each test cases in the report
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case "+result.getMethod().getMethodName()+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case "+result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		//screenshot for fail test
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String screenshotPath = System.getProperty("user.dir")+"/Reports/Screenshots/"
				+actualDate+".jpeg";
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//attach screenshot to the logs
		test.addScreenCaptureFromPath(screenshotPath, "Test case failor screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	//setup ExtendReport at the very beging of Test Execution
	public void onStart(ITestContext context) {
		extent = ExtentReportsSetUp.extentReportsSetUp();
		
	}

	@Override
	//close ExtentReport by using flush() method
	public void onFinish(ITestContext context) { 
		extent.flush();
	}
	
	

}
