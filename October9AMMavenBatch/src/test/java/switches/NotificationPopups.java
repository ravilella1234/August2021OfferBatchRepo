package switches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopups {

	public static void main(String[] args) throws Exception 
	{
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions option = new ChromeOptions();
		  option.addArguments("--disable-notifications");
		  WebDriver driver=new ChromeDriver(option);
		  driver.manage().window().maximize();
		  driver.get("https://whatmylocation.com/");
		  
		 

	}

}
