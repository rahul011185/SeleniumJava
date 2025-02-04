package com.eCommerce.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	public static void executeScript(WebDriver driver, String script, Object... args) {
		((JavascriptExecutor) driver).executeScript(script, args);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		executeScript(driver, "arguments[0].scrollIntoView();", element);
	}

	public static void clickUsingJS(WebDriver driver, WebElement element) {
		executeScript(driver, "arguments[0].click();", element);
	}
}
