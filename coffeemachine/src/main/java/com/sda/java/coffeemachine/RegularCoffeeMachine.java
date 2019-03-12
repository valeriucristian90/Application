package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.*;

public class CoffeeMachine {

    Stock stock = new Stock();
    CoffeeType coffeeType = CoffeeType.FILTERCOFFEE;


    public Stock getStock() {
        return stock;
    }


    public static void main(String[] args) throws Exception {
        final CoffeeMachine coffeeMachine = new CoffeeMachine();
        Stock stock = coffeeMachine.getStock();
        stock.addToStock(Ingredient.COFFEE, 200);
        stock.addToStock(Ingredient.WATER, 1000);
        stock.addToStock(Ingredient.SUGAR, 200);
        stock.addToStock(Ingredient.MILK, 200);

        coffeeMachine.choseCoffeeType(CoffeeType.LATTE);

        try {

            final Coffee coffee = coffeeMachine.prepareCoffee();
            System.out.println("Consuming the coffee : " + coffee);
        } catch (NotEnoughIngredientsException e) {
            System.out.println(e.getMessage());
        }

    }

    public void choseCoffeeType(CoffeeType coffeeType) {
        //todo: add check if credit is sufficient and show message
        this.coffeeType = coffeeType;
    }

    public Coffee prepareCoffee() throws Exception {
        validate();

        stock.removeFromStock(Ingredient.COFFEE, coffeeType.getCoffeeRequired());
        stock.removeFromStock(Ingredient.WATER, coffeeType.getWaterRequired());
        stock.removeFromStock(Ingredient.MILK, coffeeType.getMilkRequired());
        stock.removeFromStock(Ingredient.SUGAR, coffeeType.getSugarRequired());

        return createCoffee();
    }

    private void validate() throws Exception {
        if (!(stock.getIngredient(Ingredient.COFFEE) >= coffeeType.getCoffeeRequired())) {
            throw new NotEnoughIngredientsException(coffeeType, Ingredient.COFFEE);
        }

        if (!(stock.getIngredient(Ingredient.WATER) >= coffeeType.getWaterRequired())) {
            throw new NotEnoughIngredientsException(coffeeType, Ingredient.WATER);
        }

        if (!(stock.getIngredient(Ingredient.MILK) >= coffeeType.getMilkRequired())) {
            throw new NotEnoughIngredientsException(coffeeType, Ingredient.MILK);
        }

        if (!(stock.getIngredient(Ingredient.SUGAR) >= coffeeType.getMilkRequired())) {
            throw new NotEnoughIngredientsException(coffeeType, Ingredient.SUGAR);
        }
    }


    private Coffee createCoffee() {
        switch (coffeeType) {

            case ESPRESSO:
                return new Espresso();

            case FILTERCOFFEE:
                return new FilterCoffe();

            case LATTE:
                return new Latte();

            default:
                return new FilterCoffe();
        }

    }

}
