package com.bankapp;

import org.junit.jupiter.api.Test;
import org.junit.platform.console.ConsoleLauncher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking App!");
        System.out.println("Choose an option:");
        System.out.println("1. Run All Tests");
        System.out.println("2. Use Banking App");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            runTests();
        } else if (choice == 2) {
            runApp(scanner);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void runTests() {
        System.out.println("Running all tests...");
        String[] arguments = {"--select-package", "com.bankapp"};
        ConsoleLauncher.main(arguments);
    }
    private static void runApp(Scanner scanner) {
        System.out.println("Create an Account:");
        System.out.println("Enter Account Holder Name:");
        String name = scanner.nextLine();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();

        System.out.println("Enter minimum balance:");
        double minBalance = scanner.nextDouble();

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int accountType = scanner.nextInt();
        BankAccount account = null;

        if (accountType == 1) {
            System.out.println("Enter interest rate (e.g., 0.05 for 5%):");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(name, balance, minBalance, interestRate);
        } else if (accountType == 2) {
            System.out.println("Enter maximum withdrawal limit:");
            double maxWithdrawal = scanner.nextDouble();
            account = new CurrentAccount(name, balance, minBalance, maxWithdrawal);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            if (account instanceof SavingsAccount) {
                System.out.println("4. Apply Interest");
            }
            System.out.println("5. Exit");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposited " + depositAmount);
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrew " + withdrawalAmount);
                    } else {
                        System.out.println("Withdrawal failed. Check balance or limits.");
                    }
                    break;
                case 4:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).applyInterest();
                        System.out.println("Interest applied.");
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting. Thank you for using the Banking App!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
