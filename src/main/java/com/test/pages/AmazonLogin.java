package com.test.pages;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.testbase.TestBase;

public class AmazonLogin extends TestBase implements LoginMethods {
	// public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	// @FindBy(xpath = "//a[@id='nav-link-yourAccount']")
	@FindBy(xpath = "//*[text()='Hello, Sign in']")
	WebElement loginbtnhover;

	// WebElement signinbtn =
	// driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']//*[@class='nav-action-inner']"));

	// @FindBy(xpath = "//input[@id='ap_email']")
	@FindBy(css = "input#ap_email")
	WebElement email;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement cntnuebtn;

	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement pwd;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement loginbtn1;

	@FindBy(xpath = "//*[text()='Sign in securely']")
	WebElement secureloginbtn;

	public AmazonLogin() {
		PageFactory.initElements(driver, this);

	}

	public static void getXpathUsingContains(String value, String input) {
		WebElement element = driver.findElement(By.xpath("//*[contains(@type,'" + value + "')]"));
		element.sendKeys(input);
	}

	public AmazonHomePage loginAmazon(String un, String pass) {

		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(loginbtnhover).build().perform(); signinbtn.click();
		 * driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS);
		 */
		// getXpathUsingContains("email", prop.getProperty("username"));

		secureloginbtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		email.sendKeys(un);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='continue']")));
		System.out.println("Explicitly waiting for continue button.................");

		// driver.findElement(By.cssSelector(""))
		cntnuebtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
		pwd.sendKeys(pass);
		loginbtn1.click();
		return new AmazonHomePage();

	}
	
	public AmazonHomePage loginByHover(String un, String pass)
	{
		//List weblist =  (List) driver.findElements(By.xpath(""));
		WebElement lgn = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
		//WebElement lgn = driver.findElement(By.id("nav-link-yourAccount"));
		WebElement hoverloginbtn = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']"));
		//
		
		try {
			Actions action = new Actions(driver);
			action.moveToElement(lgn).build().perform();
			hoverloginbtn.click();
			email.sendKeys(un);
			cntnuebtn.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,
			// TimeUnit.SECONDS);
			pwd.sendKeys(pass);
			loginbtn1.click();


		}
		catch(Exception e)
		{
			System.out.println("Explicit wait not working...........");
		}
		return new AmazonHomePage();
		
	}
}
