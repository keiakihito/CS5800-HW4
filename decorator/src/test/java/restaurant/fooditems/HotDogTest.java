package restaurant.fooditems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import restaurant.components.HotDog;

/**
 * Unit tests for HotDog class.
 */
public class HotDogTest {
    @Test
    public void testHotDogCost() {
        HotDog hotDog = new HotDog();
        assertEquals(2.00, hotDog.getCost(), 0.01); // 0.01 is the margin of error
    }
    
    @Test
    public void testHotDogDescription() {
        HotDog hotDog = new HotDog();
        assertEquals("HotDog", hotDog.getDescription());
    }

}
