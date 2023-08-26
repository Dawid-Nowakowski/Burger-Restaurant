package burgers.Burger_Restaurant.Food;

import java.util.List;
import java.util.Objects;


public class Topping {

    static class ToppingManager {
        private final List<Topping> availableToppings;

        public ToppingManager() {
            availableToppings = createAvailableToppings();
        }

        public List<Topping> createAvailableToppings() {
            return List.of(
                    /*0*/  new Topping("Lettuce", Type.VEGGIE, 0.5),
                    /*1*/  new Topping("Tomato", Type.VEGGIE, 1.05),
                    /*2*/  new Topping("Onion (raw)", Type.VEGGIE, 0.7),
                    /*3*/  new Topping("Onion (grilled)", Type.VEGGIE, 0.92),
                    /*4*/  new Topping("Cucumber", Type.VEGGIE, 0.86),
                    /*5*/  new Topping("Red Pepper", Type.VEGGIE, 0.97),
                    /*6*/  new Topping("Pickles", Type.VEGGIE, 1.17),
                    /*7*/  new Topping("Avocado", Type.VEGGIE, 1.68),
                    /*8*/  new Topping("Beetroot", Type.VEGGIE, 1.35),
                    /*9*/  new Topping("Jalapeno", Type.VEGGIE, 1.42),
                    /*10*/ new Topping("Chili", Type.VEGGIE, 1.38),
                    /*11*/ new Topping("Falafel", Type.VEGGIE, 2.22),
                    /*12*/ new Topping("Beef Patty", Type.MEAT, 2.15),
                    /*13*/ new Topping("Chicken Strips", Type.MEAT, 2.15),
                    /*14*/ new Topping("Pulled Pork", Type.MEAT, 2.37),
                    /*15*/ new Topping("Bacon", Type.MEAT, 1.44),
                    /*16*/ new Topping("Ham", Type.MEAT, 1.33),
                    /*17*/ new Topping("Salami", Type.MEAT, 1.52),
                    /*18*/ new Topping("Cheddar", Type.DAIRY, 0.88),
                    /*19*/ new Topping("Mozzarella", Type.DAIRY, 1.07),
                    /*20*/ new Topping("Feta", Type.DAIRY, 0.82),
                    /*21*/ new Topping("Blue", Type.DAIRY, 1.11),
                    /*22*/ new Topping("Cheese Patty", Type.DAIRY, 2.31),
                    /*23*/ new Topping("Halloumi", Type.DAIRY, 2.43),
                    /*24*/ new Topping("Swiss", Type.DAIRY, 1.2),
                    /*25*/ new Topping("BBQ", Type.SAUCE, 0.1),
                    /*26*/ new Topping("Chipotle", Type.SAUCE, 0.1),
                    /*27*/ new Topping("Mayo", Type.SAUCE, 0.1),
                    /*28*/ new Topping("Ketchup", Type.SAUCE, 0.1),
                    /*29*/ new Topping("Sriracha", Type.SAUCE, 0.1),
                    /*30*/ new Topping("Honey Mustard", Type.SAUCE, 0.1)
            );
        }

        public List<Topping> getAvailableToppings() {
            return availableToppings;
        }
    }

    enum Type {VEGGIE, MEAT, DAIRY, SAUCE}

    private final String name;
    private final Type type;
    private final Double price;

    private Topping(String name, Type type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Topping(int index) {
        ToppingManager toppingManager = new ToppingManager();
        Topping topping = null;
        try {
            topping = toppingManager.getAvailableToppings().get(index);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Exception: Unauthorised topping");
        }
        if (topping != null) {
            name = topping.getName();
            type = topping.getType();
            price = topping.getToppingPrice();
        } else {
            throw new IllegalArgumentException("Unallowed topping.");
        }
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Double getToppingPrice() {
        return price;
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Unauthorized topping";
        }
        return String.format("%30s : $%.2f", name.toUpperCase().charAt(0) + name.substring(1), price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topping topping = (Topping) o;
        return Objects.equals(name, topping.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}