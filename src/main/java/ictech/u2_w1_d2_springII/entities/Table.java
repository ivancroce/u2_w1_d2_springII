package ictech.u2_w1_d2_springII.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Table {
    private int tableNumber;
    private int maxCovers;
    private boolean isFree;

    public void printTableInfo() {
        System.out.println("========================");
        System.out.println("   --- TABLE INFO ---");
        System.out.println("========================");
        System.out.println("Table Number: " + this.tableNumber);
        System.out.println("Max Covers: " + this.maxCovers);
        System.out.println("Status: " + (this.isFree ? "Free" : "Occupied"));
    }
}
