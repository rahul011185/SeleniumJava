package com.eCommerce.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eCommerce.utilities.ElementUtils;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement emailTxtBx;

	@FindBy(name = "password")
	WebElement passwordTxtBx;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public void setUserName(String username) {
		ElementUtils.sendKeys(driver, emailTxtBx, username);
	}

	public void setPassword(String password) {
		ElementUtils.sendKeys(driver, passwordTxtBx, password);
	}

	public void clickLoginBtn() {
	 ElementUtils.clickElement(driver, loginBtn);
	}	
	
	public void Login(String username, String password) {
		ElementUtils.sendKeys(driver, emailTxtBx, username);
        ElementUtils.sendKeys(driver, passwordTxtBx, password);
        ElementUtils.clickElement(driver, loginBtn);
		
		
	}
}
