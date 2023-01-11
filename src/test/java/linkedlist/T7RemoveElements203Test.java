package linkedlist;

import org.junit.Test;

import static linkedlist.Utils.printList;

/*
Given the head of a linked list and an integer val,
remove all the nodes of the linked list that has Node.val == val, and return the new head.

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
 */
public class T7RemoveElements203Test {

    @Test
    public void runTest() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(6);
        two.next = three;
        ListNode four = new ListNode(3);
        three.next = four;
        ListNode five = new ListNode(4);
        four.next = five;
        ListNode six = new ListNode(5);
        five.next = six;
        ListNode seven = new ListNode(6);
        six.next = seven;

        printList(one);
        ListNode listNode = removeElements(one, 6);
        printList(listNode);
    }

    @Test
    public void runSevenCaseTest() {
        ListNode one = new ListNode(7);
        ListNode two = new ListNode(7);
        one.next = two;
        ListNode three = new ListNode(7);
        two.next = three;
        ListNode four = new ListNode(7);
        three.next = four;

        printList(one);
        ListNode listNode = removeElements(one, 7);
        printList(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        while (head.val == val) {
            if (head.next == null) return head.next;
            head = head.next;
        }

        ListNode secondHead = head;
        while (secondHead.next != null) {
            if (secondHead.next.val == val) secondHead.next = secondHead.next.next;
            else secondHead = secondHead.next;
        }

        return head;
    }

}