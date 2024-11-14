package com.pluralsight.productTypes;

import com.pluralsight.toppingTypes.Topping;

import java.util.ArrayList;

public class Sandwich implements Product {
    protected String size;
    protected String breadType;
    protected ArrayList<Topping> toppings;
    protected boolean isToasted;

    public Sandwich(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    @Override
    public double calculatePrice() {
        double totalCost = 5.00; // base price

        // sizing price differences below
        if ("8".equals(size)) {
            totalCost += 2.00;
        } else if ("12".equals(size)) {
            totalCost += 4.00;
        }

        // each topping added price below
        for (Topping topping : toppings) {
            totalCost += topping.getPrice();
        }

        // the cost for toasting your bread below
        if (isToasted) {
            totalCost += 0.50;
        }
        return totalCost;
    }
    public String getName() {
        return "Sandwich";
    }
    @Override
    public String toString() {
        return "Size: " + size + ", Bread: " + breadType + ", Toasted: " + (isToasted ? "Yes" : "No") + ", Toppings: " + toppings; // ternary operator basically if-else for toasted bread
    }
    public String getDescription() {
        return size + "\" " + breadType + " Bread" + (isToasted ? ", Toasted" : "");
    }
}
