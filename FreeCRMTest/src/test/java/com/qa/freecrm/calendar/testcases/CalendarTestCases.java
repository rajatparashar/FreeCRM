package com.qa.freecrm.calendar.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;
import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.calendar.pages.CalendarPages;

public class CalendarTestCases extends TestBase {

	@Test(priority = 0)
	public void CreateNewEventTest() throws Exception {
		test = extent.createTest("Create new Event Test");
		CalendarPages calendarPages = new CalendarPages(getDriver());
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("My Meeting title");
		data.add("");
		data.add("");
		data.add("");
		data.add("");
		data.add("");
		data.add("My meeting Description");
		data.add("My meeting Location");
		data.add("");
		data.add("");
		data.add("");
		data.add("");
		data.add("");
		data.add("50");
		data.add("");
		data.add("");
		data.add("");
		data.add("My meeting Identifier");
		
		calendarPages.clickCalendarButton();
		calendarPages.verifyCalendarPage();
		calendarPages.clickNewButton();
		calendarPages.verifyCreateNewEventPage();
		calendarPages.enterCalendarDetails(data);
	}

	@Test(priority = 1)
	public void CreateNewEventTest2() throws Exception {
		test = extent.createTest("Create new Event Test 2");
		CalendarPages calendarPages = new CalendarPages(getDriver());
		
		calendarPages.clickCalendarButton();
		calendarPages.verifyCalendarPage();
		calendarPages.clickNewButton();
		calendarPages.verifyCreateNewEventPage();
//		calendarPages.enterCalendarDetails(data);
	}
	

	@Test(priority = 2)
	public void CreateNewEventTest3() throws Exception {
		test = extent.createTest("Create new Event Test 3");
		CalendarPages calendarPages = new CalendarPages(getDriver());
		
		calendarPages.clickCalendarButton();
		calendarPages.verifyCalendarPage();
		calendarPages.clickNewButton();
		calendarPages.verifyCreateNewEventPage();
//		calendarPages.enterCalendarDetails(data);
	}
}