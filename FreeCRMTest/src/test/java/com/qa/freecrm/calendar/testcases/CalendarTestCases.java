package com.qa.freecrm.calendar.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.calendar.pages.CalendarPages;

public class CalendarTestCases extends TestBase {

	public CalendarTestCases() {
		super();
	}
	@Test(priority = 0)
	public void CreateNewEventTest() throws Exception {
		test = extent.createTest("Create new Event Test");
		CalendarPages calendarPages = new CalendarPages(TestBase.test, this.getDriver());

		ArrayList<String> data = new ArrayList<String>();
		data.add("My Meeting title");
		data.add("My Calender");
		data.add("Optional");
		data.add("23/01/2021 16:15");
		data.add("30/03/2021 22:30");
		data.add("standup meeting");
		data.add("My meeting Description");
		data.add("My meeting Location");
		data.add("Yes");
		data.add("client deal");
		data.add("client task");
		data.add("client case");
		data.add("1 Hour");
		data.add("50");
		data.add("Rajat P");
		data.add("Rahul Gupta");
		data.add("Google inc.");
		data.add("Google meeting Identifier");

		calendarPages.clickCalendarButton();
		calendarPages.verifyCalendarPage();
		calendarPages.clickNewButton();
		calendarPages.verifyCreateNewEventPage();
		calendarPages.enterCalendarDetails(data);
		calendarPages.clickSaveButton();
		calendarPages.verifyMeetingCreated(data);
	}
}