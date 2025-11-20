package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void testValidLogin() {
		LoginPage loginpage = new LoginPage(driver);

		loginpage.clickLogin();
		loginpage.enterEmail("rahul@mailinator.com");
		loginpage.enterPassword("password123");
		loginpage.loginButton();

		String pageTitle = driver.getTitle();
		System.out.println("Page title is :" + pageTitle);
		Assert.assertEquals(pageTitle, "Demo Web Shop");

	}
}
