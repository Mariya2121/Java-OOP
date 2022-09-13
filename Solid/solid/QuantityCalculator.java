package Solid.solid;

import solid.products.Beverage;
import solid.products.Food;
import solid.products.Product;

import java.util.List;

public class QuantityCalculator {

    public double sumOfKilograms(List<Product> products) {
        double totalGrams = 0;

        for (Product product : products) {
            if (product instanceof Beverage) {
                totalGrams += ((Beverage) product).getMilliliters() * ((Beverage) product).getDensity();
            } else {
                totalGrams += ((Food) product).getGrams();
            }

        }
        return totalGrams;
    }
}
