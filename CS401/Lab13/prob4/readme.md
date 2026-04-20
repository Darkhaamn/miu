```java
public static double sum(Collection<? extends Number> nums {
  double s = 0.0;
  for(Number num : nums) s += num.doubleValue();
  return s;
}
```


### a. Is there a compiler error in the following lines of code? If so, where?
```java
List<Integer> ints = new ArrayList<>();
ints.add(1);
ints.add(2);

List<? extends Number> nums = ints;
double dbl = sum(nums);   // ✅ OK
nums.add(3.14);           // ❌ ERROR
```
? extends Number = unknown subtype of Number

### b. Is there a compiler error in the following lines of code? If so, where?
```java
List<Object> objs = new ArrayList<>();
objs.add(1);
objs.add("two");

List<? super Integer> ints = objs;
ints.add(3);              // ✅ OK
double dbl = sum(ints);   // ❌ ERROR
```
If it's List<Object>, it may contain "two" (String) → not a Number → unsafe
 
? extends T ---> READ only
? super T ---> WRITE only