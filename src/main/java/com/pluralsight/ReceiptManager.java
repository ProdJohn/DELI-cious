package com.pluralsight;

import com.pluralsight.productTypes.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReceiptManager {

    public void saveReceipt(OrderScreen order) {
        String filename = "receipt" + order.getOrderID() + ".txt"; //the receipt will print with the order ID in title
        try (FileWriter writer = new FileWriter(filename)) {
            // Store Header
            writer.write("PRODIGY DELI\n");
            writer.write("701 Elm St #400\n");
            writer.write("Dallas, TX 75202\n");
            writer.write("(469) 680-3140\n\n");    // year up dallas location easter egg

            // Order Header
            writer.write("ORDER ID: " + order.getOrderID() + "\n");
            writer.write("Customer: " + order.getCustomerName() + "\n");
            writer.write("Order Type: Dine In\n");

            // Date and Time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            String dateTime = LocalDateTime.now().format(formatter);
            writer.write("Date/Time: " + dateTime + "\n\n");

            // Order Items
            writer.write("Order Summary:\n");
            ArrayList<Product> products = order.getProducts();
            for (Product product : products) {
                writer.write(product.getName() + "\n");
                writer.write("  " + product.getDescription() + "\n");
                writer.write("  $" + String.format("%.2f", product.calculatePrice()) + "\n\n");
            }

            // Total Cost
            writer.write("Total Cost: $" + String.format("%.2f", order.calculateTotal()) + "\n\n");

            // Closing Remarks
            writer.write("We value your feedback!\n");
            writer.write("Visit our survey at www.prodigydeli.com/feedback\n");
            writer.write("Validation Code: 123 456 789 101\n");


            System.out.println("Receipt saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());

        }
    }
}


