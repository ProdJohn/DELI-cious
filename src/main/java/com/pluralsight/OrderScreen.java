package com.pluralsight;

import com.pluralsight.productTypes.Product;

import java.util.ArrayList;


public class OrderScreen {
    private String orderID;
    private String customerName;
    private ArrayList<Product> products; //encap

    public OrderScreen(String orderID, String customerName) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }
    //adds a product to the order below

    public void addItem(Product product) {
        products.add(product);
    }
    //removes item from the order below
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
    public String getOrderID() {
        return orderID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void printOrderSummary() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customerName);
        System.out.println("Order Summary:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Total Cost: $" + String.format("%.2f", calculateTotal()));
    }
}

