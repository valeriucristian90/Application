package com.sda.java.emag;

import com.sda.java.emag.businesslogic.Cart;
import com.sda.java.emag.businesslogic.CartController;
import com.sda.java.emag.businesslogic.Stock;
import com.sda.java.emag.businesslogic.User;
import com.sda.java.emag.item.Color;
import com.sda.java.emag.item.Phone;
import com.sda.java.emag.item.Shoes;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationEmag {
    private static final String PHONE_NAME = "Iphone X";
    private static final float PRICE = 500f;
    private static final String BRAND = "Iphone";
    private static final float DISPLAY_SIZE = 5.5f;
    private static final String CPU = "A10 Fusion";
    public static final float COMPARE_DOUBLE_DELTA = 0.01f;
    private static final String SHOES_MODEL = "Nike air";
    private static final int SHOES_PRICE = 200;
    private static final String SHOES_BRAND = "Nike";
    private static final int SHOES_SIZE = 24;
    public static final int AVAILABLE_QUANTITY = 100000;
    public static final int REQUESTED_QUANTITY = AVAILABLE_QUANTITY;

    public static void main(String[] args) throws InterruptedException {
        Object stockMutex = new Object();
        final Stock baneasaMall = new Stock(new ConcurrentHashMap<>(), stockMutex);
//        try {
//            baneasaMall.loadState();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        System.out.println(baneasaMall.showItems());
        final Phone iphoneX = new Phone(PHONE_NAME, PRICE, BRAND, DISPLAY_SIZE, CPU);
        final Shoes nike = new Shoes(SHOES_MODEL, SHOES_PRICE, SHOES_BRAND, SHOES_SIZE, Color.BLUE);
        final Cart cart = new Cart(new HashMap<>());

//        final int supply_quntity = 5;
//        final int consume_quntity = 3;
//        final int currentIphoneStock = baneasaMall.addItem (iphoneX,supply_quntity);
//        System.out.println(currentIphoneStock);
//        int retrievedIphoneQuantity = baneasaMall.retrieveItem (iphoneX,consume_quntity);
//        System.out.println(retrievedIphoneQuantity);
//        int retrievedIphoneQuantity2 = baneasaMall.retrieveItem (iphoneX,consume_quntity);
//        System.out.println(retrievedIphoneQuantity2);
//        System.out.println(iphoneX.showDetails());
//        System.out.println(baneasaMall.showItems());

        baneasaMall.addItem(iphoneX, AVAILABLE_QUANTITY);
        baneasaMall.addItem(nike, REQUESTED_QUANTITY);

//        try {
//            baneasaMall.saveState();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //cart.addCartItem(iphoneX,20);
        //cart.addCartItem(nike,10);
        //cart.checkout();
        try {
            cart.print();
        } catch (IOException e) {
            System.out.println("Cannot acces file durint print. " + e.getMessage());
        }

        CartController cartController = new CartController(baneasaMall);
        final User user1 = new User(new CartController(baneasaMall), iphoneX, REQUESTED_QUANTITY);
        final User user2 = new User(new CartController(baneasaMall), iphoneX, REQUESTED_QUANTITY);
        final Thread t1 = new Thread(user1);
        final Thread t2 = new Thread(user2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        int user1RetrievedItemsQuantity = user1.getRetrievedItemsQuantity();
        int user2RetrievedItemsQuantity = user2.getRetrievedItemsQuantity();

        System.out.println(user1RetrievedItemsQuantity);
        System.out.println(user2RetrievedItemsQuantity);


    }
}
