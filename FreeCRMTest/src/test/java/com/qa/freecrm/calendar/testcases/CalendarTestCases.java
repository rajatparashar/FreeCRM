package com.qa.freecrm.calendar.testcases;

import java.util.ArrayList;

import org.testng.annotations.Test;
import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.calendar.pages.CalendarPages;

public class CalendarTestCases extends TestBase {

	@Test
	public void CreateNewEventTest() throws Exception {
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
}