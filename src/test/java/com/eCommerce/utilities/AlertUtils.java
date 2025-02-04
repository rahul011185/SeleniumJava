package com.eCommerce.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.eCommerce.pageObject.BaseClass;

public class AlertUtils extends BaseClass {

	public static void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public static String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public static void sendKeysToAlert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	public static void waitForAlertAndAccept(WebDriver driver, String expectedAlertMessage) {
		logger.info("Waiting for the alert to be present...");
		WaitUtils.waitForAlert(driver, 10);
		getAlertText(driver);
		logger.info("****Verifying alert message. Expected:****** " + expectedAlertMessage + ", Actual: "
				+ getAlertText(driver));
		Assert.assertEquals(getAlertText(driver), expectedAlertMessage,
				"Alert message mismatch! Expected: " + expectedAlertMessage + ", but found: " + getAlertText(driver));
		logger.info("****Accepting the alert...******");
		acceptAlert(driver);
	}

}
