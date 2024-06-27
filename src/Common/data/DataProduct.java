package Common.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beust.jcommander.internal.Lists;

public class DataProduct {

    public static Map<String, String> namePriceMap = new HashMap<>();
    static {
        addProduct("Sauce Labs Backpack", "29.99");
        addProduct("Sauce Labs Bike Light", "9.99");
        addProduct("Sauce Labs Bolt T-Shirt", "15.99");
        addProduct("Sauce Labs Fleece Jacket", "49.99");
        addProduct("Sauce Labs Onesie", "7.99");
        addProduct("Test.allTheThings() T-Shirt (Red)", "15.99");
     
    }


    private static void addProduct(String productName, String price) 
    {
        namePriceMap.put(productName, price);
    }


    public static String getPrice(String productName)
    {
        return namePriceMap.get(productName);
    }

    public static void clearProductData() {
        namePriceMap.clear();
    }
	
}
