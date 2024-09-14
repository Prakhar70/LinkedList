public class DeleteDuplicate2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode p2c = null;
        int dn = 101;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                dn = curr.val;
            }
            if (curr.val != dn) {
                if(p2c != null)
                    p2c.next = null;
                prev.next = curr;
                prev = prev.next;
            }
            p2c = curr;
            curr = curr.next;
        }
        prev.next = null;
        return dummy.next;
    }
}
