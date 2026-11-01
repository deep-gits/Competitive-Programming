# Tenth Line

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a text file `file.txt`, print just the 10th line of the file.

 **Example:** 

Assume that `file.txt` has the following content:

```
Line 1
Line 2
Line 3
Line 4
Line 5
Line 6
Line 7
Line 8
Line 9
Line 10

```

Your script should output the tenth line, which is:

```
Line 10

```

 **Note:** 
1. If the file contains less than 10 lines, what should you output?
2. There's at least three different solutions. Try to explore all possibilities.

## Solution

**Language:** Bash  
**Runtime:** 20 ms (beats 73.99%)  
**Memory:** 3.8 MB (beats 94.63%)  
**Submitted:** 2026-11-01T15:51:33.537Z  

```sh
sed -n '10p' file.txt
```

---

[View on LeetCode](https://leetcode.com/problems/tenth-line/)