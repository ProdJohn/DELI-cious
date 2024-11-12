package com.pluralsight;

public class Meat extends Topping {
    private boolean extraMeat;

    public Meat(String name, double price, boolean extraMeat) {
        super(name, price);
        this.extraMeat = extraMeat;
    }
    @Override
    public double getPrice() {
        return extraMeat ? price * 1.5 : price;  // this adds 50% more cost for extra meat
    }
}
