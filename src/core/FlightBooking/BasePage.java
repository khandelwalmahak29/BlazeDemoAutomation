package core.FlightBooking;

import org.openqa.selenium.WebDriver;

public class BasePage 
{

   protected WebDriver driver;
	
	public BasePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public String getUrl()
	{
		return	getWebDriver().getCurrentUrl();
	}
	
	
	public WebDriver getWebDriver()
	{
		
		return driver;
	}
}
	

