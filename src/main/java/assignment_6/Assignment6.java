package assignment_6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author SonyVaio-HK
 *		Assignment 6: Automate "User Registration" Process for E-commerce Website using Selenium
 *			
 *		#Steps to Automate:------>
						1. Open link http://automationpractice.com/index.php
						2. Click on sign in link.
						3. Enter your email address in 'Create and account' section.
						4. Click on Create an Account button.
						5. Enter your Personal Information, Address and Contact info.
						6. Click on Register button.
						7. Validate that user is created.

 */


public class Assignment6 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
		signIn.click();
		
		WebElement emailId = driver.findElement(By.xpath("//input[@id='email_create']"));
		emailId.sendKeys("himanshukhare1995@gmail.com");
				
		WebElement createAccount = driver.findElement(By.xpath("//i[@class='icon-user left']"));
		createAccount.click();
		
		Thread.sleep(3000);
		
		WebElement title  = driver.findElement(By.id("id_gender1"));
		title.click();
		
		WebElement fname = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		fname.sendKeys("Himanshu");

		
		WebElement lname = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lname.sendKeys("Khare");
		
		//WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		
		WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
		password.sendKeys(")(*&^%$#@!");
		
		Actions act = new Actions(driver);
		
		WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
		act.moveToElement(days).click().build().perform();
		Select date = new Select(days);
		date.selectByValue("30");
		
		WebElement months = driver.findElement(By.id("months"));
		act.moveToElement(months).click().build().perform();
		Select month = new Select(months);
		//month.selectByValue("7");
		month.selectByVisibleText("July");
		
		WebElement years = driver.findElement(By.id("years"));
		act.moveToElement(years).click().build().perform();
		Select year = new Select(years);
		year.selectByValue("1992");
		
		WebElement companyName = driver.findElement(By.id("company"));
		companyName.sendKeys("UTS Global Pvt. Ltd.");
		
		WebElement companyAddress = driver.findElement(By.id("address1"));
		companyAddress.sendKeys("UTS Global Pvt. Ltd.");

		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Pune");

		WebElement states = driver.findElement(By.id("id_state"));
		Select state = new Select(states);
		state.selectByVisibleText("Texas");
		
		
		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.sendKeys("46123");
		
		
		
		WebElement mobile = driver.findElement(By.id("phone_mobile"));
		mobile.sendKeys("123456789");
		
		
		WebElement register = driver.findElement(By.xpath("//span[text()='Register']"));
		register.click();
		
		
		String registeredPageTitle = 	driver.getTitle();
		if(registeredPageTitle.contains("My account"))
		{
			System.out.println("SUCESS: User account has been created successfully !!!");
		}
		else
		{
			System.out.println("FAILED: User account is not created !!!");
		}
		
		driver.quit();
				
		
	}

}
