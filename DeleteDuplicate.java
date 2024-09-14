public class DeleteDuplicate {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int prevVal = 101;
        ListNode curr = head;
        ListNode prevToCurr = null;
        while (curr != null) {

            if (curr.val != prevVal) {
                if (prevToCurr != null)
                    prevToCurr.next = null;
                prev.next = curr;
                prev = prev.next;
                prevVal = curr.val;
            }
            prevToCurr = curr;
            curr = curr.next;
        }
        prev.next = null;
        return dummy.next;
    }
}
