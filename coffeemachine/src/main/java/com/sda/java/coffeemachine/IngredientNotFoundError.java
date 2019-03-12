package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Ingredient;

public class IngredientNotFoundError extends Error {

    public IngredientNotFoundError(Ingredient ingredient) {
        super("Stock does not contain a recepient for : " + ingredient);
    }
}
