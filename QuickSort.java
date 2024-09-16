public class QuickSort {
    public static ListNode[] segregateOverPivot(ListNode head, int idx) {
        ListNode pivot = getPivot(head, idx);

        ListNode ll = new ListNode(-1);
        ListNode gg = new ListNode(-1);
        ListNode l = ll;
        ListNode g = gg;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (curr == pivot) {
                continue;
            } else if (curr.val <= pivot.val) {
                l.next = curr;
                l = l.next;
            } else {
                g.next = curr;
                g = g.next;
            }

        }
        g.next = null;
        l.next = null;
        pivot.next = null;
        return new ListNode[] { ll.next, pivot, gg.next };

    }

    private static ListNode getPivot(ListNode head, int idx) {
        if (head == null || head.next == null) {
            return head;
        }
        int pIdx = 0;
        ListNode curr = head;
        while (curr != null) {
            if (pIdx == idx) {
                return curr;
            }
            curr = curr.next;
            pIdx++;
        }
        return null;
    }

    private static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private static ListNode[] mergeSortedList(ListNode[] leftSortedList, ListNode pivotNode,
            ListNode[] rightSortedList) {
        ListNode head = null;
        ListNode tail = null;
        if (leftSortedList[0] != null && rightSortedList[1] != null) {
            leftSortedList[1].next = pivotNode;
            pivotNode.next = rightSortedList[0];
            head = leftSortedList[0];
            tail = rightSortedList[1];
        } else if (leftSortedList[0] != null) {
            leftSortedList[1].next = pivotNode;
            head = leftSortedList[0];
            tail = pivotNode;
        } else if (rightSortedList[0] != null) {
            pivotNode.next = rightSortedList[0];
            head = pivotNode;
            tail = rightSortedList[1];
        } else {
            head = tail = null;
        }

        return new ListNode[] { head, tail };
    }
    private static ListNode[] quickSort_(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[] { head, head };
        }
        int len = length(head);
        int pivotIdx = len / 2;
        ListNode[] segregatedLists = segregateOverPivot(head, pivotIdx);

        ListNode[] leftSortedList = quickSort_(segregatedLists[0]);
        ListNode[] rightSortedList = quickSort_(segregatedLists[2]);

        return mergeSortedList(leftSortedList, segregatedLists[1], rightSortedList);
    }
    public static ListNode quickSort(ListNode head){
        return quickSort_(head)[0];
    }
}
