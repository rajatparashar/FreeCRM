package com.qa.freecrm.base;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.freecrm.common.utilities.LoginPage;
import com.qa.freecrm.common.utilities.XLMParser;

public class TestBase {
	WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void LaunchBrowser() throws Exception {
		String browser = XLMParser.getbrowser();
		String url = XLMParser.geturl();
		String username = XLMParser.getusername();
		String password = XLMParser.getpassword();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "//Drivers//operadriver.exe");
			driver = new OperaDriver();
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

	@BeforeTest
	public void extentReportSetUp() throws UnknownHostException {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//Reports//AutomationReport" + currentDate() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Free CRM Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		// General information related to application
		extent.setSystemInfo("Aplication name : ", "Free CRM");
		extent.setSystemInfo("OS : ", System.getProperty("os.name"));
		extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
		extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
		InetAddress myIP = InetAddress.getLocalHost();
		extent.setSystemInfo("IP Address : ", myIP.getHostAddress());
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName();
		String browserVersion = cap.getVersion();
		extent.setSystemInfo("Browser : ", browserName);
		extent.setSystemInfo("Browser version : ", browserVersion);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// To capture screenshot path and store the path of the screenshot in the string
			// screenshotPath
			// We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method
			String screenshotPath = TakeScreenshot(driver, result.getName());
			// To add it in the extent report
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//Screenshots//" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}

	public String currentDate() {
		return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
	}
}