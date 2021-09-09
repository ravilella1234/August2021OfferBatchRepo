package com.icici.loans.homeloans;

public class MethodOverloading 
{
	
	/*
	 * public void m1(int x) { System.out.println(x); }
	 */
	
	/*
	 * public void m1(float x) { System.out.println(x); }
	 */
	
	/*
	 * public void m1(String s) { System.out.println(s); }
	 */
	
	/*
	 * public void m1(Integer s) { System.out.println(s); }
	 */
	
	/*
	 * public void m1(Number s) { System.out.println(s); }
	 */
	
	public void m1(Object s)
	{
		System.out.println(s);
	}
	
	public static void main(String[] args) 
	{
		MethodOverloading obj = new MethodOverloading();
		obj.m1(100);
		obj.m1(12.34f);
		obj.m1("ravilella");
		obj.m1(1000);
		obj.m1(234.34f);
		obj.m1("sai");
	}

}
