package pageobjectModel;

import org.testng.annotations.Test;

import com.project.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class POM_001 extends BaseTest
{
  
	//WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() throws Exception
  {
	  init();
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
  }
  
  @Test(enabled = false)
  public void f() 
  {
	  LoginPage page  = new LoginPage(driver);
	  page.customerLogin();
	  Assert.assertEquals(page.verifyUser(), "Authentication failed.");
  }
  
  @Test
  public void customerReg() throws Exception
  {
	  CustomerRegistrationPage cr = new CustomerRegistrationPage(driver);
	  cr.customerRegistration();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
