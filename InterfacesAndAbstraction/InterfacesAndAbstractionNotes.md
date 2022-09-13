### Interfaces and Abstraction

1.Abstraction - не се интересуваме от детайлите, а от това което е необходимо за нас в текущия контекст.
- Идеята е да можем да опаковаме отделните парчета от кода, който пишем в отделни абстрактни единици(класове, методи)
- Идеята е да имаме само информацията, която е важна за контекста, в който се намираме. Не е важно да знаем детайлите
- Preserving information that is relevant in a context
- Forgetting information that is irrelevant in that context
- Abstraction means ignoring irrelevant features, properties, or functions and emphasizing the relevant ones..
- Фокусираме се върху контекста, който е важен
- Абстракцията ни помага да менажираме сложността на една по - комлексна система(Когато нараства кода, не искаме да прочетем
всичките милиони редове код).Искаме да прочетен абстракцията
- Abstraction helps us manage complexity
- Abstraction lets you focus on what the object does instead of how it works.

1.1 Achieving Abstraction(Постигане на Абстракция)
- Файлове, които съдържат интерфейси в себе си(Един файл = един интерфейс); Interfaces(100 % Abstraction)
Идеята за интерфейса е, че той просто дефинира някаква сигнатура / поведение на потребителя. Не дефинира конкретната
имплементация. В интерфейсите не трябва да има имплементация.
- Abstract class(0 % - 100 %) - към 0% той се препокрива с обикновения клас, а с интерфейса на 100%.


- implements използваме, когато имплементираме нещо в interface.Използваме implements, зашото interfaces нямат
имплементация в себе си. Това е причината да използваме implements
- extend - наследяване на класове
- implements - имплементиране на интерфейс

1.2 Abstraction vs Encapsulation
- и в двете крием код. И двете искам да ни олеснят, да не знаем и да не можем да пипаме по-прекалено много детайли,
така че да счупим нещо
- Абстракцията иска да скрие от нас кода, който е нерелевантен за контекста, в който се намираме, а енкапсулацията иска 
да скрие кода от нас така че да предпази данните(състоянието и поведението на обектите)
- Abstraction is a process of hiding the implementation details and showing only functionality to the use. It is achieved
with interfaces and abstract classes.
- Encapsulation is used to hide the code and data inside a single unit to protect the outside world.It is achieved
with access modifiers


2.Interfaces - Съдържат само сигнатура на методи, които са публични. В интерфейсите могат да се намират само публични 
методи без имплементация
- Когато метод в Interface няма access modifier, означава, че той е public и abstract
- Метода няма тяло, само се дефинира
- Имплементацията на Interface ни гарантира, че всеки един клас добавя имплементацията или тялото на метода. Затова нямаме тяло в 
интерфейса. Класът си добавя тялото на метода като го override 
- дефинира сигнатурата


2.1 Implements vs Extends
- когато двете неща са еднакви - Extends; различни Implements
- единствената ситуация да използваме Implements e Class да имплементира Interface
- можем да имплементираме многожество интерфейси, но да наследяваме само един клас
![img.png](img.png)

2.2 Extend Interfaces
- The interface can extend another interface
- The class which implements child interface must provide an implementation for parent interface too;

2.3. Default Method
- Since Java 9 we have a method body in the interface
``` java
public interface Drawable {
  void draw();
  default void msg() {
    System.out.println("default method:");
  }
}
```
- if you need to override the default method think about your design(). Никога не трябва да ни се наложи да го override
- Implementation is not needed for default methods

2.4 Static Method - обвързани са с класа
- Since Java 11, we can have a static method in the interface


3.Abstract Classes - Нещо като средния вариант на абстракция(между обикновените класове(методи с тяло) и интерфейсите(методи без тяло))
- В Абстрактните класове можем да имаме и двете - методи с имплементация и без.
- Абстрактния клас е просто клас, който позволява да имате абстрактни методи в него.
- Abstract classes cannot be instantiated
- May contain abstract methods - Но само, когато класовете са декларирани като абстрактни и метода е деклариран като абстрактен (с думата abstract)
- Не трябва да добавя имплементация за всички наследени методи от интерфейсите
- Когато имплементираме интерфейс в абстрактен клас, получаваме на готово абстрактните методи от интерфейса

3.1 Abstract Methods
- Declarations are only permitted in abstract classes
- Bodies must be empty(no curly braces)
- An abstract method declaration provides no actual implementation



4.Interfaces vs Abstract Classes
- Разликата е, че интерфейсите могат да се имплементират множество интерфейси от един клас, докато абстрактния клас пак е клас
и отново можем да наследяваме само веднъж
- Интерфейсите не могат да имат Access modifiers(всичко трябва да е публично), докато абстрактните класове могат да имат 
Access modifiers

More info in English
Interface 
- A class may implement several interfaces
- Cannot have access modifiers, everything is assumed as public
- If we add a new method we must track down all the implementations of the instance and define implementation for the new one

Abstract Class
-May inherit only one abstract class
- Provides implementation and just the signature that has to be overridden
- Can contain access modifiers for the fields, functions, properties
- Fields and constants can be defined
- If we add a new method we have the option of providing a default implementation

Абстрактен клас или интерфейс --> Ще има ли състояние класа и ще има ли обекти(не директни)
В абстрактния клас можем да добаеим състояние, докато в интерфейса не можем. Ако добавяме състояние или дефолтна имлементация на някаквъв
мвтод, тогава ни трябва абстрактен клас. Ако ще добавяме методи, които са абстрактни --> интерфейс