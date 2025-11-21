package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void setUpReport() {
		extent = ExtentReportManager.getReportInstance();
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setUp() {
		Log.info("Launch the browser");
		driver = new FirefoxDriver();
		Log.info("Maximizing the browser");
		driver.manage().window().maximize();
		Log.info("Implementing implicitwait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log.info("Navigating to test url");
		driver.get("https://demowebshop.tricentis.com/");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed.. Check Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}

		if (driver != null) {
			Log.info("Closing the browser");
			driver.quit();
		}

	}

}
