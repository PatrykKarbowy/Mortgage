package com.company;

public class MortgageCalculator {
    public double calculateMortgage(int loan, double percentageNumber, int months){
        return loan
                *((percentageNumber*Math.pow((1+percentageNumber),months))
                /(Math.pow((1+percentageNumber),months)-1));}

    public double loanBalance(int loan, double percentageNumber, int months, int rate){
        int remainingMonths = months - rate;
        return loan*(
                ((Math.pow((1+percentageNumber), months)) - (Math.pow((1+percentageNumber), remainingMonths)))
                        /((Math.pow((1+percentageNumber), months))-1));
    }
    public double monthlyInterest(double percentage){
        final byte PERCENTAGE_NUMBER = 100;
        final byte MONTHS_IN_YEAR = 12;
        return percentage/PERCENTAGE_NUMBER/MONTHS_IN_YEAR;
    }

    public int paymentsPeriodInMonths(int period){
        final byte MONTHS_IN_YEAR = 12;
        return period*MONTHS_IN_YEAR;
    }
}
