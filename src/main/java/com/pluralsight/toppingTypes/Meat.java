package com.pluralsight.toppingTypes;

public class Meat extends Topping {
    private boolean extraMeat;

    public Meat(String name, double price, boolean extraMeat) {
        super(name, price);
        this.extraMeat = extraMeat;
    }
    @Override
    public double getPrice() {
        return extraMeat ? price * 1.5 : price;  // this adds 50% more cost for extra meat the ternary operator used so condition ? value_if_true : value_if_false.
    }
}
