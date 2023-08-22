package burgers.Burger_Restaurant;

import burgers.Burger_Restaurant.Food.Extras;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Extras.ExtrasManager extrasManger = new Extras.ExtrasManager();
        List<Extras> ava = extrasManger.getAvailableExtras();
        Extras extras = new Extras(0);

        System.out.println(extras);
    }
}
