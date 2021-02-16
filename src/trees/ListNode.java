package trees;

/** Связный список. Каждый узел списка содержит численное значение и ссылку на следующий узел (если он существует).
 * @author Сергей Шершавин*/

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }

    public void printListNode () {
            System.out.print(val);
            if (next != null) {
                System.out.print("->");
                next.printListNode();
            }
    }
}
