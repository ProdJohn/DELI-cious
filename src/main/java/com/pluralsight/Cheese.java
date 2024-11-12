package com.pluralsight;

public class Cheese extends Topping {
    private boolean extraCheese;

    public Cheese(String name, double price, boolean extraCheese) {
        super(name, price);
        this.extraCheese = extraCheese;
    }
    @Override
    public double getPrice() {
        return extraCheese ? price * 1.5 : price;  // this adds 50% more cost for extra cheese
    }
}