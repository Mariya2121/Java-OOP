package WorkingWithAbstraction.HotelReservation;

public enum Discount {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double priceReduction;

    Discount(double priceReduction) {
        this.priceReduction = priceReduction;
    }

    public double getPriceReduction() {
        return priceReduction;
    }

    public static Discount parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value");
        }

    }

}
