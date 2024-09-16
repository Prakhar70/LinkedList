public class segregate01LL {
    public static ListNode segregate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy0 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1);

        ListNode zero = dummy0;
        ListNode one = dummy1;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == 0) {
                zero.next = curr;
                zero = zero.next;
            } else {
                one.next = curr;
                one = one.next;
            }
            curr = curr.next;
        }
        one.next = null;
        zero.next = dummy1.next;
        return dummy1.next;
    }
}
