package Polymorphism.WildFarm;

public class Zebra extends  Mammal{
    public Zebra(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
