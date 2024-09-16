public class SegregateOverPivotIdx {
    public static ListNode segregateOverPivot(ListNode head, int idx){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pivot = getPivot(head, idx);

        ListNode ll = new ListNode (-1);
        ListNode gg = new ListNode (-1);
        ListNode l = ll;
        ListNode g = gg;

        for(ListNode curr = head; curr != null; curr = curr.next){
            if( curr == pivot){
                continue;
            }
            else if (curr.val <= pivot.val){
                l.next = curr;
                l = l.next;
            }else{
                g.next = curr;
                g = g.next;
            }
            
        }
        g.next = null;
        l.next = pivot;
        pivot.next = gg.next;
        return ll.next;

    }

    private static ListNode getPivot(ListNode head, int idx) {
        if (head == null || head.next == null){
            return head;
        }
        int pIdx = 0;
        ListNode curr = head;
        while (curr != null){
            if (pIdx == idx){
                return curr;
            }
            curr = curr.next;
            pIdx++;
        }
        return null;
    }
}
