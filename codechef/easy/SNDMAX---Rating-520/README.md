# SNDMAX - Rating 520

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Second Max of Three Numbers
### Problem Statement

Write a program that accepts sets of three numbers, and prints the  *second-maximum number*  among the three.

### Input
- First line contains the number of triples, N.
- The next N lines which follow each have three space separated integers.
### Output

For each of the  **N**  triples, output one new line which contains the second-maximum integer among the three.

### Constraints
- 1 ≤ N ≤ 6
- 1 ≤ every integer ≤ 10000
- The three integers in a single triplet are all distinct. That is, no two of them are equal.
### Sample 1:
Input
Output

```
3
1 2 3
10 15 5
100 999 500
```

```
2
10
500
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T11:51:51.598Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            
            if ((a > b && a < c) || (a < b && a > c)) {
                System.out.println(a);
            } else if ((b > a && b < c) || (b < a && b > c)) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/SNDMAX)