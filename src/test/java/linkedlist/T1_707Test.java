package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 */
public class T1_707Test {

    MyLinkedList707 list = new MyLinkedList707();

    @Before
    public void init() {
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
    }

    @Test
    public void case24Test() {
        MyLinkedList707 list = new MyLinkedList707();
        list.addAtHead(38);
        list.addAtTail(66);
        list.addAtTail(61);
        list.addAtTail(76);
        list.addAtTail(26);
        list.addAtTail(37);
        list.addAtTail(8);
        list.deleteAtIndex(5);
        list.addAtHead(4);
        list.addAtHead(45);

        assertEquals(61, list.get(4));
    }

    @Test
    public void case23Test() {
        MyLinkedList707 list = new MyLinkedList707();
        list.addAtHead(1);
        list.deleteAtIndex(1);
        list.deleteAtIndex(1);
        list.addAtTail(7);
        list.deleteAtIndex(2);
        list.addAtTail(1);
        list.addAtTail(8);
        list.addAtHead(2);
        list.addAtIndex(5, 2);
        list.addAtTail(7);
        assertEquals(7, list.get(2));
    }

    @Test
    public void addAtHeadTest() {
        assertEquals(3, list.size);
    }

    @Test
    public void addAtTailTest() {
        list.addAtTail(4);
        assertEquals(4, list.size);
        assertEquals(4, list.get(3));
    }

    @Test
    public void addAtIndexTest() {
        assertEquals(2, list.get(1));
        assertEquals(3, list.size);
        list.addAtIndex(1, 11);
        assertEquals(11, list.get(1));
        assertEquals(4, list.size);
    }

    @Test
    public void getTest() {
        assertEquals(1, list.get(2));
        assertEquals(-1, list.get(3));
    }

    @Test
    public void deleteAtIndexTest() {
        assertEquals(2, list.get(1));
        assertEquals(3, list.size);
        list.deleteAtIndex(1);
        assertEquals(1, list.get(1));
        assertEquals(2, list.size);
    }

}