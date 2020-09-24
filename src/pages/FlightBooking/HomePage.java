package pages.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import core.FlightBooking.BasePage;

public class HomePage extends BasePage 
{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//h1")
	private WebElement pageHeading;//get text of page heading and match with Welcome to the Simple Travel Agency!
	
	@FindBy(name="fromPort")
	private WebElement departuredd;
	
	@FindBy(name="toPort")
	private WebElement destinationdd;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitFlight;	//getAttribute value and check Find Flights 
	
    
	public void selectCities(String departure,String destination)
	{
		Select selectdept=new Select(departuredd);
		selectdept.selectByVisibleText(departure);
		
		Select selectdest=new Select(destinationdd);
		selectdest.selectByVisibleText(destination);
		
	}
	public String headingMainPage()
	{
		 return pageHeading.getText();
		
    }
	public String footerButtonMainPage()
	{
		 return submitFlight.getAttribute("value");
		
    }
	public BookingPage submitFindFlight()
	{
		submitFlight.click();
		return  PageFactory.initElements(getWebDriver(), BookingPage.class);
	}
	
}
