package WorkingWithAbstractionExcercise.Hotel;

public enum Seasons {
    SUMMER("Summer", 25, "July", "August"), // викаме конструктура директно; казваме директно кои са нашите обекти
    WINTER("Winter", 5, "December", "January"),
    SPRING("Spring", 5, "April", "May"),
    AUTUMN("Autumn", 15, "September, October");

    private String name;
    private String[] months;
    private double averageTemp;


    Seasons(String name, double averageTemp, String... months) {
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
