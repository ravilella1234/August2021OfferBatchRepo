package com.icici.loans.Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedException 
{

	public static void m1() throws Exception
	{
		BufferedReader b = new BufferedReader(new FileReader("d://xyz.txt"));
	}
	
	public static void main(String[] args) throws Exception 
	{
		m1();
		System.out.println("Hi");
	}

}
