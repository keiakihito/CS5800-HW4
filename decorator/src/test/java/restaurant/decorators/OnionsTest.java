package restaurant.decorators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import restaurant.components.Burger;
import restaurant.components.HotDog;
import restaurant.decorators.Onions;


/**
 * Unit tests for Onions topping decorator.
 */
public class OnionsTest {
    @Test
    public void testOnionsAddsToBurgerCost() {
        Burger burger = new Burger();
        Onions onionsBurger = new Onions(burger);
        assertEquals(7.25, onionsBurger.getCost(), 0.01);
    }
    @Test
    public void testOnionsAddsToDescription() {
        Burger burger = new Burger();
        Onions onionsBurger = new Onions(burger);
        assertEquals("Burger + Onions", onionsBurger.getDescription());
    }
    @Test
    public void testOnionsOnHotDog() {
        HotDog hotDog = new HotDog();
        Onions onionsHotDog = new Onions(hotDog);
        assertEquals(2.25, onionsHotDog.getCost(), 0.01);
        assertEquals("HotDog + Onions", onionsHotDog.getDescription());
    }
    @Test
    public void testMultipleOnions() {
        Burger burger = new Burger();
        Onions onionsBurger = new Onions(burger);
        Onions doubleOnions = new Onions(onionsBurger);
        assertEquals(7.50, doubleOnions.getCost(), 0.01);
        assertEquals("Burger + Onions + Onions", doubleOnions.getDescription());
    }

}
