package gridpack;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridDemo 
{
  @Test
  public void test1() throws Exception 
  {
	  System.out.println("Starting test1");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\grid\\chromedriver.exe");
	  
	  DesiredCapabilities ds = new  DesiredCapabilities();
	  ds.setPlatform(Platform.WINDOWS);
	  ds.setBrowserName("firefox");
	  
	  WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.187:4444/wd/hub"), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(7000);
	  driver.quit();
	  System.out.println("Ending test1");
  }
  
  
  @Test
  public void test2() throws Exception 
  {
	  System.out.println("Starting test2");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\grid\\chromedriver.exe");
	  
	  DesiredCapabilities ds = new  DesiredCapabilities();
	  ds.setPlatform(Platform.WINDOWS);
	  ds.setBrowserName("firefox");
	  
	  WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.187:4444/wd/hub"), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(7000);
	 driver.quit();
	  System.out.println("Ending test2");
  }
  
  @Test
  public void test3() throws Exception 
  {
	  System.out.println("Starting test3");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\grid\\chromedriver.exe");
	  
	  DesiredCapabilities ds = new  DesiredCapabilities();
	  ds.setPlatform(Platform.WINDOWS);
	  ds.setBrowserName("firefox");
	  
	  WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.187:4444/wd/hub"), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(7000);
	 driver.quit();
	  System.out.println("Ending test3");
  }
  
  @Test
  public void test4() throws Exception 
  {
	  System.out.println("Starting test4");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\grid\\chromedriver.exe");
	  
	  DesiredCapabilities ds = new  DesiredCapabilities();
	  ds.setPlatform(Platform.WINDOWS);
	  ds.setBrowserName("firefox");
	  
	  WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.187:4444/wd/hub"), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(7000);
	  driver.quit();
	  System.out.println("Ending test4");
  }
  
  
  @Test
  public void test5() throws Exception 
  {
	  System.out.println("Starting test5");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\grid\\chromedriver.exe");
	  
	  DesiredCapabilities ds = new  DesiredCapabilities();
	  ds.setPlatform(Platform.WINDOWS);
	  ds.setBrowserName("firefox");
	  
	  WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.187:4444/wd/hub"), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(7000);
	 driver.quit();
	  System.out.println("Ending test5");
  }
  
  @Test
  public void test6() throws Exception 
  {
	  System.out.println("Starting test6");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\grid\\chromedriver.exe");
	  
	  DesiredCapabilities ds = new  DesiredCapabilities();
	  ds.setPlatform(Platform.WINDOWS);
	  ds.setBrowserName("firefox");
	  
	  WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.187:4444/wd/hub"), ds);
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(7000);
	 driver.quit();
	  System.out.println("Ending test6");
  }
}
