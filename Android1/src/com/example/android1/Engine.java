package com.example.android1;

public class Engine {
	
	private double investmentAmount=0;
	private int years = 0;
	private double annualInterestRate=0;
	
	public Engine(){
		
	}
	public double getinvestmentAmount(){
		return investmentAmount;
	}
	public double getyears(){
		return years;
	}
	public double getannualInterestRate(){
		return annualInterestRate;
	}
	
	public static double investmentCalculator(double investmentAmount, double years, double annualInterestRate){
		double amount=investmentAmount * Math.pow(1+(annualInterestRate/100), years);
		return amount;
	}
}
