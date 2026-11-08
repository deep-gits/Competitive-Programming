# Number of Matching Subsequences

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` and an array of strings `words`, return  *the number of*  `words[i]`  *that is a subsequence of*  `s`.

A  **subsequence**  of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

- For example, "ace" is a subsequence of "abcde".

 

 **Example 1:** 

```
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

```

 **Example 2:** 

```
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2

```

 

 **Constraints:** 

- 1 <= s.length <= 5 * 104
- 1 <= words.length <= 5000
- 1 <= words[i].length <= 50
- s and words[i] consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 81 ms (beats 76.84%)  
**Memory:** 176 MB (beats 5.13%)  
**Submitted:** 2026-11-08T10:28:04.139Z  

```java
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int[][] next = new int[n + 1][26];
        
        for (int j = 0; j < 26; j++) {
            next[n][j] = -1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            next[i][s.charAt(i) - 'a'] = i;
        }
        
        int ans = 0;
        for (String word : words) {
            int curr = 0;
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (curr >= n || next[curr][c] == -1) {
                    match = false;
                    break;
                }
                curr = next[curr][c] + 1;
            }
            if (match) {
                ans++;
            }
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-matching-subsequences/)