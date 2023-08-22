package burgers.Burger_Restaurant.Food;

import java.util.ArrayList;
import java.util.List;

public class Burger extends Product{

    public static class BurgerManager {
        private final List<Burger> availableBurgers;

        public BurgerManager() {
            availableBurgers = createAvailableBurgers();
        }

        public List<Burger> getAvailableBurgers() {
            return availableBurgers;
        }

        private static List<Burger> createAvailableBurgers() {
            return List.of(
                    /*0*/ new Burger("Hamburger", 0, 12, 15, 1, 6, 2, 25),
                    /*1*/ new Burger("Cheeseburger", 0, 12, 15, 1, 6, 2, 18, 19, 25),
                    /*2*/ new Burger("Veggie", 0, 8, 11, 7, 1, 2, 5, 30),
                    /*3*/ new Burger("Meat-boy", 0, 14, 15, 1, 6, 16, 17, 26),
                    /*4*/ new Burger("Chicken burger", 0, 13, 15, 1, 6, 2, 25),
                    /*5*/ new Burger("Hot burger", 0, 12, 15, 9, 6, 3, 10, 29),
                    /*6*/ new Burger("Cheesaur", 22, 23, 4, 6, 1, 18, 19));
        }
    }

    public enum Bun {
        PLAIN(1.12), SESAME(1.25), WHEAT(1.12), GRAHAM(1.18);
        private final double price;

        Bun(double price) {
            this.price = price;
        }

        public double getBunPrice() {
            return price;
        }
    }

    private final Bun bun;
    private final List<Topping> toppings;

    public Burger(int index) {
        super("",0);
        BurgerManager burgerManager = new BurgerManager();
        Burger preparedBurger = null;
        try {
            preparedBurger = burgerManager.getAvailableBurgers().get(index);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Exception: Unauthorised burger");
        }
        if (preparedBurger != null) {
            this.setName(preparedBurger.getName());
            bun = preparedBurger.getBun();
            toppings = preparedBurger.getToppings();
            this.setPrice(preparedBurger.getPriceCalculated());
        } else {
            this.setName(null);
            bun = null;
            toppings = null;
            this.setPrice(null);
        }
    }

    private Burger(Bun bun, int... index) {
        super("Custom", 0);
        this.bun = bun;
        List<Topping> addedToppings = new ArrayList<>();

        for (int id : index) {
            try {
                Topping topping = new Topping(id);
                addedToppings.add(topping);
            } catch (IllegalArgumentException iae) {
                System.out.println("Exception: " + iae.getMessage());
            }
        }
        toppings = addedToppings;
        this.setPrice(getPriceCalculated());
    }

    private Burger(String name, int... index) {
        this(Bun.PLAIN, index);
        this.setName(name);
    }

    public static Burger createCustomBurger(Bun bun, int... index) {
        if (index.length < 4) {
            System.err.println("Can't create burger without at least 4 toppings");
            return null;
        }
        return new Burger(bun, index);
    }

    public Bun getBun() {
        return bun;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public Double getPriceCalculated() {
        Double total = bun.getBunPrice();
        for (var topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder toppingsString = new StringBuilder();
        if (this.getName() == null || this.getPrice() == null || toppings == null || bun == null) {
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
        return String.format("%30s : $%.2f %n%s%n%30s : $%.2f+%n%s", this.getName(), this.getPrice(), spacer, bunName, bun.getBunPrice(), toppingsString);
    }
}