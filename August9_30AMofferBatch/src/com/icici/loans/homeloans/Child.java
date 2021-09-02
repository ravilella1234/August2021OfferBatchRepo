package com.icici.loans.homeloans;

class Parent
{
	public Number workhard()
	{
		System.out.println("Parent : wake-up early, goto college");
		return 0;
	}
	
	public void care()
	{
		System.out.println("Parent : atmost care...");
	}
}

public class Child extends Parent
{
	public Integer workhard()
	{
		System.out.println("Child : wake-up any-Time, goto movies");
		return 0;
	}
	
	public void love()
	{
		System.out.println("Child : iam in love");
	}
	
	public static void main(String[] args) 
	{
		 Child c = new Child();
		 c.workhard();
		 c.care();
		 c.love();
	}

}
