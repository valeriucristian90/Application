package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class FilterCoffe extends Coffee {

    public static final CoffeeType FILTERCOFFEE = CoffeeType.FILTERCOFFEE;

    public FilterCoffe() {
        super(FILTERCOFFEE);
    }

    protected String getCoffeeName() {
        return FILTERCOFFEE.toString();
    }
}
