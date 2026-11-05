# Minimum Area Rectangle II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of points in the  **X-Y**  plane `points` where `points[i] = [xi, yi]`.

Return  *the minimum area of any rectangle formed from these points, with sides  **not necessarily parallel**  to the X and Y axes*. If there is not any such rectangle, return `0`.

Answers within `10-5` of the actual answer will be accepted.

 

 **Example 1:** 

```
Input: points = [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.

```

 **Example 2:** 

```
Input: points = [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.

```

 **Example 3:** 

```
Input: points = [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.

```

 

 **Constraints:** 

- 1 <= points.length <= 50
- points[i].length == 2
- 0 <= xi, yi <= 4 * 104
- All the given points are unique.

## Solution

**Language:** Java  
**Runtime:** 27 ms (beats 75.90%)  
**Memory:** 46.7 MB (beats 92.82%)  
**Submitted:** 2026-11-05T11:30:35.426Z  

```java
class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }
        
        double minArea = Double.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int x3 = points[k][0], y3 = points[k][1];
                    
                    if ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1) == 0) {
                        int x4 = x3 + x2 - x1;
                        int y4 = y3 + y2 - y1;
                        
                        if (set.contains(x4 + "," + y4)) {
                            double area = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 
                                          Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }
        
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-area-rectangle-ii/)