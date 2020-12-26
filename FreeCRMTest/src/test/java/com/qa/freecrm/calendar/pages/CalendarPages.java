package com.qa.freecrm.calendar.pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.qa.freecrm.base.PageBase;

public class CalendarPages extends PageBase {

	public CalendarPages(WebDriver driver) {
		super(driver);
	}

	private By pageTitle = By.xpath("//div[@id='dashboard-toolbar']//div[contains(@class,'ui header')]");
	By calendarButton = By.xpath("//span[text()='Calendar']");
	private By newButton = By.xpath("//button[text()='New']");
	private By createNewEventHeader = By.xpath("//div[text()='Create new Event']");
	private By titleElement = By.xpath("//input[@name='title']");
	private By calendarElement = By.xpath("//div[@name='calendar']//i");
	private By categoryElement = By.xpath("//div[@name='category']//i");
	private By startDateElement = By
			.xpath("//label[contains(text(),'Start Date')]/..//div[contains(@class,'datepicker')]//input");
	private By endDateElement = By
			.xpath("//label[contains(text(),'End Date')]/..//div[contains(@class,'datepicker')]//input");
	private By tagsElement = By.xpath("//label[contains(text(),'Tags')]/..//div//i");
	private By descriptionElement = By.xpath("//label[contains(text(),'Description')]/..//textarea");
	private By locationElement = By.xpath("//label[contains(text(),'Location')]/..//textarea");
	private By allDayElement = By.xpath("//label[contains(text(),'All Day')]/..//div/label");
	private By dealElement = By.xpath("//label[contains(text(),'Deal')]/..//div/input");
	private By taskElement = By.xpath("//label[contains(text(),'Task')]/..//div/input");
	private By caseElement = By.xpath("//label[contains(text(),'Case')]/..//div/input");
	private By alertBeforeElement = By.xpath("//label[contains(text(),'Alert Before')]/..//div//i");
	private By reminderTimeElement = By.xpath("//label[contains(text(),'Reminder Time')]/..//div//input");
	private By assignedToElement = By.xpath("//label[contains(text(),'Assigned To')]/..//div//i");
	private By participantsElement = By.xpath("//label[contains(text(),'Participants')]/..//div//i");
	private By companyElement = By.xpath("//label[contains(text(),'Company')]/..//div//i");
	private By identifierElement = By.xpath("//label[contains(text(),'Identifier')]/..//div//input");

	public void clickCalendarButton() throws InterruptedException {
		driver.findElement(calendarButton).click();
		Thread.sleep(1000);
	}

	public void verifyCalendarPage() throws InterruptedException {
		String pageHeader = driver.findElement(pageTitle).getText();
		System.out.println(pageHeader);
		Assert.assertTrue(pageHeader.equals("Calendar"));
		Thread.sleep(1000);
	}

	public void clickNewButton() throws InterruptedException {
		driver.findElement(newButton).click();
		Thread.sleep(1000);
	}

	public void verifyCreateNewEventPage() throws InterruptedException {
		String pageHeader = driver.findElement(createNewEventHeader).getText();
		System.out.println(pageHeader);
		Assert.assertTrue(pageHeader.equals("Create new Event"));
		Thread.sleep(1000);
	}

	public void enterCalendarDetails(ArrayList<String> data) throws Exception {
		String titleValue = data.get(0);
		String calendarValue = data.get(1);
		String categoryValue = data.get(2);
		String startDateValue = data.get(3);
		String endDateValue = data.get(4);
		String tagsValue = data.get(5);
		String descriptionValue = data.get(6);
		String locationValue = data.get(7);
		String allDayValue = data.get(8);
		String dealValue = data.get(9);
		String taskValue = data.get(10);
		String caseValue = data.get(11);
		String alertBeforeValue = data.get(12);
		String reminderTimeValue = data.get(13);
		String assignedToValue = data.get(14);
		String participantsValue = data.get(15);
		String companyValue = data.get(16);
		String identifierValue = data.get(17);

		enterTitle(titleValue);
		enterCalendar(calendarValue);
		enterCategory(categoryValue);
		enterStartDate(startDateValue);
		enterEndDate(endDateValue);
		enterTags(tagsValue);
		enterDescription(descriptionValue);
		enterLocation(locationValue);
		enterAllDay(allDayValue);
		enterDeal(dealValue);
		enterTask(taskValue);
		enterCase(caseValue);
		enterAlertBefore(alertBeforeValue);
//		enterReminderTime(reminderTimeValue);
//		enterAssignedTo(assignedToValue);
//		enterParticipants(participantsValue);
//		enterCompany(companyValue);
//		enterIdentifier(identifierValue);

	}

	public void clickSaveButton(String sValue) {

	}

	public void verifyMeetingCreated(String sValue) {

	}

	public void mouseOverCalendar(String sValue) {

	}

	public void enterTitle(String sValue) throws InterruptedException {
		driver.findElement(titleElement).sendKeys(sValue);
		Thread.sleep(1000);
		System.out.println("Title: "+sValue);
	}

	public void enterCalendar(String sValue) throws InterruptedException {
		driver.findElement(calendarElement).click();
		String xpath = "//div[@name='calendar']//div[contains(@class,'menu')]//div/span[contains(text(),'"+sValue+"')]";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(1000);
	}

	public void enterCategory(String sValue) throws InterruptedException {
		driver.findElement(categoryElement).click();
		String xpath = "//div[@name='category']//div[contains(@class,'menu')]//div//span[contains(text(),'"+sValue+"')]";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(1000);
	}

	public void enterStartDate(String sValue) throws InterruptedException {
		driver.findElement(startDateElement).click();
		driver.findElement(startDateElement).clear();
		driver.findElement(startDateElement).sendKeys(sValue);
		Thread.sleep(1000);
	}

	public void enterEndDate(String sValue) throws InterruptedException {
		driver.findElement(endDateElement).click();
		driver.findElement(endDateElement).clear();
		driver.findElement(endDateElement).sendKeys(sValue);
		Thread.sleep(1000);
	}

	public void enterTags(String sValue) throws InterruptedException {
		driver.findElement(tagsElement).click();
		WebElement tagInput = driver.findElement(By.xpath("//label[contains(text(),'Tags')]/..//input"));
		tagInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Tags')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Tags')]/..//div//a[contains(text(),'"+sValue+"')]"));
		Assert.assertTrue(addedLabel.isDisplayed());
		Thread.sleep(1000);
	}

	public void enterDescription(String sValue) throws InterruptedException {
		driver.findElement(descriptionElement).sendKeys(sValue);
		Thread.sleep(1000);
		System.out.println("Description: "+sValue);
	}

	public void enterLocation(String sValue) throws InterruptedException {
		driver.findElement(locationElement).sendKeys(sValue);
		Thread.sleep(1000);
		System.out.println("Location: "+sValue);
	}

	public void enterAllDay(String sValue) throws InterruptedException {
		if(sValue.equalsIgnoreCase("true")) {
			driver.findElement(allDayElement).click();
			Thread.sleep(1000);
		}
		else {
			// no action required
		}
	}

	public void enterDeal(String sValue) throws InterruptedException {
		driver.findElement(dealElement).click();
		WebElement dealInput = driver.findElement(By.xpath("//label[contains(text(),'Deal')]/..//input"));
		dealInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Deal')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Deal')]/..//input//following-sibling::div[contains(text(),'"+sValue+"')]"));
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
		Thread.sleep(1000);

	}

	public void enterTask(String sValue) throws InterruptedException {
		driver.findElement(taskElement).click();
		WebElement taskInput = driver.findElement(By.xpath("//label[contains(text(),'Task')]/..//input"));
		taskInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Task')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Task')]/..//input//following-sibling::div[contains(text(),'"+sValue+"')]"));
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
		Thread.sleep(1000);
	}

	public void enterCase(String sValue) throws InterruptedException {
		driver.findElement(caseElement).click();
		WebElement caseInput = driver.findElement(By.xpath("//label[contains(text(),'Case')]/..//input"));
		caseInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Case')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Case')]/..//input//following-sibling::div[contains(text(),'"+sValue+"')]"));
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
		Thread.sleep(1000);
	}

	public void enterAlertBefore(String sValue) {

	}

	public void enterReminderTime(String sValue) throws InterruptedException {
		driver.findElement(reminderTimeElement).sendKeys(sValue);
		Thread.sleep(1000);
		System.out.println("ReminderTime: "+sValue);
	}

	public void enterAssignedTo(String sValue) {

	}

	public void enterParticipants(String sValue) {

	}

	public void enterCompany(String sValue) {

	}

	public void enterIdentifier(String sValue) throws InterruptedException {
		driver.findElement(identifierElement).sendKeys(sValue);
		Thread.sleep(1000);
		System.out.println("Identifier: "+sValue);
	}
}