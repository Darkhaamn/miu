## Question 1. Design and Analysis of the algorithms

### (a)

Two-pointer partition. `i` starts at the left, `j` at the right. Move `i` right while `A[i] = Blue`, move `j` left while `A[j] = Red`; if `i < j`, swap `A[i]` and `A[j]` and advance both. Stop when `i ≥ j`.

- In place: **Yes**
- Space: **O(1)**
- Time: **O(n)**

### (b) 

Three pointers `low = 0`, `mid = 0`, `high = n − 1`. While `mid ≤ high`:

- if `A[mid] = Blue`: swap `A[low], A[mid]`; `low++`; `mid++`
- if `A[mid] = Green`: `mid++`
- if `A[mid] = Red`: swap `A[mid], A[high]`; `high--`

- In place: **Yes**
- Space: **O(1)**
- Time: **O(n)**

### (c)

Counting sort. Make one pass to count each color, then a second pass to overwrite the array Blue → Red → Green → Yellow.

- In place: **Yes** (output written back into the same array)
- Space: **O(k) = O(4) = O(1)** auxiliary
- Time: **O(n)**

---

## Question 2. Quicksort (median of three)

### (a) `{1, 2, 3, 4, 5, 6, 7, 8, 9}`

**Call QuickSort(A, 0, 8).**
First = A[0] = 1, last = A[8] = 9, middle = A[4] = 5.
Median of {1, 9, 5} is 5. Pivot = 5.

Swap pivot and last:

```
1  2  3  4  9  6  7  8  5
i                       j←j        // move i and j
1  2  3  4  9  6  7  8  5
            i        j             // i stops (9≥5), j stops (4<5)
                                   // i > j, swap A[i] with pivot
[1 2 3 4]  [5]  [6 7 8 9]
```

|L| = 4, |E| = 1, |G| = 4. Recurse on L and G.

**Call QuickSort(L, 0, 3) on {1, 2, 3, 4}.**
First = 1, last = 4, middle = A[1] = 2. Median of {1, 4, 2} is 2. Pivot = 2.

Swap pivot and last:

```
1  4  3  2
i        j←j      // j starts at 2
1  4  3  2
   i  j           // i stops (4≥2), j walks left to 0
[1]  [2]  [3 4]
```

|L| = 1, |E| = 1, |G| = 2.

**Call QuickSort(G, 2, 3) on {3, 4}.**
First = 3, last = 4, middle = A[2] = 3. Median of {3, 4, 3} is 3. Pivot = 3.

Swap pivot and last:

```
4  3
ij                // i = j = 2
   J←
[ ]  [3]  [4]
```

|L| = 0, |E| = 1, |G| = 1. Base.

**Call QuickSort(G, 5, 8) on {6, 7, 8, 9}.**
First = 6, last = 9, middle = A[6] = 7. Median of {6, 9, 7} is 7. Pivot = 7.

Swap pivot and last:

```
6  9  8  7
i        j←j
6  9  8  7
   i  j
[6]  [7]  [8 9]
```

|L| = 1, |E| = 1, |G| = 2.

**Call QuickSort(G, 7, 8) on {8, 9}.**
Median of {8, 9, 8} is 8. Pivot = 8. Swap pivot and last:

```
9  8
ij
J←
[ ]  [8]  [9]
```

Final sorted: **{1, 2, 3, 4, 5, 6, 7, 8, 9}**.

---

### (b) `{8, 7, 6, 5, 4, 3, 2, 1, 9}`

**Call QuickSort(A, 0, 8).**
First = 8, last = 9, middle = A[4] = 4. Median of {8, 9, 4} is 8. Pivot = 8.

Swap pivot and last:

```
9  7  6  5  4  3  2  1  8
i                    j←j           // i stops (9≥8), j stops (1<8)
                                   // swap A[i], A[j]
1  7  6  5  4  3  2  9  8
   i              j                // i++, j--
1  7  6  5  4  3  2  9  8
                  j  i             // i walks to 7 (9≥8), j stops (2<8)
[1 7 6 5 4 3 2]  [8]  [9]
```

|L| = 7, |E| = 1, |G| = 1.

**Call QuickSort(L, 0, 6) on {1, 7, 6, 5, 4, 3, 2}.**
First = 1, last = 2, middle = A[3] = 5. Median of {1, 2, 5} is 2. Pivot = 2.

Swap pivot and last (pivot already at last, no change):

```
1  7  6  5  4  3  2
i              j←j
1  7  6  5  4  3  2
   i        j                      // i stops (7≥2), j walks left to 0
[1]  [2]  [6 5 4 3 7]
```

|L| = 1, |E| = 1, |G| = 5.

**Call QuickSort(G, 2, 6) on {6, 5, 4, 3, 7}.**
First = 6, last = 7, middle = A[4] = 4. Median of {6, 7, 4} is 6. Pivot = 6.

Swap pivot and last:

```
7  5  4  3  6
i        j←j                       // i stops (7≥6), j stops (3<6)
3  5  4  7  6                      // swap A[i], A[j]
   i  j                            // i++, j--
3  5  4  7  6
      j  i                         // i walks to 5 (7≥6), j stops (4<6)
[3 5 4]  [6]  [7]
```

|L| = 3, |E| = 1, |G| = 1.

**Call QuickSort(L, 2, 4) on {3, 5, 4}.**
First = 3, last = 4, middle = A[3] = 5. Median of {3, 4, 5} is 4. Pivot = 4.

Swap pivot and last (no change):

```
3  5  4
i  j←j
3  5  4
   i j                             // i stops (5≥4), j stops (3<4)
[3]  [4]  [5]
```

|L| = 1, |E| = 1, |G| = 1. Base cases on each side.

Final sorted: **{1, 2, 3, 4, 5, 6, 7, 8, 9}**.

---

### (c) `{9, 1, 8, 2, 7, 3, 6, 4, 5}`

**Call QuickSort(A, 0, 8).**
First = 9, last = 5, middle = A[4] = 7. Median of {9, 5, 7} is 7. Pivot = 7.

Swap pivot and last:

```
9  1  8  2  5  3  6  4  7
i                    j←j           // i stops (9≥7), j stops (4<7)
4  1  8  2  5  3  6  9  7          // swap A[i], A[j]
   i              j                // i++, j--
4  1  8  2  5  3  6  9  7
      i        j                   // i stops (8≥7), j stops (6<7)
4  1  6  2  5  3  8  9  7          // swap A[i], A[j]
         i  j                      // i++, j--
4  1  6  2  5  3  8  9  7
            j  i                   // i walks to 6 (8≥7), j stops (3<7)
[4 1 6 2 5 3]  [7]  [9 8]
```

|L| = 6, |E| = 1, |G| = 2.

**Call QuickSort(L, 0, 5) on {4, 1, 6, 2, 5, 3}.**
First = 4, last = 3, middle = A[2] = 6. Median of {4, 3, 6} is 4. Pivot = 4.

Swap pivot and last:

```
3  1  6  2  5  4
i           j←j
3  1  6  2  5  4
      i  j                         // i stops (6≥4), j stops (2<4)
3  1  2  6  5  4                   // swap A[i], A[j]
         i  j                      // i > j after stops
[3 1 2]  [4]  [5 6]
```

|L| = 3, |E| = 1, |G| = 2.

**Call QuickSort(L, 0, 2) on {3, 1, 2}.**
First = 3, last = 2, middle = A[1] = 1. Median of {3, 2, 1} is 2. Pivot = 2.

Swap pivot and last (no change):

```
3  1  2
i  j←j
3  1  2
i  j                               // i stops (3≥2), j stops (1<2)
1  3  2                            // swap A[i], A[j]
   i  
   j                               // after i++,j--
[1]  [2]  [3]
```

|L| = 1, |E| = 1, |G| = 1. Base cases.

**Call QuickSort(G, 4, 5) on {5, 6}.**
Median of {5, 6, 5} is 5. Pivot = 5. Swap pivot and last:

```
6  5
ij
J←
[ ]  [5]  [6]
```

**Call QuickSort(G, 7, 8) on {9, 8}.**
Median of {9, 8, 9} is 8. Pivot = 8. Swap pivot and last:

```
9  8
ij
J←
[ ]  [8]  [9]
```

Final sorted: **{1, 2, 3, 4, 5, 6, 7, 8, 9}**.

---

## Question 3. QuickSelect (median of three)

### (a) `{1, 2, 3, 4, 5, 6, 7, 8, 9}`, k = 4

**Call QuickSelect(A, 4).**
First = 1, last = 9, middle = A[4] = 5. Median of {1, 9, 5} is 5. Pivot = 5.

```
1  2  3  4  9  6  7  8  5
i                       j←j
1  2  3  4  9  6  7  8  5
            i        j
[1 2 3 4]  [5]  [6 7 8 9]
```

|L| = 4, |E| = 1, |G| = 4. Since |L| = 4 ≥ k = 4, recurse on L with k = 4.

**Call QuickSelect(L, 4) on {1, 2, 3, 4}.**
First = 1, last = 4, middle = A[1] = 2. Median of {1, 4, 2} is 2. Pivot = 2.

```
1  4  3  2
i        j←j
1  4  3  2
   i  j
[1]  [2]  [3 4]
```

|L| = 1, |E| = 1, |G| = 2. Since |L|+|E| = 2 < k = 4, k changes to k − (|L|+|E|) = 4 − 2 = 2. Recurse on G with k = 2.

**Call QuickSelect(G, 2) on {3, 4}.**
Median of {3, 4, 3} is 3. Pivot = 3.

```
4  3
ij
J←
[ ]  [3]  [4]
```

|L| = 0, |E| = 1, |G| = 1. Since |L|+|E| = 1 < k = 2, k changes to 2 − 1 = 1. Recurse on G with k = 1.

QuickSelect(G, 1) returns **4** since G has only one item.

**Answer: 4.**

---

### (b) `{8, 7, 6, 5, 4, 3, 2, 1, 9}`, k = 5

**Call QuickSelect(A, 5).**
First = 8, last = 9, middle = A[4] = 4. Median of {8, 9, 4} is 8. Pivot = 8.

```
9  7  6  5  4  3  2  1  8
i                    j←j
1  7  6  5  4  3  2  9  8
   i              j
1  7  6  5  4  3  2  9  8
                  j  i
[1 7 6 5 4 3 2]  [8]  [9]
```

|L| = 7, |E| = 1, |G| = 1. Since |L| = 7 ≥ k = 5, recurse on L with k = 5.

**Call QuickSelect(L, 5) on {1, 7, 6, 5, 4, 3, 2}.**
First = 1, last = 2, middle = A[3] = 5. Median of {1, 2, 5} is 2. Pivot = 2.

```
1  7  6  5  4  3  2
i              j←j
1  7  6  5  4  3  2
   i        j
[1]  [2]  [6 5 4 3 7]
```

|L| = 1, |E| = 1, |G| = 5. Since |L|+|E| = 2 < k = 5, k changes to 5 − 2 = 3. Recurse on G with k = 3.

**Call QuickSelect(G, 3) on {6, 5, 4, 3, 7}.**
First = 6, last = 7, middle = A[4] = 4. Median of {6, 7, 4} is 6. Pivot = 6.

```
7  5  4  3  6
i        j←j
3  5  4  7  6
   i  j
3  5  4  7  6
      j  i
[3 5 4]  [6]  [7]
```

|L| = 3, |E| = 1, |G| = 1. Since |L| = 3 ≥ k = 3, recurse on L with k = 3.

**Call QuickSelect(L, 3) on {3, 5, 4}.**
Median of {3, 4, 5} is 4. Pivot = 4.

```
3  5  4
i  j←j
3  5  4
   i j
[3]  [4]  [5]
```

|L| = 1, |E| = 1, |G| = 1. Since |L|+|E| = 2 < k = 3, k changes to 3 − 2 = 1. Recurse on G with k = 1.

QuickSelect(G, 1) returns **5** since G has only one item.

**Answer: 5.**

---

### (c) `{9, 1, 8, 2, 7, 3, 6, 4, 5}`, k = 6

**Call QuickSelect(A, 6).**
First = 9, last = 5, middle = A[4] = 7. Median of {9, 5, 7} is 7. Pivot = 7.

```
9  1  8  2  5  3  6  4  7
i                    j←j
4  1  8  2  5  3  6  9  7
   i              j
4  1  8  2  5  3  6  9  7
      i        j
4  1  6  2  5  3  8  9  7
         i  j
4  1  6  2  5  3  8  9  7
            j  i
[4 1 6 2 5 3]  [7]  [9 8]
```

|L| = 6, |E| = 1, |G| = 2. Since |L| = 6 ≥ k = 6, recurse on L with k = 6.

**Call QuickSelect(L, 6) on {4, 1, 6, 2, 5, 3}.**
First = 4, last = 3, middle = A[2] = 6. Median of {4, 3, 6} is 4. Pivot = 4.

```
3  1  6  2  5  4
i           j←j
3  1  6  2  5  4
      i  j
3  1  2  6  5  4
         i  j
[3 1 2]  [4]  [5 6]
```

|L| = 3, |E| = 1, |G| = 2. Since |L|+|E| = 4 < k = 6, k changes to 6 − 4 = 2. Recurse on G with k = 2.

**Call QuickSelect(G, 2) on {5, 6}.**
Median of {5, 6, 5} is 5. Pivot = 5.

```
6  5
ij
J←
[ ]  [5]  [6]
```

|L| = 0, |E| = 1, |G| = 1. Since |L|+|E| = 1 < k = 2, k changes to 2 − 1 = 1. Recurse on G with k = 1.

QuickSelect(G, 1) returns **6** since G has only one item.

**Answer: 6.**
