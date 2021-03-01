package listNodes;

/** Связный список. Каждый узел списка содержит численное значение и ссылку на следующий узел (если он существует).
 * @author Сергей Шершавин*/

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }

    /**Удаляет из текущего списка переданный узел*/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**Удаляет из текущего списка все узлы с переданным значением*/
    public ListNode removeElements(int val) {
        ListNode crutch = new ListNode(-1);
        crutch.next = this;
        ListNode current = crutch;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }
            else current = current.next;
        }
        return crutch.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) {
                sb.append(" -> ");
                sb.append(next.toString());
            }
            return sb.toString();
    }
}
