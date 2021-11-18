package keywords;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords  extends ValidationKeywords
{
	public WebDriver driver;
	Properties mainProp;
	Properties childProp;
	Properties orProp;
	public String projectPath = System.getProperty("user.dir");
	
	
	public void openBrowser(String browserName)
	{
		System.out.println("Opening the Browser : "+ browserName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
    public void navigate(String url)
    {
    	System.out.println("Navite to :- "+ url);
    	driver.get(childProp.getProperty(url));
    }
    
    public void click(String locatorKey)
    {
    	System.out.println("Clicking on : " + locatorKey );
    	getElement(locatorKey).click();
    }
    
    public void type(String locatorKey, String text)
    {
    	System.out.println("Typing Text : " + locatorKey +"Data : "+text);
    	getElement(locatorKey).sendKeys(text);
    }
    
    public void select(String locatorKey, String option)
    {
    	
    }
    
    public String getText(String locator)
    {
    	
		return locator;
    }
        
    
    public  WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for element present
		if(!isElementPresent(locatorKey))
			//report failure
			System.out.println("Element not found :" + locatorKey);
		
		element = driver.findElement(getLocator(locatorKey));
		
		return element;
	}

	public  boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Check for Element Present ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		} 
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
	
	public By getLocator(String locatorKey)
	{
		By by=null;
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}
    

}
