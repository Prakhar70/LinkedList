public class FoldOfLL {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode midNode = middleNode(head);
        ListNode nHead = midNode.next;
    
        midNode.next = null;
        
        ListNode rHead = reverseList(nHead);

        ListNode c1 = head;
        ListNode c2 = rHead;

        ListNode f1 = null;
        ListNode f2 = null;
        
        while(c2 != null){
            
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
    }
}
