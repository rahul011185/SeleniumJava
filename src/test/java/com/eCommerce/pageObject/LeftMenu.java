package com.eCommerce.pageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eCommerce.utilities.JavaScriptUtils;
import com.eCommerce.utilities.WaitUtils;

public class LeftMenu {

	WebDriver ldriver;

	public LeftMenu(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement logOutLnk;

	@FindBy(xpath = "//div[@id='navbar-brand-centered']//ul//li//a")
	public List<WebElement> links;

	public void clickLogoutLnk() {
		JavaScriptUtils.scrollToElement(ldriver, logOutLnk);
		WaitUtils.waitForElementClickable(ldriver, logOutLnk, 10);
		JavaScriptUtils.clickUsingJS(ldriver, logOutLnk);
	}

	public int LnkCount() {
		return links.size();

	}

	public void printAllLinks() {
		for (WebElement link : links) {
			System.out.println(link.getText());
		}
	}
}
