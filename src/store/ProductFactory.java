package store;

import store.electronic.Electronic;
import store.food.Food;
import store.furniture.Furniture;
import store.textile.Textile;

public class ProductFactory {

    public IProduct getProduct(String product) {
        IProduct product1=null;

        if (product.equalsIgnoreCase("electronic")){
            product1=new Electronic();
        }
        else if(product.equalsIgnoreCase("food")){
            product1= new Food();
        }
        else if (product.equalsIgnoreCase("furniture")){
            product1= new Furniture();
        }
        else if(product.equalsIgnoreCase("store/textile")){
            product1= new Textile();
        }
        else{
            System.out.println("Geçersiz Ürün");
        }
        return product1;
    }

}