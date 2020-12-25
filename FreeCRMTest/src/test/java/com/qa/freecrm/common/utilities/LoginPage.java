package com.qa.freecrm.common.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.freecrm.base.TestBase;

public class LoginPage extends TestBase {
	public static WebElement getUserName(final WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='email']"));
	}

	public static WebElement getPassword(final WebDriver driver) {
		return driver.findElement(By.xpath("//input[@name='password']"));
	}

	public static WebElement getLoginButton(final WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(@class,'submit')]"));
	}
}