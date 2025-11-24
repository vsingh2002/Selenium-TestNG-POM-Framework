package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {
		String filepath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filepath, "Sheet1");
		int rowcount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowcount - 1][2];
		for (int i = 1; i < rowcount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0);
			data[i - 1][1] = ExcelUtils.getCellData(i, 1);
		}
		ExcelUtils.closeExcel();
		return data;
	}

	@DataProvider(name = "LoginData1")
	public Object[][] getData() {

		return new Object[][] { { "rahul@mailinator.com", "password123" }, { "roshan@mailinator.com", "password1" },
				{ "sachin@gmail.com", "pass123" }, { "virat@mailinator.com", "virat123" }

		};
	}

	@Test(dataProvider = "LoginData1")
	public void testValidLogin(String email, String password) {
		Log.info("Starting login test");
		test = ExtentReportManager.createTest("Login Test");
		test.info("Navigating to URL");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding credentials");
		test.info("Adding Credentials");
		loginpage.clickLogin();
//		loginpage.enterEmail("rahul@mailinator.com");
//		loginpage.enterPassword("password123");
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		test.info("Clicking on login button");
		loginpage.loginButton();
		Log.info("Verifying the title");
		test.info("Verifying page title");
		String pageTitle = driver.getTitle();
		System.out.println("Page title is :" + pageTitle);
		Assert.assertEquals(pageTitle, "Demo Web Shop");
		test.pass("Login Successfull");

	}

//	@Test
//	public void testLoginWithInValidCredentials() {
//		Log.info("Starting login test");
//		test = ExtentReportManager.createTest("Login Test with invalid credentials");
//		test.info("Navigating to URL");
//		LoginPage loginpage = new LoginPage(driver);
//		Log.info("Adding invalid credentials");
//		test.info("Adding invalid Credentials");
//		loginpage.clickLogin();
//		loginpage.enterEmail("rahul@mailinator.com");
//		loginpage.enterPassword("password1234");
//		test.info("Clicking on login button");
//		loginpage.loginButton();
//		Log.info("Verifying the title");
//		test.info("Verifying page title");
//		String pageTitle = driver.getTitle();
//		System.out.println("Page title is :" + pageTitle);
//		Assert.assertEquals(pageTitle, "Demo Web Shop");
//		test.pass("Login Successfull");
//
//	}
}
