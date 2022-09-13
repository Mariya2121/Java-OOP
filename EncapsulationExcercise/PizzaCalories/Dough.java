package EncapsulationExcercise.PizzaCalories;

import java.util.Arrays;

public class Dough {
    private FlourTypes flourType;
    private BackingTechniqueTypes bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        boolean flourTypeExist = Arrays.stream(FlourTypes.values()).anyMatch(f -> f.name().equals(flourType));
        if (flourTypeExist) {
            this.flourType = FlourTypes.valueOf(flourType);
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean backingTechniqueExist = Arrays.stream(BackingTechniqueTypes.values()).anyMatch(b -> b.name().equals(bakingTechnique));
        if (backingTechniqueExist) {
            this.bakingTechnique = BackingTechniqueTypes.valueOf(bakingTechnique);
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * getBakingTechniqueModifier() * getFlourTypeModifier();
    }

    private double getBakingTechniqueModifier() {
        return bakingTechnique.getModifier();
    }

    private double getFlourTypeModifier() {
        return flourType.getModifier();
    }
}
