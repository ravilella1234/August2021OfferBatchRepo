package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager1
{
	public static ExtentReports reports;
	public static String screenshotFolderPath;
	
	public static ExtentReports getReports()
	{
		if(reports == null)
		{
			reports = new ExtentReports();
			//init the report folder
			Date dt = new Date();
			String reportFolder = dt.toString().replace(':', '_')+"//screenshots";
			
			screenshotFolderPath = System.getProperty("user.dir")+"//reports//"+reportFolder;
			System.out.println(screenshotFolderPath);
			File f = new File(screenshotFolderPath);
			f.mkdirs();
			
			ExtentSparkReporter sparkReport = new ExtentSparkReporter(screenshotFolderPath);
			sparkReport.config().setReportName("Production Regression Testing...");
			sparkReport.config().setDocumentTitle("Automation Report");
			sparkReport.config().setTheme(Theme.STANDARD);
			
			String reportpath = dt.toString().replace(':', '_').replace(' ', '_')+".html";
			ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(screenshotFolderPath+"//"+reportpath);
			
			reports.attachReporter(htmlReport);
			reports.attachReporter(sparkReport);
				
		}
		
		return reports;
	}

}
