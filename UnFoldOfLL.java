/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class UnFoldOfLL {
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
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null){
            return;
        }
        ListNode d1 = new ListNode (-1);
        ListNode d2 = new ListNode (-1);

        ListNode l1 = d1;
        ListNode l2 = d2;

        ListNode c = head;

        while(c != null && c.next != null){
            l1.next = c;
            l2.next = c.next;

            l1 = l1.next;
            l2 = l2.next;

            c = l2.next;
        }
        l1.next = null;
        l1.next = reverseList(d2.next);
   
    }
}