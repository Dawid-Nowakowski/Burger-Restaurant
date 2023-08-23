package burgers.Burger_Restaurant.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BurgerTest {

    @Test
    public void testValidBurger() {
        Burger burger = new Burger(0);
        assertNotNull(burger.getName());
        assertNotNull(burger.getBun());
        assertNotNull(burger.getToppings());
        assertNotNull(burger.getPrice());
        System.out.println("1");
    }

    @Test
    public void testInvalidBurger() {
        Burger burger = new Burger(123);
        assertNull(burger.getName());
        assertNull(burger.getBun());
        assertNull(burger.getToppings());
        assertNull(burger.getPrice());
        System.out.println("2");
    }

    @Test
    public void shouldCreateCustomBurger() {
        assertDoesNotThrow(() -> {
            Burger.createCustomBurger(Burger.Bun.PLAIN, 1, 3, 6, 9, 15, 20, 25, 30);
        });
        System.out.println("3");
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
        System.out.println("4");
    }

    @Test
    public void shouldNotAddToppingsToCustomBurger() {
        assertThrows(NullPointerException.class, () -> Burger.createCustomBurger(Burger.Bun.WHEAT, -1, -50, 513, 200));
        System.out.println("5");
    }

    @Test
    public void shouldNotGetAvailableBurger() {
        Burger.BurgerManager burgerManager = new Burger.BurgerManager();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> burgerManager.getAvailableBurgers().get(7));
        System.out.println("6");}
}