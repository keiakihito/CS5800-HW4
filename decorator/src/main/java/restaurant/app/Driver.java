package restaurant.app;

import restaurant.components.*;
import restaurant.decorators.*;
import restaurant.order.Order;
import restaurant.loyalty.LoyaltyDiscount;

/**
 * CS 5800 Fall 2025
 * Author: Keita Katsumi
 * Driver program demonstrating the Decorator pattern for a restaurant ordering system.
 * Shows how to create food items, add toppings, create orders in the FoodItem class, 
 * and apply loyalty discounts in the LoyaltyDiscount class.
 */
public class Driver {
    public static void main(String[] args) {

        // Create Order 1: Simple burger with cheese
        System.out.println("--- Order 1: Simple Burger ---");
        Order order1 = new Order();
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        order1.addItem(burger);

        System.out.println("Item: " + burger.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", burger.getCost()));
        System.out.println("Order Total: $" + String.format("%.2f", order1.calculateTotal()));
        System.out.println();



        // Create Order 2: Loaded hot dog
        System.out.println("--- Order 2: Loaded Hot Dog ---");
        Order order2 = new Order();
        FoodItem hotdog = new HotDog();
        hotdog = new Ketchup(hotdog);
        hotdog = new Cheese(hotdog);
        hotdog = new Onions(hotdog);
        order2.addItem(hotdog);

        System.out.println("Item: " + hotdog.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", hotdog.getCost()));
        System.out.println("Order Total: $" + String.format("%.2f", order2.calculateTotal()));
        System.out.println();




        // Create Order 3: Multiple items
        System.out.println("--- Order 3: Combo Meal ---");
        Order order3 = new Order();

        // Burger with all toppings
        FoodItem comboBurger = new Burger();
        comboBurger = new Cheese(comboBurger);
        comboBurger = new Ketchup(comboBurger);
        comboBurger = new Onions(comboBurger);
        order3.addItem(comboBurger);

        // Plain fries
        FoodItem fries = new Fries();
        order3.addItem(fries);

        // Hot dog with ketchup
        FoodItem comboHotdog = new HotDog();
        comboHotdog = new Ketchup(comboHotdog);
        order3.addItem(comboHotdog);

        System.out.println("Items in order:");
        for (FoodItem item : order3.getFoodItems()) {
            System.out.println("  - " + item.getDescription() + " ($" + String.format("%.2f", item.getCost()) + ")");
        }
        System.out.println("Order Total: $" + String.format("%.2f", order3.calculateTotal()));
        System.out.println();

        // Apply Loyalty Discounts
        System.out.println("--- Applying Loyalty Discounts ---");
        double orderTotal = order3.calculateTotal();
        System.out.println("Original Total: $" + String.format("%.2f", orderTotal));
        System.out.println();

        // Case 1: No loyalty
        LoyaltyDiscount noLoyalty = new LoyaltyDiscount("None");
        System.out.println("Case 1: " + noLoyalty.getLoyaltyLevel() + " Customer (" + (int)(noLoyalty.getDiscountRate() * 100) + "% off):");
        System.out.println("  Final Price: $" + String.format("%.2f", noLoyalty.applyDiscount(orderTotal)));
        System.out.println();

        // Case 2: Silver loyalty
        LoyaltyDiscount silverLoyalty = new LoyaltyDiscount("Silver");
        System.out.println("Case 2: " + silverLoyalty.getLoyaltyLevel() + " Customer (" + (int)(silverLoyalty.getDiscountRate() * 100) + "% off):");
        System.out.println("  Final Price: $" + String.format("%.2f", silverLoyalty.applyDiscount(orderTotal)));
        System.out.println();

        // Case 3: Gold loyalty
        LoyaltyDiscount goldLoyalty = new LoyaltyDiscount("Gold");
        System.out.println("Case 3: " + goldLoyalty.getLoyaltyLevel() + " Customer (" + (int)(goldLoyalty.getDiscountRate() * 100) + "% off):");
        System.out.println("  Final Price: $" + String.format("%.2f", goldLoyalty.applyDiscount(orderTotal)));
        System.out.println();

        // Case 4: Platinum loyalty
        LoyaltyDiscount platinumLoyalty = new LoyaltyDiscount("Platinum");
        System.out.println("Case 4: " + platinumLoyalty.getLoyaltyLevel() + " Customer (" + (int)(platinumLoyalty.getDiscountRate() * 100) + "% off):");
        System.out.println("  Final Price: $" + String.format("%.2f", platinumLoyalty.applyDiscount(orderTotal)));
        System.out.println();

       
    }
}
/** 
 Sample Run:
 ~/Dropbox/Academic/CalPolyPomona/2025/2025Fall/CS5800/HW/HW4/decorator main*
❯ mvn exec:java -D exec.mainClass="restaurant.app.Driver"
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< com.calpoly:decorator >------------------------
[INFO] Building Decorator Pattern - Restaurant Menu System 1.0.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.6.1:java (default-cli) @ decorator ---
--- Order 1: Simple Burger ---
Item: Burger + Cheese
Cost: $7.50
Order Total: $7.50

--- Order 2: Loaded Hot Dog ---
Item: HotDog + Ketchup + Cheese + Onions
Cost: $2.80
Order Total: $2.80

--- Order 3: Combo Meal ---
Items in order:
  - Burger + Cheese + Ketchup + Onions ($7.80)
  - Fries ($5.00)
  - HotDog + Ketchup ($2.05)
Order Total: $14.85

--- Applying Loyalty Discounts ---
Original Total: $14.85

Case 1: None Customer (0% off):
  Final Price: $14.85

Case 2: Silver Customer (5% off):
  Final Price: $14.11

Case 3: Gold Customer (10% off):
  Final Price: $13.37

Case 4: Platinum Customer (15% off):
  Final Price: $12.62

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.667 s
[INFO] Finished at: 2025-10-16T06:51:57-07:00
[INFO] ------------------------------------------------------------------------ 
 * 
 */