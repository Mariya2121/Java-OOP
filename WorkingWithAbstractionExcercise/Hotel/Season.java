package WorkingWithAbstractionExcercise.Hotel;

public class Season {
    private String name;
    private String[] months;
    private double averageTemp;


    public Season(String name, double averageTemp, String... months) {
        this.name = name;
        this.months = months;
        this.averageTemp = averageTemp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(double averageTemp) {
        this.averageTemp = averageTemp;
    }
}
