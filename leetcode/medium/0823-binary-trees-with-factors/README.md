# Binary Trees With Factors

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of unique integers, `arr`, where each integer `arr[i]` is strictly greater than `1`.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return  *the number of binary trees we can make*. The answer may be too large so return the answer  **modulo**  `109 + 7`.

 

 **Example 1:** 

```
Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
```

 **Example 2:** 

```
Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
```

 

 **Constraints:** 

- 1 <= arr.length <= 1000
- 2 <= arr[i] <= 109
- All the values of arr are unique.

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 59.55%)  
**Memory:** 46.7 MB (beats 52.06%)  
**Submitted:** 2026-11-08T10:28:21.686Z  

```java
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1_000_000_007;
        java.util.Arrays.sort(arr);
        java.util.Map<Integer, Long> dp = new java.util.HashMap<>();
        
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long count = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        count = (count + dp.get(arr[j]) * dp.get(right)) % MOD;
                    }
                }
            }
            dp.put(arr[i], count);
            ans = (ans + count) % MOD;
        }
        
        return (int) ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-trees-with-factors/)