package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    double fuelQuantity;
    double fuelConsumption;
    protected DecimalFormat df = new DecimalFormat("##.##");

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected Boolean canDrive(double distance) {
        double totalFuelCost = distance * getFuelConsumption();
        return totalFuelCost <= getFuelQuantity();
    }

    protected void consumeFuel(double kilometers) {
        fuelQuantity -=  kilometers * getFuelConsumption();
    }

    abstract String drive(double distance);

    abstract void refuel(double litters);

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
    public void printFuelQuantity(){
        System.out.printf("%.2f%n", fuelQuantity);
    }

}
