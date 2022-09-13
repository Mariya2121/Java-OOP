## Reflection and Annotation

1. What is Metaprogramming?
- Programming technique in which computer programs have the ability to treat programs as their data.
- Разликата от обикновеното програмиране е, че данните върху, които работим е нашият програмен код.
- The program can be designed to : Read, Generate, Analyse, Transform
- Modify itself while running.

2. What is Reflection ? 
- The ability of a programming language to be its own metalanguage.
- Programs can examine information about themselves.
- Идеята на рефлекцията е, че можем да вземем информацията на нашата програма, доката тя се изпълнява
- Извеждане на елементи от даден клас, вклучително и класа като отделен тип данни
 
3. When to use Reflection ?
Whenever we want : Когато не можем да използваме друг подход. Никога не използваме reflection, когато performance
на програмта е критично важен, защото прави overhead; прави програмта значително по-бавна в местата, които правим reflection
- Code to become more extendable
- To reduce code length significantly
- Easier maintenance(поддръжка)
- Easier testing

4. When not to use Reflection ? - когато можем :D
- If it is possible to perform an operation without using reflection, then it is preferable to avoid using it.
- Cons from using Reflection : Performance overhead; Security restrictions, Exposure of internal logic(можем да достъпим информация, която е скрита)


5. Reflection API
- библиотека, която идва от Java
5.1 The Class Object
- Obtain its java.lang.Class object
```
// If you know thw name
Class myObjectClass = MyObject.class;
//If you don't know the name at compile time
Class myClass = Class.forName(className);
```

5.2 Class Name - Obtain Class Name
- Fully qualified class name -> String className = aClass.getName();
- Class name without the package name -> String simpleName = aClass.getSimpleName();

5.3 Base Class and Interfaces
- Obtain parentClass -> Class className = aClass.getSuperclass();
- Obtain interfaces -> Class[] interfaces = aClass.getInterfaces();
- Interfaces are also represented by Class objects in Java Reflection
- Only the interfaces specifically declared implemented by a given class are returned

6. Constructors, Fields and Methods
6.1 Constructors
- Obtain only public constructors -> Constructor[] ctors = aClass.getConstructors();
- Obtain all constructors -> Constructor[] ctors = aClass.getDeclaredConstructors();
- Get constructor by parameters - > Constructor ctor = aClass.getConstructor(String.class);
- Get parameter types -> ctor.getParameterTypes();
- Instantiating objects using constructor -> 
````
  Constructor constructor =  MyObject.class.getConstructor(String.class);
  MyObject myObject = (MyObject)constructor
  .newInstance("arg1");
````

6.2 Fields Name and Type
- Obtain public fields -> Field field = aClass.getField("someField");
  Field[] fields = aClass.getFields();
- Obtain all fields -> Field[] fields = aClass.getDeclaredFields();
- Get field name and type -> String fieldName = field.getName();
Object fieldType = field.getType();

- Setting value for a field
Class aClass = MyObject.class;
Field field = aClass.getDeclaredField("someField");
MyObject objectInstance = new MyObject();
field.setAccessible(true); // Change the behavior of the AccessibleObject(public)
Object value = field.get(objectInstance);
field.set(objectInstance, value); //The objectInstance parameter passed to the get and set method should be an instance 
of the class that owns the field

6.3 Methods
- Obtain public methods -> Method[] methods = aClass.getMethods();
  Method method = aClass.getMethod("doSomething",String.class);
- Get methods without parameters -> Method method = aClass.getMethod("doSomething, null); null не е задължителен
- Obtain method parameters and return type -> Class[] paramTypes = method.getParameterTypes();
  Class returnType = method.getReturnType();
- Get method with parameters -> Method method = MyObject.class.getMethod("doSomething", String.class);
  Object returnValue = method.invoke(null, "arg1"); // null is for static methods

7. Access Modifiers
- Obtain the class modifiers like this -> int modifiers = aClass.getModifiers();
- getModifiers() can be called on constructors, fields, methods
- Each modifier is a flag bit that is eiter set or cleared
- You can check the modifiers -> Modifier.isPrivate(modifiers);
- Creating arrays via Java Reflection
int[] intArray = (int[]) Array.newInstance(int.class, 3);
Array.set(intArray, 0, 123);
- Obtain fields amd methods annotations -> Class stringArrayComponentType = stringArrayClass.getComponentType();

8. Annotation - пази някакви мета данни за нашия код
- присъстват по време на компилацията и компилатора ги вижда
- те могат да съдържат параметри
- Describe parts of your code
- Applied to : Classes, Fields, Methods
```
 @Deprecated // означава, че този метод повече няма да се поддържа и използва
  public void deprecatedMethod() {
  System.out.println("Deprecated!");
  }
```
- Използват се за генериране на код, документиране на даден код, тестови Frameworks
  @Override – generates compile time error if the method does not override a method in a parent class
````
@Override
  public String toString() {
  return "new toString() method";
  }
````

@SupressWarning - turns off compiler warning
````
@SuppressWarnings(value = "unchecked") Annotation with value
public <T> void warning(int size) {
T[] unchecked = (T[]) new Object[size];
}//(T[]) - generates compiler warning
````