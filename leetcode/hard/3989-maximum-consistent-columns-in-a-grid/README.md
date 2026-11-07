# Maximum Consistent Columns in a Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a 2D integer array `grid` of size `m x n`, and an integer `limit`.

You may remove zero or more columns from the grid, but at least one column must remain. The  **relative**  order of the remaining columns must be preserved.

A grid is called  **consistent**  if for every row `i`, and for every pair of adjacent remaining columns `a` and `b` with `a < b`, the following holds: `|grid[i][b] - grid[i][a]| <= limit`.

Return the  **maximum**  number of columns that can remain such that the resulting grid is  **consistent**.

 

 **Example 1:** 

 **Input:**  grid = [[-2,0,3]], limit = 2

 **Output:**  2

 **Explanation:** 

- Remove column 2 and keep columns 0 and 1, which gives |grid[0][1] − grid[0][0]| = |0 − (−2)| = 2 <= limit.
- Thus, the maximum number of columns that can remain is 2.

 **Example 2:** 

 **Input:**  grid = [[1,-1,1],[2,2,2]], limit = 1

 **Output:**  2

 **Explanation:** 

- Remove column 1 and keep columns 0 and 2, which gives |grid[0][2] − grid[0][0]| = |1 − 1| = 0 <= limit and |grid[1][2] − grid[1][0]| = |2 − 2| = 0 <= limit.
- Thus, the maximum number of columns that can remain is 2.

 **Example 3:** 

 **Input:**  grid = [[-5,5]], limit = 9

 **Output:**  1

 **Explanation:** 

- Remove either column 0 or column 1, since |grid[0][1] − grid[0][0]| = |5 − (−5)| = 10 > limit.
- Thus, the maximum number of columns that can remain is 1.

 

 **Constraints:** 

- 1 <= m == grid.length <= 250
- 1 <= n == grid[i].length <= 250
- -105 <= grid[i][j] <= 105
- 0 <= limit <= 105​​​​​​​​​​​​​​​​

## Solution

**Language:** Java  
**Runtime:** 44 ms (beats 83.93%)  
**Memory:** 62.1 MB (beats 42.86%)  
**Submitted:** 2026-11-07T10:07:56.745Z  

```java
class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] cols = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[j][i] = grid[i][j];
            }
        }
        
        int[] dp = new int[n];
        int maxCols = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int[] colI = cols[i];
            
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                int[] colJ = cols[j];
                
                for (int r = 0; r < m; r++) {
                    if (Math.abs(colI[r] - colJ[r]) > limit) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            
            if (dp[i] > maxCols) {
                maxCols = dp[i];
            }
        }
        
        return maxCols;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-consistent-columns-in-a-grid/)