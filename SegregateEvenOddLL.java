public class SegregateEvenOddLL {
    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyEven = new ListNode(-1);
        ListNode dummyOdd = new ListNode(-1);
        ListNode e = dummyEven;
        ListNode o = dummyOdd;

        ListNode curr = head;
        while(curr!=null){
            if(curr.val % 2 == 0){
                e.next = curr;
                e=e.next;
            }else{
                o.next = curr;
                o=o.next;
            }
            curr=curr.next;
        }
        o.next = null;
        e.next = dummyOdd.next;
        return dummyEven.next;
    }
}
