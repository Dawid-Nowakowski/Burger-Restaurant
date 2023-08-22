package burgers.Burger_Restaurant.Food;

import java.util.List;

public class Extras {
    public static class ExtrasManager {
        private final List<Extras> availableExtras;

        public ExtrasManager() {
            availableExtras = createAvailableExtras();
        }

        private static List<Extras> createAvailableExtras() {
            return List.of(
                    new Extras("Coke", Extras.Type.DRINK, Extras.Size.SMALL, 2.1),
                    new Extras("Coke", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.6),
                    new Extras("Orangeade", Extras.Type.DRINK, Extras.Size.SMALL, 1.7),
                    new Extras("Orangeade", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.06),
                    new Extras("Apple Juice", Extras.Type.DRINK, Extras.Size.SMALL, 1.85),
                    new Extras("Orange Juice", Extras.Type.DRINK, Extras.Size.SMALL, 1.85),
                    new Extras("Black Tea", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.2),
                    new Extras("Green Tea", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.32),
                    new Extras("Black Coffee", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.15),
                    new Extras("Cappuccino", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.17),
                    new Extras("Latte", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.3),
                    new Extras("Fries", Extras.Type.SNACK, Extras.Size.SMALL, 2.7),
                    new Extras("Fries", Extras.Type.SNACK, Extras.Size.MEDIUM, 3.2),
                    new Extras("Fries", Extras.Type.SNACK, Extras.Size.LARGE, 3.6),
                    new Extras("Onion Rings", Extras.Type.SNACK, Extras.Size.SMALL, 2.94),
                    new Extras("Onion Rings", Extras.Type.SNACK, Extras.Size.MEDIUM, 3.48),
                    new Extras("Chicken Strips", Extras.Type.SNACK, Extras.Size.SMALL, 3.2),
                    new Extras("Chicken Strips", Extras.Type.SNACK, Extras.Size.MEDIUM, 3.7),
                    new Extras("Chicken Strips", Extras.Type.SNACK, Extras.Size.LARGE, 4.2)
            );
        }

        public List<Extras> getAvailableExtras() {
            return availableExtras;
        }
    }

    enum Type {DRINK, SNACK}

    enum Size {
        SMALL, MEDIUM, LARGE;

        private String getValue(Type type) {
            switch (type) {
                case DRINK -> {
                    return switch (this) {
                        case SMALL -> "250ml";
                        case MEDIUM -> "333ml";
                        case LARGE -> "500ml";
                    };
                }
                case SNACK -> {
                    return switch (this) {
                        case SMALL -> "200g";
                        case MEDIUM -> "300g";
                        case LARGE -> "400g";
                    };
                }
            }
            return null;
        }
    }

    private final String name;
    private final Type type;
    private final Size size;
    private final Double price;

    private Extras(String name, Type type, Size size, Double price) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public Extras(int index) {
        ExtrasManager extrasManager = new ExtrasManager();
        Extras extras = null;
        try {
            extras = extrasManager.getAvailableExtras().get(index);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Exception: Unauthorised extra");
        }
        if (extras != null) {
            name = extras.getName();
            type = extras.getType();
            size = extras.getSize();
            price = extras.getPrice();
        } else {
            name = null;
            type = null;
            size = null;
            price = null;
        }
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        if (name != null) {
            return String.format("%30s : $%.2f", name.toUpperCase().charAt(0) +
                    name.substring(1) + "  " + size.getValue(getType()), price);
        }
        return "Unauthorized extra";
    }
}
