package com.travelpackage.takeatrip.travelagency;

import java.util.List;
import java.util.Map;

import com.travelpackage.takeatrip.passenger.Passenger;
import com.travelpackage.takeatrip.travelagency.booking.BookingDetails;
import com.travelpackage.takeatrip.travelpackage.TravelPackage;

public interface TravelAgency {

    void init();

    List<TravelPackage> getTravelPackagesList();

    Map<Passenger, List<BookingDetails>> getBookingMap();

    List<TravelPackage> listTravelPackages();

    BookingDetails bookPackageByID(Passenger person, TravelPackage travelpackage, List<Long> userActivityListId);

    void printPassengerList(TravelPackage travelpackage);
    
    void printPassengerDetails(Passenger person);

    void printFreeActivitiesInPackage(TravelPackage travelpackage);

}