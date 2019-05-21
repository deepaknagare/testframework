package com.test.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.util.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait explictwait;
	public static XSSFWorkbook workbook;

	public TestBase() {
		try {

			prop = new Properties();
			File file = new File(System.getProperty("user.dir") + "/src/main/java/com/test/config/config.properties");
			FileInputStream fip = new FileInputStream(file);
			// FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+// "/src/main/java/com/test/config/config.properties");
			prop.load(fip);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\\\deepak\\\\IFRS Docs\\\\IFRS\\\\Laptop Backup\\\\Learning\\\\docs\\\\chromedriver_win32\\\\chromedriver.exe"
			 * );
			 */
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));

			driver = new ChromeDriver();

		} else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		// driver.get(prop.getProperty("urlframe"));
		//driver.get(prop.getProperty("urlamazon"));
	}
}