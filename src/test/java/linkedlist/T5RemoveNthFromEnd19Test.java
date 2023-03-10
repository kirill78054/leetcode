package linkedlist;

import org.junit.Test;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 */
public class T5RemoveNthFromEnd19Test {

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
        removeNthFromEnd(one, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Добавим на случай удаления первого элемента
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode show = start, fast = start;

        //Сдвинем второй указатель на кол-во n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        //Двигаемся к концу сохраняя разрыв
        while (fast != null) {
            show = show.next;
            fast = fast.next;
        }

        //Пропустить нужный узел
        show.next = show.next.next;
        return start.next;
    }

}