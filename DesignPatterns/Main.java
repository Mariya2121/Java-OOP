package DesignPatterns;

public class Main {
    public static void main(String[] args) {

        Database database = Database.getInstance();

        Car car = new Car("Audi", 2002, "black", 200);

        Car car2 = car.clone();


        Address address = Address.builder()
                .withCity("Sofia")
                .withCountry("Bulgaria")
                .withPostcode("12314")
                .withEmail("hello@gmail.com")
                .build();
    }
}
