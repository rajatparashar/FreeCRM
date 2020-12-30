package com.qa.freecrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

public class PageBase {
	private static final int TIMEOUT = 50;
	private static final int POLLING = 100;
	protected WebDriver driver;
	protected TestBase test;
	public ExtentTest logger;

	public PageBase() {
	}

	public PageBase(TestBase test, WebDriver driver) {
		this.test = test;
		this.driver = driver;
		new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	public PageBase(ExtentTest test, WebDriver driver) {
		this.test = new TestBase();
		TestBase.test = test;
		this.test.driver = driver;
		this.driver = this.test.driver;
	}
}