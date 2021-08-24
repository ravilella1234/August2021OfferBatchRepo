package com.icici.loans.carloans;

public class FirstClass 
{
	
	//data properties
	int a=10, b=20, result;
	
	//Behaviours
	public void add()
	{
		result = a+b;
		System.out.println("Add of A & B is : " + result);
	}
	
	public void sub()
	{
		result = a-b;
		System.out.println("Sub of A & B is : " + result);
	}
	
	public void mul()
	{
		result = a*b;
		System.out.println("Mul of A & B is : " + result);
	}

	public static void main(String[] args) 
	{
		System.out.println("He");
					
		FirstClass obj = new FirstClass();
		obj.add();
		obj.sub();
		obj.mul();
		
		FirstClass obj1 = new FirstClass();
		obj1.add();
		obj1.sub();
		obj1.mul();
	}

}
