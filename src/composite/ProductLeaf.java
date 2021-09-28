package composite;

public class ProductLeaf extends ProductLeafBuilder{
    private String productName;
    private String price;
    private String companyName;
    private String productID;

    public ProductLeaf(String productName, String price, String companyName, String productID) {
        super();
        this.productName = productName;
        this.price = price;
        this.companyName = companyName;
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "ProductLeaf{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }
}
