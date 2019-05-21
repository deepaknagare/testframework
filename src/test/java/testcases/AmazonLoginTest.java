package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.test.pages.AmazonHomePage;
import com.test.pages.AmazonLogin;
import com.test.testbase.TestBase;
import com.test.util.TestUtils;

public class AmazonLoginTest extends TestBase {

	AmazonHomePage amazonhomepage;
	AmazonLogin amazonlogin;

	// constructor
	public AmazonLoginTest() 
	{
		super();

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		amazonlogin = new AmazonLogin();
		amazonhomepage = new AmazonHomePage();

	}

	@Test(priority = 2)
	public void loginbyHoverTest() throws IOException {

		// amazonlogin.getXpathUsingContains("email", prop.getProperty("username"));

		String un = TestUtils.accessExcel(1,1,0);
		String pwd = TestUtils.accessExcel(1,1,1);
		amazonlogin.loginByHover(un,pwd);
		//amazonhomepage = amazonlogin.loginAmazon(un,pwd);
		// amazonhomepage = amazonlogin.loginAmazon(prop.getProperty("username"), prop.getProperty("password"));

	}

	public void loginbyHoverTest(AmazonLogin amazonlogin) throws IOException {

		// amazonlogin.getXpathUsingContains("email", prop.getProperty("username"));

		String un = TestUtils.accessExcel(1,1,0);
		String pwd = TestUtils.accessExcel(1,1,1);
		amazonlogin.loginByHover(un,pwd);
		TestUtils.takeScreenShot("HomePageAfterLogin");
		//amazonhomepage = amazonlogin.loginAmazon(un,pwd);
		// amazonhomepage = amazonlogin.loginAmazon(prop.getProperty("username"), prop.getProperty("password"));

	}

	
	@Test(priority = 3)
	public void secureLoginTest() throws IOException {


		String un = TestUtils.accessExcel(1,1,0);
		String pwd = TestUtils.accessExcel(1,1,1);
		amazonhomepage = amazonlogin.loginAmazon(un,pwd);

	}

	
	
	@Test(priority = 1)
	public void getTitleHomePage() {
		String title = driver.getTitle();
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}


	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
