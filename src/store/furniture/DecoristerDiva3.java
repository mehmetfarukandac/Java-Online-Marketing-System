package store.furniture;

import operations.ProductStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DecoristerDiva3 extends Furniture implements IWardrobe , ProductStrategy {
    public static String productId="DCD3";
    public static String productName="Decorister Diva 3";
    public static String price="600";
    public static String companyName="AndacBeyazit";
    public DecoristerDiva3() {
        super();
    }

      /*
    0.73 m3 volume
    3 kapı
    2 çekmece
     */

    @Override
    public int getDoor() {
        return 3;
    }

    @Override
    public int getDrawer() {
        return 2;
    }

    @Override
    public double getVolume() {
        return 0.73;
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
