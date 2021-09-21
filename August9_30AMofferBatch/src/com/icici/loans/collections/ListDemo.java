package com.icici.loans.collections;

import java.util.ArrayList;

public class ListDemo 
{

	public static void main(String[] args) 
	{
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(10);
		a.add("ravilella");
		a.add(12.34f);
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		
		System.out.println(a);
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		System.out.println(a.get(0));
		System.out.println(a.get(3));
		System.out.println(a.indexOf(10));
		
		System.out.println(a.contains("ravilella"));
		System.out.println(a);
		a.add(50);
		System.out.println(a);
		
		a.add(1, "sai");
		System.out.println(a);
		
		a.set(2, "ravikanthlella");
		System.out.println(a);
		
		System.out.println(a.subList(2, 7));
		
		System.out.println(a);
		
		a.remove(2);
		System.out.println(a);
		
		a.remove("sai");
		System.out.println(a);
		
		a.clear();
		System.out.println(a);
	}

}
