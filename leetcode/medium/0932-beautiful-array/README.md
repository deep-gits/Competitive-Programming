# Beautiful Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An array `nums` of length `n` is  **beautiful**  if:

- nums is a permutation of the integers in the range [1, n].
- For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].

Given the integer `n`, return  *any  **beautiful**  array* `nums` *of length* `n`. There will be at least one valid answer for the given `n`.

 

 **Example 1:** 

```
Input: n = 4
Output: [2,1,4,3]

```

 **Example 2:** 

```
Input: n = 5
Output: [3,1,2,5,4]

```

 

 **Constraints:** 

- 1 <= n <= 1000

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 14.98%)  
**Memory:** 43.6 MB (beats 70.47%)  
**Submitted:** 2026-11-05T11:08:29.190Z  

```java
class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            List<Integer> temp = new ArrayList<>();
            for (int x : res) {
                if (2 * x - 1 <= n) {
                    temp.add(2 * x - 1);
                }
            }
            for (int x : res) {
                if (2 * x <= n) {
                    temp.add(2 * x);
                }
            }
            res = temp;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/beautiful-array/)