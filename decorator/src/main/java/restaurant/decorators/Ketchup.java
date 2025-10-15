package restaurant.decorators;

import restaurant.components.FoodItem;

/**
 * Concrete decorator: Adds ketchup topping to a food item.
 */
public class Ketchup extends ToppingDecorator {
    public Ketchup(FoodItem foodItem) {
        super(foodItem);
    }
    @Override
    public double getCost() {
        return 0.00;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
