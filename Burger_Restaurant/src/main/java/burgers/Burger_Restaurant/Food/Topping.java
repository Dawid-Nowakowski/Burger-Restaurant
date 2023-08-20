package burgers.Burger_Restaurant.Food;

import java.util.List;

class ToppingManager {
    private final List<Topping> availableToppings;

    public ToppingManager() {
        availableToppings = createAvailableToppings();
    }

    public Topping getToppingByIndex(int index) {
        if (index >= 0 && index < availableToppings.size()) {
            return availableToppings.get(index);
        } else
            throw new IllegalArgumentException("Unauthorized topping");
    }

    private static List<Topping> createAvailableToppings() {
        return List.of(
                /*0*/  new Topping("Lettuce", Topping.Type.VEGGIE, 0.5),
                /*1*/  new Topping("Tomato", Topping.Type.VEGGIE, 1.05),
                /*2*/  new Topping("Onion (raw)", Topping.Type.VEGGIE, 0.7),
                /*3*/  new Topping("Onion (grilled)", Topping.Type.VEGGIE, 0.92),
                /*4*/  new Topping("Cucumber", Topping.Type.VEGGIE, 0.86),
                /*5*/  new Topping("Red Pepper", Topping.Type.VEGGIE, 0.97),
                /*6*/  new Topping("Pickles", Topping.Type.VEGGIE, 1.17),
                /*7*/  new Topping("Avocado", Topping.Type.VEGGIE, 1.68),
                /*8*/  new Topping("Beetroot", Topping.Type.VEGGIE, 1.35),
                /*9*/  new Topping("Jalapeno", Topping.Type.VEGGIE, 1.42),
                /*10*/ new Topping("Chili", Topping.Type.VEGGIE, 1.38),
                /*11*/ new Topping("Falafel", Topping.Type.VEGGIE, 2.22),
                /*12*/ new Topping("Beef Patty", Topping.Type.MEAT, 2.15),
                /*13*/ new Topping("Chicken Strips", Topping.Type.MEAT, 2.15),
                /*14*/ new Topping("Pulled Pork", Topping.Type.MEAT, 2.37),
                /*15*/ new Topping("Bacon", Topping.Type.MEAT, 1.44),
                /*16*/ new Topping("Ham", Topping.Type.MEAT, 1.33),
                /*17*/ new Topping("Salami", Topping.Type.MEAT, 1.52),
                /*18*/ new Topping("Cheddar", Topping.Type.DAIRY, 0.88),
                /*19*/ new Topping("Mozzarella", Topping.Type.DAIRY, 1.07),
                /*20*/ new Topping("Feta", Topping.Type.DAIRY, 0.82),
                /*21*/ new Topping("Blue", Topping.Type.DAIRY, 1.11),
                /*22*/ new Topping("Cheese Patty", Topping.Type.DAIRY, 2.31),
                /*23*/ new Topping("Halloumi", Topping.Type.DAIRY, 2.43),
                /*24*/ new Topping("Swiss", Topping.Type.DAIRY, 1.2),
                /*25*/ new Topping("BBQ", Topping.Type.SAUCE, 0.1),
                /*26*/ new Topping("Chipotle", Topping.Type.SAUCE, 0.1),
                /*27*/ new Topping("Mayo", Topping.Type.SAUCE, 0.1),
                /*28*/ new Topping("Ketchup", Topping.Type.SAUCE, 0.1),
                /*29*/ new Topping("Sriracha", Topping.Type.SAUCE, 0.1),
                /*30*/ new Topping("Honey Mustard", Topping.Type.SAUCE, 0.1)
        );
    }
}

public class Topping {
    enum Type {VEGGIE, MEAT, DAIRY, SAUCE}

    private final String name;
    private final Type type;
    private final Double price;

    protected Topping(String name, Type type, Double price) {
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