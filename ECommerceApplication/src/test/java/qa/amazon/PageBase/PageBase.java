package qa.amazon.PageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.amazon.testBase.TestBase;

public class PageBase {
	private static int TIMEOUT = 50;
	protected WebDriver driver;
	protected TestBase test;
	
	
	public PageBase(TestBase test, WebDriver driver) {
		this.test = test;
		this.driver = driver;
		new WebDriverWait(driver, TIMEOUT);
	}

}
