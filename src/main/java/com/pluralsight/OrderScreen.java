package com.pluralsight;

import java.util.ArrayList;


public class OrderScreen {
    private String orderID;
    private ArrayList<Product> products;

    public OrderScreen(String orderID) {
        this.orderID = orderID;
        this.products = new ArrayList<>();
    }
    public void addItem(Product product) {
        products.add(product);
    }
    public void removeItem(Product product) {
        products.remove(product);
    }
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.calculatePrice();
        }
        return total;
    }
    public void printOrderSummary() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Summary:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Total Cost: $" + String.format("%.2f", calculateTotal()));
    }
}

