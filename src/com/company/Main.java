package com.company;

public class Main {

    public static void main(String[] args) {
    	InputTaker input = new InputTaker();
    	OutputPrinter out = new OutputPrinter();

		int loan = (int) input.readNumber("Loan: ", 1000, 1000000);
		double percentage = input.readNumber("Annual rate percentage: ", 0, 30);
		int period = (int) input.readNumber("Loan period in years: ", 1, 30);

		out.printMortgage(loan, percentage, period);
		out.printLoanBalance(loan, percentage, period);
	}

}
