package com.browserLaunchings;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

public class TC_007 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_007.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("TC_007");
		test.log(Status.INFO, "Init the Properties Files....");
				
		launch("chromebrowser");
		test.log(Status.PASS, "Opened the Browser :-" + p.getProperty("chromebrowser"));
				
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigated to url :- " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selected the Books by using the locator :- " + orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry potter By using the Locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		elementClick("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));
	
		report.flush();
		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

	}

	

}
