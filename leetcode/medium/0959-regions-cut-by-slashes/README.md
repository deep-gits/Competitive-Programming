# Regions Cut By Slashes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An `n x n` grid is composed of `1 x 1` squares where each `1 x 1` square consists of a `'/'`, `'\'`, or blank space `' '`. These characters divide the square into contiguous regions.

Given the grid `grid` represented as a string array, return  *the number of regions*.

Note that backslash characters are escaped, so a `'\'` is represented as `'\\'`.

 

 **Example 1:** 

```
Input: grid = [" /","/ "]
Output: 2

```

 **Example 2:** 

```
Input: grid = [" /","  "]
Output: 1

```

 **Example 3:** 

```
Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.

```

 

 **Constraints:** 

- n == grid.length == grid[i].length
- 1 <= n <= 30
- grid[i][j] is either '/', '\', or ' '.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 46.41%)  
**Memory:** 43.7 MB (beats 69.62%)  
**Submitted:** 2026-11-05T11:27:09.415Z  

```java
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[n * 3][n * 3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                int r = i * 3, col = j * 3;
                if (c == '/') {
                    g[r][col + 2] = 1;
                    g[r + 1][col + 1] = 1;
                    g[r + 2][col] = 1;
                } else if (c == '\\') {
                    g[r][col] = 1;
                    g[r + 1][col + 1] = 1;
                    g[r + 2][col + 2] = 1;
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    regions++;
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != 0) {
            return;
        }
        g[r][c] = 1;
        dfs(g, r + 1, c);
        dfs(g, r - 1, c);
        dfs(g, r, c + 1);
        dfs(g, r, c - 1);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/regions-cut-by-slashes/)