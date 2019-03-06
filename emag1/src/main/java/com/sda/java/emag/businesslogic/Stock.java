package com.sda.java.emag.businesslogic;

import com.sda.java.emag.item.Item;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Stock implements Serializable {

    private final long serialVersionUID = 1L;
    private Map<Item, Integer> items;
    static final String SEPARATOR = " ";
    private final transient Object mutex;

    public Stock(Map<Item, Integer> items,Object mutex) {
        this.mutex = mutex;
        this.items = items;
    }

    public int addItem(Item item, int quantity) {
        if (items.containsKey(item)) {
            final int supply = items.get(item) + quantity;
            items.put(item, supply);
            return supply;
        }
        items.put(item, quantity);
        return quantity;

    }

    public int retrieveItem(Item item, int consumeQuantity) {
        synchronized (mutex) {

            if (!items.containsKey(item)) {
                return 0;
            }

            int currentQuantity = items.get(item);
            if (consumeQuantity > currentQuantity) {
                items.put(item, 0);
                return currentQuantity;
            }
            final int newQunatity = currentQuantity - consumeQuantity;
            items.put(item, newQunatity);
            return consumeQuantity;
        }
    }

    public String showItems() {
        final StringBuilder displayResult = new StringBuilder();
        for (Map.Entry<Item, Integer> itemEntry : items.entrySet()) {
            final Item item = itemEntry.getKey();
            displayResult.append(item.showDetails());
            displayResult.append(SEPARATOR);
            displayResult.append(itemEntry.getValue());
            displayResult.append(System.lineSeparator());
        }
        return displayResult.toString();
    }

    public void saveState () throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream("save_stock.db");
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void loadState () throws IOException, ClassNotFoundException {
        if (! Files.exists(Paths.get("save_stock.db"))){
            return;
        }
        final FileInputStream fileInputStream = new FileInputStream("save_stock.db");
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        final ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        final Stock readOject = (Stock) objectInputStream.readObject();
        items = readOject.items;
        objectInputStream.close();
        fileInputStream.close();

    }

}


