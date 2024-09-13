public class IntersectionOfLL {
    private int findLengthOfLL (ListNode head){
        
        ListNode curr = head;
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        return size;
        
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null){
            return headA == null? headB:headA;
        }
        
        ListNode bigList = null;
        ListNode smallList = null;
        
        int lengthOfA = findLengthOfLL(headA);
        int lengthOfB = findLengthOfLL(headB);
        
        if (lengthOfA > lengthOfB){
            bigList = headA;
            smallList = headB;
        }else{
            bigList = headB;
            smallList = headA;
        }
        int diff = Math.abs(lengthOfA - lengthOfB);
        while(diff-->0){
            bigList = bigList.next;
        }
        while(bigList!=null && smallList!=null){
            if(bigList == smallList){
                return bigList;
            }
            bigList = bigList.next;
            smallList = smallList.next;
        }
        return null;
        
    }
}
