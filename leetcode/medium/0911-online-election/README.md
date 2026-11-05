# Online Election

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two integer arrays `persons` and `times`. In an election, the `ith` vote was cast for `persons[i]` at time `times[i]`.

For each query at a time `t`, find the person that was leading the election at time `t`. Votes cast at time `t` will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.

Implement the `TopVotedCandidate` class:

- TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
- int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.

 

 **Example 1:** 

```
Input
["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
Output
[null, 0, 1, 1, 0, 0, 1]

Explanation
TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
topVotedCandidate.q(15); // return 0
topVotedCandidate.q(24); // return 0
topVotedCandidate.q(8); // return 1

```

 

 **Constraints:** 

- 1 <= persons.length <= 5000
- times.length == persons.length
- 0 <= persons[i] < persons.length
- 0 <= times[i] <= 109
- times is sorted in a strictly increasing order.
- times[0] <= t <= 109
- At most 104 calls will be made to q.

## Solution

**Language:** Java  
**Runtime:** 63 ms (beats 76.34%)  
**Memory:** 70.4 MB (beats 76.34%)  
**Submitted:** 2026-11-05T10:59:48.892Z  

```java
class TopVotedCandidate {
    private int[] leaders;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];
        Map<Integer, Integer> countMap = new HashMap<>();
        int lead = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
            int votes = countMap.get(p);
            if (votes >= maxVotes) {
                maxVotes = votes;
                lead = p;
            }
            leaders[i] = lead;
        }
    }
    
    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);
        if (idx < 0) {
            idx = -idx - 2;
        }
        return leaders[idx];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/online-election/)