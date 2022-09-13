package WorkingWithAbstractionExcercise.CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Suits:");
        Arrays.stream(CardSuits.values())
                .forEach(cardSuits -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuits.ordinal(), cardSuits.name()));
    }
}
