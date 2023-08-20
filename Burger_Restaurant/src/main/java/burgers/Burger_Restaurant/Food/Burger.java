package burgers.Burger_Restaurant.Food;

import java.util.List;
import java.util.stream.Stream;

class BurgerManager {
    private final List<Burger> availableBurgers;

    public BurgerManager() {
        availableBurgers = createAvailableBurgers();
    }

    public List<Burger> getAvailableBurgers() {
        return availableBurgers;
    }

    private static List<Burger> createAvailableBurgers(){
        return List.of(
                new Burger("Hamburger", usedToppings(0, 12, 15, 1, 6, 2, 25)),
                new Burger("Cheeseburger", usedToppings(0, 12, 15, 1, 6, 2, 18, 19, 25)),
                new Burger("Veggie", usedToppings(0, 8, 11, 7, 1, 2, 5, 30)),
                new Burger("Meat-boy", usedToppings(0, 14, 15, 1, 6, 16, 17, 26)),
                new Burger("Chicken burger", usedToppings(0, 13, 15, 1, 6, 2, 25)),
                new Burger("Hot burger", usedToppings(0, 12, 15, 9, 6, 3, 10, 29)),
                new Burger("Cheesaur", usedToppings(22, 23, 4, 6, 1, 18, 19)
                ));
    }

    private static Topping[] usedToppings(Integer... toppings) {
        ToppingManager toppingManager = new ToppingManager();

        return Stream.of(toppings)
                .map(toppingManager::getToppingByIndex)
                .toArray(Topping[]::new);
    }
}
public class Burger {
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
    private Double price;

    public Burger(int index){
        BurgerManager burgerManager = new BurgerManager();
        Burger preparedBurger = burgerManager.getAvailableBurgers().get(index);
        name = preparedBurger.getName();
        bun = preparedBurger.getBun();
        toppings = preparedBurger.getToppings();
        price = preparedBurger.getPrice();
    }
    private Burger(Bun bun, Topping... toppings) {
        name = "Custom";
        this.bun = bun;
        this.toppings = List.of(toppings);
        double total = bun.getPrice();
        for (var topping : toppings) {
            total += topping.getPrice();
        }
        price = total;
    }

    protected Burger(String name, Topping... toppings) {
        this(Bun.PLAIN, toppings);
        this.name = name;
//        double total = bun.getPrice();
//        for (var topping : toppings) {
//            total += topping.getPrice();
//        }
//        price = total;
    }

    public static Burger createCustomBurger(Bun bun, Topping... toppings) {
        return new Burger(bun, toppings);
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