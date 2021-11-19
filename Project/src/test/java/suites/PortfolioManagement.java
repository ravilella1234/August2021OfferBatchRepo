package suites;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class PortfolioManagement extends BaseTest
{
	
  @Test
  public void createPortfolio() 
  {
	  System.out.println("creating the Portfolio");
	  test.log(Status.INFO, "creating the Portfolio");
  }
  
  @Test
  public void deletePortfolio() 
  {
	  System.out.println("Deleting the Portfolio");
	  test.log(Status.INFO, "Deleting the Portfolio");
  }
  
}
