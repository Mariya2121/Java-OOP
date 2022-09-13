package EncapsulationExcercise.ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personData = scanner.nextLine().split(";");
        String[] productData = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        for (String personInput : personData) {
            String[] data = personInput.split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (String productInput : productData) {
            String[] data = productInput.split("=");
            String name = data[0];
            double cost = Double.parseDouble(data[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String personName = data[0];
            String productName = data[1];

            try {
                people.get(personName).buyProduct(products.get(productName));
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        for (Person person : people.values()) {
            System.out.println(person.toString());
        }


    }
}
