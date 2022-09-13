package OOPExams.christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {
    private static final double CUBIC_CENTIMETERS = 5000;
//    private static final int MINIMUM_HORSE_POWER = 400;
//    private static final int MAXIMUM_HORSE_POWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model,horsePower, CUBIC_CENTIMETERS);
    }

}

