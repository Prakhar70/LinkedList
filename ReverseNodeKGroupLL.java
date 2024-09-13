public class ReverseNodeKGroupLL {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode c = head;
        int K = k;
        ListNode th, tt, ah, at;
        th = tt = ah = at = null;
        while (c != null) {
            ListNode f = c.next;
            c.next = null;
            if (th == null) {
                th = tt = c;
            } else {
                c.next = th;
                th = c;
            }
            K--;
            if (K == 0) {
                K = k;
                if (ah == null) {
                    ah = th;
                    at = tt;
                }else{
                    at.next = th;
                    at = tt;
                }
                th = tt = null;
            }
            c = f;
        }
        
        
        if(th!=null){
            at.next = reverseList(th);
        }
        return ah;
        
    }
}
