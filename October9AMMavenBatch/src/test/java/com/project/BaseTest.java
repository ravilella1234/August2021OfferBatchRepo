package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver; 
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String filePath;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(' ', '_').replace(':', '_');
	}
	
	public static void init() throws Exception
	{
	    fis = new FileInputStream(projectPath+"\\data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"\\environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"\\"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String value = childProp.getProperty("amazonurl");
		System.out.println(value);
		
		fis = new FileInputStream(projectPath+"\\or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectPath+"\\log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			 
			 ChromeOptions option = new ChromeOptions();
			 option.addArguments("user-data-dir=C:\\Users\\ravi\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 4");
			 option.addArguments("--disable-notifications");
			 option.addArguments("--start-maximized");
			// option.addArguments("--ignore-certificate-errors-spki-list");
			// option.addArguments("--proxy-server=http://192.168.10.1:9090");
			 driver = new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			 WebDriverManager.firefoxdriver().setup();
			 
			 ProfilesIni p = new ProfilesIni();
			 FirefoxProfile profile = p.getProfile("septemberofferprofile");
			 
			 FirefoxOptions option = new FirefoxOptions();
			 option.setProfile(profile);
			 
			 //Notifications
			 profile.setPreference("dom.webnotifications.enabled", false);
			 
			 //Setting the Firefox Binaries path 
			// option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			 
			 //certificate errors
			 profile.setAcceptUntrustedCertificates(true);
			 profile.setAssumeUntrustedCertificateIssuer(false);
			 
			 //How to work with proxy settings // about:config
			// profile.setPreference("network.proxy.type", 1);
			// profile.setPreference("network.proxy.socks", "192.168.10.1"); //here i have gave dummy port number 
			// profile.setPreference("network.proxy.socks_port", 1744);
			 
			 driver = new FirefoxDriver(option);
			// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
		
	}
	
	public static void elementClick(String locatorKey) 
	{
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
		getElement(locatorKey).click();;
	}

	public static void typeText(String locatorKey, String text) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);		
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for element present
		if(!isElementPresent(locatorKey))
			//report failure
			System.out.println("Element not found :" + locatorKey);
		
		element = driver.findElement(getLocator(locatorKey));
		
		/*
		 * if(locatorKey.endsWith("_id")) { element =
		 * driver.findElement(By.id(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_name")) { element =
		 * driver.findElement(By.name(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_classname")) { element =
		 * driver.findElement(By.className(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_xpath")) { element =
		 * driver.findElement(By.xpath(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_css")) { element =
		 * driver.findElement(By.cssSelector(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_linktext")) { element =
		 * driver.findElement(By.linkText(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_partiallinktext")) { element =
		 * driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey))); }
		 */
		return element;
		
	}

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Check for Element Present ");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_linktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_partiallinktext"))
			 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
	
	public static By getLocator(String locatorKey)
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
	
	public static boolean isLinkEqual(String expectdLink) 
	{
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		
		if(actualLink.equals(expectdLink))
			return true;
		else
			return false;
	}
	
	// ******************  Reportings ************************
	
	public static void reportSuccess(String successMsg) 
	{
		test.log(Status.PASS, successMsg);
	}

	public static void reportFailure(String failureMsg) throws Exception 
	{
		test.log(Status.FAIL, failureMsg);
		takesScreenshot();
	}

	public static void takesScreenshot() throws Exception
	{
		
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectPath+"//failurescreenshots//"+dateFormat));
		
		test.log(Status.INFO, "Screenshot --->" +test.addScreenCaptureFromPath(projectPath+"//failurescreenshots//"+dateFormat));
	}
	
	public void waitforElement(WebElement locator, int timeOutInSeconds,String typeOfAction) 
	{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			if(typeOfAction.equals("elementClickable")) {
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			}else if(typeOfAction.equals("elementVisible")) {
				wait.until(ExpectedConditions.visibilityOf(locator));
			}
				
	}
	
	public int randomNum() 
	{
		Random r = new Random();
		int ran = r.nextInt(99999);
		return ran;
	}

}
