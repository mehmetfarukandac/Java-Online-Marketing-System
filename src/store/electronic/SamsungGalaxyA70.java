package store.electronic;

import operations.ProductStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SamsungGalaxyA70 extends PhoneDecorater implements ProductStrategy {
    public static String productId="SGA70";
    public static String productName="Samsung Galaxy A70";
    public static String price="1800";
    public static String companyName="AndacBeyazit";
    public SamsungGalaxyA70(IPhone phone) {
        super(phone);
    }

    public SamsungGalaxyA70() {
        super();
    }
    /*
    6.7 inc
    128 gb memory
    6 gb ram
    4500 ma batery
    32 mp
     */

    @Override
    public double getBattery() {
        return super.getBattery()  + 500;
    }

    @Override
    public int getPixel() {
        return super.getPixel() + 16;
    }

    @Override
    public double getInch() {
        return super.getInch() +0.3;
    }

    @Override
    public int getRam() {
        return super.getRam() +2;
    }

    @Override
    public int getMemory() {
        return super.getMemory() + 64;
    }

    @Override
    public String toString() {
        return "SamsungGalaxyA70{}";
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