package assignment_5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author SonyVaio-HK
 *		#Assignment 5: Automate Buy Product Functionality for dummy E-Commerce Website

			#Steps to Automate:
							1. Open link http://automationpractice.com/index.php
							2. Login to the website.
							3. Move your cursor over Women's link.
							4. Click on sub menu 'T-shirts'.
							5. Mouse hover on the second product displayed.
							6. 'More' button will be displayed, click on 'More' button.
							7. Increase quantity to 2.
							8. Select size 'L'
							9. Select color.
							10. Click 'Add to Cart' button.
							11. Click 'Proceed to checkout' button.
							12. Complete the buy order process till payment.
							13. Make sure that Product is ordered.

 */
public class Assignment5 
{
	
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
		signIn.click();
		
		WebElement emailId = driver.findElement(By.id("email"));
		emailId.sendKeys("himanshukhare1992@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("passwd"));
		pwd.sendKeys(")(*&^%$#@!");
		
		WebElement signInButton = driver.findElement(By.id("SubmitLogin"));
		signInButton.click();

		
		Actions act = new Actions(driver);
		WebElement womenLink = driver.findElement(By.xpath("//a[@title='Women']"));
		act.moveToElement(womenLink).perform();
		
		WebElement tShirt =	driver.findElement(By.xpath("//a[@title='T-shirts']"));
		tShirt.click();
		
		WebElement firstProduct = driver.findElement(By.xpath("//div[@class='product-image-container']"));
		act.moveToElement(firstProduct).perform();
		
		WebElement moreButton = driver.findElement(By.xpath("//span[text()='More']"));
		moreButton.click();
		
		WebElement addQuantity =	driver.findElement(By.xpath("//i[@class='icon-plus']"));
		addQuantity.click();
		
		WebElement selectSize = driver.findElement(By.id("group_1"));
		Select size = new Select(selectSize);
		size.selectByVisibleText("L");
		
		WebElement selectColor = driver.findElement(By.xpath("//a[@name='Blue']"));
		selectColor.click();
		
		WebElement addToCart = driver.findElement(By.xpath("//button//span[text()='Add to cart']"));
		addToCart.click();
		
		WebElement proceedToCheckout1 = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		proceedToCheckout1.click();
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 1000)");
		
		WebElement proceedToCheckout2 = driver.findElement(By.xpath("//a//span[text()='Proceed to checkout']"));
		proceedToCheckout2.click();

		js.executeScript("scroll(0, 1000)");
		WebElement proceedToCheckout3 = driver.findElement(By.xpath("//button[@name='processAddress']"));
		proceedToCheckout3.click();
		
		js.executeScript("scroll(0, 1000)");
		WebElement tnc = driver.findElement(By.xpath("//input[@type='checkbox']"));
		tnc.click();
		
		WebElement proceedToCheckout4 = driver.findElement(By.xpath("//button[@name='processCarrier']"));
		proceedToCheckout4.click();

		WebElement paymentMode = driver.findElement(By.xpath("//a[@class='bankwire']"));
		paymentMode.click();
	
				
		WebElement confirmMyOrder = driver.findElement(By.xpath("//button[@type='submit']//span[text()='I confirm my order']"));
		confirmMyOrder.click();
		
		
		String confirmationText = driver.findElement(By.xpath("//p[@class='cheque-indent']//strong")).getText();
		//System.out.println("--->"+confirmationText);
		if(confirmationText.contains("complete"))
		{
			System.out.println("SUCCESS: Your Order has been booked successfully !!! ");
		}
		else
		{
			System.out.println("FAILED: Your Order is not booked.... :( Please check & correct the errors");
		}
		
		driver.quit();
		
		
		
	}

}
