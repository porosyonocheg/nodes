package listNodes;

/** Вставляет новый список change в оригинальный список original на позиции узлов с номера pos1 по pos2 включительно.
 * pos1 и pos2 не должны превышать длину исходного списка минус 1. Нумерация узлов идёт от нуля.
 * @author Сергей Шершавин*/

public class ReplacingSublist {

    /**@return измененный список согласно условию
     * @throws IllegalArgumentException если pos1 или pos2 отрицательно*/
    public static ListNode replaceSublist(ListNode original, ListNode change, int pos1, int pos2) {
        if (pos1 < 0 || pos2 < 0) throw new IllegalArgumentException("One or both arguments are negative");
        if (pos1 > pos2) return replaceSublist(original, change, pos2, pos1);
        ListNode head = new ListNode(0), tail = original;
        int i = 0;
        if (pos1 != 0) {
            i = 1;
            head.next = original;
            for (; i < pos1; i++) {
                original = original.next;
            }
            tail = original.next;
            original.next = change;
        }
        else head.next = change;

        while (change.next != null) {
            change = change.next;
        }

        for (; i < pos2 && tail.next != null; i++) {
            tail = tail.next;
        }
        change.next = tail.next;
        return head.next;
    }
}
