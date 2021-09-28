package store.food;

import operations.ProductStrategy;
import store.food.IMilk;
import store.food.MilkDecorator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProteinMilk extends MilkDecorator implements ProductStrategy {
    public static String productId="PRM1";
    public static String productName="Protein Milk";
    public static String price="15";
    public static String companyName="AndacBeyazit";


    public ProteinMilk(IMilk newIMilk) {
        super(newIMilk);
    }

    public ProteinMilk() {
        super();
    }

    @Override
    public double getProtein() {
        return super.getProtein() + 18;
    }

    @Override
    public int getMililiter() {
        return super.getMililiter();
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
