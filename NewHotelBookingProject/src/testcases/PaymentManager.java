package testcases;

import javax.naming.Context;
import javax.swing.text.AbstractDocument.Content;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager 
{
	
	@Test
	public void applyDiscount()
	{
		System.out.println("Apply Discount");
	}
	
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType, ITestContext context)
	{
		if(paymentType.equals("instantpay"))
			System.out.println("Making Instant Payment");
		else
			System.out.println("Pay@Hotel Booking");
		
		// booking Number
		String bookingID = "ravi1234";
		context.setAttribute("bookingid", bookingID);
		System.out.println("Booking id in makpayment function :" + bookingID);
	}
	
	

}
