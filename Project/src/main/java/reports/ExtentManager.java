package reports;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import keywords.GenericKeywords;

public class ExtentManager extends GenericKeywords
{
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports reports;
	
	public static ExtentReports getReports()
	{
		
		if(reports == null)
		{
			Date dt = new Date();
			String reportpath = dt.toString().replace(':', '_').replace(' ', '_')+".html";
			htmlReport = new ExtentHtmlReporter(projectPath +"\\src\\main\\resources\\"+reportpath);
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Functional testing Report");
			htmlReport.config().setTheme(Theme.STANDARD);
			
			reports = new ExtentReports();
			reports.attachReporter(htmlReport);
			reports.setSystemInfo("OS", "Windows");
			reports.setSystemInfo("Tester Name","ravilella");
			reports.setSystemInfo("Browser", "chrome");
			
		}
		
		return reports;
		
	}

}
