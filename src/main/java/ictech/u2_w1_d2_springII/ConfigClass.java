package ictech.u2_w1_d2_springII;

import ictech.u2_w1_d2_springII.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration // mandatory annotation to tell Spring that this class contains Beans
@PropertySource("application.properties") // to read values
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

    // Use @Bean when you need explicit control over object creation, especially if you want to create multiple different variants from the same class.
    // You tell Spring how to create the object.
    // This method creates a Pizza object and registers it as a "Bean" in the Spring container.
    // It will be created at startup and can be injected elsewhere using @Autowired.
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

    // create bean to read the cover charge value, as the main can't read it
    /*@Bean
    public double getCoverCharge(@Value("${cover.charge}") double coverCharge) {
        return coverCharge;
    }*/

    // Tables
    @Bean
    public Table table1() {
        return new Table(1, 4, false);
    }

    @Bean
    public Table table2() {
        return new Table(2, 6, false);
    }

    @Bean
    public Table table3() {
        return new Table(3, 2, false);
    }
}
