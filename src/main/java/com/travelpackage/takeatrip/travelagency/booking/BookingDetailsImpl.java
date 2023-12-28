package com.travelpackage.takeatrip.travelagency.booking;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.travelpackage.takeatrip.activity.Activity;
import com.travelpackage.takeatrip.passenger.Passenger;
import com.travelpackage.takeatrip.travelpackage.TravelPackage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingDetailsImpl implements BookingDetails {

    @Setter(AccessLevel.NONE)
    private Long id;

    private Passenger passenger;
    private TravelPackage travelPackage;
    private List<Activity> activityList;
    private BigDecimal cost;
    public BookingDetailsImpl(Passenger passenger, TravelPackage travelPackage, List<Activity> activityList,
            BigDecimal cost) {
        this.id = Instant.now().getEpochSecond();
        this.passenger = passenger;
        this.travelPackage = travelPackage;
        this.activityList = activityList;
        this.cost = cost;
    }

}
