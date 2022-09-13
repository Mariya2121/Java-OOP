package DesignPatterns.FactoryPattern;

public class CakeFactory {
    public static Cake createCake(String cakeType) {
        Cake cake = null;
        if (cakeType.equals("SpinachCake")) {
            cake = new SpinachCake(10, 20, 5);
        } else if (cakeType.equals("BiscuitCake")) {
            cake = new BiscuitCake(20, 30, 10);
        }
        return cake;
    }
}
