package burgers.Burger_Restaurant.Food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Burger {
    enum Bun {
        PLAIN, SESAME, WHEAT, GRAHAM;

        public double getPrice() {
            return switch (this) {
                case PLAIN, WHEAT -> 1.12;
                case SESAME -> 1.25;
                case GRAHAM -> 1.18;
            };
        }
    }

    private String name;
    private Bun bun;
    private List<Topping> toppings;
    private Double price;

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

    public Burger(String name, Topping... toppings) {
        this(Bun.PLAIN, toppings);
        this.name = name;
        double total = bun.getPrice();
        for (var topping : toppings) {
            total += topping.getPrice();
        }
        price = total;
    }

    public Burger(int index) {
        List<Burger> availableBurgers = new ArrayList<>(List.of(
                new Burger("Hamburger", usedToppings("lettuce", "beef patty", "Bacon", "Tomato", "pickles", "onion (raw)", "bbq")),
                new Burger("Cheeseburger", usedToppings("lettuce", "beef patty", "bacon", "tomato", "pickles", "onion (raw)", "cheddar", "mozzarella", "bbq")),
                new Burger("Veggie", usedToppings("lettuce", "beetroot", "falafel", "avocado", "tomato", "onion (raw)", "red pepper", "honey mustard")),
                new Burger("Meat-boy", usedToppings("lettuce", "beef patty", "bacon", "tomato", "pickles", "ham", "salami", "chipotle")),
                new Burger("Chicken burger", usedToppings("lettuce", "chicken strips", "bacon", "tomato", "pickles", "onion (raw)", "bbq")),
                new Burger("Hot burger", usedToppings("lettuce", "beef patty", "bacon", "jalapeno", "pickles", "onion (grilled)", "chili", "sriracha")),
                new Burger("Cheesaur", usedToppings("cheese patty", "halloumi", "cucumber", "pickles", "tomato", "cheddar", "mozzarella"))));
        if (index >= 0 && index < availableBurgers.size()) {
            for (int i = 0; i < availableBurgers.size(); i++) {
                if (i == index) {
                    name = availableBurgers.get(index).getName();
                    bun = Bun.PLAIN;
                    toppings = availableBurgers.get(index).getToppings();
                    double total = bun.getPrice();
                    for (var topping : toppings) {
                        total += topping.getPrice();
                    }
                    price = 0.85 * total;
                }
            }
        }
    }

    private static Topping[] usedToppings(String... toppings) {
        return Stream.of(toppings)
                .map(Topping::new)
                .toArray(Topping[]::new);
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