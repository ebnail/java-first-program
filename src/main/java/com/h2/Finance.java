package com.h2;

import java.util.Arrays;
import java.util.Map;

public class Finance{

	public static final String BEST_LOAN_RATES = "bestLoanRates";
	public static final String SAVINGS_CALCULATOR  =  "savingsCalculator";
	public static final String MORTGAGE_CALCULATOR =  "mortgageCalculator";
	
	
	public static final Map<String, String> commandsToUse = Map.of(BEST_LOAN_RATES, "usage: bestLoanRates", 
					SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",  
					MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");
	
	
	private static boolean validateCommandArguments(String[] args) {
		
		switch (args[0]) {
		
		case "bestLoanRates":
			return args.length==1;
			
		case "savingsCalculator":
			return args.length==3;
			
		case "MortgageCalculator":
			return args.length==4;
		}
		return false;
		
	}
	
	private static void executeCommand(String command, String[] args) {
		switch (command) { 

		case BEST_LOAN_RATES:

			System.out.println("Finding best loan rates ...");			
			BestLoanRates.main(args);
			return;
			
		case SAVINGS_CALCULATOR:

			System.out.println("Finding your net savings ...");
			SavingsCalculator.main(args);
			return;
			
		case MORTGAGE_CALCULATOR:			
			System.out.println("Finding your monthly payment ...");
			MortgageCalculator.main(args);
			return;
		}
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String command = args[0];
		if (!commandsToUse.containsKey(command)) {
			System.out.println(command + ": command not found");
			return;
		}
		boolean isValidCommand  = validateCommandArguments(args);
		if (isValidCommand==false) {
			System.out.println(commandsToUse.get(command));
			return;
		}
		
		executeCommand(command,Arrays.copyOfRange(args, 1,args.length));

	}

}
