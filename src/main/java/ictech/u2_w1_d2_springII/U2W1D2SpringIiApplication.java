package ictech.u2_w1_d2_springII;

import ictech.u2_w1_d2_springII.entities.Drink;
import ictech.u2_w1_d2_springII.entities.Pizza;
import ictech.u2_w1_d2_springII.entities.Topping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U2W1D2SpringIiApplication {

    public static void main(String[] args) {

        SpringApplication.run(U2W1D2SpringIiApplication.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigClass.class);

        System.out.println();
        System.out.println("********** Pizzeria by Aldo Baglio **********");
        System.out.println();
        /*Menu menu = ctx.getBean("menu", Menu.class);

        System.out.println("********** MENU **********");
        System.out.println("----- Pizza -----");
        for (Pizza pizza : menu.getPizzas()) {
            System.out.println(pizza.getName() + " - Calories: " + pizza.getCalories() + " - Price: " + pizza.getPrice());
        }
        System.out.println();

        System.out.println("----- Extra Toppings -----");
        for (Topping topping : menu.getToppings()) {
            System.out.println(topping.getName() + " - Calories: " + topping.getCalories() + " - Price: " + topping.getPrice());
        }
        System.out.println();

        System.out.println("----- Drinks -----");
        for (Drink Drink : menu.getDrinks()) {
            System.out.println(Drink.getName() + " - Calories: " + Drink.getCalories() + " - Price: " + Drink.getPrice());
        }*/

        // no menu class, same as lesson, more code:
        System.out.println("********** MENU **********");
        System.out.println("----- Pizza -----");
        Pizza margherita = ctx.getBean("pizzaMargherita", Pizza.class);
        System.out.println(margherita.getName() + " - Calories: " + margherita.getCalories() + " - Price: " + margherita.getPrice());

        Pizza hawaiian = ctx.getBean("pizzaHawaiian", Pizza.class);
        System.out.println(hawaiian.getName() + " - Calories: " + hawaiian.getCalories() + " - Price: " + hawaiian.getPrice());

        Pizza salami = ctx.getBean("pizzaSalami", Pizza.class);
        System.out.println(salami.getName() + " - Calories: " + salami.getCalories() + " - Price: " + salami.getPrice());
        System.out.println();

        // extra toppings
        System.out.println("----- Extra Toppings -----");
        Topping cheese = ctx.getBean("cheese", Topping.class);
        System.out.println(cheese.getName() + " - Calories: " + cheese.getCalories() + " - Price: " + cheese.getPrice());

        Topping ham = ctx.getBean("ham", Topping.class);
        System.out.println(ham.getName() + " - Calories: " + ham.getCalories() + " - Price: " + ham.getPrice());

        Topping forbiddenWord = ctx.getBean("forbiddenWord", Topping.class);
        System.out.println(forbiddenWord.getName() + " - Calories: " + forbiddenWord.getCalories() + " - Price: " + forbiddenWord.getPrice());

        Topping onions = ctx.getBean("onions", Topping.class);
        System.out.println(onions.getName() + " - Calories: " + onions.getCalories() + " - Price: " + onions.getPrice());

        Topping salamiTopping = ctx.getBean("salami", Topping.class);
        System.out.println(salamiTopping.getName() + " - Calories: " + salamiTopping.getCalories() + " - Price: " + salamiTopping.getPrice());
        System.out.println();

        // drinks
        System.out.println("----- Drinks -----");
        Drink drinkWater = ctx.getBean("drinkWater", Drink.class);
        System.out.println(drinkWater.getName() + " - Calories: " + drinkWater.getCalories() + " - Price: " + drinkWater.getPrice());


        Drink drinkLemonade = ctx.getBean("drinkLemonade", Drink.class);
        System.out.println(drinkLemonade.getName() + " - Calories: " + drinkLemonade.getCalories() + " - Price: " + drinkLemonade.getPrice());

        Drink drinkWine = ctx.getBean("drinkWine", Drink.class);
        System.out.println(drinkWine.getName() + " - Calories: " + drinkWine.getCalories() + " - Price: " + drinkWine.getPrice());

        ctx.close();
    }

}
