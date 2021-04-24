package listNodes;

/** Содержит методы, сортирующие переданный связный список по возрастанию значения узлов.
 * @author  Сергей Шершавин*/

public class ListNodeSorts {

    public static ListNode withArraysHelpSort(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        int[] array = new int[length];
        current = head;
        for (int i = 0; i < length; i++) {
            array[i] = current.val;
            current = current.next;
        }
        java.util.Arrays.sort(array);
        current = head;
        for (int i = 0; i < length; i++) {
            current.val = array[i];
            current = current.next;
        }
        return head;
    }

    public static ListNode insertionSort(ListNode head) {
        ListNode dummy = new ListNode(0), prev = dummy;
        while (head != null) {
            ListNode tail = head.next;
            if (prev.val >= head.val) prev = dummy;
            while (prev.next != null && head.val > prev.next.val) prev = prev.next;
            head.next = prev.next;
            prev.next = head;
            head = tail;
        }
        return dummy.next;
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left, right, prev;
        for (int step = 1; step < length; step <<= 1) {
            current = dummy.next;
            prev = dummy;
            while (current != null) {
                left = current;
                right = split(left, step);
                current = split(right, step);
                prev = merge(left, right, prev);
            }
        }
        return dummy.next;
    }

    private static ListNode split(ListNode head, int n) {
            for (int i = 1; head != null && i < n; i++) {
                head = head.next;
            }
            if (head == null) return null;
            ListNode nextNode = head.next;
            head.next = null;
            return nextNode;
    }

    private static ListNode merge(ListNode first, ListNode second, ListNode head) {
            ListNode current = head;
            while (first != null & second != null) {
                if (first.val > second.val) {
                    current.next = second;
                    current = second;
                    second = second.next;
                }
                else {
                    current.next = first;
                    current = first;
                    first = first.next;
                }
            }
            if (first == null) {
                current.next = second;
            }
            else current.next = first;
            while (current.next != null) current = current.next;
            return current;
    }
}
