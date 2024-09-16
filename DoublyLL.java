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

    // Addition Functions
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

    private void addLastNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
        }
    }

    public void addLast(int val) {
        Node node = new Node(val);
        addLastNode(node);
    }

    public void addAt(int index, int data){
    
        if (IndexIsInvalidException(index, 0, this.size)){
            return;
        }
        Node node = new Node(data);
        addNodeAt (index, node);

    }

    private void addNodeAt(int index, Node node) {
        if (index == 0){
            addFirstNode(node);
        }else if (index == this.size){
            addLastNode(node);
        }
        Node forw = getNodeAt(index);
        Node prev = forw.prev;

        prev.next = node;
        node.prev = prev; 

        node.next = forw;
        forw.prev = node;
        this.size ++;
        
    }

    // Exceptions
    private boolean ListIsEmptyException() {
        if (this.size == 0) {
            System.out.println("List Is Empty: ");
            return true;
        }
        return false;
    }

    private boolean IndexIsInvalidException(int index, int leftRange, int rightRange) {
        if (index < leftRange || index > rightRange) {
            System.out.println("Index is Invalid");
            return true;
        }
        return false;
    }

    // Remove Functions
    private Node removeFirstNode() {

        Node node = this.head;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node forw = node.next;
            node.next = null;
            forw.prev = null;

            this.head = forw;
        }

        this.size--;
        return node;
    }

    public int removeFirst() {
        if (ListIsEmptyException()) {
            return -1;
        }
        return removeFirstNode().val;

    }

    private Node removeLastNode() {

        Node node = this.tail;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node prevNode = node.prev;
            node.prev = null;
            prevNode.next = null;

            this.tail = prevNode;
        }

        this.size--;
        return node;
    }

    public int removeLast() {
        if (ListIsEmptyException()) {
            return -1;
        }
        return removeLastNode().val;

    }

    // Basic Functions
    public int size() {
        return this.size();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // getFunctions
    public int getFirst() {
        if (ListIsEmptyException()) {
            return -1;
        }
        return this.head.val;
    }

    public int getLast() {
        if (ListIsEmptyException()) {
            return -1;
        }
        return this.tail.val;
    }

    private Node getNodeAt (int index){
        Node curr = this.head;
        while (index-- > 0){
            curr = curr.next;
        }
        return curr;
    }
    public int getAt(int index) {
        if (ListIsEmptyException()) {
            return -1;
        }
        if (IndexIsInvalidException(index, 0, this.size-1)){
            return -1;
        }
        return getNodeAt(index).val;
    }
}
