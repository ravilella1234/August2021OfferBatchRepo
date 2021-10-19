package testcases;

import org.testng.annotations.Test;

public class BookingSearch 
{
	@Test()
	public void searchHotel()
	{
		System.out.println("----------   Search a Hotel  -----------");
	}

	@Test()
	public void selectHotel()
	{
		System.out.println("Select a Hotel");
	}
	
	@Test
	public void loadBooking()
	{
		System.out.println(" ------ Loading Booking  ---------");
	}
	
	@Test()
	public void enterGuestInformation()
	{
		System.out.println("Enter Guest Info");
	}
}
