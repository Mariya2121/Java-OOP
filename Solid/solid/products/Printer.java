package Solid.solid.products;

import solid.CalorieCalculator;

import java.util.List;

public class Printer extends CalorieCalculator {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", super.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", super.average(products));
    }
}
