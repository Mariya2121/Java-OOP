package Polymorphism.Vehicles;

public class Truck extends Vehicle {
    private static final double TINY_HOLE = 0.95;
    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    String drive(double distance) {
        if (canDrive(distance)) {
            consumeFuel(distance);
            return "Truck travelled " + super.df.format(distance) + " km";
        }
        return "Truck needs refueling";
    }


    @Override
    void refuel(double litters) {
        setFuelQuantity(getFuelQuantity() + (litters * TINY_HOLE));
    }
    @Override
    public void printFuelQuantity(){
        System.out.print("Truck: ");
        super.printFuelQuantity();
    }
}
