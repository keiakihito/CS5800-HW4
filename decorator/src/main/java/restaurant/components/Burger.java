package restaurant.components;

/**
 * Component interface for all food items.
 */
public class Burger implements FoodItem {
    @Override
    public double getCost() {
        return 5.00;
    }

    @Override
    public String getDescription() {
        return "Burger";
    }
}
