package com.qa.freecrm.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	public FileInputStream fis = null;
	public  XSSFWorkbook workbook = null;
	public  XSSFSheet sheet = null;
	public  XSSFRow row = null;
	public  XSSFCell cell = null;

	public ExcelReader(String xlFilePath) throws Exception {
		fis = new FileInputStream(new File(xlFilePath));
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	
	@DataProvider(name="getCalendarData")
	public  String getCellData(String sheetName, String colName) {
		int col_Num = 0;
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}

			row = sheet.getRow(1);
			cell = row.getCell(col_Num);

			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return " column " + col_Num + " does not exist  in Excel";
		}
	}

	public static void main(String[] args) throws Exception {
//		ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "//TestData//CalendarTestData.xlsx");
//		System.out.println(excelReader.getCellData("Calendar", "Location"));
			}
	
	
	
//	@Test(dataProvider  ="getCalendarData")
//	public void test1() throws Exception {
//		ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "//TestData//CalendarTestData.xlsx");
//		String data = excelReader.getCellData("Calendar", "Location");
//		System.out.println(data);
//	}
}