package com.pluralsight.toppingTypes;

public class Veggies extends Topping {
    public Veggies(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() {
        return price;  // no added costs for veggies
    }
}
