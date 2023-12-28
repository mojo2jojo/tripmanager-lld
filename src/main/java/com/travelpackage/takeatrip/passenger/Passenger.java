package com.travelpackage.takeatrip.passenger;

import java.math.BigDecimal;

public interface Passenger {

    Long getId();

    String getName();

    BigDecimal getBalance();

    void makePayment(BigDecimal totalActivityCost);

}