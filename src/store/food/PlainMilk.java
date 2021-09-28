package store.food;

import operations.ProductStrategy;
import store.food.Food;
import store.food.IMilk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlainMilk extends Food implements IMilk , ProductStrategy {
    public static String productId="PLM1";
    public static String productName="Plain Milk";
    public static String price="10";
    public static String companyName="AndacBeyazit";
    public PlainMilk() {
        super();
    }

    /*
    1000 ml
    34 gr protein
     */

    @Override
    public double getProtein() {
        return 34;
    }

    @Override
    public int getMililiter() {
        return 1000;
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
