## 模糊化

## Java Lambda行为参数化

  

我们可以将lambda表达式作为参数传递给方法。

### 例子

以下代码创建了一个名为 `Calculator` 的函数接口。

在 `Calculator` 中有一个称为 `calculate` 的方法，它接受两个 `int` 参数并返回一个 `int` 值。

在 `Main` 类中有一个引擎方法，它接受函数接口`Calculator`作为参数。它从计算器调用计算方法并输出结果。

在主方法中，我们用不同的lambda表达式调用引擎方法四次。

```
public class Main {
  public static void main(String[] argv) {
    engine((x,y)-> x + y);
    engine((x,y)-> x * y);
    engine((x,y)-> x / y);
    engine((x,y)-> x % y);
  }
  private static void engine(Calculator calculator){
    int x = 2, y = 4;
    int result = calculator.calculate(x,y);
    System.out.println(result);
  }
}

@FunctionalInterface
interface Calculator{
  int calculate(int x, int y);
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_lambda/EXAMPLE__D5D69420599670FF7DED.png)

### 注意

`engine` 方法的结果取决于传递给它的lambda表达式。

引擎方法的行为被参数化。

通过其参数更改方法的行为称为行为参数化。

在行为参数化中，我们将在lambda表达式中封装的逻辑传递给数据的方法。

### 行为参数化模糊性

编译器并不总是可以推断lambda表达式的类型。

一种情况是将lambda表达式传递给重载的方法。

在以下代码中有两个函数接口。 一个是 `int` 值计算，另一个用于 `long` 值。

在Main类中有称为 `engine` 的重载方法。 一个是期望 `IntCalculator` ，另一个是 `LongCalculator` 。

在main方法中，我们必须指定lambda表达式的参数，以指示我们要使用的重载函数的编译器。

```
public class Main {
  public static void main(String[] argv) {
    engine((int x,int y)-> x + y);
    engine((long x, long y)-> x * y);
    engine((int x,int y)-> x / y);
    engine((long x,long y)-> x % y);
  }
  private static void engine(IntCalculator calculator){
    int x = 2, y = 4;
    int result = calculator.calculate(x,y);
    System.out.println(result);
  }
  private static void engine(LongCalculator calculator){
    long x = 2, y = 4;
    long result = calculator.calculate(x,y);
    System.out.println(result);
  }  
}

@FunctionalInterface
interface IntCalculator{
  int calculate(int x, int y);
}

@FunctionalInterface
interface LongCalculator{
  long calculate(long x, long y);
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_lambda/BEHAVIOR_PARAMETERIZATION_AMBIGUITY__D5D69420599670FF7DED.png)

### 注意1

要解决歧义，我们可以通过指定参数的类型将隐式lambda表达式更改为explicit。这是为上面的代码做的。

或者我们可以使用cast如下。当第一次调用引擎时，我们将lambda表达式转换为`IntCalculator`。

```
public class Main {
  public static void main(String[] argv) {
    engine((IntCalculator) ((x,y)-> x + y));
    engine((long x, long y)-> x * y);
    engine((int x,int y)-> x / y);
    engine((long x,long y)-> x % y);
  }
  private static void engine(IntCalculator calculator){
    int x = 2, y = 4;
    int result = calculator.calculate(x,y);
    System.out.println(result);
  }
  private static void engine(LongCalculator calculator){
    long x = 2, y = 4;
    long result = calculator.calculate(x,y);
    System.out.println(result);
  }  
}

@FunctionalInterface
interface IntCalculator{
  int calculate(int x, int y);
}

@FunctionalInterface
interface LongCalculator{
  long calculate(long x, long y);
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_lambda/NOTE_1__D5D69420599670FF7DED.png)

### 注意2

或者我们可以避免直接使用lambda表达式作为参数。我们可以将lambda表达式分配给一个函数接口，然后将该变量传递给该方法。下面的代码显示了这种技术。

```
public class Main {
  public static void main(String[] argv) {
    IntCalculator iCal = (x,y)-> x + y;
    engine(iCal);
    engine((long x, long y)-> x * y);
    engine((int x,int y)-> x / y);
    engine((long x,long y)-> x % y);
  }
  private static void engine(IntCalculator calculator){
    int x = 2, y = 4;
    int result = calculator.calculate(x,y);
    System.out.println(result);
  }
  private static void engine(LongCalculator calculator){
    long x = 2, y = 4;
    long result = calculator.calculate(x,y);
    System.out.println(result);
  }  
}

@FunctionalInterface
interface IntCalculator{
  int calculate(int x, int y);
}

@FunctionalInterface
interface LongCalculator{
  long calculate(long x, long y);
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_lambda/NOTE_2__D5D69420599670FF7DED.png)



## Java Lambda - Java函数式接口

  

函数式接口是具有一个方法的接口，用作lambda表达式的类型。

```
public interface ActionListener extends EventListener {
    public void actionPerformed(ActionEvent event);
}

```

`ActionListener` 只有一个方法`actionPerformed`。它是一个函数式接口。无论调用什么单一方法，只要Java编译器具有兼容的方法签名，Java编译器就会将其匹配到您的lambda表达式。

lambda表达式表示函数式接口的实例。

lambda表达式的类型是一个函数式接口类型。

`(String str) -> str.length()` str.length() 获取一个String参数并返回其长度。

它的类型可以是任何具有抽象方法的函数接口类型，它使用String作为参数并返回int。  

以下是这种函数式接口的示例:

```
@FunctionalInterface
interface Processor  {
    int  getStringLength(String str);
}

```

我们可以为其函数式接口实例赋值lambda表达式。

`Processor stringProcessor = (String str) -> str.length();`

  

## 例子

在下面的代码中，我们为其函数接口赋值一个lambda表达式。然后我们通过调用函数接口中定义的方法来执行lambda表达式，并传入一个参数。

```
public class Main {
  public static void main(String[] argv) {
    Processor stringProcessor = (String str) -> str.length();
    String name = "Java Lambda";
    int length = stringProcessor.getStringLength(name);
    System.out.println(length);

  }
}

@FunctionalInterface
interface Processor {
  int getStringLength(String str);
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_lambda/EXAMPLE__BA603499F950B1AB794F.png)

  

## 注意

lambda表达式本身不能用作独立的表达式。

lambda表达式的类型由编译器推断。

## Java函数式接口定义

函数式接口是具有一个抽象方法的接口。

我们不能使用以下类型的方法来声明一个函数式接口：

-   默认方法
-   静态方法
-   从Object类继承的方法

一个函数式接口可以重新声明Object类中的方法。该方法不被视为抽象方法。因此，我们可以声明lambda表达式使用的另一种方法。

考虑 `java.util` 包中的Comparator类，如下所示:

```
package java.util;

@FunctionalInterface
public interface  Comparator<T> {
   // An  abstract method  declared in the functional interface 
   int compare(T  o1,   T  o2);

   // Re-declaration of the equals() method in the Object class 
   boolean equals(Object  obj);

   ...
}

```

Comparator接口有两个抽象方法： `compare()`和 `equals()`。

`equals()`方法是Object类中的 `equals()`方法的重新声明。

## @FunctionalInterface注释

`@FunctionalInterface` 注释在java.lang包中定义。我们可以选择使用它来标记一个函数式接口。

如果注释 `@FunctionalInterface` 在非函数式接口或其他类型（如类）上注释，则会发生编译时错误。

具有一个抽象方法的接口仍然是一个功能接口，即使我们不用 `@FunctionalInterface` 注释。

```
public class Main {
  public static void main(String[] argv) {
    Processor stringProcessor = (String str) -> str.length();
    String name = "Java Lambda";
    int length = stringProcessor.getStringLength(name);
    System.out.println(length);

  }
}

@FunctionalInterface
interface Processor {
  int getStringLength(String str);
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_lambda/FUNCTIONALINTERFACE_ANNOTATION__BA603499F950B1AB794F.png)

## 通用函数式接口

我们可以使用类型参数与函数式接口来创建通用函数式接口。

以下代码创建具有一个类型参数T的通用函数式参数函数接口。

```
@FunctionalInterface
public interface  Comparator<T> {
    int compare(T o1, T o2);
}

```

以下代码使用抽象通用方法定义非通用函数式接口：

```
@FunctionalInterface
public interface  Processor {
   <T> void  process(T[] list);
}

```

## Java Buildin函数式接口

Java 8在包java.util.function中有函数式接口

### 函数

表示接受类型`T`的参数并返回类型`R`的结果的函数。

```
public interface Function<T,R>{
   ...
   public R apply(T t);
   ...
}

```

### BiFunction

表示一个函数，它接受类型T和U的两个参数，并返回类型R的结果。

```
public interface BiFunction<T,U,R>{
   ...
   public R apply(T t, U u);
   ...
}         

```

### 谓词

表示为指定参数返回 `true` 或 `false` 的布尔函数。

```
public Predicate<T> {
   ...
   public boolean test(T  t);
   ...
}

```

### BiPredicate

表示为两个指定的参数返回 `true` 或 `false` 的布尔函数。

```
public interface BiPredicate<T,U>{
   ...
   public boolean test(T t, U u);
   ...   
}

```

### Consumer

表示接受参数并且不返回结果的操作。

```
public interface Consumer<T>{
   ...
   public void accept(T t);
   ...
}

```

### BiConsumer

表示接受两个参数并且不返回结果的操作。

```
public interface BiConsumer<T,U>{
   ...   
   public void accept(T t, U  u);
   ...   
}

```

### Supplier

表示返回类型T的值的函数。

```
public interface Supplier<T>{
   ...
    public T get();
   ...
}


```

### UnaryOperator

表示接受参数并返回相同类型的结果的函数。  

```
public interface UnaryOperator<T>{
   ...
   public T  apply(T t);
   ...
}


```

### BinaryOperator

表示一个函数，它接受两个参数并返回相同类型的结果。

```
public interface BinaryOperator<T>{
   ...
   public T apply(T t1, T t2);
   ...
}           


```

### 注意2

上述通用buildin函数式接口都是更专用的函数式接口的通用版本。

例如， `IntConsumer` 是 `Consumer<T>` 的专用版本。

## Java集合教程 - Java排序集

  

排序集是在其元素上有排序的集合。

`SortedSet` 接口表示Java集合中的排序集合框架。

排序集中的元素可以按照自然顺序排序`可比较的`接口或使用 `Comparator` 。

`SortedSet` 必须知道如何在添加元素时对其元素进行排序检查两个接口:

-   如果它的元素实现了Comparable接口，它将使用compareTo()方法来排序项目。 我们可以称之为自然顺序排序。
-   我们可以传递一个比较器做自定义排序。

如果指定了 `Comparator` ，则 `Comparator` 是用于排序并忽略 `Comparable` 接口。

`TreeSet` 类是Collection框架中SortedSet接口的一个实现。

[TreeSet API](https://www.w3cschool.cn/java/java-sorted-set.html../java.util/TreeSet/index.html)

[SortedSet API](https://www.w3cschool.cn/java/java-sorted-set.html../java.util/SortedSet/index.html)

  

## 例子

在下面的代码中，我们添加 `String` 对象 `SortedSet` 。

`String` 类实现 `Comparable` 接口。

SortedSet将使用 `Comparable` 接口及其 `compareTo()`方法对String值进行排序。

```
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    // Create a sorted set of some names
    SortedSet<String> sortedNames = new TreeSet<>();
    sortedNames.add("Java");
    sortedNames.add("SQL");
    sortedNames.add("HTML");
    sortedNames.add("CSS");

    // Print the sorted set of names
    System.out.println(sortedNames);
  }

}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_collection/EXAMPLE__29174574FDF98AF7F6AB.png)

  

## 例2

以下代码显示如何存储在 `SortedSet` 中的人物对象列表。

我们不能添加Person类的对象在SortedSet中，除非我们还提供一个 `Comparator` 对象因为Person类不实现 `Comparable` 接口。

以下代码创建一个 `SortedSet` 的使用 `Comparator` 的人使用他们的名字排序的人:

```
SortedSet<Person> personsSortedByName = new TreeSet<>(Comparator.comparing(Person::getName));

```

该代码使用方法引用来创建用于创建Comparator对象的lambda表达式。

```
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    SortedSet<Person> personsById = new TreeSet<>(
        Comparator.comparing(Person::getId));

    personsById.add(new Person(1, "X"));
    personsById.add(new Person(2, "Z"));
    personsById.add(new Person(3, "A"));
    personsById.add(new Person(4, "C"));
    personsById.add(new Person(4, "S")); // A duplicate Person

    System.out.println("Persons by  Id:");
    personsById.forEach(System.out::println);

    SortedSet<Person> personsByName = new TreeSet<>(
        Comparator.comparing(Person::getName));
    personsByName.add(new Person(1, "X"));
    personsByName.add(new Person(2, "Z"));
    personsByName.add(new Person(3, "A"));
    personsByName.add(new Person(4, "C"));

    System.out.println("Persons by  Name: ");
    personsByName.forEach(System.out::println);

  }

}

class Person {
  private int id;
  private String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Person)) {
      return false;
    }

    // id must be the same for two Persons to be equal
    Person p = (Person) o;
    if (this.id == p.getId()) {
      return true;
    }

    return false;
  }

  @Override
  public int hashCode() {
    return this.id;
  }

  @Override
  public String toString() {
    return "(" + id + ", " + name + ")";
  }
}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_collection/EXAMPLE_2__02C4827C7263AEEADD78.png)

## 例3

`SortedSet` 接口继承了 `Set` 接口的所有方法，并添加了一些方法来返回子集。

`subSet(E fromElement，E toElement)`方法从 `SortedSet` 返回fromElement(包含)和toElement(exclusive)之间的元素。

```
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    SortedSet<String> names = new TreeSet<>();
    names.add("HTML");
    names.add("Java");
    names.add("SQL");
    names.add("CSS");
    System.out.println("Sorted Set: " + names);
    System.out.println("First: " + names.first());
    System.out.println("Last: " + names.last());

    SortedSet<String> ssBeforeCSS = names.headSet("CSS");
    System.out.println(ssBeforeCSS);

    SortedSet<String> ssBetwenCSSAndHTML = names.subSet("CSS", "HTML");
    System.out.println(ssBetwenCSSAndHTML);

    SortedSet<String> ssBetwenCSSAndHTML2 = names.subSet("CSS", "HTML");
    System.out.println(ssBetwenCSSAndHTML2);

    SortedSet<String> ssCSSAndAfter = names.tailSet("CSS");
    System.out.println(ssCSSAndAfter);

  }

}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_collection/EXAMPLE_3__7E260CA0D33111CB89E4.png)

## 例4

以下代码片段使用 `Comparator` 创建一个 `SortedSet` ，它将null元素放在第一位:

```
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    // Sort the names based on their length, placing null first
    SortedSet<String> names = new TreeSet<>(Comparator.nullsFirst(Comparator
        .comparing(String::length)));
    names.add("XML");
    names.add("CSS");
    names.add("HTML");
    names.add(null); // Adds a null

    // Print the names
    names.forEach(System.out::println);

  }

}

```

上面的代码生成以下结果。

![](https://atts.w3cschool.cn/attachments/jimg/java_collection/EXAMPLE_4__46F4F97CF05956C65245.png)