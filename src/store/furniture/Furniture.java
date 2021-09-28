package store.furniture;

import store.IProduct;

public class Furniture implements IProduct {
    private String name = "furniture";
    private int price = 1000;

    public Furniture() {
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
        return "Furniture{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
