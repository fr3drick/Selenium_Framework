package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;


public class Listeners extends Base implements ITestListener {
	WebDriver driver;
	  String testMethodName;
	  
	public ExtentReports extent = ExtentReporterNG.getReporterObject();
	 public ExtentTest test;
	  

		  public void onTestFailure(ITestResult result) {
			  
			  testMethodName = result.getMethod().getMethodName();
			  
			  
			  try {
				driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  takeScreenshot(testMethodName, driver);
			  
			  test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\reports\\screenshots\\"+testMethodName+".png");
			  test.log(Status.FAIL, result.getThrowable());

		    
		  }

		 
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }


		
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			test = extent.createTest(result.getMethod().getMethodName());
		}


		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onStart(context);
		}


		
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			extent.flush();
		}


		
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			  testMethodName = result.getMethod().getMethodName();
			  
			  
			  try {
				driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  takeScreenshot(testMethodName, driver);
			  
			  test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\reports\\screenshots\\"+testMethodName+".png");
			
			test.log(Status.PASS, "Test passed");
			

		}


		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestSkipped(result);
		}


		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		
		 
		}

	

