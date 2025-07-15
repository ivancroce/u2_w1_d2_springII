package ictech.u2_w1_d2_springII.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;
    
    public void printMenu() {
        System.out.println();
        System.out.println("========================");
        System.out.println("  Aldo Baglio's Pizza");
        System.out.println("========================");
        System.out.println("   ----- MENU -----");
        System.out.println("========================");
        System.out.println("----- Pizza -----");
        for (Pizza pizza : this.pizzas) {
            System.out.println(pizza.getName() + " - Calories: " + pizza.getCalories() + " - Price: " + pizza.getPrice());
        }
        System.out.println();
        System.out.println("----- Extra Toppings -----");
        for (Topping topping : this.toppings) {
            System.out.println(topping.getName() + " - Calories: " + topping.getCalories() + " - Price: " + topping.getPrice());
        }
        System.out.println();
        System.out.println("----- Drinks -----");
        for (Drink drink : this.drinks) {
            System.out.println(drink.getName() + " - Calories: " + drink.getCalories() + " - Price: " + drink.getPrice());
        }
        System.out.println();
    }

}
