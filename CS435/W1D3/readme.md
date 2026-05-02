### What is the time complexity of DACsearchSS? Please explain your claim

Time complex is `O(n * m).`

Time Complexity

In the worst case, each step:

- Splits the matrix into 4 parts
- Recursively searches 3 of them

```
T(n) = 3·T(n/2) + O(1)
```


### What is the space complexity of DACsearchSS? Please explain your claim

`O(log n + log m)`

### (d1) Compare the algorithms searchSS and DACsearchSS using mathematical tools.

DAC is not beneficial here. The saddleback eliminates one full row or column per step; DAC only eliminates one quadrant (1/4 of the area) per level, leaving 3 subproblems — too many.

## Question 2
- $2^n$
- $2^{n + 1}$
- $2^{2n}$
- $2^{2^n}$