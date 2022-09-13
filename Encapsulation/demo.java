package Encapsulation;

public class demo {
    public static void main(String[] args) {

        ImmutablePerson person = new ImmutablePerson("Ivan", 12, "Apple", "Orange");
        person.setName("Martin"); // променяме му името => той е mutable
        person.setAge(50);
        person.getFavouriteFruits().add("Something"); // Въпреки че нямаме setter, пак променяме обекта като му добавяме нови продукти => immutable
        System.out.println(person.getFavouriteFruits());
    }
}
