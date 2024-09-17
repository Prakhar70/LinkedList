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

    public void addAt(int index, int data) {

        if (IndexIsInvalidException(index, 0, this.size)) {
            return;
        }
        Node node = new Node(data);
        addNodeAt(index, node);

    }

    private void addNodeAt(int index, Node node) {
        if (index == 0) {
            addFirstNode(node);
        } else if (index == this.size) {
            addLastNode(node);
        }
        Node forw = getNodeAt(index);
        Node prev = forw.prev;

        prev.next = node;
        node.prev = prev;

        node.next = forw;
        forw.prev = node;
        this.size++;

    }

    public void addBefore(Node refNode, int data) {
        Node newNode = new Node(data);
        addBefore(refNode, newNode);
    }

    private void addBefore(Node refNode, Node node) {
        Node prevNode = refNode.prev;
        if (prevNode == null) {
            node.next = refNode;
            refNode.prev = node;

            this.head = node;
        } else {
            prevNode.next = node;
            node.prev = prevNode;

            node.next = refNode;
            refNode.prev = node;
        }
        this.size++;
    }

    public void addAfter(Node refNode, int data) {
        Node newNode = new Node(data);
        addAfter(refNode, newNode);
    }

    private void addAfter(Node refNode, Node node) {
        Node nextNode = refNode.next;
        if (nextNode == null) {
            refNode.next = node;
            node.prev = refNode;

            this.tail = node;
        } else {
            node.next = nextNode;
            node.prev = refNode;

            refNode.next = node;
            nextNode.prev = node;
        }
        this.size++;
    }

    public int removeAfter(Node refNode) {
        if (refNode.next == null) {
            System.out.println("Location is Invalid");
            return -1;
        }
        return removeAfterNode(refNode).val;
    }

    public Node removeAfterNode(Node refNode) {

        Node forwd = refNode.next;
        if (forwd.next == null) {
            forwd.prev = null;
            refNode.next = null;

            this.tail = forwd;
        } else {
            refNode.next = forwd.next;
            forwd.next = refNode;

            forwd.next = null;
            forwd.prev = null;
        }
        this.size--;
        return forwd;

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

    public int removeAt(int index) {
        if (ListIsEmptyException()) {
            return -1;
        }
        if (IndexIsInvalidException(index, 0, this.size - 1)) {
            return -1;
        }
        return removeNodeAt(index).val;
    }

    private Node removeNodeAt(int index) {
        if (index == 0) {
            return removeFirstNode();
        } else if (index == this.size - 1) {
            return removeLastNode();
        }
        Node node = getNodeAt(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        this.size--;
        return node;

    }

    public int removeBefore(Node refNode) {

        if (refNode.prev == null) {
            System.out.println("Location is Invalid");
            return -1;
        }
        return removeBeforeNode(refNode).val;
    }

    private Node removeBeforeNode(Node refNode) {
        Node prevNode = refNode.prev;
        if (prevNode.prev == null) {
            refNode.prev = null;
            prevNode.next = null;

            this.head = refNode;
        } else {
            prevNode.prev.next = refNode;
            refNode.prev = prevNode.prev;
            prevNode.prev = prevNode.next = null;
        }
        this.size--;
        return prevNode;
    }

    public int removeNode(Node refNode) {
        Node prev = refNode.prev;
        Node next = refNode.next;
        if (this.size == 1) {
            this.head = this.tail = null;
            this.size--;
            return refNode.val;
        } else if (prev == null) {
            this.head = next;

        } else if (next == null) {

            this.tail = prev;
        } else {
            prev.next = next;
            next.prev = prev;
        }

        refNode.prev = refNode.next = this.head.prev = this.tail.next = null;
        this.size--;
        return refNode.val;

    }

    // Basic Functions
    public int size() {
        return this.size();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void displayForward() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(",");
            }
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void displayBackward() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.tail;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(",");
            }
            curr = curr.prev;
        }
        sb.append("]");
        System.out.println(sb.toString());
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

    private Node getNodeAt(int index) {
        Node curr = this.head;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr;
    }

    public int getAt(int index) {
        if (ListIsEmptyException()) {
            return -1;
        }
        if (IndexIsInvalidException(index, 0, this.size - 1)) {
            return -1;
        }
        return getNodeAt(index).val;
    }
}
