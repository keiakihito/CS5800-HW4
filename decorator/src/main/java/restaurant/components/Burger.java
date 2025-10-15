package restaurant.components;

/**
 * Concreate Component for an item, Burger.
 */
public class Burger implements FoodItem {
    @Override
    public double getCost() {
        return 7.00;
    }

    @Override
    public String getDescription() {
        return "Burger";
    }
}
