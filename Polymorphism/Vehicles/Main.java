package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split(" ");
        String[] truckData = scanner.nextLine().split(" ");

        Car car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Truck truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            if (command[0].equals("Drive")) {
                if (command[1].equals("Car")) {
                    System.out.println(car.drive(Double.parseDouble(command[2])));
                } else {
                    System.out.println(truck.drive(Double.parseDouble(command[2])));
                }
            } else {
                if (command[1].equals("Car")) {
                    car.refuel(Double.parseDouble(command[2]));
                } else {
                    truck.refuel(Double.parseDouble(command[2]));
                }

            }
        }

        car.printFuelQuantity();
        truck.printFuelQuantity();

    }
}
