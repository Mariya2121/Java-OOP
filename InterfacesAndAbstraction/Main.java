package InterfacesAndAbstraction;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Dog(); // кучето е вид животно
        Animal cat = new Cat();

        feedAnimal(dog);
        feedAnimal(cat);
    }

    public static void feedAnimal(Animal animal){ // параметрите могат да бъдат различни видове имплементация на Animal
        animal.eat();
    }
}
