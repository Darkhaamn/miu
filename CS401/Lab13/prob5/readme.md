```java
public static <T extends Comparable<? super T>> T secondSmallest(List<? extends T> list) {
  T smallest = null;
  T secondSmallest = null;

  for (T item : list) {
    if (smallest == null || item.compareTo(smallest) < 0) {
        secondSmallest = smallest;
        smallest = item;
    } else if (!item.equals(smallest) && (secondSmallest == null || item.compareTo(secondSmallest) < 0)) {
        secondSmallest = item;
    }
  }

  return secondSmallest;
}
```