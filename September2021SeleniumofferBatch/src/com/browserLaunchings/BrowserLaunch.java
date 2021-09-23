package com.browserLaunchings;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Desktop\\NewDrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:/Users/ravi/Desktop/NewDrivers/geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver1 = new FirefoxDriver();
				
		//webdriver.egde.driver
		//webdriver.ie.driver
	}

}
