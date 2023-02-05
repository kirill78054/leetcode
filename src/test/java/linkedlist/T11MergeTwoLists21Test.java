package linkedlist;

import org.junit.Test;

import static linkedlist.Utils.printList;

/*
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

 */
public class T11MergeTwoLists21Test {

    @Test
    public void runTest() {
        ListNode oneList1 = new ListNode(1);
        ListNode twoList1 = new ListNode(2);
        oneList1.next = twoList1;
        twoList1.next = new ListNode(4);

        ListNode oneList2 = new ListNode(1);
        ListNode twoList2 = new ListNode(3);
        oneList2.next = twoList2;
        twoList2.next = new ListNode(4);

        ListNode listNode = mergeTwoListsRec(oneList1, oneList2);
        printList(listNode);
    }

    private ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode firs = new ListNode(0);
        ListNode tmp = firs;

        while (list1 != null & list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        tmp.next = list1 == null ? list2 : list1;
        return firs.next;
    }

}