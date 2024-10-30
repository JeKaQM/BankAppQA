package com.bankapp;

public class CurrentAccount extends BankAccount {

    private double maxWithdrawalLimit;

    public CurrentAccount(String accountHolderName, double initialBalance, double minimumBalance, double maxWithdrawalLimit) {
        super(accountHolderName, initialBalance, minimumBalance);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= maxWithdrawalLimit) {
            return super.withdraw(amount);
        }
        return false;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }
}
