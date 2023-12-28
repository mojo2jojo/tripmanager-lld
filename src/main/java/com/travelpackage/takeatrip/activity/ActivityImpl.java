package com.travelpackage.takeatrip.activity;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActivityImpl implements Activity{
    
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String description;
    private BigDecimal cost;
    private int capacity;
    private int currentEnrollees;

    public ActivityImpl(Long id, String name, String description, BigDecimal cost, int capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.currentEnrollees = 0;
    }

}
