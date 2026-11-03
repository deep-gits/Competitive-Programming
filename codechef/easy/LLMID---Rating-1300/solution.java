/*class Node{
    int val;
    Node next;
    Node(int x){
    	val = x; next = null;
    }
}*/

static int getMiddleElement(Node head) {
    if (head == null) {
        return -1; // Return -1 or appropriate value if the list is empty
    }
    
    Node slow = head;
    Node fast = head;
    
    // Move 'fast' by 2 steps and 'slow' by 1 step
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    // 'slow' is now pointing to the middle element
    return slow.val;
}