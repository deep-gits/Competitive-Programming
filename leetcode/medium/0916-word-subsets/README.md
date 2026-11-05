# Word Subsets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two string arrays `words1` and `words2`.

A string `b` is a  **subset**  of string `a` if every letter in `b` occurs in `a` including multiplicity.

- For example, "wrr" is a subset of "warrior" but is not a subset of "world".

A string `a` from `words1` is  **universal**  if for every string `b` in `words2`, `b` is a subset of `a`.

Return an array of all the  **universal**  strings in `words1`. You may return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]

 **Output:**  ["facebook","google","leetcode"]

 **Example 2:** 

 **Input:**  words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["lc","eo"]

 **Output:**  ["leetcode"]

 **Example 3:** 

 **Input:**  words1 = ["acaac","cccbb","aacbb","caacc","bcbbb"], words2 = ["c","cc","b"]

 **Output:**  ["cccbb"]

 

 **Constraints:** 

- 1 <= words1.length, words2.length <= 104
- 1 <= words1[i].length, words2[i].length <= 10
- words1[i] and words2[i] consist only of lowercase English letters.
- All the strings of words1 are unique.

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 37.74%)  
**Memory:** 56.7 MB (beats 59.62%)  
**Submitted:** 2026-11-05T11:03:46.170Z  

```java
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxB = new int[26];
        for (String b : words2) {
            int[] count = new int[26];
            for (char c : b.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxB[i] = Math.max(maxB[i], count[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String a : words1) {
            int[] count = new int[26];
            for (char c : a.toCharArray()) {
                count[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < maxB[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans.add(a);
            }
        }
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/word-subsets/)