package pages.FlightBooking;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.FlightBooking.BasePage;
import core.FlightBooking.SyncUtils;

public class BookingPage extends BasePage
{
	  
   public BookingPage(WebDriver driver)
	{
		super(driver);
	}
  
   @FindBy(xpath="//h3")
   private WebElement pageHeading;
   
   @FindBy(xpath="//table/thead/tr[1]/th")
   private List<WebElement> pageColumns;
 
   
   private WebElement chooseFlightButton;
 
   
   public String testBookingHeading()
   {
	   return pageHeading.getText();
   }
   
   public List<String> columnheading()
   {
	  List<String> listcolumn=new ArrayList<String>();
	  for(WebElement value:pageColumns)
		  listcolumn.add(value.getText());
	  return listcolumn;
	   
   }
   
   public PurchaseFlightPage chooseFlight(String flightId) 
   {
	   chooseFlightButton= getWebDriver().findElement(By.xpath("//table/tbody/tr/td[text()='"+flightId+"']/../td[1]"));
	   chooseFlightButton.click();
	   SyncUtils.wait(5);
	   return PageFactory.initElements(getWebDriver(), PurchaseFlightPage.class);
	   
   }
			
}
