package InheritanceExcercise.Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfAnimal = scanner.nextLine();
        String animalInfo = scanner.nextLine();

        while (!animalInfo.equals("Beast!")) {
            String[] commands = animalInfo.split("\\s+");
            try {
                switch (typeOfAnimal) {
                    case "Dog":
                        Dog dog = new Dog(commands[0], Integer.parseInt(commands[1]), commands[2]);
                        System.out.println(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(commands[0], Integer.parseInt(commands[1]), commands[2]);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(commands[0], Integer.parseInt(commands[1]), commands[2]);
                        System.out.println(frog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(commands[0], Integer.parseInt(commands[1]), commands[2]);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(commands[0], Integer.parseInt(commands[1]), commands[2]);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            typeOfAnimal = scanner.nextLine();
            animalInfo = scanner.nextLine();
        }
    }
}
