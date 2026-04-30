## Question 1

### Algorithm 1
Idea – Use three loops one after another. First loop will find Max. Second loop will find Second Max, Third loop will find third max. Note that it is possible First max == second Max == Third Maxas in

```java
public static int findThirdLargeA (int[] arr) {
    int n = arr.length;

    int max1 = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max1) {
            max1 = arr[i];
        }
    }

    int max2 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        if (arr[i] <= max1 && arr[i] > max2) {
            max2 = arr[i];
        };
    }

    int max3 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        if (arr[i] <= max2 && arr[i] > max3) {
            max3 = arr[i];
        }
    }

    return max3;
}
```


### Algoritm 2
Idea – Use one loop. Maintain three variable max, preMax and prePreMax such that max will have the maximum value, preMax will have the second largest and prePreMax will have the third largest value

```java
public static int findThirdLargeB (int[] arr) {
    int n = arr.length;
    int max1 = arr[0];
    int preMax = Integer.MIN_VALUE;
    int prePreMax = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
        if (arr[i] >= max1) {
            int tmp = max1;
            max1 = arr[i];
            prePreMax = preMax;
            preMax = tmp;
        } else if (arr[i] >= preMax) {
            prePreMax = preMax;
            preMax = arr[i];
        } else if (arr[i] >= prePreMax) {
            prePreMax = arr[i];
        }
    }

    System.out.println(max1);
    System.out.println(preMax);
    System.out.println(prePreMax);

    return prePreMax;
}
```

### Algorithm 3

```
Algorithm findThirdLargest(A, n)
    Input: An array A with n > 0 integers
    Output: The third largest value in A

    D ← new OrderedDictionary
    for i ← 0 to A.length − 1 do
        D.put(A[i], A[i])

    count ← 0
    iter ← D.descendingIterator()

    while iter.hasNext() do
        key ← iter.next()
        count ← count + 1
        if count = 3 then
            return key
    return −1     
```

| Algorithm | Best Case | Average Case | Worst Case |
|---|---|---|---|
| Algorithm 1 | O(n) | O(n) | O(n) |
| Algorithm 2 | O(n) | O(n) | O(n) |
| Algorithm 3 | O(n log n) | O(n log n) | O(n log n) |


## Question 2

| 10,1                  | O(1)                     |
|:----------------------|:-------------------------|
| log(log n)            | O(log(log n))            |
| ln n, log n           | O(log n)                 |
| n<sup>1/k k > 3       | O(n<sup>1/k)             |
| n<sup>1/3             | O(n<sup>1/3)             |
| n<sup>1/3 log n       | O(n<sup>1/3</sup> log n) |
| n<sup>1/2             | O(n<sup>1/2)             |
| n<sup>1/2</sup> log n | O(n<sup>1/2</sup> log n) |
| n log n, log(n<sup>n) | O(n log n)               |
| n<sup>2               | O(n<sup>2)               |
| n<sup>3               | O(n<sup>3)               |
| 2<sup>n               | O(2<sup>n)               |
| 3<sup>n               | O(3<sup>n)               |
| n!                    | O(n!)                    |
| n<sup>n               | O(n<sup>n)               |