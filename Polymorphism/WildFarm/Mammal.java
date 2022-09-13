package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType,animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }
    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(),
                formatter.format(getAnimalWeight()), this.livingRegion, getFoodEaten());
    }
}
