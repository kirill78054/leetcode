package linkedlist;

public class Utils {

    public static void printList(ListNode list) {
        if (list == null) {
            System.out.println("[]");
            return;
        }
        ListNode nodes = list;
        StringBuilder result = new StringBuilder("[");
        while (nodes != null) {
            if (nodes.next == null) {
                result.append(nodes.val);
                break;
            }
            result.append(nodes.val + ", ");
            nodes = nodes.next;
        }
        result.append("]");
        System.out.println(result);
    }

}
