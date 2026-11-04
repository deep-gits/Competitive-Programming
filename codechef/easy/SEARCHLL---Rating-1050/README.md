# SEARCHLL - Rating 1050

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Remove Nodes with a Given Key

You are given a singly linked list containing n nodes.
Each node contains an integer value.
You are also given an integer `key`.

Your task is to  **delete all the nodes**  from the linked list whose value is  **equal to**  `key`.

After deleting those nodes, print the final linked list from  **head to tail**.

If  **all nodes**  are deleted and the linked list becomes  **empty**, the final output should be $-1$.

## Function Declaration
### Function Name

$removeKey$ — This function removes every node from the linked list whose value matches the given key.

### Parameters

$head$: A pointer to the  **first node**  of the linked list.

- May be NULL if the list is empty.

$key$: An integer value.

- All nodes whose value equals key must be removed.
### Return Value

Returns a pointer to the  **new head**  of the linked list after deleting all matching nodes.

- If all nodes are removed (resulting in an empty list), the function returns $NULL$.

`The input and output formats provided below are only for testing with custom inputs. You only need to return the new head of the linked list. Printing is handled by the driver code.`

## Constraints:
- $1 \le T \le 10^{4}$
- $1 \le n \le 10^{5}$
- $1 \le \text{Node.val} \le 10^{5}$
- $1 \le \text{key} \le 10^{5}$
- $\text{The sum of all } n \text{ across all test cases does not exceed } 10^{5}$
### Input Format

The first line contains an integer `T` — the number of test cases.

For each test case:

- The first line contains an integer n — the number of nodes in the linked list.
- The second line contains n integers — the values of the nodes (from head to tail).
- The third line contains one integer key — the value to be deleted from the list.
### Output Format

For each test case:

- Print the values of the linked list after deleting all nodes equal to key.
- If the linked list becomes empty, print -1.
### Sample 1:
Input
Output

```
4
6
10 20 30 20 40 50
20
5
5 5 5 5 5
5
7
1 2 3 4 5 6 7
8
4
9 8 9 8
9

```

```
10 30 40 50
-1
1 2 3 4 5 6 7
8 8

```

### Explanation:

 **Test Case 1** :
Linked list = [10 -> 20 -> 30 -> 20 -> 40 -> 50]
`key = 20`
Remove all 20’s -> final list = [10 -> 30 -> 40 -> 50]

 **Test Case 2** :
Linked list = [5 -> 5 -> 5 -> 5 -> 5] `key = 5`
All nodes are deleted ? print `-1`

 **Test Case 3** :
Linked list = [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7]
`key = 8`
No node with value 8 -> list remains the same.

 **Test Case 4** :
Linked list = [9 -> 8 -> 9 -> 8]
`key = 9`
After removing all 9’s -> final list = [8 -> 8]

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T16:19:47.787Z  

```java
static Node removeKey(Node head, int key) {
        while (head != null && head.data == key) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == key) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/SEARCHLL)