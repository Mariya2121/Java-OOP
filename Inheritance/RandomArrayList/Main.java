package Inheritance.RandomArrayList;


public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(10);
        randomArrayList.add(11);
        System.out.println(randomArrayList.getRandomElement());
    }
}
