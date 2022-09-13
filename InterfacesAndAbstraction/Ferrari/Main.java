package InterfacesAndAbstraction.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drivenName = scanner.nextLine();

        Car ferrari = new Ferrari(drivenName);
        System.out.println(ferrari);
    }
}
