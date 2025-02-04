package com.eCommerce.testCases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eCommerce.pageObject.BaseClass;
import com.eCommerce.pageObject.LoginPage;
import com.eCommerce.utilities.AlertUtils;
import com.eCommerce.utilities.commonUtils;

public class TC_LoginPage extends BaseClass {
	LoginPage lg;

	@BeforeMethod
	public void setup() {
		lg = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void emptyCredentials() {
		logger.info("******Test Case-1 Started empty userName/password**********");
		lg.clickLoginBtn();
		logger.info("****************click login button***************");
		AlertUtils.waitForAlertAndAccept(driver, "User is not valid");
		logger.info("******Test Case-1 End Empty empty userName/password**********");
	}

	@Test(priority = 2)
	public void blankPassword() {
		logger.info("******Test Case-3 Started Valid userName & empty password**********");
		lg.setUserName(uname);
		logger.info("*********Entered User Name********");
		lg.clickLoginBtn();
		logger.info("********click login button********");
		AlertUtils.waitForAlertAndAccept(driver, "User is not valid");
		logger.info("******Test Case-3 End Valid userName & empty password**********");
	}

	@Test(priority = 3)
	public void blankUserName() {
		logger.info("******Test Case-2 Started blank userName & valid password**********");
		logger.info("*********driver is invoked********");
		lg.setPassword(pass);
		logger.info("********Password value is added********");
		lg.clickLoginBtn();
		logger.info("********click login button********");
		AlertUtils.waitForAlertAndAccept(driver, "User is not valid");
		logger.info("******Test Case-2 End blank userName & valid password**********");
	}

	@Test(priority = 4)
	public void ValidCredentials() {
		logger.info("******Test Case-4 Started Valid userName/password**********");
		lg.Login(uname,pass);
		logger.info("*********Click Login Button********");
		commonUtils.verifyPageTitle(driver, "GTPL Bank Manager HomePage");
		logger.info("******Test Case-4 End Valid userName/password**********");
	}

}
