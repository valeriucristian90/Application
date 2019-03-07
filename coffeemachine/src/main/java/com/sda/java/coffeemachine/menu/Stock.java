package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.menu.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Stock {

    private Map<Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();

    public Stock (){
        for (Ingredient eachIngredient : Ingredient.values()) {
            ingredients.put(eachIngredient, 0);
        }
    }

    public int getIngredient (Ingredient ingredient) throws Exception {
        if(!ingredients.containsKey(ingredient)) {
            throw new Exception("Ingredient not found" + ingredient);
        }
        return ingredients.get(ingredient);
    }

    public void addToStock (String ingredient, int quantity) {
        if(!ingredients.co)
    }

    public void removeFromStock (int quantity) {
        //coffeeStock - quantity;
    }
}
