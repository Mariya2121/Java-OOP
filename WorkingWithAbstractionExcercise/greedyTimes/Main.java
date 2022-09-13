
package WorkingWithAbstractionExcercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();


        for (int i = 0; i < safe.length; i += 2) {
            String item = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            String typesOfItems = "";

            if (item.length() == 3) {
                typesOfItems = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                typesOfItems = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                typesOfItems = "Gold";
            }

            if (typesOfItems.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (typesOfItems) {
                case "Gem":
                    if (!bag.containsKey(typesOfItems)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typesOfItems).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(typesOfItems)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typesOfItems).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(typesOfItems)) {
                bag.put((typesOfItems), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(typesOfItems).containsKey(item)) {
                bag.get(typesOfItems).put(item, 0L);
            }

            long gold = 0;
            long stones = 0;
            long money = 0;

            bag.get(typesOfItems).put(item, bag.get(typesOfItems).get(item) + quantity);
            if (typesOfItems.equals("Gold")) {
                gold += quantity;
            } else if (typesOfItems.equals("Gem")) {
                stones += quantity;
            } else if (typesOfItems.equals("Cash")) {
                money += quantity;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", x.getKey(), sumValues);

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}