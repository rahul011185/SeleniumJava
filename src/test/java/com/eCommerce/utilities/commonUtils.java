package com.eCommerce.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.eCommerce.pageObject.BaseClass;

public class commonUtils extends BaseClass {

	public static void verifyPageTitle(WebDriver driver, String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
	}

}
