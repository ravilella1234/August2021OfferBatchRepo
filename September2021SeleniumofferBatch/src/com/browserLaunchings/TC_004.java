package com.browserLaunchings;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("firefoxbrowser");
		
		
		//certificate error
		navigateUrl("certificateurl");

	}

}
