package listNodes;

/**Преобразует исходный список в список, в котором сначала идут все нечетно-индексированные узлы, а затем все
 * чётно-индексированные в исходном порядке. Индексирование начинается с 1.
 * @author Сергей Шершавин*/

public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode even = new ListNode(0), odd = new ListNode(1);
        odd.next = head;
        ListNode current = head.next;
        even.next = current;
        while (head.next != null  && current.next != null) {
            head.next = head.next.next;
            current.next = current.next.next;
            if (head.next != null) head = head.next;
            if (current.next != null) current = current.next;
        }

        head.next = even.next;
        return odd.next;
    }
}
