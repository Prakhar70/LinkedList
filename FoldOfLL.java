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

        ListNode rHead = reverseList(nHead);

        ListNode c1 = head;
        ListNode c2 = rHead;
        while(c2 != null){
            ListNode t1 = c2.next;
            ListNode t2 = c1.next;

            c1.next = c2;
            c2.next = t1;
            
            c1 = t1;
            c2 = t2;
        }
    }
}
