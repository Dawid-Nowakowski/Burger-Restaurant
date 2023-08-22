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

    @Test
    public void shouldCreateCustomBurger() {
        assertDoesNotThrow(() -> {
            Burger.createCustomBurger(Burger.Bun.PLAIN, 1, 3, 6, 9, 15, 20, 25, 30);
        });
    }

    @Test
    public void shouldNotCreateCustomBurger() {
        Burger burger1 = Burger.createCustomBurger(Burger.Bun.WHEAT);
        Burger burger2 = Burger.createCustomBurger(Burger.Bun.WHEAT, 0);
        Burger burger3 = Burger.createCustomBurger(Burger.Bun.WHEAT, 0, 1);
        Burger burger4 = Burger.createCustomBurger(Burger.Bun.WHEAT, 0, 1, 2);
        assertNull(burger1);
        assertNull(burger2);
        assertNull(burger3);
        assertNull(burger4);
    }

    @Test
    public void shouldNotAddToppingsToCustomBurger() {
        Burger burger = Burger.createCustomBurger(Burger.Bun.WHEAT, -1, -50, 513, 200);
        assertTrue(burger != null && burger.getToppings().isEmpty());
    }

    @Test
    public void shouldNotFindAvailableBurger() {
        Burger.BurgerManager burgerManager = new Burger.BurgerManager();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> burgerManager.getAvailableBurgers().get(7));}
}