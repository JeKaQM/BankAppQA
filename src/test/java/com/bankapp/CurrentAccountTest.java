package com.bankapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {

    @Test
    public void testWithdrawWithinLimit() {
        CurrentAccount account = new CurrentAccount("Ed Smith", 500.0, 50.0, 200.0);
        boolean success = account.withdraw(150.0);
        assertTrue(success);
        assertEquals(350.0, account.getBalance());
    }

    @Test
    public void testWithdrawExceedingLimit() {
        CurrentAccount account = new CurrentAccount("Will Smith", 500.0, 50.0, 200.0);
        boolean success = account.withdraw(250.0);
        assertFalse(success);  // Exceeds max withdrawal limit
        assertEquals(500.0, account.getBalance());
    }
}
