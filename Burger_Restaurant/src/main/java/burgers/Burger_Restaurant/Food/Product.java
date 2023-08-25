package burgers.Burger_Restaurant.Food;

public class Product {

    private String name;
    private Double price;

    public Product(String name) {
        this.name = name;
        price = (double) 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%29s : $%6.2f%n", this.getName(), this.getPrice());
    }
}
