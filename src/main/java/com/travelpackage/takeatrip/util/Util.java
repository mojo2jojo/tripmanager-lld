package com.travelpackage.takeatrip.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.travelpackage.takeatrip.activity.Activity;
import com.travelpackage.takeatrip.activity.ActivityImpl;
import com.travelpackage.takeatrip.destination.Destination;
import com.travelpackage.takeatrip.destination.DestinationImpl;
import com.travelpackage.takeatrip.travelpackage.TravelPackageImpl;
import com.travelpackage.takeatrip.travelpackage.TravelPackage;

public class Util {

    public static List<Activity> getSomeActivities() {

        Activity randomActivity0 = new ActivityImpl(0l,"Cycling", "Cycling related description", new BigDecimal(50), 1);
        Activity randomActivity1 = new ActivityImpl(1l,"Rafting", "Rafting related description", new BigDecimal(50), 2);
        Activity randomActivity2 = new ActivityImpl(2l,"Hiking", "Hiking related description", new BigDecimal(50), 2);
        Activity randomActivity3 = new ActivityImpl(3l,"Rock Climbing", "Rock Climbing related description", new BigDecimal(50), 2);
        Activity randomActivity4 = new ActivityImpl(4l,"Camping", "Camping related description", new BigDecimal(50), 2);
        Activity randomActivity5 = new ActivityImpl(5l,"Fishing", "Fishing related description", new BigDecimal(50), 2);
        Activity randomActivity6 = new ActivityImpl(6l,"Zipling", "Zipling related description", new BigDecimal(50), 2);
        Activity randomActivity7 = new ActivityImpl(7l,"Skydive", "Skydive related description", new BigDecimal(50), 2);
        Activity randomActivity8 = new ActivityImpl(8l,"Surfing", "Surfing related description", new BigDecimal(50), 2);
        Activity randomActivity9 = new ActivityImpl(9l,"Hot Air Ballon", "Hot Air Ballon related description", new BigDecimal(50), 2);
        Activity randomActivity10 = new ActivityImpl(10l,"Wine Tasting", "Wine Tasting related description", new BigDecimal(50), 2);
        Activity randomActivity11 = new ActivityImpl(11l,"Sunset Watching", "Sunset Watching related description", new BigDecimal(50), 2);

        List<Activity> activities= new ArrayList<>();
        
        activities.add(randomActivity0);
        activities.add(randomActivity1);
        activities.add(randomActivity2);
        activities.add(randomActivity3);
        activities.add(randomActivity4);
        activities.add(randomActivity5);
        activities.add(randomActivity6);
        activities.add(randomActivity7);
        activities.add(randomActivity8);
        activities.add(randomActivity9);
        activities.add(randomActivity10);
        activities.add(randomActivity11);

        return activities;
        
    }

    public static List<Destination> getSomeDestinations() {

        List<Activity> activities = Util.getSomeActivities();

        Destination destination0 = new DestinationImpl(0l,"Goa", activities.subList(0, 3));
        Destination destination1 = new DestinationImpl(1l,"Kashmir", activities.subList(4, 7));
        Destination destination2 = new DestinationImpl(2l,"Meghalaya", activities.subList(8, 11));

        List<Destination> destinations= new ArrayList<>();

        destinations.add(destination0);
        destinations.add(destination1);
        destinations.add(destination2);

        return destinations;

    }

    public static TravelPackage getOneTravelpackage(){
        TravelPackage travelpackage = new TravelPackageImpl(0l,"New year 5D/4N", 25, getSomeDestinations());
        return travelpackage;
    }

}
