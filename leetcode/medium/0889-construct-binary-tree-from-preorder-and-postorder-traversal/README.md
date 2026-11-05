# Construct Binary Tree from Preorder and Postorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two integer arrays, `preorder` and `postorder` where `preorder` is the preorder traversal of a binary tree of  **distinct**  values and `postorder` is the postorder traversal of the same tree, reconstruct and return  *the binary tree*.

If there exist multiple answers, you can  **return any**  of them.

 

 **Example 1:** 

```
Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

```

 **Example 2:** 

```
Input: preorder = [1], postorder = [1]
Output: [1]

```

 

 **Constraints:** 

- 1 <= preorder.length <= 30
- 1 <= preorder[i] <= preorder.length
- All the values of preorder are unique.
- postorder.length == preorder.length
- 1 <= postorder[i] <= postorder.length
- All the values of postorder are unique.
- It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 23.86%)  
**Memory:** 44.8 MB (beats 77.37%)  
**Submitted:** 2026-11-05T10:51:17.921Z  

```java
import java.util.*;

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;
        
        int nextVal = pre[preStart + 1];
        int mid = map.get(nextVal);
        int leftSize = mid - postStart + 1;
        
        root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, mid, map);
        root.right = build(pre, preStart + leftSize + 1, preEnd, post, mid + 1, postEnd - 1, map);
        
        return root;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)