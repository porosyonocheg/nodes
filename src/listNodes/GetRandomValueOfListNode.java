package listNodes;

/**Возвращает случайное значение содержащееся в переданном односвязном списке
 * @author Сергей Шершавин*/
public class GetRandomValueOfListNode {
    private final ListNode head;
    private int length = 0;

    public GetRandomValueOfListNode(ListNode head) {
        this.head = head;
        while (head != null) {
            head = head.next;
            length++;
        }
    }

    public int getRandom() {
        int pos = (int) (Math.random() * length);
        ListNode current = head;
        for (int i = 0; i < pos; i++) current = current.next;
        return current.val;
    }
}
