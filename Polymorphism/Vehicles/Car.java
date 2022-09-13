package Polymorphism.Vehicles;


public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    String drive(double distance) {
        if (canDrive(distance)) {
            consumeFuel(distance);
            return "Car travelled " + super.df.format(distance) + " km";
        }
        return "Car needs refueling";
    }

    @Override
    void refuel(double litters) {
        setFuelQuantity(getFuelQuantity() + litters);
    }

    @Override
    public void printFuelQuantity(){
        System.out.print("Car: ");
        super.printFuelQuantity();
    }
}
