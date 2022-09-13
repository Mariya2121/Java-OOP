## Working with Abstraction

1.Project Architecture - съвкупност от пакичи
- Splitting code into methods - improves code readability; allows for easier debugging
- Methods let us easily reuse code
- A single method should complete a single task

2.Refactoring
- Restructures code without changing the behaviour
- improves code readability
- reduces complexity
- Breaking code into reusable units
- Extracting parts of methods and classes into new ones -> depositOrWithdraw() -> deposit(); withdraw();
- improving names of variables, methods and classes;


3.Enumerations - специален тип, който ни позволява да съдържаме някаква информация,
но базовата им идея е, че са бройни;
- Represent a numeric value from a fixed set as a text
- Различното от класовете е, че не можем да имаме всякакъв вид инстанции, а винаги когато 
описвам дадена инумерация, задължително трябва да посочим всички възможни инстанции
(пример дните на седмицата)
- репрезентират определено число (1 - Monday..);
- Могат да бъдат аргументи на методи и конструктори или просто стойности записани в променливи;
- Използват се за опростяване на кода
- Веднъж като е дефинирана една енумерация, тя трябва да съдържа всички възможни стойности
- enum Day {Mon, Tue, Wed, Thu, Fri, Sat, Sun}
- By default, enums start with 0; Every next value is incremented by 1
- we can customize enum values MON(1), TUE(2), WED(3)
- Идеята е да репрезентират числовите стойности на някакъв текст
- Не можем да инициализираме enum (new)
- Винаги се пишат с главна буква(FIRST_DAY)

4.Static Keyword in Java
##### Static Keyword
- static methods не са обвързани с инстанциите на класовете; Обвързани са с класа сам по собе си
- used for memory management mainly
- Can apply with : nested classes, variables, methods, blocks
- Belongs to the class than an instance of the class
##### Static Class
- A top level class is a class that is not a nested class
- A nested class is any class whose declaration occurs within the body of another class or interface
- Only nested classes can be static
##### Static Variable
- Can be used to refer to the common variable of all projects
##### Static Method
- belongs to the class rather than the object of a class
- can be invoked without the need for creating an instance of a classes
- can access static data member and can change the value of it
- can not use non-static data member or call a non-static method directly
- this and super cannot be used in a static content

5. Packages
- used to group related classes (like folder in a file directory)
- use packages to avoid name conflicts ant to write a better maintainable code
- Packages are divided into two categories (Build-in Packages(packages from tha Java API) and 
User-defined Packages(create own packages));


4 принципа на ООП
- Abstraction, Encapsulation, Inheritance, Polymorphism
1. Abstraction -> да описваме само нешата, които са ни нужни за момента ; без никакви детайли; извличане на необходимото
