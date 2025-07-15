package ictech.u2_w1_d2_springII.entities;

import ictech.u2_w1_d2_springII.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private Table table;
    private List<MenuItem> orderedItems;
    private int orderNumber;
    private OrderStatus orderStatus;
    private int numberOfCovers;
    private LocalDateTime acquisitionTime;
    private double total;
    private double coverChargeValue;

    public Order(Table table, List<MenuItem> orderedItems, int orderNumber, int numberCovers, double coverCharge) {
        this.table = table;
        this.orderedItems = orderedItems;
        this.orderNumber = orderNumber;
        this.orderStatus = OrderStatus.IN_PROGRESS;
        this.numberOfCovers = numberCovers;
        this.acquisitionTime = LocalDateTime.now();
        this.total = totalCalc(coverCharge);
        this.coverChargeValue = coverCharge;
    }

    // Method to calculate the total
   /* private double totalCalc(double coverCharge) {
        double itemsTotal = 0;
        // for each item in the orderedItems list, get the price and add it to the itemsTotal
        for (MenuItem item : this.orderedItems) {
            itemsTotal += item.getPrice();
        }

        double coversTotal = this.numberOfCovers * coverCharge;
        return itemsTotal + coversTotal;
    }*/

    // otherwise with .stream.mapToDouble.sum
    public double totalCalc(double coverCharge) {
        double itemsTotal = this.orderedItems.stream().mapToDouble(MenuItem::getPrice).sum();
        double coversTotal = this.numberOfCovers * coverCharge;
        return itemsTotal + coversTotal;
    }

    public void printOrder() {
        System.out.println("========================");
        System.out.println("   --- ORDER ---");
        System.out.println("========================");
        System.out.println("Order Number: " + this.orderNumber);
        System.out.println("Table Number: " + this.table.getTableNumber());
        System.out.println("Covers: " + this.numberOfCovers);
        System.out.println("Status: " + this.orderStatus);
        System.out.printf("Time: %td/%tm/%tY %tH:%tM:%tS%n", this.acquisitionTime, this.acquisitionTime, this.acquisitionTime, this.acquisitionTime, this.acquisitionTime, this.acquisitionTime);

        System.out.println("Ordered Items: ");
        for (MenuItem item : this.orderedItems) {
            System.out.println("- " + item.getName() + " (Price: " + item.getPrice() + " $)");
        }
        double coversCost = this.numberOfCovers * this.coverChargeValue;
        System.out.println("Cover Charge (" + this.numberOfCovers + " x " + this.coverChargeValue + "): " + coversCost + " $");

        System.out.println("--------------------------");
        System.out.println("Total: " + this.total + " $");
        System.out.println("========================");
    }
}


