package store.textile;

import operations.ProductStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ZebraCurtain extends Textile implements ICurtain, ProductStrategy {
    public static String productId="ZC1";
    public static String productName="Zebra Curtain";
    public static String price="500";
    public static String companyName="AndacBeyazit";

    public ZebraCurtain() {
        super();
    }
    /*
    lenght 150 cm
    Striped
     */

    @Override
    public int getLenght() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Striped";
    }

    @Override
    public void write(String productID, String productName, String productPrice, String CompanyName) throws IOException {
        File file = new File("Products.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        if (file.length() != 337) {
            if (file.length() != 0) {
                writer.newLine();
            }
            writer.write(productID);
            writer.newLine();
            writer.write(productName);
            writer.newLine();
            writer.write(productPrice);
            writer.newLine();
            writer.write(CompanyName);

            writer.close();
        }
    }
}
