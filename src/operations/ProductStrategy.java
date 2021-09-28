package operations;

import java.io.IOException;

public interface ProductStrategy {
    void write(String productID,String productName,String productPrice,String CompanyName) throws IOException;
}
