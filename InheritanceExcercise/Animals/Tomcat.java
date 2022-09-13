package InheritanceExcercise.Animals;

public class Tomcat extends Cat{

    public Tomcat(String name, int age, String gender) {
        super(name, age, "Male");
    }
    public String produceSound(){
        return "MEOW";
    }
}
