package DesignPatterns.StrategyPattern;

import java.util.Comparator;

public class FirstNameSorter implements Comparator<Person> {


    @Override
    public int compare(Person left, Person right) {
        return left.getFirstName().compareTo(right.getFirstName());
    }
}
