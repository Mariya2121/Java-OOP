package Inheritance.InheritanceExample;

public class Goat extends Organism { //Козата е вид организъм
    int milkGiven;

    public Goat(int height) {
        super(); //извикване на конструктор от базовия тип в наследника
        super.height = height; // super реферира към базовия тип
    }

}
