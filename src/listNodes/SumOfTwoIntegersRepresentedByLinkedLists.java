package listNodes;

/**Возвращает односвязный список, узлы которого представляют собой прямую последовательность цифр итоговой суммы двух
 * чисел, которые представлены последовательностями узлов списков, переданных в конструктор. Числа не должны иметь
 * ведущих нулей. Значения узлов переданных списков от 0 до 9.
 * @author Сергей Шершавин*/

public class SumOfTwoIntegersRepresentedByLinkedLists {
    private int remainder = 0;
    public ListNode getSum(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        ListNode result;
        if (length1 >= length2) {
            result = addNode(l2, l1, length1 - length2);
        }
        else result = addNode(l1, l2, length2 - length1);
        if (remainder != 0) {
            ListNode newResult = new ListNode(remainder);
            newResult.next = result;
            return newResult;
        }
        return result;
    }

    private ListNode addNode(ListNode l1, ListNode l2, int diff) {
        int sum;
        if (l1.next == null && l2.next == null) {
            sum = l1.val + l2.val;
            remainder = sum/10;
            return new ListNode(sum%10);
        }
        ListNode node, nextNode;
        if (diff == 0) {
                nextNode = addNode(l1.next, l2.next, 0);
                sum = l1.val + l2.val + remainder;
        }
        else {
                nextNode = addNode(l1, l2.next, diff - 1);
                sum = remainder + l2.val;
        }
        remainder = sum/10;
        node = new ListNode(sum%10);
        node.next = nextNode;
        return node;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
