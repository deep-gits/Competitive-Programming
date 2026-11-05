# Delete Columns to Make Sorted

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of `n` strings `strs`, all of the same length.

The strings can be arranged such that there is one on each line, making a grid.

- For example, strs = ["abc", "bce", "cae"] can be arranged as follows:

```
abc
bce
cae

```

You want to  **delete**  the columns that are  **not sorted lexicographically**. In the above example (**0-indexed**), columns 0 (`'a'`, `'b'`, `'c'`) and 2 (`'c'`, `'e'`, `'e'`) are sorted, while column 1 (`'b'`, `'c'`, `'a'`) is not, so you would delete column 1.

Return  *the number of columns that you will delete*.

 

 **Example 1:** 

```
Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.

```

 **Example 2:** 

```
Input: strs = ["a","b"]
Output: 0
Explanation: The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.

```

 **Example 3:** 

```
Input: strs = ["zyx","wvu","tsr"]
Output: 3
Explanation: The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.

```

 

 **Constraints:** 

- n == strs.length
- 1 <= n <= 100
- 1 <= strs[i].length <= 1000
- strs[i] consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 78.69%)  
**Memory:** 46.1 MB (beats 98.82%)  
**Submitted:** 2026-11-05T11:14:23.517Z  

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;
        
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows - 1; r++) {
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    deleteCount++;
                    break;
                }
            }
        }
        
        return deleteCount;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/delete-columns-to-make-sorted/)