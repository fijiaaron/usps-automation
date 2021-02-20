package usps.eddm.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverTest
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void cleanup()
	{
		pause(1);
		driver.quit();
	}
	
	public void pause(int seconds)
	{
		try
		{
			Thread.sleep(1000 * seconds);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
