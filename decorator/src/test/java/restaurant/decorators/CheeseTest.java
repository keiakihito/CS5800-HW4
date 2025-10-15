package restaurant.decorators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import restaurant.components.Burger;
import restaurant.components.HotDog;
import restaurant.decorators.Cheese;

public class CheeseTest {

    @Test
    public void testCheeseAddsToBurgerCost() {
        Burger burger = new Burger();
        Cheese cheeseBurger = new Cheese(burger);
        assertEquals(7.50, cheeseBurger.getCost(), 0.01);
    }

    @Test
    public void testCheeseAddsToDescription() {
        Burger burger = new Burger();
        Cheese cheeseBurger = new Cheese(burger);
        assertEquals("Burger + Cheese", cheeseBurger.getDescription());
    }

    @Test
    public void testCheeseOnHotDog() {
        HotDog hotDog = new HotDog();
        Cheese cheeseHotDog = new Cheese(hotDog);
        assertEquals(2.50, cheeseHotDog.getCost(), 0.01);
        assertEquals("HotDog + Cheese", cheeseHotDog.getDescription());
    }

    @Test
    public void testMultipleCheese() {
        Burger burger = new Burger();
        Cheese cheeseBurger = new Cheese(burger);
        Cheese doubleCheese = new Cheese(cheeseBurger);
        assertEquals(8.00, doubleCheese.getCost(), 0.01);
        assertEquals("Burger + Cheese + Cheese", doubleCheese.getDescription());
    }
}
