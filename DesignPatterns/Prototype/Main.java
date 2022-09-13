package DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        EmployeeRecord person = new EmployeeRecord(1, "Pesho", "Varna", 150, "Sofia");

        person.showRecord();

        Prototype person2 = person.getClone();

    }
}
