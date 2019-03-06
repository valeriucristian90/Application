package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.*;

public class CoffeeMachine {
    Stock stock = new Stock(20, 200, 10, 100);

    public Coffee prepareCoffee(CoffeeType coffeeType) {
        if (stock.getCoffeeStock() > coffeeType.getCoffeeRequired() &&
                stock.getWaterStock() > coffeeType.getWaterRequired() &&
                stock.getSugarStock() > coffeeType.getSugarRequired() &&
                stock.getMilkStock() > coffeeType.getMilkRequired()) {
            switch (coffeeType) {
                case LATTE:
                    return new Latte();
                case EXPRESSO:
                    return new Expresso();
                case FILTER_COFFEE:
                    return new FilterCoffe();
            }
        }
    }

    public static void main(String[] args) {
        final CoffeeMachine coffeeMachine = new CoffeeMachine();
    }
}
