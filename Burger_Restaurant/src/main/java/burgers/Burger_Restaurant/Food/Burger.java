package burgers.Burger_Restaurant.Food;

import java.util.ArrayList;
import java.util.List;

public class Burger extends Product {

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

    private Bun bun;
    private List<Topping> toppings = new ArrayList<>();

    public Burger(int index) {
        super("", 0);
        BurgerManager burgerManager = new BurgerManager();
        Burger preparedBurger = null;
        try {
            preparedBurger = burgerManager.getAvailableBurgers().get(index);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Exception: Unauthorised burger");
            throw new IllegalArgumentException("Product with ID " + index + " not available.");
        }
        if (preparedBurger != null) {
            this.setName(preparedBurger.getName());
            bun = preparedBurger.getBun();
            toppings = preparedBurger.getToppings();
            this.setPrice(preparedBurger.getPriceCalculated());
        }
    }

    private Burger(Bun bun, int... toppingIndex) {
        super("Custom", 0);
        this.bun = bun;

        this.addTopping(toppingIndex);
        this.setPrice(getPriceCalculated());
    }

    private Burger(String name, int... toppingIndex) {
        this(Bun.PLAIN, toppingIndex);
        this.setName(name);
    }

    public static Burger createCustomBurger(Bun bun, int... index) {
        Topping.ToppingManager tp = new Topping.ToppingManager();
        if (index.length < 4) {
            throw new IllegalArgumentException("Can't create burger without at least 4 toppings");
        }
        for (int id : index) {
            if (id > tp.getAvailableToppings().size() || id < 0) {
                throw new IllegalArgumentException();
            }
        }
        return new Burger(bun, index);
    }

    public Bun getBun() {
        return bun;
    }

    public void setBun(Bun bun) {
        this.bun = bun;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public Double getPriceCalculated() {
        Double total = bun.getBunPrice();
        for (var topping : getToppings()) {
            total += topping.getToppingPrice();
        }
        return total;
    }

    public void removeTopping(int... toppingIndex) {
        List<Topping> toppingsToRemove = new ArrayList<>();
        for (var id : toppingIndex) {
            try {
                toppingsToRemove.add(new Topping(id));
            } catch (IllegalArgumentException iae){
                System.out.println("Exception: " + iae.getMessage());
            }
        }
        this.getToppings().removeAll(toppingsToRemove);
    }

    public void addTopping(int... toppingIndex) {
        for (int id : toppingIndex) {
            try {
                Topping topping = new Topping(id);
                getToppings().add(topping);
            } catch (IllegalArgumentException iae) {
                System.out.println("Exception: " + iae.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        if (this.getName() == null || this.getPrice() == null || toppings == null || bun == null) {
            return "";
        }
        return super.toString();
    }
}