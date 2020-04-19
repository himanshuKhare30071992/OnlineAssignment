package assignment_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * @author SonyVaio-HK
 *  	#Assignment 2: Automate Menu Links and Validate Page Titles using Selenium
 *  	#Steps to Automate::---->
								1. Open this link  https://www.techlistic.com/
								2. Launch Firefox browser. (You can choose browser of your choice).
								3. Maximize or set size of browser window.
								4. Click on 'Java Tutorial' link and validate page title.
								5. Navigate back to Home Page.
								6. Click on 'Selenium Tutorial' link and validate page title.
								7. Navigate back to Home Page.
								8. Click on 'Selenium Blogs' link and validate page title.
								9. Navigate back to Home Page.
								10. Click on 'TestNG Blogs'(TestNG) link and validate page title.
								11. Close the browser.
 *
 */

public class Assignment2
{
	static String applicationURL ="https://www.techlistic.com/";
	static String expectedPageTitle1 = "Java Tutorials Series - Java For Selenium";
	static String expectedPageTitle2 = "Selenium Tutorial - Learn Selenium from Comprehensive Series of 40 Coding Tutorials";
	static String expectedPageTitle3 = "Top Selenium Blogs";
	static String expectedPageTitle4 = "Selenium with TestNG Integration - Tutorial Series";
	
	
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get(applicationURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement javaHyperlink =	driver.findElement(By.linkText("JAVA"));
		javaHyperlink.click();
		
		String actualPageTitle1 = driver.getTitle();
		Assert.assertEquals(actualPageTitle1, expectedPageTitle1, "#1 VERIFICATION FAILED: Java Page Title mismatch found !!!");
		System.out.println("#1 VERIFICATION PASS: Java Page Title match found !!!");
		
		driver.navigate().back();
		
		WebElement seleniumHyperlink =	driver.findElement(By.linkText("SELENIUM"));
		seleniumHyperlink.click();

		String actualPageTitle2 = driver.getTitle();
		Assert.assertEquals(actualPageTitle2, expectedPageTitle2, "#2 VERIFICATION FAILED: Selenium Page Title mismatch found !!!");
		System.out.println("#2 VERIFICATION PASS: Selenium Page Title match found !!!");

		//driver.navigate().back();  // NOTE: Step 7 needs to be skip/remove in order to perform Step 8
		
		WebElement seleniumBlogLink = driver.findElement(By.linkText("Selenium Blogs"));
		seleniumBlogLink.click();
		
		String actualPageTitle3 = driver.getTitle();
		Assert.assertEquals(actualPageTitle3, expectedPageTitle3, "#3 VERIFICATION FAILED: Selenium Blogs Page Title mismatch found !!!");
		System.out.println("#3 VERIFICATION PASS: Selenium Blogs Page Title match found !!!");

		
		driver.navigate().back();
		driver.navigate().back();
		
		WebElement testngLink = driver.findElement(By.linkText("TESTNG"));
		testngLink.click();
		
		String actualPageTitle4 = 	driver.getTitle();
		Assert.assertEquals(actualPageTitle4, expectedPageTitle4, "#4 VERIFICATION FAILED: TESTNG Page Title mismatch found !!!");
		System.out.println("#4 VERIFICATION PASS: TESTNG Page Title match found !!!");
		
		driver.close();
		
	}
	
	
	
}
