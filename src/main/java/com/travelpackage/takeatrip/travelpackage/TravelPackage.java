package com.travelpackage.takeatrip.travelpackage;

import java.util.List;

import com.travelpackage.takeatrip.destination.Destination;
import com.travelpackage.takeatrip.passenger.Passenger;

public interface TravelPackage {

    Long getId();

    String getName();

    int getPassengerCapacity();

    List<Destination> getItinerary();

    List<Passenger> getPassengers();

    void addPassenger(Passenger passenger);

}