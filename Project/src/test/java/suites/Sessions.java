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
	  app.openBrowser("chrome");
	  app.navigate("rediffurl");
	  app.type("userid_id", "rediffuser");
	  app.type("userpassword_id", "rediffpassword");
	 
  }
  
  @Test
  public void logout() 
  {
	  System.out.println("Do Logout");
	  //test.log(Status.INFO, "Do Logout");
	 
	 
  }
  
}
