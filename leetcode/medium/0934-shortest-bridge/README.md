# Shortest Bridge

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `n x n` binary matrix `grid` where `1` represents land and `0` represents water.

An  **island**  is a 4-directionally connected group of `1`'s not connected to any other `1`'s. There are  **exactly two islands**  in `grid`.

You may change `0`'s to `1`'s to connect the two islands to form  **one island**.

Return  *the smallest number of* `0` *'s you must flip to connect the two islands*.

 

 **Example 1:** 

```
Input: grid = [[0,1],[1,0]]
Output: 1

```

 **Example 2:** 

```
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

```

 **Example 3:** 

```
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

```

 

 **Constraints:** 

- n == grid.length == grid[i].length
- 2 <= n <= 100
- grid[i][j] is either 0 or 1.
- There are exactly two islands in grid.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 94.92%)  
**Memory:** 46.5 MB (beats 95.60%)  
**Submitted:** 2026-11-05T11:09:05.061Z  

```java
class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }
        
        int steps = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        int n = grid.length;
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        queue.offer(new int[]{r, c});
        dfs(grid, r - 1, c, queue);
        dfs(grid, r + 1, c, queue);
        dfs(grid, r, c - 1, queue);
        dfs(grid, r, c + 1, queue);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/shortest-bridge/)