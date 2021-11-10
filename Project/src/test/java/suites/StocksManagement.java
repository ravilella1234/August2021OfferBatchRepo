package suites;

import org.testng.annotations.Test;

public class StocksManagement
{
  @Test
  public void addNewStock() 
  {
	  System.out.println("Added New Stock");
  }
  
  @Test
  public void modifyStock() 
  {
	  System.out.println("Modified  Stock");
  }
  
  @Test
  public void verifyStockInList() 
  {
	  System.out.println("Verified Stock in List ");
  }
  
  @Test
  public void verifyQuantity() 
  {
	  System.out.println("Verified Stock Quantity");
  }
  
  @Test
  public void verifyTransactionHistory() 
  {
	  System.out.println("Verified TransactionHistory");
  }
}
