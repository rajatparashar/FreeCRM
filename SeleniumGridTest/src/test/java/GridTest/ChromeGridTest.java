package GridTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeGridTest {
	public static void main(String[] args) throws MalformedURLException {

//		1. Define Desired Capabilities:
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

//		2. Chrome Options definiton:
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		String hubURL = "http://192.168.43.195:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("ABC");
//		Thread.sleep(2000);
		driver.close();
//		java -Dwebdriver.chrome.driver="C:/Users/My/Downloads/chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.43.195:4444/grid/register
	}
}