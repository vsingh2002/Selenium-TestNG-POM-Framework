package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	@Test
	public void testValidLogin() {
		Log.info("Starting login test");
		test = ExtentReportManager.createTest("Login Test");
		test.info("Navigating to URL");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding credentials");
		test.info("Adding Credentials");
		loginpage.clickLogin();
		loginpage.enterEmail("rahul@mailinator.com");
		loginpage.enterPassword("password123");
		test.info("Clicking on login button");
		loginpage.loginButton();
		Log.info("Verifying the title");
		test.info("Verifying page title");
		String pageTitle = driver.getTitle();
		System.out.println("Page title is :" + pageTitle);
		Assert.assertEquals(pageTitle, "Demo Web Shop");
		test.pass("Login Successfull");

	}

	@Test
	public void testLoginWithInValidCredentials() {
		Log.info("Starting login test");
		test = ExtentReportManager.createTest("Login Test with invalid credentials");
		test.info("Navigating to URL");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding invalid credentials");
		test.info("Adding invalid Credentials");
		loginpage.clickLogin();
		loginpage.enterEmail("rahul@mailinator.com");
		loginpage.enterPassword("password1234");
		test.info("Clicking on login button");
		loginpage.loginButton();
		Log.info("Verifying the title");
		test.info("Verifying page title");
		String pageTitle = driver.getTitle();
		System.out.println("Page title is :" + pageTitle);
		Assert.assertEquals(pageTitle, "Demo Web Shop");
		test.pass("Login Successfull");

	}
}
