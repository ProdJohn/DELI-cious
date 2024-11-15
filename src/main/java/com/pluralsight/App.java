package com.pluralsight;

import com.pluralsight.productTypes.Chips;
import com.pluralsight.productTypes.Drink;
import com.pluralsight.productTypes.Sandwich;
import com.pluralsight.toppingTypes.Cheese;
import com.pluralsight.toppingTypes.Meat;
import com.pluralsight.toppingTypes.Sauce;
import com.pluralsight.toppingTypes.Veggies;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Prodigy Deli!");
        System.out.println("Please enter your name for the order (or type 'exit' to quit): ");
        String customerName = keyboard.nextLine();
        if (customerName.equalsIgnoreCase("exit")) {
            System.out.println("Canceling the order and closing the program. Thank you!");
            return;
        }

        // initialize order with customer info below

        OrderScreen order = new OrderScreen("12345", customerName);
        ReceiptManager receiptManager = new ReceiptManager();

        String size;
        while (true) {
            System.out.println("Enter sandwich size (4, 8, 12) or type 'exit' to quit: ");
            size = keyboard.nextLine();
            if (size.equalsIgnoreCase("exit")) {
                System.out.println("Canceling the order and closing the program. Thank you!");
                return;
            } else if (size.equals("4") || size.equals("8") || size.equals("12")) {
                break;
            } else {
                System.out.println("Invalid size! Please enter 4, 8, or 12.");
            }
        }

        //bread type and preference below

        System.out.println("Enter bread type (white, wheat, rye, wrap) or type 'exit' to quit: ");
        String breadType = keyboard.nextLine();
        if (breadType.equalsIgnoreCase("exit")) {
            System.out.println("Canceling the order and closing the program. Thank you!");
            return;
        }
        System.out.println("Would you like the sandwich toasted? (yes/no) or type 'exit' to quit: ");
        String toastedInput = keyboard.nextLine();

        if (toastedInput.equalsIgnoreCase("exit")) {
            System.out.println("Order canceled. Exiting program.");
            return;
        }

        boolean isToasted = toastedInput.equalsIgnoreCase("yes");
        Sandwich sandwich = new Sandwich(size, breadType, isToasted);

        //regular toppings to the sandwich below

        System.out.println("Would you like to add regular toppings? (lettuce, tomato, onion, etc.) Enter each topping, type 'done' when finished, or 'exit' to quit: ");
        String topping;
        while (true) {
            topping = keyboard.nextLine();
            if (topping.equalsIgnoreCase("exit")) {
                System.out.println("Canceling the order and closing the program. Thank you!");
                return;
            }else if (topping.equalsIgnoreCase("done")) break;
            sandwich.addTopping(new Veggies(topping, 0.0));
        }

        //premium toppings for the sandwich with additional cost below

        System.out.println("Would you like to add premium toppings? (steak, ham, cheese, etc.) Enter each topping, and type 'done' when finished, or 'exit' to quit: ");
        while (true) {
            topping = keyboard.nextLine();
            if (topping.equalsIgnoreCase("exit")) {
                System.out.println("Canceling the order and closing the program. Thank you!");
                return;
            } else if (topping.equalsIgnoreCase("done")) break;
            if (topping.equalsIgnoreCase("American") || topping.equalsIgnoreCase("Cheddar") || topping.equalsIgnoreCase("Swiss"))  { // the || means or so american or cheddar etc
                sandwich.addTopping(new Cheese(topping, 0.75, false));  // price changes depending on toppings
            } else if (topping.equalsIgnoreCase("Steak") || topping.equalsIgnoreCase("Ham")) {
                sandwich.addTopping(new Meat(topping, 1.00, false));  // price upcharge for premium meats
            }
        }
        order.addItem(sandwich); // this adds the sandwich to the order

        System.out.println("Would you like to add sauces? (ranch, mustard, ketchup, mayo, etc.) Enter each sauce, type 'done' when finished, or 'exit' to quit: ");
        while (true) {
            String sauceChoice = keyboard.nextLine();
            if (topping.equalsIgnoreCase("exit")) {
                System.out.println("Canceling the order and closing the program. Thank you!");
                return;
            } else if (sauceChoice.equalsIgnoreCase("done")) break;
            sandwich.addTopping(new Sauce(sauceChoice, 0.0));  // Assuming no extra cost for sauces
        }


        // below adds the drink to the order

        System.out.println("Would you like to add a drink? (yes/no) or type 'exit' to quit: ");
        String drinkChoice = keyboard.nextLine();
        if (drinkChoice.equalsIgnoreCase("exit")) {
            System.out.println("Canceling the order and closing the program. Thank you!");
            return;
        }else if (drinkChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter drink size (Small, Medium, Large): ");
            String drinkSize = keyboard.nextLine();
            System.out.println("Enter drink flavor (e.g., Cola, Lemonade): ");
            String drinkFlavor = keyboard.nextLine();
            Drink drink = new Drink(drinkSize, drinkFlavor, 1.50);
            order.addItem(drink);
        }

        //below adds chips to the order

        System.out.println("Would you like to add chips? (yes/no) or type 'exit' to quit: ");
        String chipsChoice = keyboard.nextLine();
        if (chipsChoice.equalsIgnoreCase("exit")) {
            System.out.println("Exiting program. Thank you!");
            return;
        }else if (chipsChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter chips flavor (e.g., BBQ, Sour Cream): ");
            String chipFlavor = keyboard.nextLine();
            Chips chips = new Chips(chipFlavor, 1.00);
            order.addItem(chips);
        }
        System.out.println("Here is your order summary:");
        order.printOrderSummary(); // Display order details
        System.out.println("Can you confirm if your order is correct? (confirm/cancel): ");
        String confirmationChoice = keyboard.nextLine();

        if (confirmationChoice.equalsIgnoreCase("confirm")) {
            // below asks for final checkout or cancel after confirmation
            System.out.println("Would you like to checkout or cancel the order? (checkout/cancel): ");
            String checkoutChoice = keyboard.nextLine();

            if (checkoutChoice.equalsIgnoreCase("checkout")) {
                receiptManager.saveReceipt(order); // below saves receipt to file
                System.out.println("Thank you for your order!");
            } else if (checkoutChoice.equalsIgnoreCase("cancel")) {
                System.out.println("Order has been canceled. Thank you!");
            } else {
                System.out.println("Invalid choice. Exiting the program.");
            }
        } else if (confirmationChoice.equalsIgnoreCase("cancel")) {
            System.out.println("Order has been canceled. Thank you!");
        } else {
            System.out.println("Invalid choice. Exiting the program.");
        }
        keyboard.close();
    }
}

