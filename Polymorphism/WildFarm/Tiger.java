package Polymorphism.WildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {

        if (food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }
}
