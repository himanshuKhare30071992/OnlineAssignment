package assignment_8;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author SonyVaio-HK
 *			Assignment 8: Get All Page Links and Print them in a loop
 */
public class Assignment8 
{	
	static WebDriver driver = null;
	
	public static void main(String[] args) 
	{
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assignment8.getAllHyperLinksText2();
		driver.quit();
	}
	
		public static void getAllHyperLinksText1()
		{
			List<WebElement> allTags = driver.findElements(By.tagName("a"));
			int totalTagSize = allTags.size();
			System.out.println("Total //a tag found in page = "+totalTagSize);
			
			for(int i=0; i<totalTagSize; i++)
			{
				String linkText = allTags.get(i).getText();
				System.out.println(i+") ---> "+linkText);
			}
		}
	
		
		public static void getAllHyperLinksText2()
		{
			List<WebElement> allTags = driver.findElements(By.tagName("a"));
			int totalTagSize = allTags.size();
			System.out.println("Total //a tag found in page = "+totalTagSize);
			
			for (WebElement ele: allTags) 
			{
				System.out.println(ele.getText());
			}
			
		}
	
		public static void getAllHyperLinksText3()
		{
			List<WebElement> allTags = driver.findElements(By.tagName("a"));
			int totalTagSize = allTags.size();
			System.out.println("Total //a tag found in page = "+totalTagSize);
			Iterator<WebElement> itr =	allTags.iterator();
			while(itr.hasNext())
			{
				WebElement ele = itr.next();
				System.out.println(ele.getText());
			}
		}
		
		
		
}
