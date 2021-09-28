package store.electronic;

import store.IProduct;

public class Electronic implements IProduct {
    private String name;
    private int price;

    public Electronic() {
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
        return "Electronic{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
