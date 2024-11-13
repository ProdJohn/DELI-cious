package com.pluralsight.toppingTypes;

public abstract class Topping {
    protected String name;
    protected double price;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public abstract double getPrice();
    @Override
    public String toString() {
        return name + " ($" + String.format("%.2f", price) + ")";
    }
}




