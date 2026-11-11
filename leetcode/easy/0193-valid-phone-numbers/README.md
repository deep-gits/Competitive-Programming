# Valid Phone Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a text file `file.txt` that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.

 **Example:** 

Assume that `file.txt` has the following content:

```
987-123-4567
123 456 7890
(123) 456-7890

```

Your script should output the following valid phone numbers:

```
987-123-4567
(123) 456-7890

```

## Solution

**Language:** Bash  
**Runtime:** 33 ms (beats 98.50%)  
**Memory:** 3.3 MB (beats 78.14%)  
**Submitted:** 2026-11-11T18:25:17.661Z  

```sh
grep -P '^(\(\d{3}\) \d{3}-\d{4}|\d{3}-\d{3}-\d{4})$' file.txt
```

---

[View on LeetCode](https://leetcode.com/problems/valid-phone-numbers/)