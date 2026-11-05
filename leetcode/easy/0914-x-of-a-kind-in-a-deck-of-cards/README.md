# X of a Kind in a Deck of Cards

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an integer array `deck` where `deck[i]` represents the number written on the `ith` card.

Partition the cards into  **one or more groups**  such that:

- Each group has exactly x cards where x > 1, and
- All the cards in one group have the same integer written on them.

Return `true` *if such partition is possible, or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

```

 **Example 2:** 

```
Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

```

 

 **Constraints:** 

- 1 <= deck.length <= 104
- 0 <= deck[i] < 104

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 59.66%)  
**Memory:** 46.7 MB (beats 91.91%)  
**Submitted:** 2026-11-05T11:01:15.766Z  

```java
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : deck) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        
        int gcd = -1;
        for (int freq : count.values()) {
            if (gcd == -1) {
                gcd = freq;
            } else {
                gcd = gcd(gcd, freq);
            }
        }
        
        return gcd >= 2;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/)