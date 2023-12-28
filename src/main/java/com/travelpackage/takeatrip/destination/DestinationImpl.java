package com.travelpackage.takeatrip.destination;

import java.util.List;

import com.travelpackage.takeatrip.activity.Activity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DestinationImpl implements Destination {
    
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private List<Activity> activities;

    public DestinationImpl(Long id, String name, List<Activity> activities) {
        this.id = id;
        this.name = name;
        this.activities=activities;
    }

}
