class SubstractTwoLL {
    //https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1
    static NodeG reverseList(NodeG head) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeG prev = null;
        NodeG curr = head;
        while (curr != null) {
            NodeG frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        return prev;
    }
    static int LengthOfLL (NodeG head){
        int size = 0;
        while (head != null){
            size ++;
            head = head.next;
        }
        return size;
    }
    

    static NodeG subLinkedList(NodeG l1, NodeG l2) {
        
        while (l1.data == 0){
            l1 = l1.next;
        }
        while (l2.data == 0){
            l2 = l2.next;
        }
        
        int lengthOfL1 = LengthOfLL(l1);
        int lengthOfL2 = LengthOfLL(l2);
        if (lengthOfL1 < lengthOfL2) {
            NodeG temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        if (lengthOfL1 == lengthOfL2){
            NodeG c1 = l1;
            NodeG c2 = l2;
            while (c1 != null){
                if (c1.data < c2.data){
                    NodeG temp = l1;
                    l1 = l2;
                    l2 = temp;
                    break;
                }else if (c1.data > c2.data){
                    break;
                }
                c1 = c1.next;
                c2 = c2.next;
            }
        }
        
        NodeG c1 = reverseList(l1);
        NodeG c2 = reverseList(l2);
        int borrow = 0;
        NodeG prev = null;
        NodeG head = null;
        while (c1 != null || c2 != null) {
            int val = c1.data - (c2 != null ? c2.data : 0) - borrow;
            borrow = 0;
            if (val < 0) {
                val += 10;
                borrow = 1;
            }
            NodeG nn = new NodeG(val);
            if (prev != null) {
                prev.next = nn;
            }else{
                head = nn;
            }
            prev = nn;
            if (c1 != null){
                c1 = c1.next;
            }
            if(c2 != null){
                c2 = c2.next;
            }
        }
        
        NodeG ans =  reverseList(head);
        while (ans != null && ans.data == 0){
            ans = ans.next;
        }
        if (ans == null){
            return new NodeG (0);
        }
        return ans;
    }
}
