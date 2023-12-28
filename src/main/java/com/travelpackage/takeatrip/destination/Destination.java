package com.travelpackage.takeatrip.destination;

import java.util.List;

import com.travelpackage.takeatrip.activity.Activity;

public interface Destination {

    Long getId();

    String getName();

    List<Activity> getActivities();

}