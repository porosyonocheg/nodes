package listNodes;

/** Связный список. Каждый узел списка содержит численное значение и ссылку на следующий узел (если он существует).
 * @author Сергей Шершавин*/

public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int x) { val = x; }

    /**Конструктор принимает строковое представление связного списка и парсингом целочисленных значений создаёт
     * из них новый список*/
    public ListNode(String list) {
        int lastIndex = list.indexOf(' ');
        if (lastIndex == -1 ) {
            val = Integer.parseInt(list);
        }
        else {
            int firstIndex = 0;
            val = Integer.parseInt(list.substring(firstIndex, lastIndex));
            ListNode current = new ListNode();
            next = current;
            firstIndex = lastIndex + 4;
            lastIndex = list.indexOf(' ', firstIndex);
            while (lastIndex != -1) {
                current.val = Integer.parseInt(list.substring(firstIndex, lastIndex));
                current.next = new ListNode();
                current = current.next;
                firstIndex = lastIndex + 4;
                lastIndex = list.indexOf(' ', firstIndex);
            }
            current.val = Integer.parseInt(list.substring(firstIndex));
        }
    }

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

    /**Метод удаляет все дупликаты из списка с переданным максимальным значением узлов*/
    public ListNode deleteDuplicates(int maxValue) {
        int[] set = new int[maxValue];
        ListNode crutch = this;
        ListNode current = crutch.next;
        set[this.val - 1]++;
        while (current != null) {
            set[current.val - 1]++;
            if (set[current.val - 1] > 1) {
                crutch.next = current.next;
            }
            else {
                crutch = crutch.next;
            }
            current = current.next;
        }
        return this;
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

    /**Переворачивает список задом наперёд
     * @return модифицированный список*/
    public ListNode reverseList() {
        ListNode previousNode = null;
        ListNode head = this;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
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
