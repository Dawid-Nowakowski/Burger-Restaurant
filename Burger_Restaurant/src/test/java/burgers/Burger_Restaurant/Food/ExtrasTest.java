package burgers.Burger_Restaurant.Food;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtrasTest {

    private final Extras.ExtrasManager extrasManager = new Extras.ExtrasManager();

    @Test
    public void testValidExtra() {
        Extras extras = new Extras(0);
        assertNotNull(extras.getName());
        assertNotNull(extras.getType());
        assertNotNull(extras.getSize());
        assertNotNull(extras.getPrice());
    }

    @Test
    public void testInvalidExtra() {
        Extras extras = new Extras(51);
        assertNull(extras.getName());
        assertNull(extras.getType());
        assertNull(extras.getSize());
        assertNull(extras.getPrice());
    }

    @Test
    public void shouldGetExtra() {
        assertDoesNotThrow(() -> extrasManager.getAvailableExtras().get(0));
    }

    @Test
    public void shouldNotGetExtra() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> extrasManager.getAvailableExtras().get(50));
    }
}