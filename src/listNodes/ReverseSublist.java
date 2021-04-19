package listNodes;

/** Переворачивает часть односвязного списка с позиции left по позицию right включительно (если позиции заданы корректно).
 * Возвращает модифицированный список. Нумерация узлов идёт с 1.
 * @author Сергей Шершавин*/

public class ReverseSublist {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left < 1) throw new IllegalArgumentException("Left position is wrong");
        if (left > right) return reverseBetween(head, right, left);
        ListNode dummy = new ListNode(-501);
        dummy.next = head;
        ListNode prev = dummy;
        int i = 1;
        for(; i < left && head != null; i++) {
            head = head.next;
            prev = prev.next;
        }
        ListNode previous = prev;
        for (; i <= right && head != null; i++) {
            ListNode nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
        }
        prev.next.next = head;
        prev.next = previous;
        return dummy.next;
    }
}
