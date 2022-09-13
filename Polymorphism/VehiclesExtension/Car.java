package Polymorphism.VehiclesExtension;

public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION_INCREASE, tankCapacity);
    }

//    @Override
//    public void setFuelConsumption(double fuelConsumption) {
//        super.setFuelConsumption(fuelConsumption + FUEL_CONSUMPTION_INCREASE);
//    }


}
