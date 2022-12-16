package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
	
	
	private long loanAmount;
	private int termInYears;
	private float annualRate;
	private double monthlyPayment;
	
	public MortgageCalculator(long loanAmount, int termInYears,float annualRate) {
		this.loanAmount = loanAmount;
		this.termInYears = termInYears;
		this.annualRate = annualRate;
		
	}
	
	private int getNumberOfPayments() {
		return this.termInYears*12;
	}
	
	private float getMonthlyInterestRate() {
		float interestRate =this.annualRate/100;  
		return interestRate/12;
	}

	public void calculateMonthlyPayment() {
		
		float r = this.getMonthlyInterestRate();
	    float ratePower = (float) Math.pow((1 + this.getMonthlyInterestRate()), this.getNumberOfPayments());
	    this.monthlyPayment = this.loanAmount*(r*ratePower)/(ratePower-1);
	    
//		M = P(r(1+r)^n/(((1+r)^n)-1)
//
//				M is the calculated monthly mortgage payment,  
//
//				P is the principal amount, represented by loanAmount in our class,  
//
//				r is the monthly interest rate, which you can find by calling getMonthlyInterestRate().  
//
//				n is the total number of payments which you can find by calling getNumberOfPayments().
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("####0.00");
		return "monthlyPayment: " + df.format(this.monthlyPayment);
	}
	
	public static void main(String[] args) {
		if(args.length!=3)
			System.out.print("Bad Data\n");
		else {
			long loanAmount = Utilities.getLongValue(args[0]);
			int termInYears = Utilities.getIntValue(args[1]); 
			float annualRate = Utilities.getFloatValue(args[2]);
			MortgageCalculator calc = new MortgageCalculator(loanAmount,termInYears,annualRate);
			calc.calculateMonthlyPayment();
			System.out.print(calc.toString()+"\n");
		}
	}

}
