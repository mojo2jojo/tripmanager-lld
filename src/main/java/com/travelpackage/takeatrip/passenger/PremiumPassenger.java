package com.travelpackage.takeatrip.passenger;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PremiumPassenger implements Passenger{
    
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private BigDecimal balance;

    public PremiumPassenger(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void makePayment(BigDecimal totalActivityCost) {        
        if(balance.compareTo(new BigDecimal(0)) < 0 ) {
            throw new RuntimeException("Insufficient balance");
        }
    }

}
