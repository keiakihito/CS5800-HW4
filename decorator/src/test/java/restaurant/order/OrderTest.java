package restaurant.order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import restaurant.components.Burger;
import restaurant.components.HotDog;
import restaurant.components.Fries;
import restaurant.decorators.Ketchup;
import restaurant.decorators.Cheese;
import restaurant.decorators.Onions;
import restaurant.loyalty.LoyaltyDiscount;

/**
 * Unit tests for Order class.
 */
public class OrderTest {

    @Test
    public void testEmptyOrder() {
        Order order = new Order();
        assertEquals(0.0, order.calculateTotal(), 0.01);
    }

    @Test
    public void testAddSingleItem() {
        Order order = new Order();
        order.addItem(new Burger());
        assertEquals(7.00, order.calculateTotal(), 0.01);
    }

    @Test
    public void testAddMultipleItems() {
        Order order = new Order();
        order.addItem(new Burger()); // 7.00
        order.addItem(new HotDog()); // 2.00
        order.addItem(new Fries()); // 5.00
        assertEquals(14.00, order.calculateTotal(), 0.01);
    }

    @Test
    public void testAddItemsWithToppings() {
        Order order = new Order();
        order.addItem(new Ketchup(new Burger())); // 7.00 + 0.05 = 7.05
        order.addItem(new Cheese(new HotDog())); // 2.00 + 0.50 = 2.50
        assertEquals(9.55, order.calculateTotal(), 0.01);
    }

    @Test
    public void testOrderWithSilverLoyalty() {
        Order order = new Order();
        order.addItem(new Burger()); // 7.00
        order.addItem(new HotDog()); // 2.00
        LoyaltyDiscount silverLoyalty = new LoyaltyDiscount("Silver");
        double discountedTotal = silverLoyalty.applyDiscount(order.calculateTotal());
        assertEquals(8.55, discountedTotal, 0.01); // (7.00 + 2.00) * 0.95
    }

    @Test
    public void testOrderWithGoldLoyalty() {
        Order order = new Order();
        order.addItem(new Burger()); // 7.00
        order.addItem(new Fries()); // 5.00
        LoyaltyDiscount goldLoyalty = new LoyaltyDiscount("Gold");
        double discountedTotal = goldLoyalty.applyDiscount(order.calculateTotal());
        assertEquals(10.8, discountedTotal, 0.01); // (7.00 + 5.00) * 0.90
    }

    @Test
    public void testOrderWithPlatinumLoyalty() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new HotDog());
        LoyaltyDiscount platinumLoyalty = new LoyaltyDiscount("Platinum");
        double discountedTotal = platinumLoyalty.applyDiscount(order.calculateTotal());
        assertEquals(7.65, discountedTotal, 0.01); // (7.00 + 2.00) * 0.85
    }

    @Test
    public void testOrderWithNoLoyalty() {
        Order order = new Order();
        order.addItem(new Burger());
        LoyaltyDiscount noLoyalty = new LoyaltyDiscount("None");
        double discountedTotal = noLoyalty.applyDiscount(order.calculateTotal());
        assertEquals(7.00, discountedTotal, 0.01);
    }

    @Test
    public void testComplexOrderWithLoyalty() {
        Order order = new Order();
        order.addItem(new Ketchup(new Cheese(new Burger())));
        order.addItem(new Onions(new HotDog()));
        order.addItem(new Fries());
        LoyaltyDiscount goldLoyalty = new LoyaltyDiscount("Gold");
        double discountedTotal = goldLoyalty.applyDiscount(order.calculateTotal());
        // Burger(7.00) + Cheese(0.50) + Ketchup(0.05) + HotDog(2.00) + Onions(0.25) + Fries(5.00) = 14.08
        // 14.08 * 0.90 = 13.32
        assertEquals(13.32 ,discountedTotal, 0.01);
    }

    @Test
    public void testGetItemCount() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new HotDog());
        order.addItem(new Fries());
        assertEquals(3, order.getFoodItemCount());
    }
}
