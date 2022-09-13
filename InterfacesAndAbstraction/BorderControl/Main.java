package InterfacesAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            Identifiable identifiable = commands.length == 2
                    ? new Robot(commands[0], commands[1])
                    : new Citizen(commands[0], Integer.parseInt(commands[1]), commands[2]);

            identifiables.add(identifiable);
            input = scanner.nextLine();
        }

        String fakeIdPostfix = scanner.nextLine();

        identifiables.stream().map(Identifiable::getId).filter(i -> i.endsWith(fakeIdPostfix)).forEach(System.out::println);
    }
}
