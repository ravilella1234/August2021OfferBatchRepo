package com.icici.loans.collections;

import java.util.Set;
import java.util.TreeMap;

public class MapDemo 
{

	public static void main(String[] args) 
	{
		TreeMap<Integer, Integer> h = new TreeMap<Integer, Integer>();
		h.put(100, 100);
		h.put(2000, 200);
		h.put(3, 300);
		h.put(1, 400);
		h.put(10, 200);
		
		System.out.println(h);
		System.out.println(h.get(30));
		System.out.println(h.get(10));
		System.out.println(h.size());
		
		Set<Integer> keys = h.keySet();
		for(Integer k:keys)
		{
			System.out.println(k+ " ----- "+ h.get(k));
		}

	}

}
