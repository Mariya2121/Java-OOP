package WorkingWithAbstraction;

public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);


    public int getDayNumber() {
        return dayNumber;
    }

    private int dayNumber;

    private DayOfWeek(int dayNumber) {
        this.dayNumber = dayNumber;
    }
}
