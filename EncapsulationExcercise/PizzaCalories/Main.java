package EncapsulationExcercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weight = Double.parseDouble(doughData[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            Dough dough = new Dough(flourType, bakingTechnique, weight);

            pizza.setDough(dough);

            String toppings = scanner.nextLine();

            while (!toppings.equals("END")) {
                String[] toppingsData = toppings.split(" ");
                String toppingType = toppingsData[1];
                double toppingWeight = Double.parseDouble(toppingsData[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
                toppings = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
