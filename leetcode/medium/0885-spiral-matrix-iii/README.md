# Spiral Matrix III

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You start at the cell `(rStart, cStart)` of an `rows x cols` grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all `rows * cols` spaces of the grid.

Return  *an array of coordinates representing the positions of the grid in the order you visited them*.

 

 **Example 1:** 

```
Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

```

 **Example 2:** 

```
Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

```

 

 **Constraints:** 

- 1 <= rows, cols <= 100
- 0 <= rStart < rows
- 0 <= cStart < cols

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 42.81%)  
**Memory:** 46.6 MB (beats 86.73%)  
**Submitted:** 2026-11-05T10:49:21.092Z  

```java
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[rows * cols][2];
        int len = 0;
        int d = 0;
        int r = rStart, c = cStart;
        int idx = 0;
        
        res[idx++] = new int[]{r, c};
        
        while (idx < rows * cols) {
            if (d == 0 || d == 2) {
                len++;
            }
            for (int i = 0; i < len; i++) {
                r += dirs[d][0];
                c += dirs[d][1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[idx++] = new int[]{r, c};
                }
            }
            d = (d + 1) % 4;
        }
        
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/spiral-matrix-iii/)