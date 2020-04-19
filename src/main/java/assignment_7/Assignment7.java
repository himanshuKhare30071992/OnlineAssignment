package assignment_7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author SonyVaio-HK
 *	#Assignment 7: Automate "Search Product" Functionality for E-Commerce Website using Selenium
 *		#Steps to Automate:
					1. Open link http://automationpractice.com/index.php
					2. Move your cursor over Women's link.
					3. Click on sub menu 'T-shirts'
					4. Get Name/Text of the first product displayed on the page.
					5. Now enter the same product name in the search bar present on top of page and click search button.
					6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
 */
public class Assignment7 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		WebElement womenLink = driver.findElement(By.xpath("//a[@title='Women']"));
		Actions act = new Actions(driver);
		act.moveToElement(womenLink).build().perform();
		
		WebElement tshirtLink =	driver.findElement(By.xpath("//a[@title='T-shirts']"));
		tshirtLink.click();
			
		WebElement firstProduct = driver.findElement(By.xpath("//a[@class='product_img_link']//img"));
		String productName = 	firstProduct.getAttribute("title");
		System.out.println("====First Product Name===>"+productName);	
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		searchBox.sendKeys(productName);
		
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		
		WebElement searchResult = driver.findElement(By.xpath("//a[@class='product_img_link']//img"));
		String seachResultProduct =  searchResult.getAttribute("title");
		
		if(seachResultProduct.equals(productName))
		{
			System.out.println("PASS: Displayed Product is same !!! ");
		}
		else
		{
			System.out.println("FAILED: Displayed Product is not same !!!");
		}
		
		driver.quit();
	}

}
