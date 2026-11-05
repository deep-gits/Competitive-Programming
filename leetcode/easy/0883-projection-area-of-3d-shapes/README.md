# Projection Area of 3D Shapes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an `n x n` `grid` where we place some `1 x 1 x 1` cubes that are axis-aligned with the `x`, `y`, and `z` axes.

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of the cell `(i, j)`.

We view the projection of these cubes onto the `xy`, `yz`, and `zx` planes.

A  **projection**  is like a shadow, that maps our  **3-dimensional**  figure to a  **2-dimensional**  plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return  *the total area of all three projections*.

 

 **Example 1:** 

```
Input: grid = [[1,2],[3,4]]
Output: 17
Explanation: Here are the three projections ("shadows") of the shape made with each axis-aligned plane.

```

 **Example 2:** 

```
Input: grid = [[2]]
Output: 5

```

 **Example 3:** 

```
Input: grid = [[1,0],[0,2]]
Output: 8

```

 

 **Constraints:** 

- n == grid.length == grid[i].length
- 1 <= n <= 50
- 0 <= grid[i][j] <= 50

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 97.62%)  
**Memory:** 45.8 MB (beats 81.37%)  
**Submitted:** 2026-11-05T10:47:24.538Z  

```java
class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    ans++;
                }
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            ans += maxRow + maxCol;
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/projection-area-of-3d-shapes/)