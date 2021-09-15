package com.icici.loans.homeloans;

public class TwoDimenssionArray 
{

	public static void main(String[] args) 
	{
		//int[] a = {10,20};
		
		int[][] a = 
			{
					{10,20,30},
					{40,50},
					{70,80,90,50,60},
					{10}
			};
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
		
		System.out.println("-------------------------------");
		
		for(int p[]:a)
		{
			for(int q:p)
			{
				System.out.print(q+" ");
			}
			System.out.println();
		}

	}

}
