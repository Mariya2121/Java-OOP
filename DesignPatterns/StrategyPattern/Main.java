package DesignPatterns.StrategyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person person = new Person("Pesho", "Ivanov");
        Person person1 = new Person("Ivan", "Petrov");
        Person person2 = new Person("Georgi","Georgiev");

        people.add(person);
        people.add(person1);
        people.add(person2);

        Collections.sort(people, new FirstNameSorter());
    }
}
