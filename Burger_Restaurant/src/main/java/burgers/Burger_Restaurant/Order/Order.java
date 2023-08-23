package burgers.Burger_Restaurant.Order;

import burgers.Burger_Restaurant.Food.Burger;
import burgers.Burger_Restaurant.Food.Extras;
import burgers.Burger_Restaurant.Food.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int orderNumber;
    private List<Product> orderedProductsList = new ArrayList<>();
    private final List<Extras> availableExtras = new Extras.ExtrasManager().getAvailableExtras();
    private final List<Burger> availableBurgers = new Burger.BurgerManager().getAvailableBurgers();
    private final Map<Integer, Product> availableProductsMap = createAvailableProducts(availableBurgers, availableExtras);
    private static int ID = 1;

    public Order() {
        orderNumber = ID++;
    }

    public Order(int... index) {
        super();
        List<Product> addedProducts = new ArrayList<>();

        for (int id : index) {
            try {
                addedProducts.add(availableProductsMap.get(id));
            }catch (IndexOutOfBoundsException ioobe){
                System.out.println("Exception: " + ioobe.getMessage());
            }
        }
        orderedProductsList = addedProducts;
    }

    public Map<Integer, Product> createAvailableProducts(List<Burger> availableBurgers, List<Extras> availableExtras) {
        Map<Integer, Product> orderMap = new HashMap<>();

        for (var b : availableBurgers) {
            Integer key = availableBurgers.indexOf(b);
            orderMap.put(key, b);
        }
        for (var e : availableExtras) {
            Integer key = availableExtras.indexOf(e) + 100;
            orderMap.put(key, e);
        }
        return orderMap;
    }

    public Burger getCustomBurger(Burger.Bun bun, int... index) {
        return Burger.createCustomBurger(bun, index);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Product> getOrderedProductsList() {
        return orderedProductsList;
    }

    public Map<Integer, Product> getAvailableProducts() {
        return availableProductsMap;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderedProductsList=" + orderedProductsList +
                '}';
    }
}
