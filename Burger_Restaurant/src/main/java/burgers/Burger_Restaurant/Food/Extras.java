package burgers.Burger_Restaurant.Food;

import java.util.ArrayList;
import java.util.List;

public class Extras {
    enum Type {DRINK, SNACK}

    enum Size {SMALL, MEDIUM, LARGE}

    private String name;
    private Type type;
    private Size size;
    private Double price;

    public Extras(int index) {
        List<Extras> availableExtras = new ArrayList<>(List.of(
                new Extras("Coke", Type.DRINK, Size.SMALL, 2.1),
                new Extras("Coke", Type.DRINK, Size.MEDIUM, 2.6),
                new Extras("Orangeade", Type.DRINK, Size.SMALL, 1.7),
                new Extras("Orangeade", Type.DRINK, Size.MEDIUM, 2.06),
                new Extras("Apple Juice", Type.DRINK, Size.SMALL, 1.85),
                new Extras("Orange Juice", Type.DRINK, Size.SMALL, 1.85),
                new Extras("Black Tea", Type.DRINK, Size.MEDIUM, 2.2),
                new Extras("Green Tea", Type.DRINK, Size.MEDIUM, 2.32),
                new Extras("Black Coffee", Type.DRINK, Size.MEDIUM, 2.15),
                new Extras("Cappuccino", Type.DRINK, Size.MEDIUM, 2.17),
                new Extras("Latte", Type.DRINK, Size.MEDIUM, 2.3),
                new Extras("Fries", Type.SNACK, Size.SMALL, 2.7),
                new Extras("Fries", Type.SNACK, Size.MEDIUM, 3.2),
                new Extras("Fries", Type.SNACK, Size.LARGE, 3.6),
                new Extras("Onion Rings", Type.SNACK, Size.SMALL, 2.94),
                new Extras("Onion Rings", Type.SNACK, Size.MEDIUM, 3.48),
                new Extras("Chicken Strips", Type.SNACK, Size.SMALL, 3.2),
                new Extras("Chicken Strips", Type.SNACK, Size.MEDIUM, 3.7),
                new Extras("Chicken Strips", Type.SNACK, Size.LARGE, 4.2)
        ));
        if (index >= 0 && index < availableExtras.size()) {
            for (int i = 0; i < availableExtras.size(); i++) {
                if (availableExtras.contains(availableExtras.get(index))) {
                    this.name = availableExtras.get(index).getName();
                    this.type = availableExtras.get(index).getType();
                    this.size = availableExtras.get(index).getSize();
                    this.price = availableExtras.get(index).getPrice();
                    break;
                }
            }
        } else {
            try {
                throw new RuntimeException("Unauthorized extra");
            } catch (RuntimeException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
    }

    private Extras(String name, Type type, Size size, Double price) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
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
        String tSize = "";
        if (type == Type.DRINK) {
            switch (size) {
                case SMALL -> tSize = "250ml";
                case MEDIUM -> tSize = "333ml";
                case LARGE -> tSize = "500ml";
            }
        } else if (type == Type.SNACK) {
            switch (size) {
                case SMALL -> tSize = "200g";
                case MEDIUM -> tSize = "300g";
                case LARGE -> tSize = "400g";
            }
        }
        if (name != null) {
            return String.format("%30s : $%.2f", name.toUpperCase().charAt(0) +
                    name.substring(1) + "  " + tSize, price);
        }
        return "Unauthorized extra";
    }
}
