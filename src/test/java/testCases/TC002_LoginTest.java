package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	

	

	
	@Test(groups={"Sanity","Master"})
	public void verify_login() throws InterruptedException {

		logger.info("***** Starting TC002_LoginTest *****");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on myaccount link");
			hp.clickLogin();
			logger.info("Clicked on login link");

			LoginPage lp=new LoginPage(driver);
			
			
			logger.info("Providing customer details");

			
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage,true,"Login failed");
			
			

		}catch(Exception e) {
			logger.info("***** EXCEPTION TC002_LoginTest *****");
			logger.debug(e.getMessage());

			Assert.fail();
		}
		
		
		logger.info("***** Finished TC002_LoginTest *****");

	}
	
	
}
