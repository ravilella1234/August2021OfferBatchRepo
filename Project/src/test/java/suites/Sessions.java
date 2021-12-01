package suites;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Sessions extends BaseTest
{
  @Test
  public void login() 
  {
	  System.out.println("Do Login");  
	  //test.log(Status.INFO, "Do Login");
	  app.log("Do Login");
	  app.openBrowser("chrome");
	  app.navigate("rediffurl");
	  app.reportFailure("title not mached");
	  app.type("userid_id", "rediffuser");
	  //failure message
	  app.type("userpassword_id", "rediffpassword");
	  app.assertAll();
  }
  
  @Test
  public void logout() 
  {
	  System.out.println("Do Logout");
	  //test.log(Status.INFO, "Do Logout");
	  app.log("Do Logout");
	 
	 
  }
  
}
