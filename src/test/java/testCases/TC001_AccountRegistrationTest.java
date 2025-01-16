package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	

	
	@Test(groups={"Regression","Master"})

	public void verify_account_registration() throws InterruptedException {

		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on myaccount link");
			hp.clickRegister();
			logger.info("Clicked on register link");

			Thread.sleep(30);
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			
			logger.info("Providing customer details");

			
			regpage.setFirstname(randomeString().toUpperCase());
			regpage.setLastname(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");
			
			
			regpage.setPassword(randomeAlphaNumeric());
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			String confirmationMsg = regpage.getConfirmationMsg();
			if (confirmationMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test failed...");
				logger.debug("Debug logs");
				Assert.fail();
			}

		}catch(Exception e) {
			logger.error("Test failed...");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");

	}
	
	
}
