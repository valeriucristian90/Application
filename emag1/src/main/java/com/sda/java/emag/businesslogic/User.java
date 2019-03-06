package com.sda.java.emag.businesslogic;

import com.sda.java.emag.item.Item;

public class User implements Runnable {

    public static final int RUN_TIME_SECONDS = 5;
    private final CartController cartController;
    private final Item requestedItem;
    private final int requestedQuantity;
    private int retrievedItemsQuantity;
    private static final int MILLISECONDS_TO_SECONDS_RATIO = 1000;

    public int getRetrievedItemsQuantity (){
        return retrievedItemsQuantity;
    }

    public User(CartController cartController, Item requestedItem, int requestedQuantity) {
        this.cartController = cartController;
        this.requestedItem = requestedItem;
        this.requestedQuantity = requestedQuantity;
    }

    private int getElapsedTimeInSeconds(long startTime) {
        return new Long((System.currentTimeMillis() - startTime) / MILLISECONDS_TO_SECONDS_RATIO).intValue();
    }

    @Override
    public void run() {

        retrievedItemsQuantity = 0;
        long startTime = System.currentTimeMillis();
        while (retrievedItemsQuantity < requestedQuantity && getElapsedTimeInSeconds(startTime) < RUN_TIME_SECONDS) {
            retrievedItemsQuantity += cartController.addItemToCart(requestedItem, 1);
        }
    }

    public int getAddedItems (){
        return retrievedItemsQuantity;
    }


}
