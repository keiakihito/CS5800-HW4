package restaurant.components;

/**
 * Concrete food item: Hot Dog with base price.
 */
public class HotDog implements FoodItem {
    @Override
    public double getCost() {
        return 0.00;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
