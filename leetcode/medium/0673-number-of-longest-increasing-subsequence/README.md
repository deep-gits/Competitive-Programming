# Number of Longest Increasing Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return  *the number of longest increasing subsequences.* 

 **Notice**  that the sequence has to be  **strictly**  increasing.

 

 **Example 1:** 

```
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

```

 **Example 2:** 

```
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.

```

 

 **Constraints:** 

- 1 <= nums.length <= 2000
- -106 <= nums[i] <= 106
- The answer is guaranteed to fit inside a 32-bit integer.

## Solution

**Language:** Java  
**Runtime:** 19 ms (beats 77.82%)  
**Memory:** 44.9 MB (beats 92.79%)  
**Submitted:** 2026-11-02T15:37:19.440Z  

```java
import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] lengths = new int[n];
        int[] counts = new int[n];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)