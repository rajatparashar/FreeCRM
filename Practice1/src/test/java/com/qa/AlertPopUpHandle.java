package com.qa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertPopUpHandle {

	@Test
	@Parameters("browser")
	public void AlertTest(String browser) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();

		WebElement goButton = driver.findElement(By.name("proceed"));
		goButton.click();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		if (alert.getText().equals("Please enter a valid user name")) {
			System.out.println("correct alert message");
		} else {
			System.out.println("incorrect alert message");
		}
		alert.accept(); // click on OK button
	}
}