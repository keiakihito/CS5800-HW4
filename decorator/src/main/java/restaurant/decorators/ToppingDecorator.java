package restaurant.decorators;

import restaurant.components.FoodItem;

/**
 * Abstract decorator class for toppings.
 * Wraps a FoodItem and adds topping cost to the base item.
 */
public abstract class ToppingDecorator implements FoodItem {
    private FoodItem foodItem;
    public ToppingDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public abstract double getCost();
    public abstract String getDescription();
}
