package store.textile;

import operations.ProductStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BackgroundCurtain extends CurtainDecorator implements ProductStrategy {
    public static String productId="BC1";
    public static String productName="Background Curtain";
    public static String price="600";
    public static String companyName="AndacBeyazit";
    public BackgroundCurtain() {
        super();
    }
    public BackgroundCurtain(ICurtain iCurtain) {
        super(iCurtain);
    }
    /*
    200 cm
    Striped and tulle
     */

    @Override
    public int getLenght() {
        return super.getLenght() + 50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " and tulle";
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
