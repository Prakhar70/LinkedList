public class addTwoNum {
    private ListNode reverseList(ListNode head) {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c1 = reverseList (l1);
        ListNode c2 = reverseList (l2);
        int carry = 0;

        ListNode prev = null;
        ListNode head = null;
        while (c1 != null || c2 != null || carry != 0) {

            int firstValue = c1 != null ? c1.val : 0;
            int secondValue = c2 != null ? c2.val : 0;
            int val = firstValue + secondValue + carry;
            ListNode nn = new ListNode (val%10);
            carry = val/10;
            
            if (prev != null){
                prev.next = nn;
            }else{
                head = nn;
            }
            prev = nn;
            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        return reverseList(head);
    }
}
