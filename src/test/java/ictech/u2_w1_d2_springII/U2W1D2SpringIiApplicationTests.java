package ictech.u2_w1_d2_springII;

import ictech.u2_w1_d2_springII.entities.Menu;
import ictech.u2_w1_d2_springII.entities.MenuItem;
import ictech.u2_w1_d2_springII.entities.Order;
import ictech.u2_w1_d2_springII.entities.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U2W1D2SpringIiApplicationTests {

    @Autowired
    private Menu menu;

    @Autowired
    @Qualifier("table2")
    private Table table;

    @Value("${cover.charge}")
    private double coverCharge;

    // test total newOrder from runner
    @Test
    void testOrderTotalCorrectlyInRunner() {

        MenuItem pizza1 = menu.getPizzas().get(0); // margherita
        MenuItem pizza2 = menu.getPizzas().get(2); // salami
        MenuItem drink1 = menu.getDrinks().get(1); // water

        List<MenuItem> orederedItems = List.of(pizza1, pizza2, drink1);

        double expectedItemsTotal = pizza1.getPrice() + pizza2.getPrice() + drink1.getPrice();
        double expectedCoversTotal = 2 * coverCharge;
        double expectedTotal = expectedItemsTotal + expectedCoversTotal;
        System.out.println("Expected Total: " + expectedTotal);

        Order newOrder = new Order(table, orederedItems, 1, 2, this.coverCharge);
        System.out.println("Total from newOrder in runner: " + newOrder.getTotal());

        assertEquals(expectedTotal, newOrder.getTotal());
    }

    // ParameterizedTest testing the total with the same order but with different number of covers
    @ParameterizedTest
    @CsvSource({"2, 18.27", "5, 27.27", "3, 21.27"})
    void testOrderTotalCorrectlyWithDiffNumbOfCovers(int numberOfCovers, double expectedTotal) {

        MenuItem pizza1 = menu.getPizzas().get(0); // pizzaMargherita
        MenuItem pizza2 = menu.getPizzas().get(2); // pizzaSalami
        MenuItem drink1 = menu.getDrinks().get(1); // drinkWater

        List<MenuItem> orederedItems = List.of(pizza1, pizza2, drink1);

        Order newOrder = new Order(table, orederedItems, 1, numberOfCovers, this.coverCharge);

        assertEquals(expectedTotal, newOrder.getTotal());
    }

}

