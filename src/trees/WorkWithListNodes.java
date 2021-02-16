package trees;

/**Данный класс описывает некоторые методы работы со связным списком, а также примеры их реализации
 * @author  Сергей Шершавин*/

public class WorkWithListNodes {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node5.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
        node1.next = node;

        node5.printListNode();
    }
}
