package com.icici.loans.homeloans;

import java.util.ArrayList;

public class MethodOverloading 
{
	
	
	
	  //public void m1(int x) { System.out.println(x); }
	 
	
	/*
	 * public void m1(float x) { System.out.println(x); }
	 */
	
	
	  public void m1(Integer x) { System.out.println(x); }
	 
	
	/*
	 * public void m1(Number x) { System.out.println(x); }
	 */
	
	/*
	 * public void m1(String x) { System.out.println(x); }
	 */
	
	public void m1(Object x)
	{
		System.out.println(x);
	}
	
	public static void main(String[] args) 
	{
		MethodOverloading obj = new MethodOverloading();
		obj.m1(100);
		obj.m1(23.34f);
		obj.m1("ravilella");
		obj.m1(200);
		obj.m1(45.45f);
		obj.m1("sai");
		
		ArrayList<Integer> a  =  new ArrayList<Integer>();
		a.add(100);
		a.add(200);
		
		System.out.println(a);
		
		int i1 = 100;
		System.out.println(i1);
		
		Integer i2 = 200;
		System.out.println(i2);
		
		
	}

}
