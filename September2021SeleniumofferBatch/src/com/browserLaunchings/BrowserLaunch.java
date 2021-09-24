package com.browserLaunchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args)
	{
		WebDriver driver; 
		String projectPath = System.getProperty("user.dir"); 
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\NewDrivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:/Users/ravi/Desktop/NewDrivers/geckodriver.exe");
		 System.setProperty("Webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
				
		//webdriver.egde.driver
		//webdriver.ie.driver
	}

}
