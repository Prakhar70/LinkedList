import java.util.PriorityQueue;

public class MergekSortedLLPQ {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for(ListNode ele: lists){
            if(ele != null)
                pq.add(ele);
        }

        while(pq.size()>0){

            ListNode rNode = pq.remove();
            p.next = rNode;
            p =  p.next;
            if(rNode != null)
                pq.add(rNode.next);
        }
        return dummy.next;
    }
}
