package store.electronic;

import operations.ProductStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SamsungGalaxyA30 extends Electronic implements IPhone, ProductStrategy {
    public static String productId="SGA30";
    public static String productName="Samsung Galaxy A30";
    public static String price="1500";
    public static String companyName="AndacBeyazit";

    public SamsungGalaxyA30() {
        super();
    }

         /*
        6.4 inc
        64gb memory
        4gb ram
        4000 batery
        16 mp
         */

    @Override
    public double getBattery() {
        return 4000;
    }

    @Override
    public int getPixel() {
        return 16;
    }

    @Override
    public double getInch() {
        return 6.4;
    }

    @Override
    public int getRam() {
        return 4;
    }

    @Override
    public int getMemory() {
        return 64;
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
