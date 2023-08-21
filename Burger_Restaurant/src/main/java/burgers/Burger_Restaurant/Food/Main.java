package burgers.Burger_Restaurant.Food;

public class Main {
    public static void main(String[] args) {
        Burger burger = Burger.createCustomBurger(Burger.Bun.SESAME, 50,101,222,4);
        System.out.println(burger);

        Burger burger1 = new Burger(9);
        System.out.println(burger1);

    }
}
