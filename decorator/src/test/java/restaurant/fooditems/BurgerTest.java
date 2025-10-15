package restaurant.fooditems;

import org.junit.jupiter.api.Test;

import restaurant.components.Burger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Burger class.
 */
public class BurgerTest {

    @Test
    public void testBurgerCost() {
        Burger burger = new Burger();
        assertEquals(7.00, burger.getCost(), 0.01); // 0.01 is the margin of error
    }

    @Test
    public void testBurgerDescription() {
        Burger burger = new Burger();
        assertEquals("Burger", burger.getDescription());
    }
}
