package listNodes;

/** Связный список. Каждый узел списка содержит численное значение и ссылку на следующий узел (если он существует).
 * @author Сергей Шершавин*/

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }

    /**Удаляет переданный узел из текущего списка*/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public String listNodeToString() {
        StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) {
                sb.append(" -> ");
                sb.append(next.listNodeToString());
            }
            return sb.toString();
    }
}
