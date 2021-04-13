package listNodes;

import java.util.HashMap;
import java.util.Map;

/** Возвращает голову модифицированного односвязного списка после удаления последовательных узлов,
 * сумма которых равна нулю
 * @author Сергей Шершавин*/

public class RemoveZeroSumConsecutiveNodes {

    /**На первом проходе записываем суммы, которые накпливаются на текущем узле, на повторном проходе просто присваиваем
     * следующему текущему узлу последний узел для текущей суммы (в мапу запишется последний узел с тем же значением
     * суммы, что означает выполнение условия для удаления данных узлов)*/
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        Map<Integer, ListNode> nodes = new HashMap<>();
        dummy.next = head;
        int currentSum = 0;
        for (ListNode n = dummy; n != null; n = n.next) {
            currentSum += n.val;
            nodes.put(currentSum, n);
        }
        currentSum = 0;
        for (ListNode n = dummy; n != null; n = n.next) {
            currentSum += n.val;
            n.next = nodes.get(currentSum).next;
        }
        return dummy.next;
    }
}
