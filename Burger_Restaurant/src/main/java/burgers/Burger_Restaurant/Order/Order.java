package burgers.Burger_Restaurant.Order;

import burgers.Burger_Restaurant.Food.Burger;
import burgers.Burger_Restaurant.Food.Extras;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public Order() {
    }

    public List<Burger> orderedStandardBurgers(int... index) {
        List<Burger> orderedBurgers = new ArrayList<>();
        Burger.BurgerManager burgerManager = new Burger.BurgerManager();
        List<Burger> availableBurgers = burgerManager.getAvailableBurgers();
        try {
            for (var id : index) {
                orderedBurgers.add(availableBurgers.get(id));
            }
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Unauthorized burger");
        }
        return orderedBurgers;
    }

    public List<Extras> orderedExtras(int... index) {
        List<Extras> orderedExtras = new ArrayList<>();
        Extras.ExtrasManager extrasManager = new Extras.ExtrasManager();
        List<Extras> availableExtras = extrasManager.getAvailableExtras();
        try {
            for (var id : index) {
                orderedExtras.add(availableExtras.get(id));
            }
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Unauthorized extra");
        }
        return orderedExtras;
    }
}
