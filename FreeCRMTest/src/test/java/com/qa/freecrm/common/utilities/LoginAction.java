package com.qa.freecrm.common.utilities;

import org.openqa.selenium.WebDriver;

public class LoginAction {

	public void login(final String username, final String password) {
		WebDriver driver = null;
		LoginPage.getUserName(driver).sendKeys(username);
		LoginPage.getPassword(driver).sendKeys(password);
		LoginPage.getLoginButton(driver).click();
	}
}