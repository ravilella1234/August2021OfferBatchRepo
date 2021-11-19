package suites;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Sessions extends BaseTest
{
  @Test
  public void login() 
  {
	  System.out.println("Do Login");  
	  test.log(Status.INFO, "Do Login");
	 
  }
  
  @Test
  public void logout() 
  {
	  System.out.println("Do Logout");
	  test.log(Status.INFO, "Do Logout");
	 
  }
  
}
