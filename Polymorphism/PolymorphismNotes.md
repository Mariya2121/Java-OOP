### Polymorphism

1. What is Polymorphism ?
- идеята е един тип да може да заема много форми.
- в една абстракция да мога да записвам различни видове имплементация на тази абстракция
- Such as a word having several different meanings based on the context
- един конкретен обект да можем да записваме в ралични типове, референции
- the ability of an object to take on many forms
```java
public interface Animal {}
public abstract class Mammal {}
public class Person extends Mammal implements Animal {}

// Person is a Person; Person is a Mammal; Person is an Animal; Person is an Object
    Animal person    = new Person();
    Mammal personOne = new Person();
    Person personTwo = new Person();
    // Animal, Mammal, Person are Reference Types; Person() is Object Type
```
- Variables are saved in reference type
- you can use only reference methods

1.1 Keyword - Instanceof  Проверка на типа 
- check if an object is an instance of a specific class
```
if(car instanceof Seat){
    Seat seat = (Seat) car;
}else if(car.getClass() == Audi.class){
    
}
```

2. Types of Polymorphism

2.1 Runtime polymorphism - по време на изпълнение на програмата, някъде създавеме обекти с клучовата дума new 
и ги записваме в някакъв тип, който тип най-вероятно е абстракция. 
- когато на някакъв обект му правим полиморфизъм с типа(записваме го с друг тип)
- methods overriding
- Also known as Dynamic Polymorphism
```java
public class Shape {}
public class Circle extends Shape {} // В Circle могат да се override всички методи на Shape
    public static void main(String[] args) {
        Shape shape = new Circle();
    }
```

2.2 Compile time polymorphism - използва възможността да overload methods

overload - метод със същото име, но с различен списък на параметри

// int sum(int a, int b, int c)
// double sum(double a, double b) --> Method overloading

- Compile time е защото програмата знае за неговото случване по време на компилация
- Also known as Static Polymorphism
- Идеята е, че списъка с аргументите е различен от другия метод със същото име
- Argument lists could differ in:
  Number of parameters
  The data type of parameters
  The sequence of Data type parameters

Rules for Overloading Methods
- overloading can take place in the same class or its subclass()
- Overloading не може да се случва при наследяване
- Constructors in Java can be overloaded
- Overloaded methods must have different argument list(По return тип не се различават)
- The overloaded method should always be part of the same class (can also take place in a subclass),
with the same name but different parameters
- They may have the same or different return types
- сигнатура на метод -> add(int,int); няма return type и имена

Rules for Overriding Methods
- Overriding can take place in sub-class
- The argument list must be the same as that of the parent method.(name of the method and return type are the same)
- Можем да променим Access modifier, но той не може да бъде по-рестриктиращ. Може да е от protected на public, но не и обратното
- The overriding method must have the same return type
- Access modifier cannot be more restrictive
- Private, static and final methods cannot be overriden 
Private(защото наследниците не ги виждат); static(не са обвързани с инстанциите, а с типовете);
- final(забранява се да overrid-ваме в наследниците)
- The overriding method must not throw new or broader checked exceptions

3.Abstract Classes
- An Abstract class cannot be instantiated
- An abstract class  may or may not include abstract methods(without body)
- If it has at least one abstract method, it must be declared abstract
- To use an abstract class, you need to inherit it



