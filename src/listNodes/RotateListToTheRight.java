package listNodes;

/** "Поворачивает" односвязный список вправо на k-шагов (крайний правый узел становится головным)
 * @author Сергей Шершавин*/

public class RotateListToTheRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode current = head;
        int length = 0;

        while (current != null) {
            current = current.next;
            length++;
        }

        k = k % length;

        if (k == 0) return head;

        current = new ListNode(-1);
        current.next = head;

        for (int i = 0; i < length - k - 1; i++) {
            head = head.next;
        }

        ListNode newHead = head.next;
        head.next = null;
        head = current.next;
        current.next = newHead;

        while(newHead.next != null) {
            newHead = newHead.next;
        }

        newHead.next = head;
        return current.next;
    }
}