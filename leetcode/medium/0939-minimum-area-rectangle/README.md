# Minimum Area Rectangle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array of points in the  **X-Y**  plane `points` where `points[i] = [xi, yi]`.

Return  *the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes*. If there is not any such rectangle, return `0`.

 

 **Example 1:** 

```
Input: points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4

```

 **Example 2:** 

```
Input: points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2

```

 

 **Constraints:** 

- 1 <= points.length <= 500
- points[i].length == 2
- 0 <= xi, yi <= 4 * 104
- All the given points are unique.

## Solution

**Language:** Java  
**Runtime:** 107 ms (beats 94.57%)  
**Memory:** 46.5 MB (beats 93.43%)  
**Submitted:** 2026-11-05T11:10:06.086Z  

```java
class Solution {
    public int minAreaRect(int[][] points) {
        Set<Integer> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] * 40001 + p[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    if (pointSet.contains(x1 * 40001 + y2) && pointSet.contains(x2 * 40001 + y1)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-area-rectangle/)