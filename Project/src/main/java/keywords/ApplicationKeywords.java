package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ApplicationKeywords  extends GenericKeywords
{
	

	public ApplicationKeywords() throws Exception 
	{
		
		mainProp = new Properties();
		childProp = new Properties();
		
		try 
		{
			FileInputStream fis = new FileInputStream(projectPath+"\\src\\test\\resources\\environment.properties");
			mainProp.load(fis);
			String e = mainProp.getProperty("env");
			System.out.println(e);
			
			fis = new FileInputStream(projectPath+"\\src\\test\\resources\\"+e+".properties");
			childProp.load(fis);
			System.out.println(childProp.getProperty("rediffurl"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void login()
	{
		
	}
	
    public void selectDateFromCalander()
    {
    	
    }

}
