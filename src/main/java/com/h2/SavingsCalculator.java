package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;

public class SavingsCalculator {
	
	private float[] credits;
	private float[] debits;
	
	public SavingsCalculator(float[] credits,float[] debits) {
		this.credits = credits;
		this.debits = debits;
	}
	
	private float sumOfCredits() {
		float sum = 0.0f;		
		for (float number: this.credits) {
            sum += number;
        }		
		return sum;
	}
	
	private float sumOfDebits() {
		float sum = 0.0f;		
		for (float number: this.debits) {
            sum += number;
        }		
		return sum;
	}
	
	private static int remainingDaysInMonth(LocalDate date) {
		YearMonth yearMonth = YearMonth.of(date.getYear(),date.getMonth());
		int totalDaysInMonth = yearMonth.lengthOfMonth();
		int remainingDays = totalDaysInMonth-date.getDayOfMonth();
		return remainingDays;
	}
	
	
	public float calculate() {
		return this.sumOfCredits()-this.sumOfDebits();
	}
	
	public static void main(String[] args) {
		String[] creditString = args[0].split(",");
		String [] debitString = args[1].split(",");
		float[] credits = new float[creditString.length];
		float[] debits = new float[debitString.length];
		
		for(int i=0; i<creditString.length; i++) {
			credits[i] = Float.parseFloat(creditString[i]);			
		}
		for(int i=0; i<debitString.length; i++) {
			debits[i] = Float.parseFloat(debitString[i]);			
		}	
		SavingsCalculator sc = new SavingsCalculator(credits, debits);
		float netSavings = sc.calculate();
		System.out.print("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now())+"\n");
		
	}

}
