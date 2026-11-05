# Unique Paths III

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an `m x n` integer array `grid` where `grid[i][j]` could be:

- 1 representing the starting square. There is exactly one starting square.
- 2 representing the ending square. There is exactly one ending square.
- 0 representing empty squares we can walk over.
- -1 representing obstacles that we cannot walk over.

Return  *the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once*.

 

 **Example 1:** 

```
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

```

 **Example 2:** 

```
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

```

 **Example 3:** 

```
Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

```

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 20
- 1 <= m * n <= 20
- -1 <= grid[i][j] <= 2
- There is exactly one starting cell and one ending cell.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.1 MB (beats 90.51%)  
**Submitted:** 2026-11-05T11:37:30.454Z  

```java
class Solution {
    private int res = 0;
    private int empty = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        int rows = grid.length, cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    empty++;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        
        dfs(grid, startX, startY, 0);
        return res;
    }
    
    private void dfs(int[][] grid, int r, int c, int count) {
        int rows = grid.length, cols = grid[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == -1) {
            return;
        }
        
        if (grid[r][c] == 2) {
            if (count == empty) {
                res++;
            }
            return;
        }
        
        int temp = grid[r][c];
        grid[r][c] = -1;
        count++;
        
        dfs(grid, r + 1, c, count);
        dfs(grid, r - 1, c, count);
        dfs(grid, r, c + 1, count);
        dfs(grid, r, c - 1, count);
        
        grid[r][c] = temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/unique-paths-iii/)