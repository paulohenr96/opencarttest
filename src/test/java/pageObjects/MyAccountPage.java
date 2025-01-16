package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ("//h1[normalize-space()='My Account']"))
	WebElement msgHeading;
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement lnkLogout;

	public boolean isMyAccountPageExists() {

		try {

			return msgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickLogout() {
		clickMyAccount();
		lnkLogout.click();

	}
	
	
}
