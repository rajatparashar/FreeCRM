package com.qa.freecrm.calendar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.freecrm.base.PageBase;

public class CalendarPages extends PageBase {
	public CalendarPages(ExtentTest extentTest, WebDriver oDriver) {
		driver = oDriver;
		logger = extentTest;
	}

	private By pageTitle = By.xpath("//div[@id='dashboard-toolbar']//div[contains(@class,'ui header')]");
	By calendarButton = By.xpath("//span[text()='Calendar']");
	private By newButton = By.xpath("//button[text()='New']");
	private By createNewEventHeader = By.xpath("//div[text()='Create new Event']");
	private By titleElement = By.xpath("//input[@name='title']");
	private By calendarElement = By.xpath("//div[@name='calendar']//i");
	private By categoryElement = By.xpath("//div[@name='category']//i");
	private By startDateElement = By.xpath("//label[contains(text(),'Start Date')]/..//div[contains(@class,'datepicker')]//input");
	private By endDateElement = By.xpath("//label[contains(text(),'End Date')]/..//div[contains(@class,'datepicker')]//input");
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
	private By saveButton = By.xpath("//div//button//i[@class='save icon']");

	public void clickCalendarButton() throws InterruptedException {
		driver.findElement(calendarButton).click();
		logger.log(Status.INFO, "Clicked on Calendar button");
	}

	public void verifyCalendarPage() throws InterruptedException {
		String pageHeader = driver.findElement(pageTitle).getText();
		Assert.assertTrue(pageHeader.equals("Calendar"));
		logger.log(Status.PASS, "User is navigated to Calendar page");
	}

	public void clickNewButton() throws InterruptedException {
		driver.findElement(newButton).click();
		logger.log(Status.INFO, "Clicked on New button");
	}

	public void verifyCreateNewEventPage() throws InterruptedException {
		String pageHeader = driver.findElement(createNewEventHeader).getText();
		Assert.assertTrue(pageHeader.equals("Create new Event"));
		logger.log(Status.PASS, "User is navigated to Create new Event page");
	}

	public void enterCalendarDetails(String Title, String Calendar, String Category, String StartDate, String EndDate,
			String Tags, String Description, String Location, String AllDay, String Deal, String Task, String Case,
			String AlertBefore, String ReminderTime, String AssignedTo, String Participants, String Company,
			String Identifier) throws InterruptedException {

		enterTitle(Title);
		enterCalendar(Calendar);
		enterCategory(Category);
		enterStartDate(StartDate);
		enterEndDate(EndDate);
		enterTags(Tags);
		enterDescription(Description);
		enterLocation(Location);
		enterAllDay(AllDay);
		enterDeal(Deal);
		enterTask(Task);
		enterCase(Case);
		enterAlertBefore(AlertBefore);
		enterReminderTime(ReminderTime);
		enterAssignedTo(AssignedTo);
		enterParticipants(Participants);
		enterCompany(Company);
		enterIdentifier(Identifier);
	}

	public void clickSaveButton() throws InterruptedException {
		driver.findElement(saveButton).click();
		logger.log(Status.INFO, "Clicked on Save button");
	}

	public void enterTitle(String sValue) throws InterruptedException {
		driver.findElement(titleElement).sendKeys(sValue);
		logger.log(Status.INFO, "Entered Title is " + sValue);
	}

	public void enterCalendar(String sValue) throws InterruptedException {
		driver.findElement(calendarElement).click();
		String xpath = "//div[@name='calendar']//div[contains(@class,'menu')]//div/span[contains(text(),'" + sValue + "')]";
		driver.findElement(By.xpath(xpath)).click();
		logger.log(Status.INFO, "Selected Calendar is " + sValue);
	}

	public void enterCategory(String sValue) throws InterruptedException {
		driver.findElement(categoryElement).click();
		String xpath = "//div[@name='category']//div[contains(@class,'menu')]//div//span[contains(text(),'" + sValue + "')]";
		driver.findElement(By.xpath(xpath)).click();
		logger.log(Status.INFO, "Entered Category is " + sValue);
	}

	public void enterStartDate(String sValue) throws InterruptedException {
		driver.findElement(startDateElement).click();
		driver.findElement(startDateElement).clear();
		driver.findElement(startDateElement).sendKeys(sValue);
	}

	public void enterEndDate(String sValue) throws InterruptedException {
		driver.findElement(endDateElement).click();
		driver.findElement(endDateElement).clear();
		driver.findElement(endDateElement).sendKeys(sValue);
	}

	public void enterTags(String sValue) throws InterruptedException {
		driver.findElement(tagsElement).click();
		WebElement tagInput = driver.findElement(By.xpath("//label[contains(text(),'Tags')]/..//input"));
		tagInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Tags')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Tags')]/..//div//a[contains(text(),'" + sValue + "')]"));
		logger.log(Status.INFO, "Entered Tag is " + sValue);
		Assert.assertTrue(addedLabel.isDisplayed());
	}

	public void enterDescription(String sValue) throws InterruptedException {
		driver.findElement(descriptionElement).sendKeys(sValue);
		logger.log(Status.INFO, "Entered Description is " + sValue);
	}

	public void enterLocation(String sValue) throws InterruptedException {
		driver.findElement(locationElement).sendKeys(sValue);
		logger.log(Status.INFO, "Entered Location is " + sValue);
	}

	public void enterAllDay(String sValue) throws InterruptedException {
		if (sValue.equalsIgnoreCase("yes")) {
			driver.findElement(allDayElement).click();
		} else {
			// no action required
		}
	}

	public void enterDeal(String sValue) throws InterruptedException {
		driver.findElement(dealElement).click();
		WebElement dealInput = driver.findElement(By.xpath("//label[contains(text(),'Deal')]/..//input"));
		dealInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Deal')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Deal')]/..//input//following-sibling::div[contains(text(),'" + sValue + "')]"));
		logger.log(Status.INFO, "Entered Deal is " + sValue);
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
	}

	public void enterTask(String sValue) throws InterruptedException {
		driver.findElement(taskElement).click();
		WebElement taskInput = driver.findElement(By.xpath("//label[contains(text(),'Task')]/..//input"));
		taskInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Task')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Task')]/..//input//following-sibling::div[contains(text(),'" + sValue + "')]"));
		logger.log(Status.INFO, "Entered Task is " + sValue);
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
	}

	public void enterCase(String sValue) throws InterruptedException {
		driver.findElement(caseElement).click();
		WebElement caseInput = driver.findElement(By.xpath("//label[contains(text(),'Case')]/..//input"));
		caseInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Case')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Case')]/..//input//following-sibling::div[contains(text(),'" + sValue + "')]"));
		logger.log(Status.INFO, "Entered Case is " + sValue);
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
	}

	public void enterAlertBefore(String sValue) throws InterruptedException {
		driver.findElement(alertBeforeElement).click();
		String xpath = "//div[@name='minutesBefore']//div//div//span[contains(text(),'" + sValue + "')]";
		driver.findElement(By.xpath(xpath)).click();
		logger.log(Status.INFO, "Alert before is " + sValue);
	}

	public void enterReminderTime(String sValue) throws InterruptedException {
		driver.findElement(reminderTimeElement).sendKeys(sValue);
		logger.log(Status.INFO, "Entered Reminder Time is " + sValue);
	}

	public void enterAssignedTo(String sValue) throws InterruptedException {
		driver.findElement(assignedToElement).click();
		String xpath = "//label[contains(text(),'Assigned To')]/..//div//i/following-sibling::div//div//span[contains(text(),'"	+ sValue + "')]";
		driver.findElement(By.xpath(xpath)).click();
		logger.log(Status.INFO, "Assigned to is " + sValue);
	}

	public void enterParticipants(String sValue) throws InterruptedException {
		driver.findElement(participantsElement).click();
		WebElement participantInput = driver.findElement(By.xpath("//label[contains(text(),'Participants')]/..//input"));
		participantInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Participants')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Participants')]/..//div//a[contains(text(),'" + sValue + "')]"));
		logger.log(Status.INFO, "Entered Participants is " + sValue);
		Assert.assertTrue(addedLabel.isDisplayed());
	}

	public void enterCompany(String sValue) throws InterruptedException {
		driver.findElement(companyElement).click();
		WebElement companyInput = driver.findElement(By.xpath("//label[contains(text(),'Company')]/..//input"));
		companyInput.sendKeys(sValue);
		WebElement suggestion = driver.findElement(By.xpath("//label[contains(text(),'Company')]/..//div//div//span"));
		suggestion.click();
		WebElement addedLabel = driver.findElement(By.xpath("//label[contains(text(),'Company')]/..//input//following-sibling::div[contains(text(),'" + sValue + "')]"));
		logger.log(Status.INFO, "Entered Company is " + sValue);
		Assert.assertTrue(addedLabel.getText().equalsIgnoreCase(sValue));
	}

	public void enterIdentifier(String sValue) throws InterruptedException {
		driver.findElement(identifierElement).sendKeys(sValue);
		logger.log(Status.INFO, "Entered Identifier is " + sValue);
	}

	public void verifyMeetingCreated(String Title, String Calendar, String Category, String StartDate, String EndDate,
			String Tags, String Description, String Location, String AllDay, String Deal, String Task, String Case,
			String AlertBefore, String ReminderTime, String AssignedTo, String Participants, String Company,
			String Identifier) throws InterruptedException {

		String actualTitle = driver.findElement(By.xpath("//div[contains(text(),'Title')]/following-sibling::div//div//span//p")).getText();
		String actualCalendar = driver.findElement(By.xpath("//div[contains(text(),'Calendar')]/following-sibling::div")).getText();
		String actualCategory = driver.findElement(By.xpath("//div[contains(text(),'Category')]/following-sibling::div//div")).getText();
		String actualStartDate = driver.findElement(By.xpath("//div[contains(text(),'Start Date')]/following-sibling::div//a[1]")).getText();
		String actualEndDate = driver.findElement(By.xpath("//div[contains(text(),'End Date')]/following-sibling::div//a[1]")).getText();
		String actualTags = driver.findElement(By.xpath("//div[contains(text(),'Tags')]/following-sibling::div//a//div")).getText();
		String actualDescription = driver.findElement(By.xpath("//div[contains(text(),'Description')]/following-sibling::div//div//span//p")).getText();
		String actualLocation = driver.findElement(By.xpath("//div[contains(text(),'Location')]/following-sibling::div//div//span//p")).getText();
		String actualAllDay = driver.findElement(By.xpath("//div[contains(text(),'All Day')]/following-sibling::div")).getText();
		String actualDeal = driver.findElement(By.xpath("//div[contains(text(),'Deal')]/following-sibling::div//a//div[1]//div")).getText();
		String actualTask = driver.findElement(By.xpath("//div[contains(text(),'Task')]/following-sibling::div//a//div[1]//div")).getText();
		String actualCase = driver.findElement(By.xpath("//div[contains(text(),'Case')]/following-sibling::div//a//div[1]//div")).getText();
		String actualReminderTime = driver.findElement(By.xpath("//div[contains(text(),'Reminder Time')]/following-sibling::div//div")).getText();
		String actualAssignedTo = driver.findElement(By.xpath("//label[contains(text(),'Assigned To')]/..//div//div")).getText();
		String actualParticipants = driver.findElement(By.xpath("//div[contains(text(),'Participants')]/following-sibling::div//div[1]//div")).getText();
		String actualCompany = driver.findElement(By.xpath("//div[contains(text(),'Company')]/following-sibling::div//div[1]//div")).getText();
		String actualIdentifier = driver.findElement(By.xpath("//div[contains(text(),'Identifier')]/following-sibling::div//div//span//p")).getText();

		Assert.assertEquals(actualTitle, Title);
		logger.log(Status.PASS, "Title matches");
		Assert.assertEquals(actualCalendar, Calendar);
		logger.log(Status.PASS, "Calendar value matches");
		Assert.assertEquals(actualCategory, Category);
		logger.log(Status.PASS, "Category matches");
//		Assert.assertEquals(actualStartDate, startDateValue);
//		Assert.assertEquals(actualEndDate, endDateValue);
		Assert.assertEquals(actualTags, Tags);
		logger.log(Status.PASS, "Tag matches");
		Assert.assertEquals(actualDescription, Description);
		logger.log(Status.PASS, "Description matches");
		Assert.assertEquals(actualLocation, Location);
		logger.log(Status.PASS, "Location matches");
		Assert.assertEquals(actualAllDay, AllDay);
		logger.log(Status.PASS, "All Day matches");
		Assert.assertEquals(actualDeal, Deal);
		logger.log(Status.PASS, "Deal matches");
		Assert.assertEquals(actualTask, Task);
		logger.log(Status.PASS, "Task matches");
		Assert.assertEquals(actualCase, Case);
		logger.log(Status.PASS, "Case matches");
		Assert.assertEquals(actualReminderTime, ReminderTime);
		logger.log(Status.PASS, "Reminder Time mtches");
		Assert.assertEquals(actualAssignedTo, AssignedTo);
		logger.log(Status.PASS, "Assigned To matches");
		Assert.assertEquals(actualParticipants, Participants);
		logger.log(Status.PASS, "Participants matches");
		Assert.assertEquals(actualCompany, Company);
		logger.log(Status.PASS, "Company matches");
		Assert.assertEquals(actualIdentifier, Identifier);
		logger.log(Status.PASS, "Identifier matches");
	}
}