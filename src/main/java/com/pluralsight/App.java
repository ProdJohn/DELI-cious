package com.pluralsight;

import com.pluralsight.productTypes.Chips;
import com.pluralsight.productTypes.Drink;
import com.pluralsight.productTypes.Sandwich;
import com.pluralsight.toppingTypes.Cheese;
import com.pluralsight.toppingTypes.Meat;
import com.pluralsight.toppingTypes.Veggies;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Prodigy Deli!");
        System.out.println("Please enter your name for the order: ");
        String customerName = keyboard.nextLine();
        System.out.println("To begin, please let us know your order!");

        // initialize order with customer info below

        OrderScreen order = new OrderScreen("12345", customerName);
        ReceiptManager receiptManager = new ReceiptManager();

        String size;
        while (true) {
            System.out.println("Enter sandwich size (4, 8, 12): ");
            size = keyboard.nextLine();
            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                break;
            } else {
                System.out.println("Invalid size! Please enter 4, 8, or 12.");
            }
        }

        //bread type and preference below

        System.out.println("Enter bread type (white, wheat, rye, wrap): ");
        String breadType = keyboard.nextLine();
        System.out.println("Would you like the sandwich toasted? (yes/no): ");
        boolean isToasted = keyboard.nextLine().equalsIgnoreCase("yes");
        Sandwich sandwich = new Sandwich(size, breadType, isToasted);

        //regular toppings to the sandwich below

        System.out.println("Would you like to add regular toppings? (lettuce, tomato, onion, etc.) Enter each topping, type 'done' when finished:");
        String topping;
        while (true) {
            topping = keyboard.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addTopping(new Veggies(topping, 0.0));
        }

        //premium toppings for the sandwich with additional cost below

        System.out.println("Would you like to add premium toppings? (steak, ham, cheese, etc.) Enter each topping, and type 'done' when finished:");
        while (true) {
            topping = keyboard.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (topping.equalsIgnoreCase("American") || topping.equalsIgnoreCase("Cheddar") || topping.equalsIgnoreCase("Swiss"))  {
                sandwich.addTopping(new Cheese(topping, 0.75, false));  // price changes depending on toppings
            } else if (topping.equalsIgnoreCase("Steak") || topping.equalsIgnoreCase("Ham")) {
                sandwich.addTopping(new Meat(topping, 1.00, false));  // price upcharge for premium meats
            }
        }
        order.addItem(sandwich); // this adds the sandwich to the order

        //this adds the drink to the order

        System.out.println("Would you like to add a drink? (yes/no): ");
        if (keyboard.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter drink size (Small, Medium, Large): ");
            String drinkSize = keyboard.nextLine();
            System.out.println("Enter drink flavor (e.g., Cola, Lemonade): ");
            String drinkFlavor = keyboard.nextLine();
            Drink drink = new Drink(drinkSize, drinkFlavor, 1.50);
            order.addItem(drink);
        }

        //this adds chips to the order

        System.out.println("Would you like to add chips? (yes/no): ");
        if (keyboard.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter chips flavor (e.g., BBQ, Sour Cream): ");
            String chipFlavor = keyboard.nextLine();
            Chips chips = new Chips(chipFlavor, 1.00); //creates new chips based on input
            order.addItem(chips);
        }
        order.printOrderSummary(); //prints summary of order to console
        receiptManager.saveReceipt(order); //saves receipt to file
        keyboard.close();
    }
}

