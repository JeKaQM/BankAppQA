package com.bankapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {

    @Test
    public void testApplyInterest() {
        SavingsAccount account = new SavingsAccount("Jeno", 1000.0, 100.0, 0.05);
        account.applyInterest();
        assertEquals(1050.0, account.getBalance());
    }
}
