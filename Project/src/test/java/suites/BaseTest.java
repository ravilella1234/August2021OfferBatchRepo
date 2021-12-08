package suites;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;
import reports.ExtentManager1;

public class BaseTest 
{
	
	public ApplicationKeywords app ;
	public ExtentReports rep;
	public ExtentTest test;
	
	@BeforeTest
	public void startTest(ITestContext context) throws Exception
	{
		System.out.println("-----------  Before Test  ---------");
		
		app = new ApplicationKeywords();
		context.setAttribute("app", app);
		
		//init the reporting for the test
		rep = ExtentManager1.getReports();
		test = rep.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting test :" + context.getCurrentXmlTest().getName());
		
		app.setReport(test);
		
		context.setAttribute("report", rep);
		context.setAttribute("test", test);
	}
	
	@BeforeMethod
	public void startMethod(ITestContext context)
	{
		System.out.println("---------- BeforeMethod  --------------------");
		test = (ExtentTest)context.getAttribute("test");
		
		String criticalFail = (String)context.getAttribute("criticalFailure");
		if(criticalFail!=null && criticalFail.equals("Y"))
		{
			test.log(Status.SKIP, "Critical Faliure in Privious Tests");
			throw new SkipException("Critical Faliure in Privious Tests"); // skip the current test TestNG Reports
		}
			
		app = (ApplicationKeywords)context.getAttribute("app");
		rep = (ExtentReports)context.getAttribute("report");
		
	}
	
	@AfterTest
	public void quit()
	{
		System.out.println("After execution flush");
		if(rep!=null)
			rep.flush();
	}

}
