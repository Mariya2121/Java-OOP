package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < n - i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 1; i <= n - 1; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < n - i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }

        printRhombus(n);
    }

    public static void printRhombus(int size) {
        //Print count number of lines

        for (int i = 1; i <= size; i++) {
            printUpperPart(size, i);
        }
        for (int i = 1; i < size; i++) {
            printBottom(size, i);
        }
    }

    private static void printUpperPart(int size, int i) {
        // Print decreasing pattern
        for (int j = 0; j < size - i; j++) {
            System.out.print(" ");
        }
        //Print increasing pattern
        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printBottom(int size, int i) {
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < size - i ; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
