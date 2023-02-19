package linkedlist;

import org.junit.Test;

import static linkedlist.Utils.printList;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/

public class T12AddTwoNumbers2Test {

    @Test
    public void runTest() {
        ListNode oneList1 = new ListNode(2);
        ListNode twoList1 = new ListNode(4);
        oneList1.next = twoList1;
        twoList1.next = new ListNode(3);

        ListNode oneList2 = new ListNode(5);
        ListNode twoList2 = new ListNode(6);
        oneList2.next = twoList2;
        twoList2.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(oneList1, oneList2);
        printList(listNode);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumNumbers(l1, l2, 0);
    }

    private ListNode sumNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode result = null;
        if (l1 != null && l2 != null) {
            carry = l1.val + l2.val + carry;
            result = new ListNode(carry % 10);
            result.next = sumNumbers(l1.next, l2.next, carry / 10);
        } else if (l1 == null && l2 == null) {
            if (carry != 0)
                result = new ListNode(carry);
        } else if (l1 != null) {
            carry = l1.val + carry;
            result = new ListNode(carry % 10);
            result.next = sumNumbers(l1.next, l2, carry / 10);
        } else if (l2 != null) {
            carry = l2.val + carry;
            result = new ListNode(carry % 10);
            result.next = sumNumbers(l1, l2.next, carry / 10);
        }

        return result;
    }

}
