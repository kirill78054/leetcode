package linkedlist;


import lombok.Getter;

@Getter
public class T10MyLinkedList {

    private Node first = null, tail = null;
    private int size = 0;

    public T10MyLinkedList() {
    }

    public int get(int index) {
        if (index >= size) return -1;
        Node res = first;
        while (index != 0) {
            index--;
            res = res.next;
        }
        return res.getValue();
    }

    public void addAtHead(int val) {
        Node first = new Node(val);
        if (this.first == null) {
            tail = first;
        } else {
            first.next = this.first;
            this.first.prev = first;
        }
        this.first = first;
        size++;
    }

    public void addAtTail(int val) {
        Node last = new Node(val);
        if (tail == null) {
            first = last;
        } else {
            last.prev = tail;
            tail.next = last;
        }
        tail = last;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node next;
        if (index > size / 2) {
            next = tail;
            int lindex = size - 1;
            while (lindex > index) {
                lindex--;
                next = next.prev;
            }
        } else {
            next = first;
            while (index != 0) {
                index--;
                next = next.next;
            }
        }
        Node middle = new Node(val);
        middle.prev = next.prev;
        middle.next = next;

        next.prev.next = middle;
        next.prev = middle;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        if (index == 0) {
            first = first.next;
            if (size == 1) {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            if (size == 1) {
                first = null;
            }
        } else {
            Node cur = first;
            while (index != 0) {
                index--;
                cur = cur.next;
            }
            if (cur.prev != null) cur.prev.next = cur.next;
            if (cur.next != null) cur.next.prev = cur.prev;
        }
    }

    public static class Node {
        private final int value;
        private Node prev, next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

    }

}
