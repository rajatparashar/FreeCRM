package com.qa.freecrm.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.freecrm.common.utilities.LoginPage;
import com.qa.freecrm.common.utilities.XLMParser;

public class TestBase {
	static WebDriver driver;

	@BeforeSuite
	public void LaunchBrowser() throws Exception {
		String browser = XLMParser.getbrowser();
		String url = XLMParser.geturl();
		String username = XLMParser.getusername();
		String password = XLMParser.getpassword();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"//Drivers//operadriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		LoginPage.getUserName(driver).sendKeys(username);
		LoginPage.getPassword(driver).sendKeys(password);
		LoginPage.getLoginButton(driver).click();
	}
	
	public WebDriver getDriver() {
        return driver;
    }
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
}