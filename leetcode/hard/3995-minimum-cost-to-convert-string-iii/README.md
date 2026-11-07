# Minimum Cost to Convert String III

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given two strings, `source` and `target`.

You are also given a 2D string array `rules`, where `rules[i] = [patterni, replacementi]`, and an integer array `costs`, where `costs[i]` is the base cost of applying `rules[i]`. Both arrays have the same length. Additionally, `patterni` and `replacementi` have the same length.

You may apply  **any**  rule  **any**  number of times. Each rule application works as follows:

- Choose an index l such that the range of positions from l to l + patterni.length - 1 exists in the current string and none of these positions has been used in a previous rule application.
- For each index j, the character patterni[j] must either be equal to the current character at position l + j, or be '*'.
- Replace the characters in this range with replacementi. The replacement is used exactly as given and does not contain wildcards.
- The cost of this rule application is costs[i] plus the number of '*' characters in patterni.
- Once a character position has been used in a rule application, it cannot be used in any later rule application.

Since every `patterni` and `replacementi` have the same length, character positions are preserved after every rule application.

Return the  **minimum**  total cost required to transform `source` into `target`. If it is impossible, return -1.

 

 **Example 1:** 

 **Input:**  source = "hello", target = "world", rules = [["he","wo"],["llo","rld"]], costs = [3,4]

 **Output:**  7

 **Explanation:** 

- Apply rules[0] to replace "he" with "wo" at cost 3, so the string becomes "wollo".
- Apply rules[1] to replace "llo" with "rld" at cost 4, so the string becomes "world".
- The total cost is 3 + 4 = 7.

 **Example 2:** 

 **Input:**  source = "cat", target = "dog", rules = [["c*t","dog"]], costs = [2]

 **Output:**  3

 **Explanation:** 

- Apply rules[0] to replace "cat" with "dog". The wildcard '*' matches 'a', adding 1 to the base cost 2.
- The total cost is 2 + 1 = 3.

 **Example 3:** 

 **Input:**  source = "test", target = "next", rules = [[" *e* t","next"]], costs = [4]

 **Output:**  6

 **Explanation:** 

- Apply rules[0] to replace "test" with "next". The first wildcard matches 't' and the second wildcard matches 's', adding 2 to the base cost 4.
- The total cost is 4 + 2 = 6.

 **Example 4:** 

 **Input:**  source = "ab", target = "bc", rules = [["a*","bd"]], costs = [9]

 **Output:**  -1

 **Explanation:** 

No sequence of rule applications can transform `source` into `target`, so the answer is -1.

 

 **Constraints:** 

- 1 <= source.length == target.length <= 5000
- source and target consist of lowercase English letters.
- 1 <= rules.length == costs.length <= 200
- rules[i] = [patterni, replacementi]
- 1 <= patterni.length == replacementi.length <= 20
- patterni contains at least one lowercase English letter and at most 5 '*' characters.
- replacementi contains only lowercase English letters.
- 1 <= costs[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 57 ms (beats 79.31%)  
**Memory:** 47.4 MB (beats 68.97%)  
**Submitted:** 2026-11-07T10:04:02.875Z  

```java
import java.util.List;

class Solution {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        int n = source.length();
        int m = rules.size();
        
        long[] ruleCosts = new long[m];
        char[][] patterns = new char[m][];
        char[][] replacements = new char[m][];
        int[] ruleLens = new int[m];
        
        for (int i = 0; i < m; i++) {
            patterns[i] = rules.get(i).get(0).toCharArray();
            replacements[i] = rules.get(i).get(1).toCharArray();
            ruleLens[i] = patterns[i].length;
            
            ruleCosts[i] = costs[i];
            for (char c : patterns[i]) {
                if (c == '*') {
                    ruleCosts[i]++;
                }
            }
        }
        
        char[] sChars = source.toCharArray();
        char[] tChars = target.toCharArray();
        
        long INF = Long.MAX_VALUE / 2;
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, INF);
        dp[n] = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (sChars[i] == tChars[i]) {
                dp[i] = dp[i + 1];
            }
            
            for (int k = 0; k < m; k++) {
                int L = ruleLens[k];
                if (i + L <= n) {
                    boolean match = true;
                    char[] p = patterns[k];
                    char[] r = replacements[k];
                    
                    for (int j = 0; j < L; j++) {
                        if (r[j] != tChars[i + j]) {
                            match = false;
                            break;
                        }
                        char pChar = p[j];
                        if (pChar != '*' && pChar != sChars[i + j]) {
                            match = false;
                            break;
                        }
                    }
                    
                    if (match) {
                        long cost = ruleCosts[k] + dp[i + L];
                        if (cost < dp[i]) {
                            dp[i] = cost;
                        }
                    }
                }
            }
        }
        
        return dp[0] >= INF ? -1 : (int) dp[0];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-cost-to-convert-string-iii/)