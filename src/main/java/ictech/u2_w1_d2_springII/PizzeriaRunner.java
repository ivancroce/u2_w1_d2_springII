package ictech.u2_w1_d2_springII;

import ictech.u2_w1_d2_springII.entities.Menu;
import ictech.u2_w1_d2_springII.entities.MenuItem;
import ictech.u2_w1_d2_springII.entities.Order;
import ictech.u2_w1_d2_springII.entities.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// Turns this class into a Spring Bean. Spring will automatically find it during its component scan.
@Component
public class PizzeriaRunner implements CommandLineRunner {
    // Dependency Injection (DI): Spring finds the Menu bean (there is one only) and "injects" (assigns) it here automatically.
    @Autowired
    private Menu menu;
    // We can read the value from the application.properties file.
    @Value("${cover.charge}")
    private double coverCharge;
    // When there are multiple beans of the same type, @Qualifier specifies which one to use.
    @Autowired
    @Qualifier("table2")
    private Table aSpecificTable;

    @Override
    public void run(String... args) throws Exception {

        menu.printMenu();
        aSpecificTable.printTableInfo();

        /*System.out.println("--- Value of the Cover Charge from the Bean or from the application.properties: " + this.coverCharge);
        System.out.println();*/

        // a list of orderedItems
        List<MenuItem> orderedItems = List.of(
                menu.getPizzas().get(0),
                menu.getPizzas().get(2),
                menu.getDrinks().get(1)
        );

        // otherwise, adding the @Autowired and @Qualifier of the items and then do for example:
        /* List<MenuItem> orderedItems = List.of(
                margherita, salami, water
        ); */

        // or adding a method in Order class, addItem(), call the beans here and add the items:
        // newOrder.addItem(ctx.getBean("pizzaMargherita", Pizza.class))

        Order newOrder = new Order(aSpecificTable, orderedItems, 1, 2, this.coverCharge);

        newOrder.printOrder();
    }
}
