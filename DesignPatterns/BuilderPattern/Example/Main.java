package DesignPatterns.BuilderPattern.Example;



public class Main {
    public static void main(String[] args) {
        // Person person = new Person("Pesho", "Ivanov", "Sofia");



        Person person1 = Person.builder() // method chaining
                .withAddress("Sofia")
                .withName("Ivan").build();
    }
}
