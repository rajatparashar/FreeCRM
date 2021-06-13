import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2_WorkingWithBrowser {

	WebDriver driver;
	String url = "https://www.google.com/";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\My\\eclipse-workspace\\Selenium_Demo\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test
	public void test() {
		String title = driver.getTitle();
		Assert.assertEquals("Google", title);
		System.out.println("Page title is " + title);
	}

	@After
	public void tearDown() {
		driver.close();
	}

}
