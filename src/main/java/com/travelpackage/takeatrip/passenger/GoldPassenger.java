package com.travelpackage.takeatrip.passenger;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoldPassenger implements Passenger{

    @Setter(AccessLevel.NONE)
    private Long id;
    
    private String name;
    private BigDecimal balance;

    public GoldPassenger(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void makePayment(BigDecimal totalActivityCost) {        

        BigDecimal discount = totalActivityCost.multiply(new BigDecimal(0.1));
        totalActivityCost=totalActivityCost.subtract(discount);

        if(balance.compareTo(totalActivityCost) < 0 ) {
            throw new RuntimeException("Insufficient balance");
        }
        this.setBalance(balance.subtract(totalActivityCost));
    }

}
