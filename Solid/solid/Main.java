package Solid.solid;

import solid.products.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Food chips = new Chips(200);
        System.out.println(chips.getGrams());
        System.out.println(chips.getAmountOfCalories());

        Food chocolate = new Chocolate(100);

        List<Product> productList = new ArrayList<>();
        productList.add(chips);
        productList.add(chocolate);

        Beverage coke = new Coke(500);
        productList.add(coke);

        QuantityCalculator quantityCalculator = new QuantityCalculator();
        System.out.println(quantityCalculator.sumOfKilograms(productList));

    }
}
