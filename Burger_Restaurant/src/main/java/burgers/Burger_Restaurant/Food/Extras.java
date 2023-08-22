package burgers.Burger_Restaurant.Food;

import java.util.List;

public class Extras extends Product {
    public static class ExtrasManager {
        private final List<Extras> availableExtras;

        public ExtrasManager() {
            availableExtras = createAvailableExtras();
        }

        private static List<Extras> createAvailableExtras() {
            return List.of(
                    /*0*/  new Extras("Coke", Extras.Type.DRINK, Extras.Size.SMALL, 2.1),
                    /*1*/  new Extras("Coke", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.6),
                    /*2*/  new Extras("Orangeade", Extras.Type.DRINK, Extras.Size.SMALL, 1.7),
                    /*3*/  new Extras("Orangeade", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.06),
                    /*4*/  new Extras("Apple Juice", Extras.Type.DRINK, Extras.Size.SMALL, 1.85),
                    /*5*/  new Extras("Orange Juice", Extras.Type.DRINK, Extras.Size.SMALL, 1.85),
                    /*6*/  new Extras("Black Tea", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.2),
                    /*7*/  new Extras("Green Tea", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.32),
                    /*8*/  new Extras("Black Coffee", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.15),
                    /*9*/  new Extras("Cappuccino", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.17),
                    /*10*/ new Extras("Latte", Extras.Type.DRINK, Extras.Size.MEDIUM, 2.3),
                    /*11*/ new Extras("Fries", Extras.Type.SNACK, Extras.Size.SMALL, 2.7),
                    /*12*/ new Extras("Fries", Extras.Type.SNACK, Extras.Size.MEDIUM, 3.2),
                    /*13*/ new Extras("Fries", Extras.Type.SNACK, Extras.Size.LARGE, 3.6),
                    /*14*/ new Extras("Onion Rings", Extras.Type.SNACK, Extras.Size.SMALL, 2.94),
                    /*15*/ new Extras("Onion Rings", Extras.Type.SNACK, Extras.Size.MEDIUM, 3.48),
                    /*16*/ new Extras("Chicken Strips", Extras.Type.SNACK, Extras.Size.SMALL, 3.2),
                    /*17*/ new Extras("Chicken Strips", Extras.Type.SNACK, Extras.Size.MEDIUM, 3.7),
                    /*18*/ new Extras("Chicken Strips", Extras.Type.SNACK, Extras.Size.LARGE, 4.2)
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
    private final Type type;
    private final Size size;
    //private final Double price;

    private Extras(String name, Type type, Size size, Double price) {
        super(name, price);
        this.type = type;
        this.size = size;
    }

    public Extras(int index) {
        super("",0);
        ExtrasManager extrasManager = new ExtrasManager();
        Extras extras = null;
        try {
            extras = extrasManager.getAvailableExtras().get(index);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Exception: Unauthorised extra");
        }
        if (extras != null) {
            this.setName(extras.getName());
            type = extras.getType();
            size = extras.getSize();
            this.setPrice(extras.getPrice());
        } else {
            this.setName(null);
            type = null;
            size = null;
            this.setPrice(null);
        }
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (this.getName() != null) {
            return String.format("%30s : $%.2f", this.getName().toUpperCase().charAt(0) +
                    this.getName().substring(1) + "  " + size.getValue(getType()), this.getPrice());
        }
        return "Unauthorized extra";
    }
}
