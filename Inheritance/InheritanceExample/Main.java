package Inheritance.InheritanceExample;

public class Main {
    public static void main(String[] args) {

        Organism organism = new Organism(10,11);
        organism.height = 10;

        Goat goat = new Goat(22);
        goat.height = 15;
    }
}
