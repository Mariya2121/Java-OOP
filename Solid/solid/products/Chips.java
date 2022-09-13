package Solid.solid.products;

public class Chips implements Food{
    public static final double CALORIES_PER_100_GRAMS = 529.0;

    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * getGrams();
    }

    @Override
    public double getGrams() {
        return grams;
    }
}
