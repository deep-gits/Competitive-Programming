# Longest Continuous Increasing Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an unsorted array of integers `nums`, return  *the length of the longest  **continuous increasing subsequence**  (i.e. subarray)*. The subsequence must be  **strictly**  increasing.

A  **continuous increasing subsequence**  is defined by two indices `l` and `r` (`l < r`) such that it is `[nums[l], nums[l + 1],..., nums[r - 1], nums[r]]` and for each `l <= i < r`, `nums[i] < nums[i + 1]`.

 

 **Example 1:** 

```
Input: nums = [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
4.

```

 **Example 2:** 

```
Input: nums = [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
increasing.

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -109 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 50.73%)  
**Memory:** 46.5 MB (beats 83.40%)  
**Submitted:** 2026-11-02T15:38:21.914Z  

```java
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        int currentLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)