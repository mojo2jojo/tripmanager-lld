package com.travelpackage.takeatrip.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class GoldPassengerTest {
    @Test
    void testMakePayment() {
        GoldPassenger goldPassenger=new GoldPassenger(0l, "test-user-1", new BigDecimal(150));
        
        BigDecimal totalActivityCost = new BigDecimal(50);
        goldPassenger.makePayment(totalActivityCost);

        BigDecimal discount = totalActivityCost.multiply(new BigDecimal(0.1));
        totalActivityCost = totalActivityCost.subtract(discount);
        BigDecimal resultant = new BigDecimal(150).subtract(totalActivityCost);
        
        assertEquals((resultant).equals(goldPassenger.getBalance()), true);
    }
}
