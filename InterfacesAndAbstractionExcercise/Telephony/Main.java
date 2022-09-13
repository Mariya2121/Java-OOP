package InterfacesAndAbstractionExcercise.Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> history = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone phone = new Smartphone(phoneNumbers, history);
        System.out.println(phone.call());
        System.out.println(phone.browse());

    }
}
