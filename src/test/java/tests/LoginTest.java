package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {
	@Test
	public void testValidLogin() {
		Log.info("Starting login test");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding credentials");
		loginpage.clickLogin();
		loginpage.enterEmail("rahul@mailinator.com");
		loginpage.enterPassword("password123");
		loginpage.loginButton();
		Log.info("Verifying the title");
		String pageTitle = driver.getTitle();
		System.out.println("Page title is :" + pageTitle);
		Assert.assertEquals(pageTitle, "Demo Web Shop");

	}
}
