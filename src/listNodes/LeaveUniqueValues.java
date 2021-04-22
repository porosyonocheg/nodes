package listNodes;

/** Возвращает исходный список без узлов, содержавших повторяющиеся значения.
 * @author Сергей Шершавин*/

public class LeaveUniqueValues {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else head.next = deleteDuplicates(head.next);
        return head;
    }
}
