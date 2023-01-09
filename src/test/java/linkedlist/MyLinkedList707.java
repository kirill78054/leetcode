package linkedlist;

public class MyLinkedList707 {

    int size;
    private Node head;

    public int get(int index) {
        if (head == null) return -1;
        if (index == 0) return head.getValue();

        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node.next == null) return -1;
            node = node.next;
        }
        return node.getValue();
    }

    public void addAtHead(int val) {
        this.head = new Node(val, head);
        this.size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            this.head = new Node(val);
            size++;
            return;
        }

        Node lastTail = head;
        while (lastTail.next != null) {
            lastTail = lastTail.next;
        }
        lastTail.setNext(new Node(val));
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index == 0) {
            this.head = new Node(val, this.head);
            size++;
            return;
        }

        Node prevNode = head, lastNode = head.next;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
            lastNode = prevNode.next;
        }
        Node newNode = new Node(val, lastNode);
        prevNode.setNext(newNode);
        size++;
    }

    public void deleteAtIndex(int index) {
        index++;
        if (index > size) {
            return;
        } else if (index - 1 == 0) {
            this.head = head.next;
            size--;
            return;
        }

        Node prevNode = head, lastNode = head.next;
        for (int i = 0; i < index - 2; i++) {
            prevNode = prevNode.next;
            lastNode = prevNode.next;
        }

        prevNode.setNext(lastNode.next);
        size--;
    }

    static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
