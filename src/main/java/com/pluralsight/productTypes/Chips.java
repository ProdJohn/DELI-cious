package com.pluralsight.productTypes;

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
    public String getName() {
        return "Chips";
    }
    @Override
    public String toString() {
        return "Chips - Flavor: " + flavor + ", Price: $" + String.format("%.2f", price);
    }
    public String getDescription() {
        return flavor;
    }
}
