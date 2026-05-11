
## Question 1. Practice Radix Sort (Radix = 9)

Array to be sorted: {179, 721, 639, 549, 292, 427, 335, 435, 62}

### Pass 1: Key % 9

```
0 -> 639 -> 549
1 -> 721
2 -> 335
3 -> 435
4 -> 292 -> 427
5 -> (empty)
6 -> (empty)
7 -> (empty)
8 -> 179 -> 62
```


After Pass 1: **639, 549, 721, 335, 435, 292, 427, 179, 62**

### Pass 2: (Key / 9) % 9

```
0 -> (empty)
1 -> 335 -> 179
2 -> 427
3 -> 435
4 -> (empty)
5 -> 292
6 -> 62
7 -> 549
8 -> 639 -> 721
```

After Pass 2: **335, 179, 427, 435, 292, 62, 549, 639, 721**

### Pass 3: Key / 81  (i.e. ((Key / 9) / 9))

```
0 -> 62
1 -> (empty)
2 -> 179
3 -> 292
4 -> 335
5 -> 427 -> 435
6 -> 549
7 -> 639
8 -> 721
```

### Sorted order

**62, 179, 292, 335, 427, 435, 549, 639, 721**


## Question 2. Sorting 4 Elements in Exactly 5 Comparisons

```
1. Compare a : b → relabel so a < b.
2. Compare c : d → relabel so c < d.
3. Compare a : c → relabel pairs so a < c. Now a is the min, with a < b and a < c < d.
4. Compare b : c. If b < c, result is a < b < c < d (done in 4).
5. Else compare b : d. If b < d, result is a < c < b < d; otherwise a < c < d < b.
```

Worst case = 5 comparisons.
Does it violate the lower bound? No.