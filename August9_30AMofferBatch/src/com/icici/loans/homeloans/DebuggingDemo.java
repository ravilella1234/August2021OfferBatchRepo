package com.icici.loans.homeloans;

import java.util.Scanner;

public class DebuggingDemo 
{
	
	public int m1()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Array Size :");
		int asize = sc.nextInt();
		
		int[] a = new int[asize];	
		int sum = 0;
		System.out.println("Enter the array Elements : ");
		for(int i=0;i<a.length;i++)
		{
			a[i] = sc.nextInt();
			System.out.println("a["+i+"]="+a[i]);
			sum = sum + a[i];
		}
		System.out.println("Sum of the array is : " + sum);
		return sum;
	}
	
	public static void main(String[] args) 
	{
		DebuggingDemo obj = new DebuggingDemo();
		int count = obj.m1();
		System.out.println("Count of Array is : " + count);
	}

}
