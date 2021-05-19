package listNodes;

/**Целое число представлено в виде односвязного списка со значениями узлов, соответствующими цифрам, из которого оно
 * состоит. Вернуть аналогичный связный список после фактической операции сложения двух чисел
 * @author Сергей Шершавин*/

public class SumForIntegerRepresentedByLinkedList {

    /**@param head представление числа в виде цифр в узлах односвязного списка
     * @param value число, с которым суммируется представление, должно быть неотрицательным*/
    public static ListNode accumulate(ListNode head, int value) {
        if (value < 0) throw new IllegalArgumentException("value is negative!");
        if (head == null) {
            return null;
        }

        head = head.reverseList();
        ListNode current = head;
        int tempSum, currentDigit;
        while (current.next != null) {
            if (value > 9) {
                currentDigit = value%10;
                value /= 10;
            }
            else {
                currentDigit = value;
                value = 0;
            }
            tempSum = current.val + currentDigit;
            if (tempSum > 9) {
                current.val = tempSum%10;
                value += tempSum/10;
            }
            else {
                current.val = tempSum;
            }
            current = current.next;
        }

        if (value > 0) {
            tempSum = current.val + value;
            if (tempSum > 9) {
                current.val = tempSum%10;
                value = tempSum/10;
            }
            else if (tempSum > 0) {
                current.val = tempSum;
                value = 0;
            }
            while (value > 0) {
                if (value > 9) {
                    tempSum = value % 10;
                    current.next = new ListNode(tempSum);
                }
                else current.next = new ListNode(value);
                value /= 10;
                current = current.next;
            }
        }

        return head.reverseList();
    }
}
