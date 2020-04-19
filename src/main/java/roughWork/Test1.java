package roughWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 
{
	static WebDriver driver;
	
	public static void main(String[] args)  {
		
			try 
			{
				driver = new ChromeDriver();
				driver.get("https://translate.google.com/");
				driver.close();
			}
			finally 
			{
				driver.close();
			}
	
	}

}
