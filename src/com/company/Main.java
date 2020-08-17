package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		int loan = (int) readNumber("Loan: ", 1000, 1000000);
		double percentage = readNumber("Annual rate percentage: ", 0, 30);
		int period = (int) readNumber("Loan period in years: ", 1, 30);

		printMortgage(loan, percentage, period);
		printLoanBalance(loan, percentage, period);
	}

	public static void printLoanBalance(int loan, double percentage, int period) {
		int rate = paymentsPeriodInMonths(period);
		System.out.println("\nPayment Schedule:\n");
		for(int i = (rate-1); i >= 0; i-- ){
			double loanBalance = loanBalance(loan, monthlyInterest(percentage), paymentsPeriodInMonths(period), i);
			String loanBalanceFormatted = NumberFormat.getCurrencyInstance().format(loanBalance);
			System.out.println(loanBalanceFormatted);
		}
	}

	public static void printMortgage(int loan, double percentage, int period) {
		double mortgage = calculateMortgage(loan, monthlyInterest(percentage), paymentsPeriodInMonths(period));
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);
	}

	public static double readNumber(String prompt, double min, double max){
		Scanner scanner = new Scanner(System.in);
		double value;
		while (true){
			System.out.print(prompt);
			value = scanner.nextDouble();
			if (value >= min && value <= max)
				break;
			System.out.println("Enter a number between" + min + " and " + max);
		}
		return value;
	}

    public static double calculateMortgage(int loan, double percentageNumber, int months){

		double mortgage = loan
				*((percentageNumber*Math.pow((1+percentageNumber),months))
				/(Math.pow((1+percentageNumber),months)-1));

		return mortgage;
	}

	public static double monthlyInterest(double percentage){
		final byte PERCENTAGE_NUMBER = 100;
		final byte MONTHS_IN_YEAR = 12;
		double percentageNumber = percentage/PERCENTAGE_NUMBER/MONTHS_IN_YEAR;
		return percentageNumber;
	}

	public static int paymentsPeriodInMonths(int period){
		final byte MONTHS_IN_YEAR = 12;
		int months = period*MONTHS_IN_YEAR;
		return months;
	}

	public static double loanBalance(int loan, double percentageNumber, int months, int rate){
    	int remainingMonths = months - rate;
    	double remainingBalance = loan*(
				((Math.pow((1+percentageNumber), months)) - (Math.pow((1+percentageNumber), remainingMonths)))
				/((Math.pow((1+percentageNumber), months))-1));
    	return remainingBalance;
	}
}
