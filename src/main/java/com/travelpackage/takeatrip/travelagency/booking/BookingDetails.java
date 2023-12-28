package com.travelpackage.takeatrip.travelagency.booking;

import java.math.BigDecimal;
import java.util.List;

import com.travelpackage.takeatrip.activity.Activity;
import com.travelpackage.takeatrip.passenger.Passenger;
import com.travelpackage.takeatrip.travelpackage.TravelPackage;

public interface BookingDetails {

    Long getId();

    Passenger getPassenger();

    TravelPackage getTravelPackage();

    List<Activity> getActivityList();

    BigDecimal getCost();

}