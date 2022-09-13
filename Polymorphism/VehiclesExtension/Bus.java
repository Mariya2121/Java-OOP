package Polymorphism.VehiclesExtension;

public class Bus extends Vehicle {
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.4;
    private Boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = true;
    }
    public void setEmpty(boolean empty) {
        if (this.isEmpty == empty) {
            return;
        }

        if(this.isEmpty && !empty){
            super.setFuelConsumption(super.getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
        }

        if(!this.isEmpty && empty){
            super.setFuelConsumption(super.getFuelConsumption() - AC_ADDITIONAL_CONSUMPTION);
        }

        this.isEmpty = empty;
    }


}
