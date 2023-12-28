package com.travelpackage.takeatrip.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class StandardPassengerTest {
    @Test
    void testMakePayment() {

        StandardPassenger passenger=new StandardPassenger(0l, "test-standard-user-1", new BigDecimal(150));
        
        BigDecimal totalActivityCost = new BigDecimal(50);
        passenger.makePayment(totalActivityCost);

        assertEquals((new BigDecimal(100)).equals(passenger.getBalance()), true);
    }
}
