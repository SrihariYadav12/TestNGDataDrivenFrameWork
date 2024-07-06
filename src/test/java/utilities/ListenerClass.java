/**
 * 
 */
package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;

/**
 * @author Srihari
 *
 */
public class ListenerClass implements ITestListener {
	String testName;
	ExtentReports extentReport;
	ExtentTest extenttest;

	public void onStart(ITestContext context) {
		extentReport = ExtentReport.generateExtentReport();
	}

	public void onTestStart(ITestResult result) {

		testName = result.getName();
		extenttest = extentReport.createTest(testName);
		extenttest.log(Status.INFO, testName + "Testcase execution started");

	}

	public void onTestSuccess(ITestResult result) {
		testName = result.getName();
		extenttest.log(Status.PASS, result.getName() + "TestCase Passed");
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, result.getName() + "TestCase skipped");
	}

	public void onTestFailure(ITestResult result) {
		testName = result.getName();
		try {
			extenttest.addScreenCaptureFromPath(BaseClass.captureScreenShot(testName));
		} catch (Throwable e) {

			e.printStackTrace();
		}
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, result.getName() + "Testcase failed");

	}

	public void onFinish(ITestContext context) {
		extentReport.flush();

		File reportFile = new File(System.getProperty("user.dir") + "//test-output//ExtentReports//extenreport.html");
		try {
			Desktop.getDesktop().browse(reportFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
