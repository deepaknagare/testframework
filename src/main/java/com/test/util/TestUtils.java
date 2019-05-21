package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.testbase.TestBase;

public class TestUtils extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static long EXPLICT_WAIT = 10;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String accessExcel(int sheetnum,int rownum, int cellnum) throws IOException 
	{
			File src = new File(System.getProperty("user.dir") + "/src/main/java/com/test/testdata/TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			// sh= wb.getSheet("amazontestdata");
			sh = wb.getSheetAt(sheetnum);
			cell = sh.getRow(rownum).getCell(cellnum);
			cell.setCellType(cell.CELL_TYPE_STRING);
			String value = cell.getStringCellValue();
			System.out.println("Value is : " + value);
		return value;

		
	}

	
	
	public static void takeScreenShot(String filename) throws IOException
	{
		TakesScreenshot scrshot = ((TakesScreenshot)driver);
		File srcfile = scrshot.getScreenshotAs(OutputType.FILE);
		File dstfile = new File("C:\\Users\\dnagare\\Desktop\\scrshots\\" +filename +".jpg");
		FileUtils.copyFile(srcfile, dstfile);
		
	}


}
