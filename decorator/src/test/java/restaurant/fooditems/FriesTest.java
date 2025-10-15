package restaurant.fooditems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import restaurant.components.Fries;

/**
 * Unit tests for Fries class.
 */
public class FriesTest {

    @Test
    public void testFriesCost() {
        Fries fries = new Fries();
        assertEquals(5.00, fries.getCost(), 0.01); // 0.01 is the margin of error
    }

    @Test
    public void testFriesDescription() {
        Fries fries = new Fries();
        assertEquals("Fries", fries.getDescription());
    }
}
