package com.project;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_003 extends BaseTest
{
	
  @BeforeMethod(groups = {"regression"})
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception 
  {
	  	init();
		test = report.createTest("TNG_003");
		test.log(Status.INFO, "Init the Properties Files....");
				
		launch(bType);
		test.log(Status.PASS, "Opened the Browser :-" + bType);
				
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigated to url :- " + childProp.getProperty("amazonurl"));
  }

  @Test(groups = {"regression"})
  public void f() 
  {
	    selectOption("amazondropdown_id","Books");
		test.log(Status.FAIL, "Selected the Books by using the locator :- " + orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry potter By using the Locator :- " + orProp.getProperty("amazonsearchtext_name"));
		
		elementClick("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));
  }
  
  @AfterMethod(groups = {"regression"})
  public void afterMethod()
  {
	  report.flush();
	  driver.quit();
  }

}
