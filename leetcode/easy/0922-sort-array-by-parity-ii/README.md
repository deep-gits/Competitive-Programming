# Sort Array By Parity II

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of integers `nums`, half of the integers in `nums` are  **odd**, and the other half are  **even**.

Sort the array so that whenever `nums[i]` is odd, `i` is  **odd**, and whenever `nums[i]` is even, `i` is  **even**.

Return  *any answer array that satisfies this condition*.

 

 **Example 1:** 

```
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

```

 **Example 2:** 

```
Input: nums = [2,3]
Output: [2,3]

```

 

 **Constraints:** 

- 2 <= nums.length <= 2 * 104
- nums.length is even.
- Half of the integers in nums are even.
- 0 <= nums[i] <= 1000

 

 **Follow Up:**  Could you solve it in-place?

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 66.59%)  
**Memory:** 48.2 MB (beats 67.92%)  
**Submitted:** 2026-11-05T11:04:43.826Z  

```java
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 != 0) {
                j += 2;
            }
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sort-array-by-parity-ii/)