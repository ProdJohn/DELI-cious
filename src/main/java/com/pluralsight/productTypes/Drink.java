package com.pluralsight.productTypes;

public class Drink implements Product {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
        this.price = price;
    }
    @Override
    public double calculatePrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Drink - Size: " + size + ", Flavor: " + flavor + ", Price: $" + String.format("%.2f", price);
    }
}

