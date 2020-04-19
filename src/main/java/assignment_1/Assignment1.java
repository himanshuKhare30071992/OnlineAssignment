package assignment_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * @author SonyVaio-HK
 
 #Assignment 1: Automate Browser Actions - Launch Browser, maximize window, validate title & close browser

#Steps to Automate:---->

			1. Open this link - https://www.techlistic.com/
			2. Launch Firefox browser. (You can choose browser of your choice).
			3. Maximize or set size of browser window.
			4. Get Title of page and validate it with expected value.
			5. Get URL of current page and validate it with expected value.
			6. Get Page source of web page.
			7. And Validate that page title is present in page source.
			8. Close browser.

*/


public class Assignment1 
{
	static String actualPageTitle ="Techlistic";
	static String actualApplicationURL = "https://www.techlistic.com/";
	
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get(actualApplicationURL);
		
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String pageTitle  = driver.getTitle();
		System.out.println("======Page Title====== "+pageTitle);
		
		Assert.assertEquals(actualPageTitle, pageTitle, "VALIDATION FAILED: Page title mismatch found !!!");
		System.out.println("===VALIDATION SUCCESS: Page title match found !!! ");
		
		String currentPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualApplicationURL, currentPageURL, "VALIDATION FAILED: Page URL mismatch found !!!");
		System.out.println("===VALIDATION SUCCESS: Page URL match found !!!");
		
		String pageSource  = driver.getPageSource();
		//System.out.println(pageSource);
		boolean status = 	pageSource.contains(pageTitle);
		
		if(status==true)
		{
			System.out.println("===SUCCESS: Page title found in the page source !!!");
		}
		else
		{
			System.out.println("===FAILED: Page title NOT found in the page source !!!");
		}
		
		
		driver.close();
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
}
