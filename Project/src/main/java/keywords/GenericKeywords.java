package keywords;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentManager1;

public class GenericKeywords
{
	public WebDriver driver;
	Properties mainProp;
	Properties childProp;
	Properties orProp;
	public static String projectPath = System.getProperty("user.dir");
	public ExtentTest test;
	public SoftAssert softAssert;
	
	public void openBrowser(String browserName)
	{
		System.out.println("Opening the Browser : "+ browserName);
		//test.log(Status.INFO, "Opening the Browser : "+ browserName);
		log("Opening the Browser : "+ browserName);
		
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
    	//test.log(Status.INFO, "Navite to :- "+ url);
    	log("Navite to :- "+ url);
    	driver.get(childProp.getProperty(url));
    	
    }
    
    public void click(String locatorKey)
    {
    	System.out.println("Clicking on : " + locatorKey );
    	//test.log(Status.INFO, "Clicking on : " + orProp.getProperty(locatorKey) );
    	log("Clicking on : " + orProp.getProperty(locatorKey));
    	getElement(locatorKey).click();
    }
    
    public void type(String locatorKey, String text)
    {
    	System.out.println("Typing Text : " + locatorKey +"Data : "+text);
    	//test.log(Status.INFO, "Typing Text : " + childProp.getProperty(text) +"with locator : "+orProp.getProperty(locatorKey));
    	log("Typing Text : " + childProp.getProperty(text) +"with locator : "+orProp.getProperty(locatorKey));
    	getElement(locatorKey).sendKeys(childProp.getProperty(text));
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
		if(!isElementVisible(locatorKey))
		{
			//report failure
			System.out.println("Element not visible :" + locatorKey);
			reportFailure("Element not visible :" + locatorKey,true);
		}
		else
		{
			element = driver.findElement(getLocator(locatorKey));
		}
			
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
	
	
	public  boolean isElementVisible(String locatorKey) 
	{
		System.out.println("Check for Element Visible ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
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
    
	
	//reporting function
	public void log(String msg)
	{
		test.log(Status.INFO, msg);
	}
	
	public void reportFailure(String failureMsg,boolean stopOnFailure)
	{
		//System.out.println(failureMsg);
		test.log(Status.FAIL, failureMsg); // faliure in extent reports
		takeScreenShot();
		softAssert.fail(failureMsg); // failure in TestNG Reports
		
		if(stopOnFailure)
			assertAll(); // report all the failures (criticals /non-criticals)
	}
	
	public void takeScreenShot() 
	{
		Date d = new Date();
		String screenshotFileName = d.toString().replace(':','_').replace(' ','_')+".png";
		
		//Take the scrrenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File(ExtentManager1.screenshotFolderPath+"//"+screenshotFileName));
			test.log(Status.INFO, "Screenshot -->"+ test.addScreenCaptureFromPath(ExtentManager1.screenshotFolderPath+"//"+screenshotFileName));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public void assertAll()
	{
		Reporter.getCurrentTestResult().getTestContext().setAttribute("criticalFailure", "Y");
		softAssert.assertAll();
	}

}
