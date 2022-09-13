package Solid.solid.products;

public class Chocolate implements Food {
    public static final double CALORIES_PER_100_GRAMS = 575.0;


    private double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    @Override
    public double getGrams() {
        return grams;
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * getGrams();
    }
}
