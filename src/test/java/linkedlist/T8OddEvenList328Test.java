package linkedlist;

import org.junit.Test;

import static linkedlist.Utils.printList;

/*
Given the head of a singly linked list,
group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
 */
public class T8OddEvenList328Test {

    @Test
    public void runTest() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        four.next = new ListNode(5);

        printList(one);
        ListNode listNode = oddEvenList(one);
        printList(listNode);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, join = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = join;
        return head;
    }

}