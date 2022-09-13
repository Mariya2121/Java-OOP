package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(name, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), this.breed,
                formatter.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
