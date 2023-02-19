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
        ListNode firs = new ListNode(0);
        ListNode result = new ListNode(0);
        firs.next = result;

        int sumOne = 0, sumTwo = 0, sum;
        boolean tenFlag = false;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sumOne = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sumTwo = l2.val;
                l2 = l2.next;
            }

            sum = sumOne + sumTwo;
            if (tenFlag) {
                sum++;
                tenFlag = false;
            }

            if (sum >= 10) {
                sum -= 10;
                tenFlag = true;
            }

            result.next = new ListNode(sum);
            result = result.next;
            sumOne = 0;
            sumTwo = 0;
        }

        if (tenFlag) result.next = new ListNode(1);
        return firs.next.next;
    }

}
