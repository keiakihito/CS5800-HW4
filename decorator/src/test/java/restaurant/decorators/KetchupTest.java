package restaurant.decorators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import restaurant.components.Burger;
import restaurant.components.HotDog;
import restaurant.decorators.Ketchup;

public class KetchupTest {

    @Test
    public void testKetchupAddsToBurgerCost() {
        Burger burger = new Burger();
        Ketchup ketchupBurger = new Ketchup(burger);
        assertEquals(7.05, ketchupBurger.getCost(), 0.01);
    }

    @Test
    public void testKetchupAddsToDescription() {
        Burger burger = new Burger();
        Ketchup ketchupBurger = new Ketchup(burger);
        assertEquals("Burger + Ketchup", ketchupBurger.getDescription());
    }

    @Test
    public void testKetchupOnHotDog() {
        HotDog hotDog = new HotDog();
        Ketchup ketchupHotDog = new Ketchup(hotDog);
        assertEquals(2.05, ketchupHotDog.getCost(), 0.01);
        assertEquals("HotDog + Ketchup", ketchupHotDog.getDescription());
    }

    @Test
    public void testMultipleKetchup() {
        Burger burger = new Burger();
        Ketchup ketchupBurger = new Ketchup(burger);
        Ketchup doubleKetchup = new Ketchup(ketchupBurger);
        assertEquals(7.10, doubleKetchup.getCost(), 0.01);
        assertEquals("Burger + Ketchup + Ketchup", doubleKetchup.getDescription());
    }
}
