package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        OrderScreen order = new OrderScreen("12345");
        ReceiptManager receiptManager = new ReceiptManager();

        System.out.println("Welcome to the Prodigy Deli!");
        System.out.println("To begin, please let us know your order!");
        System.out.println("Enter sandwich size (4, 8, 12): ");
        String size = keyboard.nextLine();
        System.out.println("Enter bread type (white, wheat, rye, wrap): ");
        String breadType = keyboard.nextLine();
        System.out.println("Would you like the sandwich toasted? (yes/no): ");
        boolean isToasted = keyboard.nextLine().equalsIgnoreCase("yes");
        Sandwich sandwich = new Sandwich(size, breadType, isToasted);
        System.out.println("Would you like to add regular toppings? (lettuce, tomato, onion, etc.) Enter each topping, type 'done' when finished:");
        String topping;
        while (true) {
            topping = keyboard.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addTopping(new Veggies(topping, 0.0));
        }
        System.out.println("Would you like to add premium toppings? (steak, ham, cheese, etc.) Enter each topping, and type 'done' when finished:");
        while (true) {
            topping = keyboard.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (topping.equalsIgnoreCase("American") || topping.equalsIgnoreCase("Cheddar") || topping.equalsIgnoreCase("Swiss")) {
                sandwich.addTopping(new Cheese(topping, 0.75, false));  // price changes depending on toppings
            } else if (topping.equalsIgnoreCase("Steak") || topping.equalsIgnoreCase("Ham")) {
                sandwich.addTopping(new Meat(topping, 1.00, false));  // price upcharge for premium meats
            }
        }
        order.addItem(sandwich);
        System.out.println("Would you like to add a drink? (yes/no): ");
        if (keyboard.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter drink size (Small, Medium, Large): ");
            String drinkSize = keyboard.nextLine();
            System.out.println("Enter drink flavor (e.g., Cola, Lemonade): ");
            String drinkFlavor = keyboard.nextLine();
            Drink drink = new Drink(drinkSize, drinkFlavor, 1.50);
            order.addItem(drink);
        }
        System.out.println("Would you like to add chips? (yes/no): ");
        if (keyboard.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter chips flavor (e.g., BBQ, Sour Cream): ");
            String chipFlavor = keyboard.nextLine();
            Chips chips = new Chips(chipFlavor, 1.00);
            order.addItem(chips);
        }
        order.printOrderSummary();
        receiptManager.saveReceipt(order);
        keyboard.close();
    }
}
