package switches;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitching3 
{

	public static void main(String[] args) throws Exception 
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
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		List<WebElement> mediaLinks = driver.findElements(By.xpath("//div[@class='social-media-links wow fadeInUp']/ul/li/p/a/span[2]/img"));
		for(int i=0;i<mediaLinks.size();i++)
		{
			//System.out.println(mediaLinks.get(i).getAttribute("alt"));
			Actions a = new Actions(driver);
			a.moveToElement(mediaLinks.get(i));
			a.contextClick(mediaLinks.get(i)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			
			//Thread.sleep(4000);
		}
	}

}
