package listNodes;

/**Преобразует список из порядка 0, 1, 2,....n-2, n-1, n в порядок 0, n, 1, n-1, 2, n-2,...
 * Например: 1 -> 2 -> 3 -> 4 -> 5  === 1 -> 5 -> 2 -> 4 -> 3
 * @author Сергей Шершавин*/

public class ReorderList {

    /** Делим список на два. Находим середину списка (slow), переворачиваем вторую часть, зануляем ссылку на средний узел.
     * Объединяем две части*/
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.reverseList();
        prev.next = null;
        while (slow != null) {
            ListNode nextNode = head.next;
            head.next = slow;
            head = slow;
            slow = nextNode;
        }
    }
}
