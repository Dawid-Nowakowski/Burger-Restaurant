package burgers.Burger_Restaurant.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BurgerTest {

    @Test
    public void testValidIndex() {
        Burger burger = new Burger(0);
        assertNotNull(burger.getName());
        assertNotNull(burger.getBun());
        assertNotNull(burger.getToppings());
        assertNotNull(burger.getPrice());
    }

    @Test
    public void testNullBurger() {
        Burger burger = new Burger(123);
        assertNull(burger.getName());
        assertNull(burger.getBun());
        assertNull(burger.getToppings());
        assertNull(burger.getPrice());
    }
}
