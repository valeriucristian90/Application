package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Coffee;

import java.util.Random;

public class User {

    private CoffeeMachine coffeeMachine;
    private Coffee mugCoffee;

    public User(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public CoffeeType getCoffee(){
        final byte coffeeTypesCount = (byte) CoffeeType.values().length;
        final Random random = new Random();
        final int randomPick = random.nextInt(coffeeTypesCount);
        final CoffeeType randomlyChosenCoffe = CoffeeType.values()[randomPick];

        coffeeMachine.choseCoffee(randomlyChosenCoffe);
        try {
            mugCoffee = coffeeMachine.prepareCoffee();
        }catch (NotEnoughIngredientsException e){
            System.out.println("User could not get coffee: " + e.getMessage());
        }

        return randomlyChosenCoffe;
    }

    public void consumeCoffee () {
        if(mugCoffee == null){
            System.out.println("Coffee mug is empty");
        }else {
            System.out.println("Consuming coffee : " +mugCoffee);
            mugCoffee = null;
        }
    }

}
