package arrays;

import org.junit.Test;


public class T876Test {

    @Test
    public void solutionTest() {
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        ListNode liat = null;
        for (int x = mas.length - 1; x >= 0; x--) {
            liat = new ListNode(mas[x], liat);
        }
        ListNode result = middleNode(liat);
        printList(result);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void printList(ListNode list) {
        ListNode result = list;
        while (true) {
            System.out.print(result.val + " ");
            if (result.next == null) {
                break;
            }
            result = result.next;

        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}