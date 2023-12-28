package com.travelpackage.takeatrip.activity;

import java.math.BigDecimal;

public interface Activity {

    Long getId();

    String getName();

    String getDescription();

    BigDecimal getCost();

    int getCapacity();

    void setCapacity(int capacity);

    int getCurrentEnrollees();

    void setCurrentEnrollees(int currentEnrollees);

}