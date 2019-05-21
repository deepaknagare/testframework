package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.pages.AmazonHomePage;
import com.test.pages.AmazonLogin;
import com.test.testbase.TestBase;

public class AmazonHomePageTest extends TestBase {

	AmazonLoginTest alogin;
	AmazonHomePage ahome;
	AmazonLogin amazonlogin;
	
	public AmazonHomePageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void initHomePage() throws IOException
	{
		initialization();
		alogin = new AmazonLoginTest();
		ahome = new AmazonHomePage();
		amazonlogin = new AmazonLogin();
		alogin.loginbyHoverTest(amazonlogin);
		
	}
	
	@Test
	public void selectDeviceTest()
	{
		ahome.clickAndSelectCategory();
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
}
