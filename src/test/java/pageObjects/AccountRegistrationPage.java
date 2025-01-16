package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = ("//input[@id='input-firstname']"))
	WebElement txtFirstname;
	@FindBy(xpath = ("//input[@id='input-lastname']"))
	WebElement txtLastname;

	@FindBy(xpath = ("//input[@id='input-email']"))
	WebElement txtEmail;

	@FindBy(xpath = ("//input[@id='input-password']"))
	WebElement txtPassword;

	@FindBy(xpath = ("//input[@id='input-confirm']"))
	WebElement txtConfirmPassword;

	@FindBy(xpath = ("//input[@id='input-telephone']"))
	WebElement txtTelephone;

	@FindBy (xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy (xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstname(String txtFirstname) {
		this.txtFirstname.sendKeys(txtFirstname);
	}

	public void setLastname(String txtLastname) {
		this.txtLastname.sendKeys(txtLastname);
	}

	public void setEmail(String txtEmail) {
		this.txtEmail.sendKeys(txtEmail);
	}

	public void setPassword(String txtPassword) {
		this.txtPassword.sendKeys( txtPassword);
	}

	public void setConfirmPassword(String txtConfirmPassword) {
		this.txtConfirmPassword.sendKeys(txtConfirmPassword);
	}

	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);;
	}

	
	public void setPrivacyPolicy() {
//		chkdPolicy.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", chkdPolicy);
	}
	
	public void clickContinue() {
//		btnContinue.click();
		
//		btnContinue.submit();
		
//		Actions act=new Actions(driver);
//		act.moveToElement(btnContinue).click();
//		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", btnContinue);
//		
		btnContinue.sendKeys(Keys.RETURN);
//		
//		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	
	
	public String getConfirmationMsg() {
		try {
			
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	
	
}
