package com.bankapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount("Jeno", 100.0, 50.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Alex", 100.0, 50.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testWithdrawWithinBalance() {
        BankAccount account = new BankAccount("Ben", 100.0, 50.0);
        boolean success = account.withdraw(30.0);
        assertTrue(success);
        assertEquals(70.0, account.getBalance());
    }

    @Test
    public void testWithdrawExceedingBalance() {
        BankAccount account = new BankAccount("Jordan", 100.0, 50.0);
        boolean success = account.withdraw(70.0);
        assertFalse(success);  // Exceeds minimum balance
        assertEquals(100.0, account.getBalance());
    }
}
