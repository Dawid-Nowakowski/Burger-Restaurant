package burgers.Burger_Restaurant.Food;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    enum Type {VEGGIE, MEAT, DAIRY, SAUCE}
    private String name;
    private Type type;
    private Double price;

    public Topping(String name) {
        boolean unallowed = false;
        List<Topping> availableToppings = new ArrayList<>(List.of(
                new Topping("Lettuce", Type.VEGGIE, 0.5),
                new Topping("Tomato", Type.VEGGIE, 1.05),
                new Topping("Onion (raw)", Type.VEGGIE, 0.7),
                new Topping("Onion (grilled)", Type.VEGGIE, 0.92),
                new Topping("Cucumber", Type.VEGGIE, 0.86),
                new Topping("Red Pepper", Type.VEGGIE, 0.97),
                new Topping("Pickles", Type.VEGGIE, 1.17),
                new Topping("Avocado", Type.VEGGIE, 1.68),
                new Topping("Beetroot", Type.VEGGIE, 1.35),
                new Topping("Jalapeno", Type.VEGGIE, 1.42),
                new Topping("Chili", Type.VEGGIE, 1.38),
                new Topping("Falafel", Type.VEGGIE, 2.22),
                new Topping("Beef Patty", Type.MEAT, 2.15),
                new Topping("Chicken Strips", Type.MEAT, 2.15),
                new Topping("Pulled Pork", Type.MEAT, 2.37),
                new Topping("Bacon", Type.MEAT, 1.44),
                new Topping("Ham", Type.MEAT, 1.33),
                new Topping("Salami", Type.MEAT, 1.52),
                new Topping("Cheddar", Type.DAIRY, 0.88),
                new Topping("Mozzarella", Type.DAIRY, 1.07),
                new Topping("Feta", Type.DAIRY, 0.82),
                new Topping("Blue", Type.DAIRY, 1.11),
                new Topping("Cheese Patty", Type.DAIRY, 2.31),
                new Topping("Halloumi", Type.DAIRY, 2.43),
                new Topping("Swiss", Type.DAIRY, 1.2),
                new Topping("BBQ", Type.SAUCE, 0.1),
                new Topping("Chipotle", Type.SAUCE, 0.1),
                new Topping("Mayo", Type.SAUCE, 0.1),
                new Topping("Ketchup", Type.SAUCE, 0.1),
                new Topping("Sriracha", Type.SAUCE, 0.1),
                new Topping("Honey Mustard", Type.SAUCE, 0.1)
        ));
        for (Topping topping : availableToppings) {
            if (name.equalsIgnoreCase(topping.getName())) {
                this.name = name;
                this.type = topping.getType();
                this.price = topping.getPrice();
                break;
            } else {
                unallowed = true;
            }
        }
        try {
            if (name == null) {
                throw new NullPointerException("Unauthorized topping. Not added to the burger.");
            } else if (unallowed) {
                throw new NullPointerException("Unauthorized topping (" + name + ")");
            }
        } catch (NullPointerException e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }

    private Topping(String name, Type type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Unauthorized topping";
        }
        return String.format("%30s : $%.2f", name.toUpperCase().charAt(0) + name.substring(1), price);
    }
}