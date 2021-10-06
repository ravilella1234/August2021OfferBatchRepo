package com.browserLaunchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		//driver.findElement(By.linkText("Customer Service")).click();
		
		//driver.findElement(By.partialLinkText("Customer Serv" )).click();
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				System.out.println(links.get(i).getText());
			}
			
		}
		
		System.out.println("-----------------------------------------------");
		
		System.out.println();
		
		List<WebElement> lks = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		for(int j=0;j<lks.size();j++)
		{
			System.out.println(lks.get(j).getText());
		}

	}

}
