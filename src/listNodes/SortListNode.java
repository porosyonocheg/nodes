package listNodes;

/** Содержит метод, сортирующий переданный связный список по возрастанию значения узлов.
 * @author  Сергей Шершавин*/

public class SortListNode {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left, right, prev;
        for (int step = 1; step < length; step <<= 1) {
            current = dummy.next;
            prev = dummy;
            while (current != null) {
                left = current;
                right = split(left, step);
                current = split(right, step);
                prev = merge(left, right, prev);
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int n) {
            for (int i = 1; head != null && i < n; i++) {
                head = head.next;
            }
            if (head == null) return null;
            ListNode nextNode = head.next;
            head.next = null;
            return nextNode;
    }

    private ListNode merge(ListNode first, ListNode second, ListNode head) {
            ListNode current = head;
            while (first != null & second != null) {
                if (first.val > second.val) {
                    current.next = second;
                    current = second;
                    second = second.next;
                }
                else {
                    current.next = first;
                    current = first;
                    first = first.next;
                }
            }
            if (first == null) {
                current.next = second;
            }
            else current.next = first;
            while (current.next != null) current = current.next;
            return current;
    }
}
