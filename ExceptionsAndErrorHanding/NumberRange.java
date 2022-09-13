import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

public class NumberRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startIndex = range[0];
        int endIndex = range[1];

        System.out.printf("Range: [%d...%d]%n", startIndex, endIndex);

        String input = scanner.nextLine();
        boolean isInRange = false;

        while (!isInRange){
            Optional<Integer> number = Optional.empty();
            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (NumberFormatException ignored) {
            }

            if (number.isEmpty() || number.get() < startIndex || number.get() > endIndex){
                System.out.println("Invalid number: " + input);
                input = scanner.nextLine();
            }
            else {
                isInRange = true;
            }
        }

        System.out.println("Valid number: " + input);

    }
}
