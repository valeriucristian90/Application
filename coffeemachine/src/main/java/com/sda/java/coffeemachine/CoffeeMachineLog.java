package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Coffee;

import java.util.Date;

public class CoffeeMachineLog {

    Date date = new Date();
    Coffee coffee;

    public CoffeeMachineLog(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String toString() {
        return "CoffeeMachineLog{" +
                "date=" + date +
                ", coffee=" + coffee +
                '}';
    }
}


