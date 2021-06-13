package com.qa.freecrm.common.utilities;

import com.qa.freecrm.base.PageBase;

public class LoginAction extends PageBase {

	public void login(final String username, final String password) {
		LoginPage.getUserName(driver).sendKeys(username);
		LoginPage.getPassword(driver).sendKeys(password);
		LoginPage.getLoginButton(driver).click();
	}
}