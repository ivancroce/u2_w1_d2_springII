package ictech.u2_w1_d2_springII;

import ictech.u2_w1_d2_springII.entities.Drink;
import ictech.u2_w1_d2_springII.entities.Menu;
import ictech.u2_w1_d2_springII.entities.Pizza;
import ictech.u2_w1_d2_springII.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration // mandatory annotation to tell Spring that this class contains Beans
public class ConfigClass {
    // list of obj needed when starting the app

    // ----- Toppings -----
    @Bean(name = "cheese")
    public Topping toppingCheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean(name = "ham")
    public Topping toppingHam() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean(name = "onions")
    public Topping toppingOnions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean(name = "forbiddenWord")
    public Topping toppingPineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean(name = "salami")
    public Topping toppingSalami() {
        return new Topping("Salami", 86, 0.99);
    }

    // ----- Pizza -----
    @Bean
    public Pizza pizzaMargherita() {
        return new Pizza(1104, 4.99, "Pizza Margherita");
    }

    @Bean
    public Pizza pizzaHawaiian() {
        return new Pizza(1024, 6.49, "Pizza Hawaiian").addTopping(toppingHam()).addTopping(toppingPineapple());
    }

    @Bean
    public Pizza pizzaSalami() {
        return new Pizza(1160, 5.99, "Pizza Salami").addTopping(toppingSalami());
    }

    // ----- Drinks -----
    @Bean
    public Drink drinkLemonade() {
        return new Drink("Lemonade (0.33l)", 128, 1.29);
    }

    @Bean
    public Drink drinkWater() {
        return new Drink("Water (0.5l)", 0, 1.29);
    }

    @Bean
    public Drink drinkWine() {
        return new Drink("Wine (0.75l, 13%)", 607, 7.49);
    }

    // Spring will look through the beans and fill all the lists
    @Bean
    public Menu menu(List<Pizza> pizzaList, List<Topping> toppingList, List<Drink> drinkList) {
        return new Menu(pizzaList, toppingList, drinkList);
    }

    /*@Bean
    public Menu menu() {
        List<Pizza> pizzaList = List.of(pizzaMargherita(), pizzaHawaiian(), pizzaSalami());
        List<Topping> toppingList = List.of(toppingCheese(), toppingHam(), toppingPineapple(), toppingOnions(), toppingSalami());
        List<Drink> drinkList = List.of(drinkWater(), drinkLemonade(), drinkWine());

        return new Menu(pizzaList, toppingList, drinkList);
    }*/
}
