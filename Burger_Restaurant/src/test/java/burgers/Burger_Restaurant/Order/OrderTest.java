package burgers.Burger_Restaurant.Order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void shouldCreateOrder() {
        System.out.println(new Order(0, 1, 2, 3, 4, 5, 6));
        assertFalse(new Order(0, 1, 2, 3, 4, 5, 6).getOrderedProductsList().isEmpty());
        assertFalse(new Order(100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118).getOrderedProductsList().isEmpty());
    }

    @Test
    public void shouldNotCreateOrder() {
        Order order = new Order(-1,7,250);
        for (var o : order.getOrderedProductsList()){
            assertNull(o);
        }
    }
}
