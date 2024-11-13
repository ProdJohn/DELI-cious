package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {

    public void saveReceipt(OrderScreen order) {
        String filename = "receipt_" + order.getOrderID() + ".txt";
        try (FileWriter writer = new FileWriter("Receipt.txt")) {
            writer.write("Order ID: " + order.getOrderID() + "\n");
            writer.write("Order Summary:\n");
            for (Product product : order.getProducts()) {
                writer.write(product.toString() + "\n");
            }
            writer.write("Total Cost: $" + String.format("%.2f", order.calculateTotal()) + "\n");
            System.out.println("Receipt saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    public void readReceipt(String filename) {
        // this displays our receipt at end of program
    }
}