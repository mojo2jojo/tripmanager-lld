package com.travelpackage.takeatrip.travelpackage;

import java.util.ArrayList;
import java.util.List;

import com.travelpackage.takeatrip.destination.Destination;
import com.travelpackage.takeatrip.passenger.Passenger;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TravelPackageImpl implements TravelPackage {
    
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackageImpl(Long id, String name, int passengerCapacity, List<Destination> itinerary) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary=itinerary;
        this.passengers = new ArrayList<>();
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

}
