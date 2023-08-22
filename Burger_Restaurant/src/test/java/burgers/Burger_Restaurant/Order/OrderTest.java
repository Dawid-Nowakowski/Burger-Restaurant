package burgers.Burger_Restaurant.Order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private final Order order = new Order();

    @Test
    public void shouldCreateOrderForStandardBurger(){
        assertNotNull(order.orderedStandardBurgers(0,1,2,3,4,5,6));
    }

    @Test
    public void shouldNotCreateOrderForStandardBurger(){
        assertTrue(order.orderedStandardBurgers(-1,7).isEmpty());
    }

    @Test
    public void shouldCreateOrderForExtras(){
        assertNotNull(order.orderedExtras(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18));
    }

    @Test
    public void shouldNotCreateOrderForExtras(){
        assertTrue(order.orderedExtras(-2, 20).isEmpty());
    }
}
