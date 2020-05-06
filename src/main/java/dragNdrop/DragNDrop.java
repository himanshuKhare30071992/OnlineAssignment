package dragNdrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//span[text()='Learning DHTMLX Suite UI']")); 
		WebElement destinationDropArea = driver.findElement(By.xpath("//div[@id='treeTarget']//ul"));
		
		
		act.clickAndHold(source).pause(1000).
		moveToElement(destinationDropArea).pause(1000).
		release().build().perform();

	}

}
