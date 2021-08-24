package com.icici.loans.carloans;

public class HDFC implements Rbi
{

	@Override
	public void withdrawl() {
		System.out.println("iam overriden withdrawl in HDFC");
	}

	@Override
	public void deposit() {
		System.out.println("iam overriden deposit in HDFC");
	}
	
	public static void main(String[] args) {
		HDFC h = new HDFC();
		h.deposit();
		h.withdrawl();
	}

}
