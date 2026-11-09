# Maximal Square

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` binary `matrix` filled with `0`'s and `1`'s,  *find the largest square containing only*  `1`'s  *and return its area*.

 

 **Example 1:** 

```
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

```

 **Example 2:** 

```
Input: matrix = [["0","1"],["1","0"]]
Output: 1

```

 **Example 3:** 

```
Input: matrix = [["0"]]
Output: 0

```

 

 **Constraints:** 

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 300
- matrix[i][j] is '0' or '1'.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 78.01%)  
**Memory:** 70.4 MB (beats 89.56%)  
**Submitted:** 2026-11-09T16:02:33.504Z  

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxLen = 0;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        
        return maxLen * maxLen;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximal-square/)