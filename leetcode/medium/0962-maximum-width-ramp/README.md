# Maximum Width Ramp

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

A  **ramp**  in an integer array `nums` is a pair `(i, j)` for which `i < j` and `nums[i] <= nums[j]`. The  **width**  of such a ramp is `j - i`.

Given an integer array `nums`, return  *the maximum width of a  **ramp**  in* `nums`. If there is no  **ramp**  in `nums`, return `0`.

 

 **Example 1:** 

```
Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.

```

 **Example 2:** 

```
Input: nums = [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.

```

 

 **Constraints:** 

- 2 <= nums.length <= 5 * 104
- 0 <= nums[i] <= 5 * 104

## Solution

**Language:** Java  
**Runtime:** 33 ms (beats 13.49%)  
**Memory:** 59.6 MB (beats 57.35%)  
**Submitted:** 2026-11-05T11:29:13.246Z  

```java
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));
        
        int minIndex = n;
        int maxWidth = 0;
        
        for (int i = 0; i < n; i++) {
            maxWidth = Math.max(maxWidth, indices[i] - minIndex);
            minIndex = Math.min(minIndex, indices[i]);
        }
        
        return maxWidth;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-width-ramp/)