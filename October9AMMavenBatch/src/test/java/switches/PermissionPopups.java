package switches;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopups 
{

	public static void main(String[] args)
	{
		
		HashMap<String, Integer> contextSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions option = new ChromeOptions();
		
		contextSettings.put("geolocation", 0);
		//contextSettings.put("notification", 0);
		//contextSettings.put("media-stream", 0);
		profile.put("managed_default_content_settings", contextSettings);
		prefs.put("profile", profile);
		option.setExperimentalOption("prefs", prefs);
		//option.addArguments("disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://whatmylocation.com/");

	}

}
