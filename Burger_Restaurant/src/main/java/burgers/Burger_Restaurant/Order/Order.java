package burgers.Burger_Restaurant.Order;

import burgers.Burger_Restaurant.Food.Burger;
import burgers.Burger_Restaurant.Food.Extras;
import burgers.Burger_Restaurant.Food.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Integer orderNumber;
    private List<Product> orderedProductsList = new ArrayList<>();
    private final List<Extras> availableExtras = Extras.ExtrasManager.getAvailableExtras();
    private final List<Burger> availableBurgers = Burger.BurgerManager.getAvailableBurgers();
    private final Map<Integer, Product> availableProductsMap = createAvailableProducts(availableBurgers, availableExtras);
    private static int ID = 1;
    private double total;
    private String formattedDT;

    public Order() {
        orderNumber = ID++;
        generateDate();
    }

    // constructor below allows to create new object of type Order by providing index from available products (availableProductsMap)

    public Order(int... index) {
        this();

        for (int id : index) {
                Product p = availableProductsMap.get(id);
                if (p != null) {
                    orderedProductsList.add(p);
                    total += p.getPrice();
                } else {
                    orderNumber = null;
                    throw new IllegalArgumentException("Product with ID " + id + " not available.");
                }
        }
    }

    public Order(Product product) {
        this();
        if (product != null) {
            orderedProductsList.add(product);
            total += product.getPrice();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Map<Integer, Product> createAvailableProducts
            (List<Burger> availableBurgers, List<Extras> availableExtras) {
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

    public void generateDate(){
        LocalDateTime orderDateTime = LocalDateTime.now();
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        formattedDT = orderDateTime.format(dtFormat);
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public List<Product> getOrderedProductsList() {
        return orderedProductsList;
    }

    public Map<Integer, Product> getAvailableProducts() {
        return availableProductsMap;
    }

    public double getTotal() {
        return total;
    }

    public String getFormattedDT() {
        return formattedDT;
    }

    @Override
    public String toString() {
        if (getOrderNumber() == null) {
            return null;
        }
        StringBuilder orderBuilder = new StringBuilder();

        for (var p : getOrderedProductsList()) {
            orderBuilder.append(p.toString());
        }
        String spacer = "- ".repeat(20);
        String line = "_".repeat(39);
        int position;
        if(total > 99.99 && total < 1000){
            position = 31;
        } else if (total > 999.99 && total < 10000) {
            position = 30;
        } else if (total > 9999.99 && total < 100000) {
            position = 29;
        } else if (total > 99999.99 && total < 1000000) {
            position = 28;
        } else {
            position = 32;
        }

        return String.format("%s%n%28s%n%n%22s%d%n%n%s%s%n%" + position + "s$%6.2f%n%s%n%28s%n%s%n",
                line, "Burger Restaurant", "Order #", getOrderNumber(), orderBuilder, spacer,
                "Total : ", total, spacer, getFormattedDT(), line);
    }
}