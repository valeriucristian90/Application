package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.IngredientNotFoundError;
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

    public int getIngredient (Ingredient ingredient) throws IngredientNotFoundError {
        if(!ingredients.containsKey(ingredient)) {
            throw new IngredientNotFoundError (ingredient);
        }
        return ingredients.get(ingredient);
    }

    public void addToStock (Ingredient ingredient, int quantity) throws IngredientNotFoundError {
        if(!ingredients.containsKey(ingredient)) {
            throw new IngredientNotFoundError(ingredient);
        }
        Integer curentQuantity = ingredients.get(ingredient);
        ingredients.put(ingredient,quantity+curentQuantity);
    }

    public void removeFromStock (Ingredient ingredient ,int quantity){
        if(!ingredients.containsKey(ingredient)) {
            throw new IngredientNotFoundError(ingredient);
        }
        Integer curentQuantity = ingredients.get(ingredient);
        ingredients.put(ingredient,curentQuantity-quantity);
    }
}
