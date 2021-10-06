package com.browserLaunchings;

import org.apache.log4j.Logger;

public class TC_005 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_005.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Init the Properties Files....");
		
		launch("chromebrowser");
		log.info("Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + childProp.getProperty("amazonurl") );
		
		selectOption("amazondropbox_id","Books");
		log.info("Selected the Books by using the locator :- " + orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		log.info("Entered the text Harry potter By using the Locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		elementClick("amazonsearchbutton_xpath");
		log.info("Clicked on Element By Using Locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));

		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

	}

	

}
