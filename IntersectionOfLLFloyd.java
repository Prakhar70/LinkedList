public class IntersectionOfLLFloyd {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        // Finding tail of A.. 
        ListNode tail = headA;
        while(tail.next != null){
            tail = tail.next;
        }
        // Making cycle.
        tail.next = headB;

        ListNode slow = headA;
        ListNode fast = headA;
        
        boolean isCyclic = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCyclic = true;
                break;
            }
        }
        if(isCyclic == false){
            // breaking the link
            // No meeting point present
            tail.next = null;
            return null;
        }
        
        slow = headA;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                break;
            }
        } 
        
        // breaking the link
        tail.next = null;
        return slow;
    }
}