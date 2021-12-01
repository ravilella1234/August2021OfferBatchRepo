package suites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertsDemo 
{
  @Test
  public void f() 
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  String actualtitle = driver.getTitle();
	  String extecpedtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon";
	  
	 // Assert.assertEquals(actualtitle, extecpedtitle);
	  //Assert.assertTrue(actualtitle.equals(extecpedtitle));
	  
	 // Assert.assertTrue(actualtitle.equals(extecpedtitle), "Both titles are not equal...");
	  
	  
	  
	  SoftAssert obj = new SoftAssert();
	  //obj.assertEquals(actualtitle, extecpedtitle);
	  obj.assertTrue(actualtitle.equals(extecpedtitle), "Both titles are not equal...");
	  
	  obj.assertTrue(false, "err1");
	  
	  obj.assertTrue(false, "err2");
	  
	  obj.assertTrue(true, "err3");
	  
	  obj.assertTrue(false, "err4");
	  
	  driver.findElement(By.linkText("Customer Service")).click();
	  
	 obj.assertAll();
	  
  }
}
