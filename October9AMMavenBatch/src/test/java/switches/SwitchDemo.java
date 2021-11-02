package switches;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchDemo
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.icicibank.com/");
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		System.out.println(driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("modal-close")))).click();

		driver.switchTo().frame("iframe-full-height");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='content lifestyle-5']/div/a[contains(text(),'Apply now')]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='content lifestyle-5']/div/a[contains(text(),'KNOW MORE')]")))).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> iWinds = new ArrayList<String>(windows);
		
		for(String i:iWinds)
		{
			System.out.println(i);
		}
		
		System.out.println(driver.getTitle() + "---->" + driver.getWindowHandle());
		
		driver.switchTo().window(iWinds.get(1));
		System.out.println(driver.getTitle() + "---->" + driver.getWindowHandle());
		
		driver.switchTo().window(iWinds.get(2));
		System.out.println(driver.getTitle() + "---->" + driver.getWindowHandle());
		
		
		
	}

}
