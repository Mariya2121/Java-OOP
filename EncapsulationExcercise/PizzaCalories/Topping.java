package EncapsulationExcercise.PizzaCalories;

import java.util.Arrays;

public class Topping {
    private ToppingTypes toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        boolean toppingExist = Arrays.stream(ToppingTypes.values()).anyMatch(t -> t.name().equals(toppingType));
        if (toppingExist) {
            this.toppingType = ToppingTypes.valueOf(toppingType);
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * getToppingModifiers();
    }

    private double getToppingModifiers() {
        return toppingType.getModifier();
    }
}
