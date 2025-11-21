package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Log;

public class BaseTest {
	protected WebDriver driver;

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
	public void tearDown() {

		Log.info("Closing the browser");
		if (driver != null) {
			driver.quit();
		}

	}

}
