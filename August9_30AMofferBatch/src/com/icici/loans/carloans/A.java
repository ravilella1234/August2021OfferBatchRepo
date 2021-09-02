package com.icici.loans.carloans;

import java.io.File;
import java.util.Date;

import com.icici.loans.homeloans.C;

public class A 
{
	public final int x=10;
	public static final String cname = "vmware";
	
	
	
	public  void m1()
	{
		System.out.println(x);
		System.out.println("iam m1 from A");
	}
	
	public static void m5() {
		System.out.println("iam m5 static method");
	}
	
	static
	{
		System.out.println("iam static Block....");
	}
	
	static
	{
		Date dt = new Date();
		System.out.println(dt);
	}
	
	static
	{
		File f = new File("D:\\August2021Repo\\August9_30AMofferBatch\\abc\\xyz\\pqr");
		f.mkdirs();
	}
	
		
	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		m5();
		
		A obj;
		obj = new B();
		obj = new C();
	}

}
