package burgers.Burger_Restaurant.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToppingTest {

    private final Topping.ToppingManager toppingManager = new Topping.ToppingManager();

    @Test
    public void testValidTopping() {
        Topping topping = new Topping(0);
        assertNotNull(topping.getName());
        assertNotNull(topping.getType());
        assertNotNull(topping.getToppingPrice());
    }

    @Test
    public void testInvalidTopping() {
        assertThrows(IllegalArgumentException.class, () -> {
            Topping topping = new Topping(50);
        });
    }

    @Test
    public void shouldGetTopping() {
        assertDoesNotThrow(() -> toppingManager.getAvailableToppings().get(0));
    }
}
