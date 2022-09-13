package Polymorphism.VehiclesExtension;


public class Truck extends Vehicle {
    private static final double REFILL_PERCENTAGE = 0.95;
    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, tankCapacity);
    }

    //
//    @Override
//    public void setFuelConsumption(double fuelConsumption) {
//        this.fuelConsumption = fuelConsumption + FUEL_CONSUMPTION_INCREASE;
//    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFILL_PERCENTAGE);
    }

}
