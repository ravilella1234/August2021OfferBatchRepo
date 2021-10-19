package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunications 
{

	@Test
	public void checkEmailVerification(ITestContext context)
	{
		
		String bookingid = (String)context.getAttribute("bookingid");
		System.out.println("Checking mail for Confirmation : " + bookingid);
	}
	
	@Test
	public void checkMobileVerification()
	{
		System.out.println("Checking mobile for Confirmation");
	}
	
	
}
