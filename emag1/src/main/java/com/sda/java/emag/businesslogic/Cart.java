package com.sda.java.emag.businesslogic;

import com.sda.java.emag.item.Item;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private Map<Item, Integer> cartItems;
    private float total;
    static final String SEPARATOR = " ";

    public Cart(Map<Item, Integer> items) {
        this.cartItems = items;
    }

    public int addCartItem(Item item, int addQuantity) {
        total += addQuantity * item.getPrice();
        if (cartItems.containsKey(item)) {
            final int updatedQuantity = cartItems.get(item) + addQuantity;
            cartItems.put(item, updatedQuantity);

            return updatedQuantity;
        }
        cartItems.put(item, addQuantity);
        return addQuantity;

    }

    public int removeItem(Item item, int removeQuntity) {
        if (!cartItems.containsKey(item)) {
            return 0;
        }

        int currentQuantity = cartItems.get(item);
        if (removeQuntity >= currentQuantity) {
            cartItems.remove(item);
            total -= currentQuantity * item.getPrice();
            return currentQuantity;
        }
        final int newQunatity = currentQuantity - removeQuntity;
        cartItems.put(item, newQunatity);
        total -= removeQuntity * item.getPrice();
        return removeQuntity;
    }

    public Map<Item, Integer> removeAll() {
        final Map<Item, Integer> previousState = cartItems;
        cartItems = new HashMap<>();
        total = 0;
        return previousState;
    }

    public String checkout() {
        String processedItems = getItemToString();

        removeAll();
        return processedItems;
    }

    private String getItemToString() {
        return cartItems.entrySet().stream()
                .map(itemEntry -> {
                    final StringBuilder displayResult = new StringBuilder();
                    final Item item = itemEntry.getKey();
                    displayResult.append(item.showDetails());
                    displayResult.append(SEPARATOR);
                    displayResult.append(itemEntry.getValue());
                    return displayResult.toString();
                })
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void print () throws IOException {

        final FileWriter fileWriter = new FileWriter("print_cart.txt");
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        final String processedItems = getItemToString();
        bufferedWriter.write(processedItems);
        bufferedWriter.flush();
        bufferedWriter.close();

    }


}
