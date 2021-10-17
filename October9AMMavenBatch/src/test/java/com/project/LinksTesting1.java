package com.project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LinksTesting1 extends BaseTest
{

	@BeforeMethod(groups = {"regression","sanity"})
	@Parameters("browser")
	public void setup(String bType) throws Exception
	{
		init();
		test = report.createTest("LinksTesting1");
		test.log(Status.INFO, "----------------   Started LinksTesting1 ------------------------");
		test.log(Status.INFO, "initialising the dependency files...... ");
				
		launch(bType);
		test.log(Status.PASS, "Opening the browser :-" + bType);
				
		navigateUrl("googleurl");
		test.log(Status.INFO, "Navigated to :- " + childProp.getProperty("googleurl"));
		
	}
	
	
	@Test(groups = {"regression","sanity"})
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		System.out.println(actval);
		System.out.println(expval);
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod(groups = {"regression","sanity"})
	public void tearDown()
	{
		  report.flush();
		  driver.quit();
	}

}
