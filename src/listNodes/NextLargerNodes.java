package listNodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**Возвращает массив, каждый элемент которого равен значению ближайшего следующего узла, превышающего значение
 * текущего узла, если такое существует иначе нулю.
 * @author Сергей Шершавин*/

public class NextLargerNodes {
    public static int[] getNextLargerValuesArray(ListNode head) {
        List<Integer> listNode = new ArrayList<>();
        while (head != null) {
            listNode.add(head.val);
            head = head.next;
        }
        int[] result = new int[listNode.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length; i++) {
            while (!stack.isEmpty() && listNode.get(stack.peek()) < listNode.get(i)) {
                result[stack.pop()] = listNode.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
