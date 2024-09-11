public class IsPalindromeLL {
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

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode midNode = middleNode(head);

        ListNode nHead = midNode.next;
        midNode.next = null;

        ListNode reversedLL = reverseList(nHead);

        ListNode curr1 = head;
        ListNode curr2 = reversedLL;

        boolean res = true;
        while (curr1 != null && curr2 != null) {
            if (curr1.val != curr2.val) {
                res = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        midNode.next = reverseList(nHead);

        return res;

    }
}
