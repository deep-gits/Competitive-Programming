# Valid Number

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s`, return whether `s` is a  **valid number**.

For example, all the following are valid numbers: `"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"`, while the following are not valid numbers: `"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"`.

Formally, a  **valid number**  is defined using one of the following definitions:

- An integer number followed by an optional exponent.
- A decimal number followed by an optional exponent.

An  **integer number**  is defined with an  **optional sign**  `'-'` or `'+'` followed by  **digits**.

A  **decimal number**  is defined with an  **optional sign**  `'-'` or `'+'` followed by one of the following definitions:

- Digits followed by a dot '.'.
- Digits followed by a dot '.' followed by digits.
- A dot '.' followed by digits.

An  **exponent**  is defined with an  **exponent notation**  `'e'` or `'E'` followed by an  **integer number**.

The  **digits**  are defined as one or more digits.

 

Original
Java
 **Example 1:** 

 **Input:**  s = "0"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "e"

 **Output:**  false

 **Example 3:** 

 **Input:**  s = "."

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length <= 20
- s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 42.31%)  
**Memory:** 43.5 MB (beats 76.14%)  
**Submitted:** 2026-11-10T15:54:15.163Z  

```java
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } else if (ch == '+' || ch == '-') {
                if (i > 0) {
                    char prev = s.charAt(i - 1);
                    if (prev != 'e' && prev != 'E') {
                        return false;
                    }
                }
            } else if (ch == '.') {
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } else if (ch == 'e' || ch == 'E') {
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false;
            } else {
                return false;
            }
        }
        
        return seenDigit;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-number/)