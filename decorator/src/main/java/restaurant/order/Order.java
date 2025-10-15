package restaurant.order;

import restaurant.components.FoodItem;
import java.util.List;
import java.util.ArrayList;
import restaurant.loyalty.LoyaltyDiscount;

/**
 * Represents a customer's order.
 * Manages a list of food items and calculates the total cost.
 * Loyalty discount can be set to apply a discount to the total cost based on the loyalty level.
 */
public class Order {
    private List<FoodItem> _foodItems;

    public Order() {
        _foodItems = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        _foodItems.add(item);
    }

    public double calculateTotal() {
        return _foodItems.stream().mapToDouble(FoodItem::getCost).sum();
    }

    public List<FoodItem> getFoodItems() {
        return _foodItems;
    }

    public int getFoodItemCount() {
        return _foodItems.size();
    }


}
