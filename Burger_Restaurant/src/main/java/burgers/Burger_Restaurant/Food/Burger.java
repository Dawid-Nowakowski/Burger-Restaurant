package burgers.Burger_Restaurant.Food;

import java.util.ArrayList;
import java.util.List;

public class Burger {

    static class BurgerManager {
        private final List<Burger> availableBurgers;

        public BurgerManager() {
            availableBurgers = createAvailableBurgers();
        }

        public List<Burger> getAvailableBurgers() {
            return availableBurgers;
        }

        private static List<Burger> createAvailableBurgers() {
            return List.of(
                    new Burger("Hamburger", 0, 12, 15, 1, 6, 2, 25),
                    new Burger("Cheeseburger", 0, 12, 15, 1, 6, 2, 18, 19, 25),
                    new Burger("Veggie", 0, 8, 11, 7, 1, 2, 5, 30),
                    new Burger("Meat-boy", 0, 14, 15, 1, 6, 16, 17, 26),
                    new Burger("Chicken burger", 0, 13, 15, 1, 6, 2, 25),
                    new Burger("Hot burger", 0, 12, 15, 9, 6, 3, 10, 29),
                    new Burger("Cheesaur", 22, 23, 4, 6, 1, 18, 19));
        }
    }
    public enum Bun {
        PLAIN(1.12), SESAME(1.25), WHEAT(1.12), GRAHAM(1.18);
        private final double price;

        Bun(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    private String name;
    private final Bun bun;
    private final List<Topping> toppings;
    private final Double price;

    public Burger(int index) {
        BurgerManager burgerManager = new BurgerManager();
        Burger preparedBurger = null;
        try {
            preparedBurger = burgerManager.getAvailableBurgers().get(index);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Exception: Unauthorised burger ");
        }
        if(preparedBurger != null) {
            name = preparedBurger.getName();
            bun = preparedBurger.getBun();
            toppings = preparedBurger.getToppings();
            price = preparedBurger.getPrice();
        }else{
            name = null;
            bun = null;
            toppings = null;
            price = null;
        }
    }

    private Burger(Bun bun, int... index) {
        name = "Custom";
        this.bun = bun;
        List<Topping> addedToppings = new ArrayList<>();
        Topping.ToppingManager toppingManager = new Topping.ToppingManager();

        for (int i : index) {
            try {
                Topping topping = toppingManager.getToppingByIndex(i);
                addedToppings.add(topping);
            } catch (IllegalArgumentException iae) {
                System.out.println("Exception: " + iae.getMessage());
            }
        }
        toppings = addedToppings;
        double total = bun.getPrice();
        for (var topping : toppings) {
            total += topping.getPrice();
        }
        price = total;
    }

    protected Burger(String name, int... index) {
        this(Bun.PLAIN, index);
        this.name = name;
    }

    public static Burger createCustomBurger(Bun bun, int... index) {
        if(index.length < 4){
            System.err.println("Can't create burger without at least 4 toppings");
            return null;
        }
        return new Burger(bun, index);
    }

    public String getName() {
        return name;
    }

    public Bun getBun() {
        return bun;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder toppingsString = new StringBuilder();
        if(name == null || price == null || toppings == null || bun == null){
            return "";
        }
        for (Topping topping : toppings) {
            toppingsString.append(topping.toString()).append("+\n");
        }
        if (toppingsString.length() > 0) {
            toppingsString.setLength(toppingsString.length() - 1);
        }
        String spacer = "_ ".repeat(20);
        String bunName = bun.name().charAt(0) + bun.name().toLowerCase().substring(1) + " bun";
        return String.format("%30s : $%.2f %n%s%n%30s : $%.2f+%n%s", name, price, spacer, bunName, bun.getPrice(), toppingsString);
    }
}