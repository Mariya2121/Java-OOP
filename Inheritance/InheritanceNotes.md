### Inheritance (наследяване)

1. What is inheritance ?
- То е една от основните парадигми в ООП, която ни позволява да преизползваме код.

- Superclasses(Base class) - Parent class, Base class - The class gives its members to its child class
- никога не знае за своите наследници, защото не знаем в бъдещето дали ще се появи подбазов тип,
затова стрелката сочи на обратно(от наследника към базовия клас), наследника знае, че има базов тип
- Subclass(наследник) - Child class, Derived class - The class taking members from its base class
- взима информацията, качествата и свойствата на базовия тип(поведението и състоянието - полетата и методите)
Взима всичко това, не можем да си изберем определени качества или свойства да вземем


- An inheritance leads to hierarchies of classes and/or interfaces
- The object is at the root og Java Class Hierarchy

- Наследяване правим, когато имаме йерархична структура, която ни подсказва, че имаме една и съща видова репрезентация.
- Постигаме 3 цели чрез наследяването --> преизползване на код; йерархичност получаваме; да постигнем абстракция

 
- Обектите наследници в паметта се запазват като тяхната клетка се разделя на 2 чати. Първата част е частта,
която инизиализара базовия клас и следващата част е за насленика.(снимка). Това е причината, че когато имаме наследяване
първо трябва да се погрижим за правилното инициализиране на базовия тип. То се случва чрез извикване на конструктура на
базовия тип с клучовата дума super.
- super реферира към базовия тип. Така се извиква конструктура от базовия тип в наследника. Super трябва да е първото действие
в конструктура
![img.png](img.png)
- Java supports inheritance through extends keyword
- Constructors are not inherited
- Constructors can be reused by the child classes
- A derived class instance contains an instance of its base class
- Inheritance has a transitive relation

2.Reusing classes
2.1 Inheritance and Access Modifiers
- наследниците на дадени класове имат достъп до всяко едно нещо, което е публично и до всяко едно нещо, което е protected
- наследниците могат да имат достъп до клас членове, които са без access modifier, но да се намират в същия package
- наследниците нямат достъп до private полета и методи

2.2 Shadowing Variables - не е добра практика
- не е добре да се дублират имената; объркващо е
- проблема може да се разреши с правилните указатели за достъп(super, this);
```java
class Patient extends Person { // Person have int weight
  protected float weight;
  public void method() {
    double weight = 0.5d;
    this.weight = 0.6f;
    super.weight = 1;
  }
}
```

2.3 Overriding Derived Methods
- Signature and return type should match to have override
- това, което правим като override-ваме е че хващаме поведението на някакъв метод който идва от базовия клас и правим друга 
имлементация, друго поведение
- Идеята е, че можем да имаме методи в базовите типове, които да се държат по различен начин в наследниците.
- Когато override-ваме методи, това не означава,че не можем да преизваме логиката в базовия тип; просто добавяме допълнителна
- - Method in base class must not be final when override -- String class is final, затова не можем да го наследяваме
- final може да се използва в полета(const field), методи(не може да бъде override), class(не може да бъде наследяван) -
final e последната версия

2.4 Inheritance Benefits
- Друг + на наследяването е, че постигаме абстракция. One approach for proving an abstraction 
- Можем да добавим логика към класове, които не можем да променим(пр; структура базирана на ArrayList с допълнителне наши методи)


3. Types of Class Reuse - не винаги е възможно да правим наследяваме, тогава използваме следните стратегии
3.1 Extension - когато мога да наследя директно
- Duplicate code is error prone
- Reuse classes through the extension

3.2 Composition - когато моят клас е съставен от други класове; да иползваме различни класове в нашия клас, за да може да направим решение
- Разликата между композицията и наследяването е, че при наследяването винаги имаме една връзка, при която класа,който extend-ва
базовия тип се съгласява, че е същия вид. При композицията тази връзка я няма.
- reuse code like this

3.3 Delegation - когато делигирим на нещата в композицията да вършат работа


4.When to use inheritance
- Когато, класът който искаме да наследим, е по - абстрактна версия на нашия клас(Animal е по-абстрактен от Dog);
Идеята е, че имат общи физически характеристики.
- Classes share is a relationship
- Derived class is a substitute for the base class
- Share the same role
- The derived class is the same as the base class, but adds a little bit more functionality


 