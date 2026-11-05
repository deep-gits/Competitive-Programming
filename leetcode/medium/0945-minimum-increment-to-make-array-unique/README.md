# Minimum Increment to Make Array Unique

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums`. In one move, you can pick an index `i` where `0 <= i < nums.length` and increment `nums[i]` by `1`.

Return  *the minimum number of moves to make every value in* `nums` ***unique***.

The test cases are generated so that the answer fits in a 32-bit integer.

 

 **Example 1:** 

```
Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

```

 **Example 2:** 

```
Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown that it is impossible for the array to have all unique values with 5 or less moves.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 0 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 44 ms (beats 45.84%)  
**Memory:** 79.7 MB (beats 65.87%)  
**Submitted:** 2026-11-05T11:15:00.196Z  

```java
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int minIncrements = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] + 1 - nums[i];
                minIncrements += increment;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return minIncrements;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-increment-to-make-array-unique/)