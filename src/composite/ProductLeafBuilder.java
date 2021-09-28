package composite;

public class ProductLeafBuilder {
    private String productName;
    private String productID;
    private String price;
    private String companyName;

    public ProductLeafBuilder(String productName, String productID, String price, String companyName) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.companyName = companyName;
    }
    public ProductLeafBuilder(){

    }

    public ProductLeafBuilder(String productName, String price){
        this.productID = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public ProductLeafBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductID() {
        return productID;
    }

    public ProductLeafBuilder setProductID(String productID) {
        this.productID = productID;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public ProductLeafBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ProductLeafBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
}
