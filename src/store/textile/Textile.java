package store.textile;

import store.IProduct;

public class Textile implements IProduct {
    private String name = "store/textile";
    private int price = 24;

    public Textile() {
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
        return "Textile{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
