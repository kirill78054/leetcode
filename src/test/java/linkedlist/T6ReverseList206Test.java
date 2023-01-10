package linkedlist;

import org.junit.Test;

/*
Разверните список

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
 */
public class T6ReverseList206Test {

    @Test
    public void runTest() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        reverseList(one);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head, tmp;

        while (current != null) {
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }

}