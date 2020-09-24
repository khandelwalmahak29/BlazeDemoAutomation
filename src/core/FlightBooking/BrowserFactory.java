package core.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory
{
	public static WebDriver getInstance() 
		{
			WebDriver driver=null;
			switch(Constants.BROWSER_NAME.toUpperCase())
			{
			case "CHROME":
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_PATH);
			driver=new ChromeDriver();
			break;
		   case "FIREFOX":
			System.setProperty("webdriver.chrome.driver",Constants.FIREFOX_PATH);
			driver=new FirefoxDriver();
			break;
			default:
			new RuntimeException("Invalid browser name");
			
		   }
			return driver;	

	}
}
