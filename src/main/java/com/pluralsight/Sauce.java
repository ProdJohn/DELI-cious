package com.pluralsight;

public class Sauce extends Topping {
    public Sauce(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() {
        return price;  //no added costs for sauce
    }
}
