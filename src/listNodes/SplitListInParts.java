package listNodes;

/**Разбивает список на k примерно равных подсписков (каждый последующий подсписок не должен быть короче более чем на 1 узел)
 * @author Сергей Шершавин*/

public class SplitListInParts {

    /**@param k число разбиений списка
     * @return массив подсписков, полученный в результате разбиения, может содержать null-элементы в конце, если k
     * больше длины исходного списка*/
    public static ListNode[] split(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) return result;
        int length = 0;
        ListNode current = root;
        while (current != null) {
            length++;
            current = current.next;
        }
        current = root;
        ListNode prev = null;
        int size = length / k, r = length % k;
        for (int i = 0; i < k; i++) {
            result[i] = current;
            int currentSize = size;
            if (r > 0) {
                currentSize++;
                r--;
            }
            for (int j = 0; j < currentSize; j++) {
                prev = current;
                current = current.next;
            }
            prev.next = null;

        }
        return result;
    }
}
