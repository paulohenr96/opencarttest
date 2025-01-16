package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = ("//input[@id='input-email']"))
	WebElement txtEmailAddress;
	@FindBy(xpath = ("//input[@id='input-password']"))
	WebElement txtPassword;

	@FindBy(xpath = ("//button[normalize-space()='Login']"))
	WebElement btnLogin;

	public void setEmail(String txtFirstname) {
		txtEmailAddress.sendKeys(txtFirstname);
	}

	public void setPassword(String txtLastname) {
		txtPassword.sendKeys(txtLastname);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
}
