package com.company;

import java.text.NumberFormat;

public class OutputPrinter {
    MortgageCalculator calculatedValue = new MortgageCalculator();

    public void printLoanBalance(int loan, double percentage, int period) {
        int rate = calculatedValue.paymentsPeriodInMonths(period);
        System.out.println("\nPayment Schedule:\n");
        for(int i = (rate-1); i >= 0; i-- ){
            double loanBalance = calculatedValue.loanBalance(loan, calculatedValue.monthlyInterest(percentage), calculatedValue.paymentsPeriodInMonths(period), i);
            String loanBalanceFormatted = NumberFormat.getCurrencyInstance().format(loanBalance);
            System.out.println(loanBalanceFormatted);
        }
    }

    public void printMortgage(int loan, double percentage, int period) {
        double mortgage = calculatedValue.calculateMortgage(loan, calculatedValue.monthlyInterest(percentage), calculatedValue.paymentsPeriodInMonths(period));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
