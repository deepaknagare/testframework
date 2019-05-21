package com.test.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.testbase.TestBase;
public class AmazonHomePage extends TestBase{
	/*AmazonLogin login;
	WebElement navbar = driver.findElement(By.xpath("//a[contains(@href,'sv_top_elec_mega_1')]"));
	*/
	@FindBy(xpath="//a[contains(@href,'mega_elec_s23_1_2_1_6')]")
	WebElement apple;
	
	@FindBy(xpath="//a[contains(@href,'sv_top_elec_mega_1')]")
	WebElement navbar;
	
	//WebElement devicedrpdwn = driver.findElement(By.id("s-result-sort-select"));
	
	@FindBy(id="s-result-sort-select")
	WebElement devicedrpdwn;
			
	@FindBy(xpath="//*[contains(text(),'Apple iPhone XR (64GB) - Blue')]//parent::a")
	WebElement selectdevice;
	
	@FindBy(xpath="//img[@src='https://images-na.ssl-images-amazon.com/images/I/41x3E3NeRVL._SS36_.jpg']")
	WebElement selectreddevice;
	
	
	@FindBy(id="a-autoid-17-announce")
	WebElement reddvebtn;
	
	@FindBy(id="buy-now-button")
	WebElement buynowbtn;
	
	@FindBy(id="nav-link-shopall")
	WebElement shopbycat;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchtxtbx;
	
	@FindBy(xpath="//*[@name='site-search']//child::div[2]")
	WebElement go;
	
	@FindBy(xpath="//*[text()='Mobiles, Computers']")
	WebElement mobandcomp;
	
	@FindBy(xpath="//*[contains(@href,'nav_shopall_sbc_mobcomp_all_mobiles')]")
	WebElement allmobiles;
	//WebElement reddvebtn = driver.findElement(By.id("a-autoid-17-announce"));
	
	//WebElement buynowbtn = driver.findElement(By.id("buy-now-button"));
	
	
	
	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickAndSelectCategory()
	{
		/*searchtxtbx.sendKeys("apple");
		go.click();
		*/
		
		
		
		
		Actions a = new Actions(driver);
		a.moveToElement(shopbycat).build().perform();
		a.moveToElement(mobandcomp).build().perform();
		allmobiles.click();
		String parentwindow = driver.getWindowHandle();
		a.moveToElement(driver.findElement(By.xpath("//*[@id='nav-subnav']//child::a[2]"))).build().perform();
		apple.click();
		
		/*Select s = new Select(devicedrpdwn);
		s.selectByVisibleText("Newest Arrivals");
		*/
		drpDown("Newest Arrivals");
		
		selectdevice.click();
		Set<String> childwindow = driver.getWindowHandles();
		
		
	/*	for(String child : childwindow)
		{
		if(!parentwindow.equalsIgnoreCase(child))
		{
			driver.switchTo().window(child);
			driver.close();
		}
		
		}
	*/	
		ArrayList<String> tab = new ArrayList<String>(childwindow);
		driver.switchTo().window(tab.get(1));
		System.out.println("Window Title after selecting device is :"	+driver.getTitle()); 		
		selectreddevice.click();
		reddvebtn.click();
		buynowbtn.click();
	}
	
	
	
	public String drpDown(String visibletext)
	{
		Select s = new Select(devicedrpdwn);
		String st= visibletext;
	    s.selectByVisibleText(st);
		return st;
		
	}
	

}
