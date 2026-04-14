# Prob1

## a

```java
Runnable r = () -> {
    int[][] products = new int[s][t];
    for (int i = 0; i < s; i++) {
        for(int j = i + 1; j < t; j++) { 
            products[i][j] = i * j; 
        } 
    }
};
```
- Parameters: Empty
- Free variables: s and t

```java
Comparator<String> comp = (s, t) -> {
    if(ignoreCase == true) {
        return s.compareToIgnoreCase(t);
    } else {
        return s.compareTo(t);
    }
};
```
- Parameters: s and t
- Free variables: ignoreCase


## b

1. Supplier<Double> sup = () -> Math.random();
2. 
```java
public class Main {
    void main(String[] args) {
        Supplier<Double> sup = () -> Math.random();
        System.out.println(sup.get());
    }
}
```
3. 
```java
public class Main {
    static class MySupplier implements Supplier<Double> {
      public Double get() {
          return Math.random();
      }
    }

    void main(String[] args) {
      Supplier<Double> sup = new MySupplier();
      System.out.println(sup.get());
    }
}
```


## Prob 5 - 1

### A

- Function<Employee, String> f1 = e -> e.getName();
- Function<Employee, String> f2 = Employee::getName;

### B

- (Employee e, String s) -> e.setName(s)
- Employee::setName

### C

- (String s1,String s2) -> s1.compareTo(s2)
- String::compareTo

### D
  - (Integer x, Integer y) -> Math.pow(x,y)
  - Math::pow
### E
  - (Apple a) -> a.getWeight()
  - Apple::getWeight
### F
  - (String x) -> Integer.parseInt(x)
  - Integer::parseInt

### G
  - EmployeeNameComparator comp = new EmployeeNameComparator();
(Employee e1, Employee e2) -> comp.compare(e1,e2)
  - BiFunction<Employee, Employee, Integer> f2 = comp::compare;


## Prob 5 - 2

```java
public class Examples {
    void main(String[] args) {
        Examples ex = new Examples();
        ex.evaluator();
    }

    void evaluator() {
        // A
        Function<Employee, String> fA = Employee::getName;
        System.out.println(fA.apply(new Employee("John", 5000)));

        // B
        BiConsumer<Employee, String> fB = Employee::setName;
        Employee e = new Employee("Old", 1000);
        fB.accept(e, "New");
        System.out.println(e.getName());

        // C
        BiFunction<String, String, Integer> fC = String::compareTo;
        System.out.println(fC.apply("a", "b"));

        // D
        BiFunction<Integer, Integer, Double> fD = Math::pow;
        System.out.println(fD.apply(2, 3));

        // E (Assume Apple class exists)
        Function<Apple, Double> fE = Apple::getWeight;
        System.out.println(fE.apply(new Apple(2.5)));

        // F
        Function<String, Integer> fF = Integer::parseInt;
        System.out.println(fF.apply("123"));

        // G
        EmployeeNameComparator comp = new EmployeeNameComparator();
        BiFunction<Employee, Employee, Integer> fG = comp::compare;
        System.out.println(fG.apply(
                new Employee("A", 100),
                new Employee("B", 200)
        ));
    }
}
```