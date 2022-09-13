package DesignPatterns;

public class Car implements Cloneable {
    private String model;
    private int year;
    private String color;
    private int horsepower;

    public Car(String model, int year, String color, int horsepower) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.horsepower = horsepower;
    }

    @Override
    public Car clone() { // Prototype pattern; create new object by copying this prototype
        return new Car(model, year, color, horsepower);
    }
}
