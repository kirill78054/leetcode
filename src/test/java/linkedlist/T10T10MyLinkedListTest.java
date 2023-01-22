package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class T10T10MyLinkedListTest {

    @Test
    public void addHeadTest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        list.addAtHead(4);
        printList(list);
        assertEquals(1, list.getTail().getValue());
        assertEquals(4, list.getFirst().getValue());
    }

    @Test
    public void addTailTest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        assertEquals(1, list.getFirst().getValue());
        assertEquals(4, list.getTail().getValue());
    }

    @Test
    public void getTest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        printList(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(-1, list.get(4));
    }

    @Test
    public void getNPETest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtTail(1);
        assertEquals(1, list.get(0));
        assertEquals(-1, list.get(2));
    }

    @Test
    public void addIndexZeroTest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtIndex(0, 1);
        assertEquals(1, list.getFirst().getValue());
    }

    @Test
    public void addIndexTest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtHead(2);
        list.addAtIndex(0, 1);
        list.addAtIndex(2, 3);
        list.addAtIndex(3, 3);
        list.addAtIndex(4, 4);
        list.addAtIndex(5, 5);
        list.addAtIndex(8, 22);
        assertEquals(-1, list.get(8));
    }

    @Test
    public void deleteAtIndexTest() {
        T10MyLinkedList list = new T10MyLinkedList();
        list.addAtIndex(0, 1);
        list.addAtIndex(1, 2);
        list.addAtIndex(2, 3);
        list.addAtIndex(3, 4);

        printList(list);
        list.deleteAtIndex(4);
        System.out.println();
        printList(list);
    }
    private void printList(T10MyLinkedList list) {
        T10MyLinkedList.Node first = list.getFirst();
        while (first != null) {
            System.out.print(first.getValue() + " ");
            first = first.getNext();
        }


    }


}
