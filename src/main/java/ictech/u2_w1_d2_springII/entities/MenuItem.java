package ictech.u2_w1_d2_springII.entities;

public abstract class MenuItem {
    protected int calories;
    protected double price;

    public MenuItem(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getName();
}
