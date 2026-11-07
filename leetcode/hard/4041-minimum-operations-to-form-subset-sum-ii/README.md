# Minimum Operations to Form Subset Sum II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and an integer `sum`.

In one  **operation**, choose an element with current value `x` and replace it with either `2 * x` or `floor(x / 2)`.

For each element,  **multiplication**  and  **division**  operations may be performed in any order.

Return the  **minimum**  number of operations needed so that some subset of the resulting array has a sum  **exactly**  equal to `sum`. If it is impossible, return -1.

The `floor()` function returns the integer part of the division.

 

 **Example 1:** 

 **Input:**  nums = [10,2], sum = 13

 **Output:**  3

 **Explanation:** 

- Divide nums[0] = 10 once: 10 → 5, costing 1 operation.
- Multiply nums[1] = 2 twice: 2 → 4 → 8, costing 2 operations.
- After these operations, nums = [5, 8]. The subset {5, 8} sums to 13 using 3 operations in total.

 **Example 2:** 

 **Input:**  nums = [6,3], sum = 8

 **Output:**  2

 **Explanation:** ​​​​​​​

- Turn nums[1] = 3 into 2 using 2 operations: Divide nums[1] to get 1. Multiply nums[1] = 1 to get 2.
- After these operations, nums = [6, 2]. The subset {6, 2} sums to 8 using 2 operations in total.

 **Example 3:** 

 **Input:**  nums = [2,2], sum = 7

 **Output:**  -1

 **Explanation:** 

- No sequence of operations lets a subset of nums sum to 7, so the answer is -1.

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 1 <= nums[i] <= 500
- 1 <= sum <= 5000

## Solution

**Language:** Java  
**Runtime:** 325 ms (beats 46.40%)  
**Memory:** 44.4 MB (beats 99.35%)  
**Submitted:** 2026-11-07T09:56:27.514Z  

```java
class Solution {
    public int minOperations(int[] nums, int sum) {
        int inf = 1_000_000_000;
        int[] dp = new int[sum + 1];
        java.util.Arrays.fill(dp, inf);
        dp[0] = 0;
        
        for (int x : nums) {
            for (int w = sum; w >= 0; w--) {
                for (int i = 0, y = x; y <= w; i++, y *= 2) {
                    dp[w] = Math.min(dp[w], dp[w - y] + i);
                }
                for (int i = 1, y = x / 2; y > 0; i++, y /= 2) {
                    for (int j = 0, z = y; z <= w; j++, z *= 2) {
                        dp[w] = Math.min(dp[w], dp[w - z] + i + j);
                    }
                }
            }
        }
        
        return dp[sum] == inf ? -1 : dp[sum];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-form-subset-sum-ii/)