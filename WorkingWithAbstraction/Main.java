package WorkingWithAbstraction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        //  System.out.println(dayOfWeek.ordinal() + 1);
        // ordinal - реда, започва от 0

        System.out.println(dayOfWeek.getDayNumber());


    }
}
