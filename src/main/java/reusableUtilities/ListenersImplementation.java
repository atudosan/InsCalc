package reusableUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.MyObjectsRepo;

public class ListenersImplementation extends MyObjectsRepo implements ITestListener {

	@Override
	//create a node for each test cases in the report
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
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
