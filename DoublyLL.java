public class DoublyLL {
    private class Node {
        Node prev;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    int size = 0;

    private void addFirstNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        addFirstNode(node);
    }

    private void addLastNode(Node node){
        if (this.size==0){
            this.head = this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
        }
    }

    public void addLast(int val){
        Node node = new Node(val);
        addLastNode(node);
    }

}
