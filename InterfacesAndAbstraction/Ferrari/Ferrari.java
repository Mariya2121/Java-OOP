package InterfacesAndAbstraction.Ferrari;

public class Ferrari implements Car {
    private String drivenName;
    private String model;

    public Ferrari(String drivenName) {
        this.drivenName = drivenName;
        this.model = "488-Spider";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", model, brakes(), gas(), drivenName);
    }
}
