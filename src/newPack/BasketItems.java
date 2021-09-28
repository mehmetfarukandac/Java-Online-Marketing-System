package newPack;

public class BasketItems {
    private String product_Name;
    private String product_Price;

    public String getProduct_Name() {
        return product_Name;
    }

    public BasketItems(String productName, String productPrice) {
        this.product_Name = productName;
        this.product_Price = productPrice;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(String product_Price) {
        this.product_Price = product_Price;
    }


}
