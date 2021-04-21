package listNodes;

/** Возврщает список, узлы которого со значениями строго меньшие x стоят слева от узлов со значениями больше либо
 * равными x. Общий порядок следования узлов сохраняется. Например: 5 -> 4 -> 3 -> 2 -> 1, x = 3.
 * Результат: 2 -> 1 -> 5 -> 4 -> 3.
 * @author Сергей Шершавин*/

public class PartitioningValues {

    public static ListNode partition(ListNode head, int x) {
        ListNode lessX = new ListNode(-1);
        ListNode headList = lessX;
        ListNode greaterX = new ListNode(-1);
        ListNode tailList = greaterX;
        while (head != null) {
            if (head.val < x) {
                lessX.next = head;
                lessX = lessX.next;
            }
            else {
                greaterX.next = head;
                greaterX = greaterX.next;
            }
            head = head.next;
        }
        greaterX.next = null; // обнуляем хвостовую часть, чтобы не получить цикл в возвращаемом списке
        lessX.next = tailList.next;
        return headList.next;
    }
}
