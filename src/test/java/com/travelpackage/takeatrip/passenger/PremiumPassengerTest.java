package com.travelpackage.takeatrip.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class PremiumPassengerTest {
    @Test
    void testMakePayment() {
        PremiumPassenger passenger=new PremiumPassenger(0l, "test-user-1", new BigDecimal(150));
        
        BigDecimal totalActivityCost = new BigDecimal(50);
        passenger.makePayment(totalActivityCost);
        
        assertEquals((new BigDecimal(150)).equals(passenger.getBalance()), true);
    }
}
