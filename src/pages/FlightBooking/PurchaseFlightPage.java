package pages.FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import core.FlightBooking.BasePage;
import core.FlightBooking.SyncUtils;

public class PurchaseFlightPage  extends BasePage
{
	public PurchaseFlightPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@value='Purchase Flight']")
	private WebElement purchaseFlightButton;
	
	@FindBy(id="inputName")
	private WebElement enterName;
	
	@FindBy(id="cardType")
	private WebElement  enterCardType;
	
	@FindBy(id="creditCardNumber")
	private WebElement enterCardNumber;
	
	@FindBy(id="nameOnCard")
	private WebElement enterNameonCard;
	
	@FindBy(xpath="//hr/following::p[1]")
	private WebElement purchasePrice;
	
	
	public ConfirmationPage purchaseFlightButton()
	{
		purchaseFlightButton.click();
		SyncUtils.wait(5);
		return PageFactory.initElements(getWebDriver(), ConfirmationPage.class);
	}

   public void fillUserDetails(String name,String cardNumber,String nameOnCard,String cardType)
   {
	enterName.sendKeys(name);
	enterCardNumber.sendKeys(cardNumber);
	enterNameonCard.sendKeys(nameOnCard);
	Select select =new Select(enterCardType);
	select.selectByVisibleText(cardType);
	
   }
   
   public String getPurchaseAmount()
   {
	   return purchasePrice.getText();
   }
}
