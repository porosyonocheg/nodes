package listNodes;

import java.util.HashSet;
import java.util.Set;

/** Подсчитывает количество компонентов в head. Массив G содержит подсписок значений узлов списка head в произвольном
 * порядке. Компонентом в head считается совокупность несвязанных узлов, значения которых содержатся в G.
 * Например: head = [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8], G = {2, 5, 8, 1, 6}.
 * Компоненты в head [1 -> 2, 5 -> 6, 8]. Итог: 3.
 * @author Сергей Шершавин*/

public class CountingComponents {

    public static int countComponents(ListNode head, int[] G) {
        if (head == null) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : G) set.add(i);
        int count = 0;
        boolean flag = false; // проверяем находимся ли в данный момент внутри компонента
        while (head != null) {
            if (!flag && set.contains(head.val)) flag = true;
            else if (flag && !set.contains(head.val)) {
                count++;
                flag = false;
            }
            head = head.next;
        }
        return flag ? count+1 : count;
    }
}
