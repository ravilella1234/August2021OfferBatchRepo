package suites;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import keywords.ApplicationKeywords;

public class BaseTest 
{
	
	public ApplicationKeywords app ;
	
	@BeforeTest
	public void startTest(ITestContext context) throws Exception
	{
		System.out.println("-----------  Before Test  ---------");
		
		app = new ApplicationKeywords();
		context.setAttribute("app", app);
	}
	
	@BeforeMethod
	public void startMethod(ITestContext context)
	{
		System.out.println("---------- BeforeMethod  --------------------");
		app = (ApplicationKeywords)context.getAttribute("app");
	}

}
