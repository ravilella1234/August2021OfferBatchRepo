package com.icici.loans.homeloans;

public class Student 
{
	int sno;
	String sname;
	
	public Student(int sno, String sname) 
	{
		super();
		this.sno = sno;
		this.sname = sname;
	}
	
	@Override
	public String toString() 
	{
		return "Student [sno=" + sno + ", sname=" + sname + "]";
	}

	public static void main(String[] args) 
	{
		Student s = new Student(1744,"sai");
		System.out.println(s);
		//System.out.println(s.sno);
		//System.out.println(s.sname);
		
		Student s1 = new Student(100, "student1");
		Student s2 = new Student(200, "student2");
		Student s3 = new Student(300, "student3");
		Student s4 = new Student(400, "student4");
		
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(s3);
		//System.out.println(s4);
		Student[] st = new Student[4];
		st[0]=s1;
		st[1]=s2;
		st[2]=s3;
		st[3]=s4;
		
		for(Student p:st)
		{
			System.out.println(p);
		}
		
	}
}
