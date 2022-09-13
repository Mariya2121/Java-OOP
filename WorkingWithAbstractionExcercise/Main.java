package WorkingWithAbstractionExcercise;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Gosho", "Petrov");
        Person person1 = new Person("Asen", "Ivanov");

        person.age = 15;
        person1.age = 20;
        // Age е една и съща за всички инстанции; И когато я променя се променя за всички;


    }
}
