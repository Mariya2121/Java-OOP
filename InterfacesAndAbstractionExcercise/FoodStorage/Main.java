package InterfacesAndAbstractionExcercise.FoodStorage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Buyer buyer = null;

            if (data.length == 3) {
                buyer = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
            } else {
                buyer = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
            }
            buyerMap.put(data[0], buyer);
        }

        String name = scanner.nextLine();

        while (!name.equals("End")) {
            Buyer buyer = buyerMap.get(name);

            if (buyer != null) {
                buyer.buyFood();
            }
            name = scanner.nextLine();
        }

        System.out.println(buyerMap.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
