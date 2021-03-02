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

    /**Удаляет из текущего списка все узлы с переданным значением
     * @return обновлённый список*/
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

    /**Удаляет все дупликаты из отсортированного связного списка
     * @return обновлённый список*/
    public ListNode deleteDuplicatesFromSortedList() {
        if (this.next == null) return this;
        ListNode current = this;
        int currentValue;
        while (current != null) {
            currentValue = current.val;
            while (current.next != null && current.next.val == currentValue) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return this;
    }

    /**@return узел, находящийся в середине данного списка. Если число узлов чётное - следующий узел за "серединой"*/
    public ListNode middleNode() {
        ListNode head = this;
        ListNode middle = head;
        int depth = 1;
        while (head.next != null) {
            head = head.next;
            depth++;
            if (depth %2 == 0) middle = middle.next;

        }
        return middle;
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
