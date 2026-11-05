# Partition Array into Disjoint Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, partition it into two (contiguous) subarrays `left` and `right` so that:

- Every element in left is less than or equal to every element in right.
- left and right are non-empty.
- left has the smallest possible size.

Return  *the length of* `left` *after such a partitioning*.

Test cases are generated such that partitioning exists.

 

 **Example 1:** 

```
Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

```

 **Example 2:** 

```
Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- 0 <= nums[i] <= 106
- There is at least one valid answer for the given input.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 93.35%)  
**Memory:** 86.4 MB (beats 52.33%)  
**Submitted:** 2026-11-05T11:03:06.399Z  

```java
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0];
        int maxSoFar = nums[0];
        int partitionIdx = 0;
        
        for (int i = 1; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = maxSoFar;
                partitionIdx = i;
            }
        }
        
        return partitionIdx + 1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/partition-array-into-disjoint-intervals/)