package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException {

		logger.info("***** Starting TC003_LoginDDT *****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on myaccount link");
			hp.clickLogin();
			logger.info("Clicked on login link");

			LoginPage lp = new LoginPage(driver);

			logger.info("Providing customer details");

			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage) {
					macc.clickLogout();

					Assert.assertTrue(true);
				} else {

					Assert.assertTrue(false);
				}

			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage) {
					macc.clickLogout();

					Assert.assertTrue(false);
				} else {

					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			System.out.println(email);
			e.printStackTrace();
			Assert.fail();
		}

		logger.info("***** Finished TC003_LoginDDT *****");

	}

}
