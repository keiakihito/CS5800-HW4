package restaurant.decorators;

import restaurant.components.FoodItem;

/**
 * Concrete decorator: Adds cheese topping to a food item.
 */
public class Cheese extends ToppingDecorator {
    public Cheese(FoodItem foodItem) {
        super(foodItem);
    }
    @Override
    public double getCost() {
        return foodItem.getCost() + 0.50; 
    }
    @Override
    public String getDescription() {
        return foodItem.getDescription() + " + Cheese";
    }
}
