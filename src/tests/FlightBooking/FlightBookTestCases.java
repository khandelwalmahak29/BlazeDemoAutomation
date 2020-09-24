package tests.FlightBooking;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import core.FlightBooking.BaseTest;
import pages.FlightBooking.BookingPage;
import pages.FlightBooking.ConfirmationPage;
import pages.FlightBooking.HomePage;
import pages.FlightBooking.PurchaseFlightPage;


public class FlightBookTestCases extends BaseTest
{

	private String destinationCity="Dublin";
	private String departureCity="Boston";
	private String flightId="234";
	List<String> expectedColumns= Arrays.asList("Choose","Flight #","Airline","Departs: Boston","Arrives: Dublin","Price");
	
	/*Test Scenario for LandingPage which verifies Heading and Footer of the page, 
	  landing into the site and select departure and destination city
	 */
	@Test
	public void flightBookLandingpage()
	{
		HomePage homepage=PageFactory.initElements(getWebDriver(), HomePage.class);
		Assert.assertEquals(homepage.headingMainPage(),"Welcome to the Simple Travel Agency!", "The Heading of the Flight Booking main page is not correct");
		Assert.assertEquals(homepage.footerButtonMainPage(),"Find Flights","The Find Flights button is not present");
		homepage.selectCities(departureCity, destinationCity);
	}
	
	/*
	 * This test case verifies that same cities chosen in previous page are reflected in choose flight page,also verifies all  column headings  
	 */
	@Test
	public void chooseFlight()
	{
		flightBookLandingpage();
		HomePage homepage=PageFactory.initElements(getWebDriver(), HomePage.class);
		BookingPage bookingpage=homepage.submitFindFlight();
		//Verifying the same cities appears in BookingPage heading  as selected in HomePage
		Assert.assertEquals(bookingpage.testBookingHeading(),"Flights from "+departureCity+" to "+destinationCity+":","The Booking heading is appearing incorrect");
		//Verifying column headings of the page:
		List<String> actualcolumns=bookingpage.columnheading();
		Assert.assertEquals(actualcolumns,expectedColumns);
		
	}
	/*
	 * This test case verifies the heading of the Confirmation page and also verifies that confirmation id is created 
	 */
	
	@Test
	public void fillPassengerDetailsCheckConfirmationId()
	{
		chooseFlight();
		BookingPage bookingpage=PageFactory.initElements(getWebDriver(),BookingPage.class);
		//Choose any flight Id and click on choose  this flight button
		PurchaseFlightPage purchaseflightpage=bookingpage.chooseFlight(flightId);
		//Fill all details and click on purchase flight
		purchaseflightpage.fillUserDetails("Mahak Khandelwal","45678901234","Mahak Khandelwal","American Express");
		ConfirmationPage confirmationpage=purchaseflightpage.purchaseFlightButton();
		Assert.assertEquals(confirmationpage.testConfirmationPageHeading(),"Thank you for your purchase today!","The Confirmation page heading is not correct");
		Assert.assertNotNull(confirmationpage.testConfirmationId());
	}
	
	/*
	 * This test case verifies the price match(Total cost) in Purchase page and Amount in Confirmation page
	 * 
	 */
	@Test
	public void flightBookEndToEnd()
	{				
		chooseFlight();
		BookingPage bookingpage=PageFactory.initElements(getWebDriver(),BookingPage.class);
		//Choose any flight Id and click on choose  this flight button
		PurchaseFlightPage purchaseflightpage=bookingpage.chooseFlight(flightId);
		String amount=purchaseflightpage.getPurchaseAmount()	;
		String[] cost=amount.split(" ");//as in amount getting total cost: 914.76 so used split function to get only price 
		//Confirm confirmation id is created and heading is correct of the page
		ConfirmationPage confirmationpage=purchaseflightpage.purchaseFlightButton();
		//Verify the price matched total cost of purchasing page and Amount of Confirmation page,if price is not same so it will fail
		Assert.assertEquals(confirmationpage.testAmount(),cost[cost.length-1],"The amount didnt match");
			
	}
	
	
}
