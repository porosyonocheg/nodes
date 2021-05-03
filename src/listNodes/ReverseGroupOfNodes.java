package listNodes;

/**Разбивает список на максимальное число групп узлов заданной длины и переворачивает каждую из них,
 * возвращая результирующий список. Узлы, не составляющие полноценную группу не переворачиваются.
 * @author Сергей Шершавин*/

public class ReverseGroupOfNodes {

    /**@param k длина каждой группы узлов для реверса*/
    public static ListNode reverse(ListNode head, int k) {
        if (k < 2) return head;
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        if (k > length) k = length;
        current = head;
        for (int i = 1; i + k <= length + 1; i += k) {
            current = ReverseSublist.reverseBetween(current, i,  i + k - 1);
        }
        return current;
    }
}
