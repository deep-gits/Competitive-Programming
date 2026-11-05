# Sum of Even Numbers After Queries

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` and an array `queries` where `queries[i] = [vali, indexi]`.

For each query `i`, first, apply `nums[indexi] = nums[indexi] + vali`, then print the sum of the even values of `nums`.

Return  *an integer array* `answer` *where* `answer[i]` *is the answer to the* `ith` *query*.

 

 **Example 1:** 

```
Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: At the beginning, the array is [1,2,3,4].
After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

```

 **Example 2:** 

```
Input: nums = [1], queries = [[4,0]]
Output: [0]

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -104 <= nums[i] <= 104
- 1 <= queries.length <= 104
- -104 <= vali <= 104
- 0 <= indexi < nums.length

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 77.37%)  
**Memory:** 52.2 MB (beats 76.34%)  
**Submitted:** 2026-11-05T11:39:32.302Z  

```java
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                evenSum += x;
            }
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            
            if (nums[idx] % 2 == 0) {
                evenSum -= nums[idx];
            }
            
            nums[idx] += val;
            
            if (nums[idx] % 2 == 0) {
                evenSum += nums[idx];
            }
            
            ans[i] = evenSum;
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-even-numbers-after-queries/)