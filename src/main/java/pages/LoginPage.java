package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By login = By.linkText("Log in");
	private By emailField = By.id("Email");
	private By passwordField = By.id("Password");
	private By loginButton = By.xpath("//input[@value='Log in']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickLogin() {
		driver.findElement(login).click();
	}

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void loginButton() {
		driver.findElement(loginButton).click();

	}
}
