package listeners_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass_utility.BaseClass;
import generic_utility.JavaUtility;



public class listeners implements ITestListener , ISuiteListener {
	public ExtentReports report;
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
 
	/**
	 * Creates and configures the Extent report before the suite starts.
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("this is on start");
		String time = JavaUtility.genCurrentTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/" + time + ".html");
		spark.config().setDocumentTitle("CRM_dummy");
		spark.config().setReportName("CRM_01");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Operating System", "Windows");
	}

	/**
	 * Creates a report entry when a test method starts.
	 */
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.set(report.createTest(methodName));
	}

	/**
	 * Marks the current test as passed in the Extent report.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.get().log(Status.PASS, methodName + " got passed");
	}

	/**
	 * Marks the current test as failed and attaches a screenshot to the report.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.get().log(Status.FAIL, methodName + " Failed....");

		TakesScreenshot tks = (TakesScreenshot) BaseClass.getDriver();
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.get().addScreenCaptureFromBase64String(ss, methodName);
	}

	/**
	 * Marks the current test as skipped in the Extent report.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.get().log(Status.SKIP, methodName + "skip...");
	}

	/**
	 * Flushes all collected test results to the Extent report after the suite ends.
	 */
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("this is on finish");
	}

}