# Three Equal Parts

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an array `arr` which consists of only zeros and ones, divide the array into  **three non-empty parts**  such that all of these parts represent the same binary value.

If it is possible, return any `[i, j]` with `i + 1 < j`, such that:

- arr[0], arr[1],..., arr[i] is the first part,
- arr[i + 1], arr[i + 2],..., arr[j - 1] is the second part, and
- arr[j], arr[j + 1],..., arr[arr.length - 1] is the third part.
- All three parts have equal binary values.

If it is not possible, return `[-1, -1]`.

Note that the entire part is used when considering what binary value it represents. For example, `[1,1,0]` represents `6` in decimal, not `3`. Also, leading zeros  **are allowed**, so `[0,1,1]` and `[1,1]` represent the same value.

 

 **Example 1:** 

```
Input: arr = [1,0,1,0,1]
Output: [0,3]

```

 **Example 2:** 

```
Input: arr = [1,1,0,1,1]
Output: [-1,-1]

```

 **Example 3:** 

```
Input: arr = [1,1,0,0,1]
Output: [0,2]

```

 

 **Constraints:** 

- 3 <= arr.length <= 3 * 104
- arr[i] is 0 or 1

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 71.72%)  
**Memory:** 50.6 MB (beats 58.59%)  
**Submitted:** 2026-11-05T11:06:41.418Z  

```java
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int totalOnes = 0;
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }
        if (totalOnes == 0) {
            return new int[]{0, arr.length - 1};
        }
        if (totalOnes % 3 != 0) {
            return new int[]{-1, -1};
        }
        
        int targetOnes = totalOnes / 3;
        int i1 = -1, i2 = -1, i3 = -1;
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == 1) i1 = i;
                if (count == targetOnes + 1) i2 = i;
                if (count == 2 * targetOnes + 1) i3 = i;
            }
        }
        
        int n = arr.length;
        while (i3 < n) {
            if (arr[i1] == arr[i2] && arr[i2] == arr[i3]) {
                i1++;
                i2++;
                i3++;
            } else {
                return new int[]{-1, -1};
            }
        }
        
        return new int[]{i1 - 1, i2};
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/three-equal-parts/)