package InterfacesAndAbstractionExcercise.BirthdayCelebrations;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            if (data[0].equals("Citizen")) {
                Birthable citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                birthables.add(citizen);
            }
            else if (data[0].equals("Robot")){
                Identifiable robot = new Robot(data[1],data[2]);
            }
            else {
                Birthable pet = new Pet(data[1],data[2]);
                birthables.add(pet);
            }
            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        List<Birthable> collect = birthables.stream().filter(b -> b.getBirthDate().endsWith(year)).collect(Collectors.toList());

        if (collect.isEmpty()){
            System.out.println("<no output>");
        }
        else {
            collect.forEach(e -> System.out.println(e.getBirthDate()));
        }
    }
}
