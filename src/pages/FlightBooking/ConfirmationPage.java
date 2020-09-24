package pages.FlightBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.FlightBooking.BasePage;

public class ConfirmationPage extends BasePage
{

	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1")
	 private WebElement pageHeadingConfirmationPage;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	 private WebElement confirmationId;
	
	@FindBy(xpath="//table/tbody/tr[3]/td[2]")
	 private WebElement getAmount;

	 
	 public String testConfirmationPageHeading()
	   {
		   return pageHeadingConfirmationPage.getText();
	   }
	  	   
	   public String testConfirmationId()
	   {
		   return confirmationId.getText();
	   }
	   public String testAmount()
	   {
		   return getAmount.getText();
	   }
	
}
