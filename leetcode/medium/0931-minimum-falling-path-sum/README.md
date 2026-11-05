# Minimum Falling Path Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `n x n` array of integers `matrix`, return  *the  **minimum sum**  of any  **falling path**  through*  `matrix`.

A  **falling path**  starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position `(row, col)` will be `(row + 1, col - 1)`, `(row + 1, col)`, or `(row + 1, col + 1)`.

 

 **Example 1:** 

```
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.

```

 **Example 2:** 

```
Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.

```

 

 **Constraints:** 

- n == matrix.length == matrix[i].length
- 1 <= n <= 100
- -100 <= matrix[i][j] <= 100

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 49.88%)  
**Memory:** 47.1 MB (beats 61.08%)  
**Submitted:** 2026-11-05T11:08:03.379Z  

```java
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int left = j > 0 ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = j < n - 1 ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min(down, Math.min(left, right));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[0][j]);
        }
        return minSum;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-falling-path-sum/)