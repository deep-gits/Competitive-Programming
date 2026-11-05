# Largest Component Size by Common Factor

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array of unique positive integers `nums`. Consider the following graph:

- There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
- There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.

Return  *the size of the largest connected component in the graph*.

 

 **Example 1:** 

```
Input: nums = [4,6,15,35]
Output: 4

```

 **Example 2:** 

```
Input: nums = [20,50,9,63]
Output: 2

```

 **Example 3:** 

```
Input: nums = [2,3,6,7,4,12,21,39]
Output: 8

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 104
- 1 <= nums[i] <= 105
- All the values of nums are unique.

## Solution

**Language:** Java  
**Runtime:** 110 ms (beats 52.79%)  
**Memory:** 48 MB (beats 92.94%)  
**Submitted:** 2026-11-05T11:18:35.575Z  

```java
class Solution {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        DSU dsu = new DSU(max + 1);
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    dsu.union(num, factor);
                    dsu.union(num, num / factor);
                }
            }
        }
        
        int[] count = new int[max + 1];
        int maxComponent = 0;
        for (int num : nums) {
            int root = dsu.find(num);
            count[root]++;
            maxComponent = Math.max(maxComponent, count[root]);
        }
        
        return maxComponent;
    }
    
    class DSU {
        int[] parent;
        
        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }
        
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/largest-component-size-by-common-factor/)