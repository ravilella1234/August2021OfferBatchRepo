package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ApplicationKeywords  extends ValidationKeywords
{
	

	public ApplicationKeywords() throws Exception 
	{
		
		mainProp = new Properties();
		childProp = new Properties();
		orProp = new Properties();
		
		try 
		{
			FileInputStream fis = new FileInputStream(projectPath+"\\src\\test\\resources\\environment.properties");
			mainProp.load(fis);
			String e = mainProp.getProperty("env");
			System.out.println(e);
			
			fis = new FileInputStream(projectPath+"\\src\\test\\resources\\"+e+".properties");
			childProp.load(fis);
			System.out.println(childProp.getProperty("rediffurl"));
			
			fis = new FileInputStream(projectPath+"\\src\\test\\resources\\or.properties");
			orProp.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void login()
	{
		test.log(Status.INFO, "login");
	}
	
    public void selectDateFromCalander()
    {
    	
    }
    
    public void setReport(ExtentTest test)
    {
    	this.test=test;
    }

}
