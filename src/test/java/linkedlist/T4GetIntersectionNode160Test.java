package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
Given the heads of two singly linked-lists and , return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
 */
public class T4GetIntersectionNode160Test {

    ListNode oneFirst;
    ListNode oneSecond;
    ListNode three;

    @Before
    public void init() {
        oneFirst = new ListNode(1);
        ListNode twoFirst = new ListNode(9);
        oneFirst.next = twoFirst;
        ListNode threeFirst = new ListNode(1);
        twoFirst.next = threeFirst;

        oneSecond = new ListNode(3);

        three = new ListNode(2);
        threeFirst.next = three;
        oneSecond.next = three;
        three.next = new ListNode(4);
    }

    @Test
    public void runTest() {
        assertEquals(three, getIntersectionNode(oneFirst, oneSecond));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        while (a != null) {
            a = a.next;
            lenA++;
        }
        while (b != null) {
            b = b.next;
            lenB++;
        }
        a = headA;
        b = headB;

        while (lenA > lenB) {
            a = a.next;
            lenA--;
        }
        while (lenB > lenA) {
            b = b.next;
            lenB--;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

}