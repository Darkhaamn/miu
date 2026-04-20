## a. First fragment

```java
List<Integer> ints = new ArrayList<>();
ints.add(1);
ints.add(2);
List<Number> nums = ints;   // ❌ ERROR here
nums.add(3.14);
```

List<Integer> is NOT a subtype of List<Number>

## b. Second fragment

```java
List<Integer> ints = new ArrayList<>();
ints.add(1);
ints.add(2);
List<? extends Number> nums = ints;
nums.add(3.14);   // ❌ ERROR here
```

? extends Number means some unknown subtype of Number, Compiler does not know the exact type