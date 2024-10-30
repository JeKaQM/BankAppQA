package com.bankapp;

public class BankAccount {

    private double balance;
    private double minimumBalance;
    private String accountHolderName;

    public BankAccount(String accountHolderName, double initialBalance, double minimumBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minimumBalance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
}
