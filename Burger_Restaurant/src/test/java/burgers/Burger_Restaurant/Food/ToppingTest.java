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
        assertNotNull(topping.getPrice());
    }

    @Test
    public void testInvalidTopping() {
        Topping topping = new Topping(50);
        assertNull(topping.getName());
        assertNull(topping.getType());
        assertNull(topping.getPrice());
    }

    @Test
    public void shouldGetExtra() {
        assertDoesNotThrow(() -> toppingManager.getAvailableToppings().get(0));
    }

    @Test
    public void shouldNotGetExtra() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> toppingManager.getAvailableToppings().get(50));
    }
}
