package store.food;

import store.IProduct;

public class Food implements IProduct {
    private String name = "food";
    private int price = 465;

    public Food() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
