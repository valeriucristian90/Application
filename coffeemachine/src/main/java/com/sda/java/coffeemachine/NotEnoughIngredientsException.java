package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Ingredient;

public class NotEnoughIngredientsException extends Exception {
    public NotEnoughIngredientsException(CoffeeType coffeeType, Ingredient ingredient) {
        super(coffeeType + " is not create because is not enough " + ingredient );
    }
}
