package com.sda.java.coffeemachine.menu;

public class Stock {

    private int coffeeStock ;
    private int waterStock ;
    private int sugarStock ;
    private int milkStock;

    public Stock(int coffeeStock, int waterStock, int sugarStock, int milkStock) {
        this.coffeeStock = coffeeStock;
        this.waterStock = waterStock;
        this.sugarStock = sugarStock;
        this.milkStock = milkStock;
    }

    public int getCoffeeStock() {
        return coffeeStock;
    }

    public int getWaterStock() {
        return waterStock;
    }

    public int getSugarStock() {
        return sugarStock;
    }

    public int getMilkStock() {
        return milkStock;
    }
}
