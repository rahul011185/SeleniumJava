package com.eCommerce.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	
	public static WebElement findElement(WebDriver driver, WebElement ele, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(ele)); // Fix applied here
    }

    public static void clickElement(WebDriver driver, WebElement ele) {
        WebElement element = findElement(driver, ele, 10);
        element.click();
    }

    public static void sendKeys(WebDriver driver, WebElement element, String text) {
        WebElement elementValue = findElement(driver, element, 10);
        elementValue.clear();
        elementValue.sendKeys(text);
    }
}
