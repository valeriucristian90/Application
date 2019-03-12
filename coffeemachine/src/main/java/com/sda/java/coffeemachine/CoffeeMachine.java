package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Coffee;

public interface CoffeeMachine {

   public void choseCoffee(CoffeeType coffeeType);

   public Coffee prepareCoffee() throws NotEnoughIngredientsException;
}
