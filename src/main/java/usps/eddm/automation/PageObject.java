package usps.eddm.automation;

import static java.util.concurrent.TimeUnit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject
{
	WebDriver driver;
	WebDriverWait wait;
	
	String url;
	
	public PageObject(WebDriver driver, String url)
	{
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(60, SECONDS);
		this.wait = new WebDriverWait(driver, 30);
		
		this.url = url;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void open()
	{
		driver.get(url);
	}
}
