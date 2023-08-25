package burgers.Burger_Restaurant.Order;

import burgers.Burger_Restaurant.Food.Burger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118})
    public void shouldCreateOrder(int value) {
        assertFalse(new Order(value).getOrderedProductsList().isEmpty());
    }

    @Test
    public void ordersShouldHaveDifferentId() {
        Order order1 = new Order(0, 1);
        Order order2 = new Order(0, 105);
        System.out.println(order1);
        System.out.println(order2);
        assertNotSame(order1.getOrderNumber(), order2.getOrderNumber());
    }

    @Test
    public void shouldNotCreateOrder() {
        assertThrows(IllegalArgumentException.class, () -> new Order(-1, 7, 250));
    }

    @Test
    public void shouldMakeCustomBurger() {
        assertDoesNotThrow(() -> new Order((Burger.createCustomBurger(Burger.Bun.SESAME, 1, 2, 3, 4))));
    }

    @Test
    public void shouldNotCreateOrderWithInvalidProduct() {
        assertThrows(IllegalArgumentException.class, () -> new Order(new Burger(8)));
    }
}