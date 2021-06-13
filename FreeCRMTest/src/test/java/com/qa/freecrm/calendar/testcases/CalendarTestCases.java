package com.qa.freecrm.calendar.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.freecrm.base.TestBase;
import com.qa.freecrm.calendar.pages.CalendarPages;
import com.qa.freecrm.common.utilities.ExcelReader;

public class CalendarTestCases extends TestBase {

	public CalendarTestCases() {
		super();
	}

	private static String sTestDataFile = System.getProperty("user.dir") + "\\TestData\\CalendarTestData.xlsx";

	@DataProvider
	public Object[][] createnewevent() throws Exception {
		return ExcelReader.getTableArray(sTestDataFile, "Calendar");
	}

	@Test(dataProvider = "createnewevent", priority = 0)
	public void CreateNewEventTest(String Iteration, String Title, String Calendar, String Category, String StartDate,
			String EndDate, String Tags, String Description, String Location, String AllDay, String Deal, String Task,
			String Case, String AlertBefore, String ReminderTime, String AssignedTo, String Participants,
			String Company, String Identifier) throws Exception {
		test = extent.createTest("Create new Event Test");
		CalendarPages calendarPages = new CalendarPages(TestBase.test, this.getDriver());

		calendarPages.clickCalendarButton();
		calendarPages.verifyCalendarPage();
		calendarPages.clickNewButton();
		calendarPages.verifyCreateNewEventPage();
		calendarPages.enterCalendarDetails(Title, Calendar, Category, StartDate, EndDate, Tags, Description, Location,
				AllDay, Deal, Task, Case, AlertBefore, ReminderTime, AssignedTo, Participants, Company, Identifier);
		calendarPages.clickSaveButton();
		calendarPages.verifyMeetingCreated(Title, Calendar, Category, StartDate, EndDate, Tags, Description, Location,
				AllDay, Deal, Task, Case, AlertBefore, ReminderTime, AssignedTo, Participants, Company, Identifier);
	}
}