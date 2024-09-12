class MergeSortLL {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null)
            return list1 != null ? list1 : list2;

        ListNode c1 = list1;
        ListNode c2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.next = c1;
                prev = prev.next;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev = prev.next;
                c2 = c2.next;
            }
        }
        prev.next = (c1 != null) ? c1 : c2;

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = middleNode (head);
        ListNode nHead = midNode.next;

        midNode.next = null;

        return mergeTwoLists(sortList(head), sortList(nHead));
    }
}