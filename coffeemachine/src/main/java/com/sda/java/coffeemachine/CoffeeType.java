package com.sda.java.coffeemachine;

public enum CoffeeType {

    EXPRESSO(5,50,0,0),
    FILTER_COFFEE(10,100,2,10),
    LATTE(10,100,4,50);

    private final int coffeeRequired;
    private final int waterRequired;
    private final int sugarRequired;
    private final int milkRequired;

    CoffeeType(int coffeeRequired, int waterRequired, int sugarRequired, int milkRequired) {
        this.coffeeRequired = coffeeRequired;
        this.waterRequired = waterRequired;
        this.sugarRequired = sugarRequired;
        this.milkRequired = milkRequired;
    }

    public int getCoffeeRequired() {
        return coffeeRequired;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getSugarRequired() {
        return sugarRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }


}

