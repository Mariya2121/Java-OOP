package Polymorphism.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;
    protected DecimalFormat df = new DecimalFormat("##.##");

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }


   public String drive(double distance){
        double fuelNeeded = distance * this.getFuelConsumption();

        if (fuelNeeded > this.fuelQuantity){
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuelQuantity -= fuelNeeded;

       return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    public void refuel(double litters){
        if (litters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double newFuelQuantity = fuelQuantity + litters;
        if (newFuelQuantity > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += litters;

    }


    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

}
