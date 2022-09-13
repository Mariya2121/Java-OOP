package ReflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String modifier = scanner.nextLine();

        while (!modifier.equals("HARVEST")) {

            Class<RichSoilLand> clazz = RichSoilLand.class;
            Field[] declaredFields = clazz.getDeclaredFields();
            if (modifier.equals("all")) {
                Arrays.stream(declaredFields)
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
                modifier = scanner.nextLine();
                continue;
            }
            printByModifier(declaredFields, modifier);
            modifier = scanner.nextLine();
        }
    }

    public static void printByModifier(Field[] fields, String modifier) {
        Arrays.stream(fields)
                .filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
                .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
    }
}
