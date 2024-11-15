# DELI-cious

A simple Java-based sandwich ordering system that allows customers to customize their sandwich order by selecting the size, bread type, toppings, drinks, chips, and sauces. The application calculates the total price based on user input and displays an order summary.

## Features

- **Sandwich Customization**: Choose sandwich size (4", 8", 12"), bread type, regular and premium toppings.
- **Extra Options**: Add extra toppings and drinks, with options for different sizes and flavors.
- **Sauce Selection**: Choose from a variety of sauces (e.g., mayo, mustard, ketchup, ranch).
- **Price Calculation**: The application calculates the total cost based on selected options, including any extra charges for additional items like extra meat.
- **Order Summary**: Displays a detailed order summary with the total cost at the end.
- **Exit Option**: The user can type 'exit' to cancel the order and close the program.

## How It Works

The system interacts with the user through the console, asking for various inputs regarding the sandwich and drink selection. After gathering all choices, it calculates the total price and presents an order summary. If the user decides to cancel the order at any point, they can type 'exit' to close the program.
![placing sandwich order at a deli](https://github.com/user-attachments/assets/db665181-8774-4063-8b11-1d5190994846)
![exiting the ordering for deli sandwich](https://github.com/user-attachments/assets/1120f40c-8c94-487e-a5de-300c40c37319)
![receipt showcase](https://github.com/user-attachments/assets/fe6a2894-b2ac-48b5-8142-94c1e8d01ef6)

### Key Components

- **Order Class**: Manages the customer's order, adding items (like Sandwiches and Drinks) and calculating the total price.
- **Sandwich Class**: Represents a sandwich with properties like size, bread type, and toppings.
- **Drink Class**: Represents a drink with properties like size, flavor, and price.
- **Sauces Class**: Manages different sauces available for selection.

### Notable code!

```java
// Example of applying a price increase for extra meat using a ternary operator
return extraMeat ? price * 1.5 : price;
