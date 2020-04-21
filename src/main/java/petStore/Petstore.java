package petStore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Petstore 
{
	static WebDriver driver = null;
	
	
	public static void main(String[] args) 
	{
		driver = new ChromeDriver();
		driver.get("https://petstore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		System.out.println("------------------------First Lowest Product Details------------------------");
		
		WebElement catalog = driver.findElement(By.xpath("//span[@class='site-nav__label' and text()='Catalog']"));
		catalog.click();
		
		WebElement filterByDropdown = driver.findElement(By.xpath("//select[@id='FilterTags']"));
		Select products = new Select(filterByDropdown);
		products.selectByVisibleText("Dog");
		
		WebElement sortBy = driver.findElement(By.xpath("//select[@id='SortBy']"));
		Select sorting = new Select(sortBy);
		sorting.selectByVisibleText("Price, low to high");
		
		
		WebElement firstProduct = driver.findElement(By.xpath("//a[@class='grid-view-item__link grid-view-item__image-container full-width-link'][1]"));
		String firstProductName = firstProduct.getText();
		System.out.println("===Product Name===>"+firstProductName);
		firstProduct.click();
		
		WebElement firstProductPrice = driver.findElement(By.xpath("//div[@class='price__regular']//dd//span[1]"));
		String price = firstProductPrice.getText();
		System.out.println("===Lowest Price===>"+price);
		// code for screenshot
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file =	ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss a dd-MMMM-YYYY	");
		Date date = new Date();
		String currentDateTime = dateFormat.format(date);
		
		try {
			FileUtils.copyFile(file, new File("./screenshots/"+currentDateTime+".png"));
			System.out.println("Screenshot taken !!!"+currentDateTime);
		   } 
		catch (IOException e) 
		{
			System.out.println("Screenshot not taken !!!"+currentDateTime);
			e.printStackTrace();
		}
		
		
		System.out.println("------------------------Second Highest Product Details------------------------");
		
		WebElement catalog1 = driver.findElement(By.xpath("//ul[@id='SiteNav']//li[2]//a"));
		catalog1.click();	

		filterByDropdown = driver.findElement(By.xpath("//select[@id='FilterTags']"));
		products = new Select(filterByDropdown);
		products.selectByVisibleText("Dog");
		
		sortBy = driver.findElement(By.xpath("//select[@id='SortBy']"));
		sorting = new Select(sortBy);
		sorting.selectByVisibleText("Price, high to low");

		firstProduct = driver.findElement(By.xpath("//div[@id='Collection']//a[1]"));
		firstProductName = firstProduct.getText();
		System.out.println("===First Highest Price Product Name===>"+firstProductName);
		firstProduct.click();
		
		
		firstProductPrice = driver.findElement(By.xpath("//div[@class='price__regular']//dd//span[1]"));
		price = firstProductPrice.getText();
		System.out.println("==Highest Product Price==>"+price);
		
		try {
			FileUtils.copyFile(file, new File("./screenshots/"+currentDateTime+".png"));
			System.out.println("Screenshot taken !!!"+currentDateTime);
		   } 
		catch (IOException e) 
		{
			System.out.println("Screenshot not taken !!!"+currentDateTime);
			e.printStackTrace();
		}
	
		driver.quit();
	
		
		//driver.quit();
		
	}

}
