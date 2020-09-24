package core.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest
{
	private WebDriver driver;
	
    ThreadLocal<WebDriver> driverThread=new ThreadLocal<WebDriver>();
	
	
	@BeforeMethod()
	public void beforeEach()
	{
	  driver=BrowserFactory.getInstance();
	  driverThread.set(driver);
	  getWebDriver().manage().window().maximize();
	  getWebDriver().get(Constants.URL);
	  SyncUtils.wait(10);
	}
	
	
	@AfterMethod()
	public void cleanUp()
	{
		 getWebDriver().quit();
	}
	
	protected WebDriver getWebDriver()
	{
	
		return driverThread.get();
	}
}
