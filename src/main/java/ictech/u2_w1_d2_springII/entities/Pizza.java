package ictech.u2_w1_d2_springII.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {
    private String name;
    private List<Topping> toppings;

    public Pizza(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
        this.toppings = new ArrayList<>();
    }

    public Pizza addTopping(Topping topping) {
        this.toppings.add(topping);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", toppings=" + toppings +
                ", calories=" + calories +
                ", price=" + price +
                "} " + super.toString();
    }
}
