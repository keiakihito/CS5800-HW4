package restaurant.fooditems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Burger class.
 */
public class BurgerTest {

    @Test
    public void testBurgerCost() {
        Burger burger = new Burger();
        assertEquals(5.00, burger.getCost(), 0.01);
    }

    @Test
    public void testBurgerDescription() {
        Burger burger = new Burger();
        assertEquals("Burger", burger.getDescription());
    }
}
