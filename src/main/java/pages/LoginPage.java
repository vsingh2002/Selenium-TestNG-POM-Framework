package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	private WebDriver driver;

	@FindBy(linkText = "Log in")
	WebElement loginLink;
	@FindBy(id = "Email")
	WebElement userEmailId;
	@FindBy(id = "Password")
	WebElement userPassword;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickLogin() {
		Log.info("Clicking the login link");
// driver.findElement(login).click();
		loginLink.click();
	}

	public void enterEmail(String email) {
		Log.info("Enterning the emailid");
		// driver.findElement(emailField).sendKeys(email);
		userEmailId.sendKeys(email);
	}

	public void enterPassword(String password) {
		Log.info("Entering the password");
		// driver.findElement(passwordField).sendKeys(password);
		userPassword.sendKeys(password);
	}

	public void loginButton() {
		Log.info("Clicking login button");
		// driver.findElement(loginButton).click();
		loginButton.click();

	}
}
