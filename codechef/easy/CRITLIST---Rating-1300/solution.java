class Solution {
    static int solve(Node root) {
        if (root == null || root.next == null || root.next.next == null) {
            return 0;
        }
        
        int criticalPoints = 0;
        Node prev = root;
        Node current = root.next;
        Node next = current.next;
        
        while (next != null) {
            if ((current.val > prev.val && current.val > next.val) || 
                (current.val < prev.val && current.val < next.val)) {
                criticalPoints++;
            }
            
            prev = current;
            current = next;
            next = next.next;
        }
        
        return criticalPoints;
    }
}