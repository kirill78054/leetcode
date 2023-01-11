package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

Input: head = [3,2,0,-4], pos = 1
Output: true

Input: head = [1,2], pos = 0
Output: true
 */
public class T3DetectCycle142Test {

    @Test
    public void runTest() {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(0);
        two.next = three;
        ListNode four = new ListNode(-4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        ListNode seven = new ListNode(7);
        six.next = seven;

        assertNull(detectCycle(one));
        seven.next = four;

        assertEquals(four, detectCycle(one));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}