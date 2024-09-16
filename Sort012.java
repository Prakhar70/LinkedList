public class Sort012 {
    //https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
    static NodeG segregate(NodeG head) {
        if (head == null || head.next == null){
            return head;
        }
        NodeG dummy0 = new NodeG (-1);
        NodeG zero = dummy0;
        
        NodeG dummy1 = new NodeG (-1);
        NodeG one = dummy1;
        
        NodeG dummy2 = new NodeG (-1);
        NodeG two = dummy2;
        
        NodeG curr = head;
        while(curr != null){
            if (curr.data == 0){
                zero.next = curr;
                zero = zero.next;
            }else if(curr.data == 1){
                one.next = curr;
                one = one.next;
            }else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        one.next = dummy2.next;
        zero.next = dummy1.next;
        two.next = null;
        
        return dummy0.next;
    }
}
