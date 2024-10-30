package com.bankapp;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountHolderName, double initialBalance, double minimumBalance, double interestRate) {
        super(accountHolderName, initialBalance, minimumBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }
}
