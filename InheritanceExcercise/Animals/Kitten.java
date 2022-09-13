package InheritanceExcercise.Animals;

public class Kitten extends Cat{

    public Kitten(String name, int age, String gender) {
        super(name, age, "Female");
    }
    public String produceSound(){
        return "Meow";
    }
}
