package restaurant.decorators;

import restaurant.components.FoodItem;

/**
 * Concrete decorator: Adds onions topping to a food item.
 */
public class Onions extends ToppingDecorator {
    public Onions(FoodItem foodItem) {
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
