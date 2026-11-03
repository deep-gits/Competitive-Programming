# Detonate the Maximum Bombs

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a list of bombs. The  **range**  of a bomb is defined as the area where its effect can be felt. This area is in the shape of a  **circle**  with the center as the location of the bomb.

The bombs are represented by a  **0-indexed**  2D integer array `bombs` where `bombs[i] = [xi, yi, ri]`. `xi` and `yi` denote the X-coordinate and Y-coordinate of the location of the `ith` bomb, whereas `ri` denotes the  **radius**  of its range.

You may choose to detonate a  **single**  bomb. When a bomb is detonated, it will detonate  **all bombs**  that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of `bombs`, return  *the  **maximum**  number of bombs that can be detonated if you are allowed to detonate  **only one**  bomb*.

 

 **Example 1:** 

```
Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.

```

 **Example 2:** 

```
Input: bombs = [[1,1,5],[10,10,5]]
Output: 1
Explanation:
Detonating either bomb will not detonate the other bomb, so the maximum number of bombs that can be detonated is 1.

```

 **Example 3:** 

```
Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
Output: 5
Explanation:
The best bomb to detonate is bomb 0 because:
- Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
- Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
- Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
Thus all 5 bombs are detonated.

```

 

 **Constraints:** 

- 1 <= bombs.length <= 100
- bombs[i].length == 3
- 1 <= xi, yi, ri <= 105

## Solution

**Language:** Java  
**Runtime:** 206 ms (beats 12.41%)  
**Memory:** 46.3 MB (beats 79.72%)  
**Submitted:** 2026-11-03T13:29:35.238Z  

```java
import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long distSq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                if (distSq <= r1 * r1) {
                    graph[i].add(j);
                }
            }
        }
        
        int maxBombs = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            dfs(graph, i, visited);
            maxBombs = Math.max(maxReg(maxBombs, visited.size()), maxBombs);
        }
        
        return maxBombs;
    }
    
    private void dfs(List<Integer>[] graph, int u, Set<Integer> visited) {
        visited.add(u);
        for (int v : graph[u]) {
            if (!visited.contains(v)) {
                dfs(graph, v, visited);
            }
        }
    }
    
    private int maxReg(int a, int b) {
        return Math.max(a, b);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/detonate-the-maximum-bombs/)