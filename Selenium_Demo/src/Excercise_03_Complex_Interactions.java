import java.util.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Excercise_03_Complex_Interactions {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "https://www.yatra.com/";
		driver.get(url);
	}

	@Test
	public void test() {
		action = new Actions(driver);
		login();
		selectBusesOption();
		selectSource();
		selectDestination();
		selectJourneyDate();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

	public void login() {
		WebElement myAccountLink = driver.findElement(By.xpath("//a[text()='My Account']"));
		action.moveToElement(myAccountLink).build().perform();
		WebElement loginButton = driver.findElement(By.id("signInBtn"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInBtn")));
		loginButton.click();
		loginProcess();
	}

	public void loginProcess() {
		WebElement emailIdElement = driver.findElement(By.xpath("//input[@title='Enter your email id/mobile to continue.']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Enter your email id/mobile to continue.']")));
		emailIdElement.sendKeys("rajatparasharan@gmail.com");
		WebElement continueButton = driver.findElement(By.id("login-continue-btn"));
		continueButton.click();

		WebElement passwordElement = driver.findElement(By.id("login-password"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));
		passwordElement.sendKeys("Rajat@1234");

		WebElement loginButton = driver.findElement(By.id("login-submit-btn"));
		loginButton.click();
		verifyLogin();
	}

	public void verifyLogin() {
		WebElement guestElement = driver.findElement(By.xpath("//a[contains(@class,'loginUserName')]"));
		Assert.assertEquals("Hi Guest", guestElement.getText());
	}

	public void selectBusesOption() {
		WebElement busesElement = driver.findElement(By.xpath("//span[text()='Buses']"));
		busesElement.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Book Bus Tickets']")));
	}

	public void selectSource() {
		WebElement departFromElement = driver.findElement(By.id("BE_bus_from_station"));
		departFromElement.click();
		departFromElement.sendKeys("Bangalore");
//		departFromElement.sendKeys(Keys.RETURN);
		List<WebElement> goingToList = driver.findElements(By.xpath("//div[@class='ac_results dest_ac']//ul//li//span"));

		for (int i = 1; i <= goingToList.size(); i++) {
			WebElement listItem = driver.findElement(By.xpath("//div[@class='ac_results dest_ac']//ul//li[" + i + "]//span"));
			if (listItem.getText().equalsIgnoreCase("Bangalore")) {
				System.out.println("going to " + listItem.getText());
				listItem.click();
				break;
			} else {
				System.out.println("going to " + listItem.getText());
			}
		}
	}

	public void selectDestination() {
		WebElement goingToElement = driver.findElement(By.id("BE_bus_to_station"));
		goingToElement.click();
		goingToElement.sendKeys("Hyderabad");
//		goingToElement.sendKeys(Keys.RETURN);
		List<WebElement> goingToList = driver.findElements(By.xpath("//div[@class='ac_results dest_ac']//ul//li//span"));

		for (int i = 1; i <= goingToList.size(); i++) {
			WebElement listItem = driver.findElement(By.xpath("//div[@class='ac_results dest_ac']//ul//li[" + i + "]//span"));
			if (listItem.getText().equalsIgnoreCase("Hyderabad")) {
				System.out.println("going to " + listItem.getText());
				listItem.click();
				break;
			} else {
				System.out.println("going to " + listItem.getText());
			}
		}
	}

	public void selectJourneyDate() {
		WebElement goingToElement = driver.findElement(By.id("BE_bus_depart_date"));
		goingToElement.click();
		driver.findElement(By.xpath("//td[@class=' weekend']")).click();
	}
}