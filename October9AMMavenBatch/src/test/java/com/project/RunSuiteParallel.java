package com.project;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuiteParallel 
{

	public static void main(String[] args) 
	{
		
		String[] s1 = {"r1","r2"};
		
		String[] s2 = new String[2];
		s2[0]="r1";
		s2[1]="r2";
		
		String[] s3 = new String[] {"r1","r2"};
		
		TestNG obj = new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//testngmegasuite.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();
	}

}
