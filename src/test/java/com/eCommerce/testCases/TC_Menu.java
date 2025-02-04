package com.eCommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eCommerce.pageObject.BaseClass;
import com.eCommerce.pageObject.LeftMenu;
import com.eCommerce.pageObject.LoginPage;
import com.eCommerce.utilities.AlertUtils;

public class TC_Menu extends BaseClass {
	LoginPage lg;
	LeftMenu menu;

	@BeforeMethod
	public void setUpLogin() {
		menu = new LeftMenu(driver);
		lg = new LoginPage(driver);
		lg.setUserName(uname);
		logger.info("*******UserName is set*************");
		lg.setPassword(pass);
		logger.info("*******Password is set*************");
		lg.clickLoginBtn();
		logger.info("*******click loginBtn*************");
	}
	@Test(priority = 1)
	public void menuCount() throws InterruptedException {
		Thread.sleep(5000l);
		int actuallnk = menu.LnkCount();
		logger.info("*********** Count is calculated**************");
		Assert.assertEquals(actuallnk, 35);
		logger.info("*********** Count is calculated**************" + actuallnk);
	}  
	
	@AfterMethod
	public void clickLogoutLnk() {
		menu.clickLogoutLnk();
		AlertUtils.waitForAlertAndAccept(driver, "You Have Succesfully Logged Out!!");
	}
}
