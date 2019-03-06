package com.sda.java.emag.businesslogic;

import com.sda.java.emag.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartController {

    private final Cart cart = new Cart(new LinkedHashMap<>());
    private final Stock stock;

    public CartController(Stock stock) {
        this.stock = stock;
    }

    public  int addItemToCart (Item item, int quantity) {
        final int retrieveItems = stock.retrieveItem(item, quantity);
        return cart.addCartItem(item, retrieveItems);
    }

    public int removeItemFromCart(Item item, int quantity) {
        final int removeItems = cart.removeItem(item, quantity);
        return stock.addItem(item, removeItems);
    }

    public int removeAllItemsFromCart() {
        final Map<Item, Integer> removeAll = cart.removeAll();
        for (Map.Entry<Item, Integer> entry : removeAll.entrySet()) {
            stock.addItem(entry.getKey(), entry.getValue());
        }
        return removeAll.entrySet().size();
    }

    public int removeAllItemsFromCartWithLambda() {
        final Map<Item, Integer> removeAll = cart.removeAll();
        removeAll.forEach(stock::addItem);  //Not funtional oriented programming
        return removeAll.entrySet().size();
    }
}
