package Polymorphism;

public class MathOperation {

    public int add(int a, int b) {
        return a + b;
    }
// Overload methods
    public int add(int a, int b, int c) {
      //   return add(add(a,b),c);
        return add(a, b) + c;
    }

    public int add(int a, int b, int c, int d) {
        return add(a, b, c) + d;
    }
}
