package Encapsulation;

import WorkingWithAbstractionExcercise.TrafficLights.Color;

import java.util.*;

public class ImmutablePerson {
    private String name;
    private int age;
    private List<String> favouriteFruits;

    public ImmutablePerson(String name, int age, String... favouriteFruits) {
        this.name = name;
        this.age = age;
        this.favouriteFruits = new ArrayList<>(Arrays.asList(favouriteFruits));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFavouriteFruits() {
       // return favouriteFruits; Въпреки че нямаме setter, пак променяме обекта като му добавяме нови продукти => immutable

         //return new ArrayList<>(this.favouriteFruits);
         // връща копие на списъка с плодове и когато се опитаме да променим нещо, няма да променим оригинала

        // друг начин
        return Collections.unmodifiableList(this.favouriteFruits); //връща лист, но хвърля грешка, когато някой се опита да променя стойности
    }
}
