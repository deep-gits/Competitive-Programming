# Prison Cells After N Days

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `8` prison cells in a row and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

- If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
- Otherwise, it becomes vacant.

 **Note**  that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

You are given an integer array `cells` where `cells[i] == 1` if the `ith` cell is occupied and `cells[i] == 0` if the `ith` cell is vacant, and you are given an integer `n`.

Return the state of the prison after `n` days (i.e., `n` such changes described above).

 

 **Example 1:** 

```
Input: cells = [0,1,0,1,1,0,0,1], n = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

```

 **Example 2:** 

```
Input: cells = [1,0,0,1,0,0,1,0], n = 1000000000
Output: [0,0,1,1,1,1,1,0]

```

 

 **Constraints:** 

- cells.length == 8
- cells[i] is either 0 or 1.
- 1 <= n <= 109

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 46.92%)  
**Memory:** 44.2 MB (beats 52.69%)  
**Submitted:** 2026-11-05T11:26:25.504Z  

```java
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean fastForwarded = false;
        
        for (int i = 0; i < n; i++) {
            String key = Arrays.toString(cells);
            if (!fastForwarded && seen.containsKey(key)) {
                int cycleLength = i - seen.get(key);
                int remaining = (n - 1 - i) % cycleLength;
                i = n - 1 - remaining;
                fastForwarded = true;
            } else {
                seen.put(key, i);
            }
            cells = nextDay(cells);
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                next[i] = 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/prison-cells-after-n-days/)