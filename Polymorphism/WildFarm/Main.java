package Polymorphism.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String typeOfAnimal = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];

            Animal animal = null;

            if (typeOfAnimal.equals("Cat")) {
                animal = new Cat(animalName, typeOfAnimal, animalWeight, animalLivingRegion, tokens[4]);
            } else if (typeOfAnimal.equals("Tiger")) {
                animal = new Tiger(animalName, typeOfAnimal, animalWeight, animalLivingRegion);

            } else if (typeOfAnimal.equals("Zebra")) {
                animal = new Zebra(animalName, typeOfAnimal, animalWeight, animalLivingRegion);

            } else if (typeOfAnimal.equals("Mouse")) {
                animal = new Mouse(animalName, typeOfAnimal, animalWeight, animalLivingRegion);
            }
            animals.add(animal);
            animal.makeSound();

            String foodInput = scanner.nextLine();
            Food food = getFood(foodInput.split(" "));

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    public static Food getFood(String[] tokens) {
        String type = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        if (type.equals("Meat")) {
            return new Meat(quantity);
        } else return new Vegetable(quantity);
    }
}
