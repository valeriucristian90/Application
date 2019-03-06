package com.sda.java.emag.item;

import java.util.Objects;

public class Phone extends Item {

    private final long serialVersionUID = 1L;

    public static final Category CATEGORY = Category.ELECTRONICS;
    private final String brand;
    private final float display_size;
    private final String cpu;

    public Phone(String name, float price, String brand, float display_size, String cpu) {
        super(CATEGORY, name, price);
        this.brand = brand;
        this.display_size = display_size;
        this.cpu = cpu;
    }

    public String getBrand() {
        return brand;
    }

    public float getDisplay_size() {
        return display_size;
    }

    public String getCpu() {
        return cpu;
    }

    @Override
    public String showDetails() {
        final StringBuilder displayDetails = new StringBuilder();
        displayDetails.append(getItemDetails());
        displayDetails.append(SEPARATOR);
        displayDetails.append(brand);
        displayDetails.append(SEPARATOR);
        displayDetails.append(display_size);
        displayDetails.append(SEPARATOR);
        displayDetails.append(cpu);
        return displayDetails.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Float.compare(phone.display_size, display_size) == 0 &&
                Objects.equals(brand, phone.brand) &&
                Objects.equals(cpu, phone.cpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, display_size, cpu);
    }
}
