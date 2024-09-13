public class CopyRandomPtrLL {
    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        Node curr = head;
        while(curr != null){
            Node frwd = curr.next;
        
            Node nn = new Node (curr.val);

            curr.next = nn;
            nn.next = frwd;
            curr = frwd;
        }

        curr = head;
        while (curr!=null){

            if (curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr= curr.next.next;
        }

        Node originalDummy = new Node (-1);
        Node e = originalDummy;
        Node ansDummy = new Node (-1);
        Node o = ansDummy;
        
        curr = head;
        boolean isOriginalNode = true;
        while(curr != null){
            if (isOriginalNode){
                e.next = curr;
                e= e.next;
            }else{
                o.next = curr;
                o = o.next;
            }
            isOriginalNode = !isOriginalNode;
            curr = curr.next;
        }
        e.next = null;
        o.next = null;
        return ansDummy.next;
    }
}
