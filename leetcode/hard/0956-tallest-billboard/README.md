# Tallest Billboard

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.

You are given a collection of `rods` that can be welded together. For example, if you have rods of lengths `1`, `2`, and `3`, you can weld them together to make a support of length `6`.

Return  *the largest possible height of your billboard installation*. If you cannot support the billboard, return `0`.

 

 **Example 1:** 

```
Input: rods = [1,2,3,6]
Output: 6
Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.

```

 **Example 2:** 

```
Input: rods = [1,2,3,4,5,6]
Output: 10
Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.

```

 **Example 3:** 

```
Input: rods = [1,2]
Output: 0
Explanation: The billboard cannot be supported, so we return 0.

```

 

 **Constraints:** 

- 1 <= rods.length <= 20
- 1 <= rods[i] <= 1000
- sum(rods[i]) <= 5000

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 86.38%)  
**Memory:** 46.5 MB (beats 80.80%)  
**Submitted:** 2026-11-05T11:25:15.045Z  

```java
class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int r : rods) sum += r;
        
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int r : rods) {
            int[] nextDp = dp.clone();
            for (int diff = 0; diff <= sum - r; diff++) {
                if (dp[diff] < 0) continue;
                
                nextDp[diff + r] = Math.max(nextDp[diff + r], dp[diff]);
                
                int diff2 = Math.abs(diff - r);
                int add2 = Math.min(diff, r);
                nextDp[diff2] = Math.max(nextDp[diff2], dp[diff] + add2);
            }
            dp = nextDp;
        }
        
        return dp[0];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/tallest-billboard/)