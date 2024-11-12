package com.pluralsight;

public class Chips implements Product {
    private String flavor;
    private double price;

    public Chips(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }
    @Override
    public double calculatePrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Chips - Flavor: " + flavor + ", Price: $" + String.format("%.2f", price);
    }
}
