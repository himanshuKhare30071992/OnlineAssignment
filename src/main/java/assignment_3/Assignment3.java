package assignment_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author SonyVaio-HK
 *	#Assignment 3 - Automate demo 'About Me' form using Selenium
 * 	#Steps to automate:---->
						1.	Open this link - https://www.techlistic.com/p/selenium-practice-form.html
						2.	Enter first and last name (textbox).
						3.	Select gender (radio button).
						4.	Select years of experience (radio button).
						5.	Enter date.
						6.	Select Profession (Checkbox).
						7.	Select Automation tools you are familiar with (multiple checkboxes).
						8.	Select Continent (Select box).
						9.	Select multiple commands from a multi select box.
						10.	If you can handle Upload image then try it or leave this step.
						11.	Click on Download file link and handle the download file pop-up (leave it if you are beginner).
						12.	Click on Submit button.

 *
 */
public class Assignment3 
{
	public static void main(String[] args) 
	{
		
			WebDriver driver =  new ChromeDriver();
			driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
			firstName.sendKeys("Himanshu");
			
			WebElement secondName = driver.findElement(By.xpath("//input[@name='lastname']"));
			secondName.sendKeys("Khare");
		
			WebElement maleRadioButton = driver.findElement(By.xpath("//input[@id='sex-0']"));
			maleRadioButton.click();
		
			WebElement yearsOfExperience = driver.findElement(By.xpath("//input[@id='exp-1']"));
			yearsOfExperience.click();
			
			WebElement dob = driver.findElement(By.xpath("//input[@id='datepicker']"));
			dob.sendKeys("30-07-1992");
			
			
			WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
			profession.click();
			
			
			WebElement automationTool = driver.findElement(By.xpath("//input[@id='tool-2']"));
			automationTool.click();
			
			
			WebElement continentsDropbox = driver.findElement(By.xpath("//select[@id='continents']"));
			Select continent = new Select(continentsDropbox);
			continent.selectByVisibleText("Australia");
			
			
			WebElement seleniumCommands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
			Select commands = new Select(seleniumCommands);
			commands.selectByVisibleText("Browser Commands");
			commands.selectByVisibleText("Navigation Commands");
			commands.selectByVisibleText("WebElement Commands");
			
			WebElement uploadImage = driver.findElement(By.xpath("//input[@id='photo']"));
			uploadImage.sendKeys("C:\\Users\\SonyVaio-HK\\Desktop\\Tiffin.txt");
			
			
			
	}

}
