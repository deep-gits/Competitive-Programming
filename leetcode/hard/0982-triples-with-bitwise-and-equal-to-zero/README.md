# Triples with Bitwise AND Equal To Zero

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array nums, return  *the number of  **AND triples***.

An  **AND triple**  is a triple of indices `(i, j, k)` such that:

- 0 <= i < nums.length
- 0 <= j < nums.length
- 0 <= k < nums.length
- nums[i] & nums[j] & nums[k] == 0, where & represents the bitwise-AND operator.

 

 **Example 1:** 

```
Input: nums = [2,1,3]
Output: 12
Explanation: We could choose the following i, j, k triples:
(i=0, j=0, k=1) : 2 & 2 & 1
(i=0, j=1, k=0) : 2 & 1 & 2
(i=0, j=1, k=1) : 2 & 1 & 1
(i=0, j=1, k=2) : 2 & 1 & 3
(i=0, j=2, k=1) : 2 & 3 & 1
(i=1, j=0, k=0) : 1 & 2 & 2
(i=1, j=0, k=1) : 1 & 2 & 1
(i=1, j=0, k=2) : 1 & 2 & 3
(i=1, j=1, k=0) : 1 & 1 & 2
(i=1, j=2, k=0) : 1 & 3 & 2
(i=2, j=0, k=1) : 3 & 2 & 1
(i=2, j=1, k=0) : 3 & 1 & 2

```

 **Example 2:** 

```
Input: nums = [0,0,0]
Output: 27

```

 

 **Constraints:** 

- 1 <= nums.length <= 1000
- 0 <= nums[i] < 216

## Solution

**Language:** Java  
**Runtime:** 234 ms (beats 54.17%)  
**Memory:** 46.2 MB (beats 77.08%)  
**Submitted:** 2026-11-05T11:38:06.035Z  

```java
class Solution {
    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                count[x & y]++;
            }
        }
        
        int ans = 0;
        for (int z : nums) {
            for (int i = 0; i < (1 << 16); i++) {
                if ((i & z) == 0) {
                    ans += count[i];
                }
            }
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/)