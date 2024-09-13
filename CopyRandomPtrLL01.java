import java.util.HashMap;

public class CopyRandomPtrLL01 {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }
        Node curr = head;

        Node newCurr = null;
        Node newPrev = null;
        Node nhead = null;

        HashMap<Node, Node> map = new HashMap<>();
        while (curr != null) {


            newCurr = new Node(curr.val);
            if (newPrev == null){
                nhead = newCurr;
            }

            map.put(curr, newCurr);

            if (newPrev != null) {
                newPrev.next = newCurr;
            }
            newPrev = newCurr;
            curr = curr.next;
        }

        Node c = head;
        Node nc = nhead;
        while (c != null){

            if(c.random!=null)
                nc.random = map.get(c.random);
            nc = nc.next;
            c = c.next;
        }

        return nhead;

    }
}
