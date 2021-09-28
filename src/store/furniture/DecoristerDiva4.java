package store.furniture;

import operations.ProductStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DecoristerDiva4 extends WardrobeDecorator implements ProductStrategy {
    public static String productId="DCD4";
    public static String productName="Decorister Diva 4";
    public static String price="600";
    public static String companyName="AndacBeyazit";
    public DecoristerDiva4(IWardrobe iWardrobe) {
        super(iWardrobe);
    }

    public DecoristerDiva4() {
        super();
    }
    /*
    0.97 m2
    4 k
    3 Ç
     */

    @Override
    public int getDoor() {
        return super.getDoor() + 1;
    }

    @Override
    public int getDrawer() {
        return super.getDrawer() + 1;
    }

    @Override
    public double getVolume() {
        return super.getVolume() + 0.24;
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
