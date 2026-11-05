# Sum of Subsequence Widths

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

The  **width**  of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers `nums`, return  *the sum of the  **widths**  of all the non-empty  **subsequences**  of* `nums`. Since the answer may be very large, return it  **modulo**  `109 + 7`.

A  **subsequence**  is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, `[3,6,2,7]` is a subsequence of the array `[0,3,1,6,2,2,7]`.

 

 **Example 1:** 

```
Input: nums = [2,1,3]
Output: 6
Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

```

 **Example 2:** 

```
Input: nums = [2]
Output: 0

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 34 ms (beats 90.60%)  
**Memory:** 64.9 MB (beats 48.99%)  
**Submitted:** 2026-11-05T10:52:34.659Z  

```java
class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long mod = 1_000_000_007;
        long ans = 0;
        long p = 1;
        
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }
        
        for (int i = 0; i < n; i++) {
            ans = (ans + (pow2[i] - pow2[n - 1 - i]) * nums[i]) % mod;
        }
        
        return (int)((ans + mod) % mod);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-subsequence-widths/)