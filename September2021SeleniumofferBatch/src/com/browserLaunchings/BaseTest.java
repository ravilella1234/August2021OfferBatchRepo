package com.browserLaunchings;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver; 
	public static String projectPath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	
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
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
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
		else if(p.getProperty(browser).equals("firefox"))
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
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void elementClick(String locator) 
	{
		driver.findElement(By.xpath(locator)).click();
	}

	public static void typeText(String locator, String text) 
	{
		driver.findElement(By.name(locator)).sendKeys(text);		
	}

	public static void selectOption(String locator, String option) 
	{
		driver.findElement(By.id(locator)).sendKeys(option);
	}

}
