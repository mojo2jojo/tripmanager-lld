package com.travelpackage.takeatrip.travelagency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.travelpackage.takeatrip.activity.Activity;
import com.travelpackage.takeatrip.destination.Destination;
import com.travelpackage.takeatrip.passenger.Passenger;
import com.travelpackage.takeatrip.travelagency.booking.BookingDetails;
import com.travelpackage.takeatrip.travelagency.booking.BookingDetailsImpl;
import com.travelpackage.takeatrip.travelpackage.TravelPackage;
import com.travelpackage.takeatrip.util.Util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TravelAgencyImpl implements TravelAgency {

    List<TravelPackage> travelPackagesList;
    Map<Passenger,List<BookingDetails>> bookingMap;

    public TravelAgencyImpl() {
        this.travelPackagesList= new ArrayList<>();
        this.bookingMap= new HashMap<>();
    }

    @Override
    public void init() {
        TravelPackage  travelpackage = Util.getOneTravelpackage();
        travelPackagesList.add(travelpackage);
    }

    @Override
    public  List<TravelPackage> listTravelPackages() {
        return new ArrayList<>(travelPackagesList);
    }

    @Override
    public BookingDetails bookPackageByID(Passenger person, TravelPackage travelpackage, List<Long> userActivityListId) {
        int maxPackagePassengerCapacity = travelpackage.getPassengerCapacity();
        int currentPassengerCapacity = travelpackage.getPassengers().size();

        if(currentPassengerCapacity + 1 > maxPackagePassengerCapacity) {
            throw new RuntimeException("Booking full");
        }

        List<Destination> destinations = travelpackage.getItinerary();
        List<Activity> userActivities = new ArrayList<>();

        Map<Long, Activity>  activityMap = new HashMap<>();

        for(Destination destination: destinations) {
            List<Activity> activities = destination.getActivities();
            for(Activity activity: activities) {
                activityMap.put(activity.getId(), activity);
            }
        }

        BigDecimal totalActivityCost = new BigDecimal(0);

        for(Long activityId: userActivityListId) {

            Activity tmpActivity= activityMap.getOrDefault(activityId, null);

            if(tmpActivity == null) {
                throw new RuntimeException("Invalid activity Id: " + activityId +" provided by user");
            }
            else if(tmpActivity.getCurrentEnrollees() == tmpActivity.getCapacity() ) {
                throw new RuntimeException("Activity Id: " + activityId +"is full");
            }
            else {
                userActivities.add(tmpActivity);
                totalActivityCost=totalActivityCost.add(tmpActivity.getCost());
            }
        }

        person.makePayment(totalActivityCost);
        travelpackage.addPassenger(person);

        for(Activity activity: userActivities) {
            activity.setCurrentEnrollees(activity.getCurrentEnrollees()+1);
        }

        BookingDetails bookingDetails= new BookingDetailsImpl(person,travelpackage,userActivities,totalActivityCost);
        if(!bookingMap.containsKey(person)) {
            bookingMap.put(person, new ArrayList<>(Arrays.asList(bookingDetails)));
        }
        else {
            List<BookingDetails> bookingDetailsList = bookingMap.get(person);
            bookingDetailsList.add(bookingDetails);
        }

        return bookingDetails;

    }

    @Override
    public void printPassengerList(TravelPackage travelpackage) {
        if(travelpackage==null) {
            throw new RuntimeException("Null package");
        }
        System.out.println("Package name: " + travelpackage.getName());
        System.out.println("Passenger capacity: " + (travelpackage.getPassengerCapacity()));
        System.out.println("Passenger enrolled: "+ travelpackage.getPassengers().size());
        System.out.println(travelpackage.getPassengers());

    }

    @Override
    public void printPassengerDetails(Passenger person) {
        if(person==null) {
            throw new RuntimeException("Null person");
        }
        System.out.println("Person name: " + person.getName());
        System.out.println("Passenger number: " + person.getId());
        System.out.println("Balance: "+ person.getBalance());
        System.out.println(bookingMap.getOrDefault(person, null).toString());
    }

    @Override
    public void printFreeActivitiesInPackage(TravelPackage travelpackage) {
        
        System.out.println("Package name: " + travelpackage.getName());

        for(Destination destination: travelpackage.getItinerary()) {
            
            List<Activity> activities = destination.getActivities();
            
            for(Activity activity: activities) {
                if(activity.getCurrentEnrollees() < activity.getCapacity())
                    System.out.println(activity);
            }
        }
    }
    
}
