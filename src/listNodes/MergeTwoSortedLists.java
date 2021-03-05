package listNodes;

/**Содержит метод, объединяющий два переданных отсортированных связных списка в один отсортированный связный список
 * @author Сергей Шершавин*/
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        if (l1.val < l2.val) {
            result = new ListNode(l1.val);
            if (l1.next != null) result.next = mergeTwoLists(l2, l1.next);
            else result.next = l2;
        }
        else {
            result = new ListNode(l2.val);
            if (l2.next != null) result.next = mergeTwoLists(l1, l2.next);
            else result.next = l1;
        }
        return result;
    }
}
