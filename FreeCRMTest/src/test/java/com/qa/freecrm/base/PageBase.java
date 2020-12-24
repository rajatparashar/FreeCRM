package com.qa.freecrm.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import com.qa.freecrm.common.utilities.XLMParser;

public class PageBase {
	static WebDriver driver;

	@BeforeTest
	public void LaunchBrowser() throws Exception {
		String browser = XLMParser.getbrowser();
		String url = XLMParser.geturl();
		String username = XLMParser.getusername();
		String password = XLMParser.getpassword();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.driver.chromedriver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
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
		

	}
}