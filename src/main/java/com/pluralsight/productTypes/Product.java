package com.pluralsight.productTypes;

public interface Product {
    double calculatePrice();
    String getName();
    String getDescription();
}
// created interface to implement price based on sandwich size, toppings, and drink class