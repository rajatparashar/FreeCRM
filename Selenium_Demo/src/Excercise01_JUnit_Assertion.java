import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise01_JUnit_Assertion {
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = "https://ui.freecrm.com/";
		driver.get(url);
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("rajatparasharan@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Rajat@1234");
		driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
		String pageURL = driver.getCurrentUrl();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened windows: "+windowHandles.size());
		
		System.out.println("Curent URL is " + pageURL);
		Thread.sleep(5000);

		String text = driver.findElement(By.xpath("//span[@class='user-display']")).getText();
		Assert.assertEquals("Rajat P", text);
		
		driver.findElement(By.xpath("//div/i[@class='settings icon']")).click();
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
	}

	@After
	public void tearDown() {
		driver.close();
	}
}