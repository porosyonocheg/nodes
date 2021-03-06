package listNodes;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** Односвязный список. Каждый узел списка содержит численное значение и ссылку на следующий узел (если он существует).
 * @author Сергей Шершавин*/

public class ListNode {
    public int val;
    public ListNode next;

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

    /**Добавляет переданный узел в конец текущего списка*/
    public void addListNode(ListNode node) {
        ListNode head = this;
        while (head.next != null) head = head.next;
        head.next = node;
    }

    /**Всталяет в исходный список новый узел со значением value, объединив с узлом со значением target, если он существует.
     * Если таких элементов несколько, то объединение произойдёт с ближайшим к голове списка.
     * @return true - если вставка прошла успешно, false - если узел со значением target отсутствует в списке*/
    public boolean insertNewNode(int target, int value) {
        ListNode head = this;
        while (head != null) {
            if (head.val == target) {
                ListNode current = new ListNode(value);
                current.next = head.next;
                head.next = current;
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**Объединяет исходный список с переданным списком в узле со значением target, если он существует.
     * Если таких элементов несколько, то объединение произойдёт с ближайшим к голове списка.
     * @return true - если вставка прошла успешно, false - если узел со значением target отсутствует в списке*/
    public boolean insertListNode(ListNode node, int target) {
        ListNode head = this;
        while (head != null) {
            if (head.val == target) {
                ListNode currentNode = head.next;
                head.next = node;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = currentNode;
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**Объединяет исходный список с переданным списком в узле со значением равным значению головного узла переданного списка,
     * если он существует. Если таких элементов несколько, то объединение произойдёт с ближайшим к голове исходного списка.
     * Если значение не найдено в исходном списке, переданный список будет добавлен ему в конец. */
    public void insertListNode(ListNode node) {
        ListNode head = this;
        while (head != null) {
            if (head.val == node.val) {
                ListNode currentNode = head.next;
               if (node.next != null) head.next = node.next;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = currentNode;
                return;
            }
            head = head.next;
        }
        addListNode(node);
    }

    /**При помощи внутреннего рекурсивного метода меняет соседние пары узлов местами, возвращает обновлённый список*/
    public ListNode swapPairs(){
        return swapPairsInner(this);
    }

    private ListNode swapPairsInner(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairsInner(head.next.next);
        next.next = head;
        return next;
    }

    /**@return список, в котором меняются местами значения k-го узла от начала списка и k-го узла от конца списка*/
    public ListNode swapNodes(int k) {
        ListNode first = this;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode second = this, secondFast = first.next;
        while (secondFast != null) {
            secondFast = secondFast.next;
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return this;
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

    /**Удаляет n-ый элемент с конца списка за один проход. n должно быть в пределах от 1 до размера списка включительно.*/
    public void removeNthFromEnd(int n) {
        ListNode tail = this;
        while (n-- > 0) tail = tail.next;
        if (tail == null) {
            this.deleteNode(this);
            return;
        }
        ListNode newHead = this;
        tail = tail.next;
        while (tail != null) {
            tail = tail.next;
            newHead = newHead.next;
        }
        newHead.next = newHead.next.next;
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

    /**@return true, если список является палиндромом, false - в обратном случае
     * За то время, как бегунок fast пробегает список, slow доходит ровно до середины. Переворачиваем slow,
     * то есть правую половину списка и сравниваем поэлементно с начала исходного списка*/
    public boolean isPalindrome() {
        ListNode slow = this;
        ListNode fast = this;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.reverseList();
        fast = this;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /**@return true, если один из узлов списка содержит ссылку на следующий узел уже встречавшийся в списке (список
    * зациклен), false - если циклов нет*/
    public boolean hasCycle() {
        ListNode fast = this;
        ListNode slow = this;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    /**При наличии цикла "разрывает" его в точке образования, меняя ссылку на null*/
    public void breakCycle() {
        if (hasCycle()) {
            Set<ListNode> nodes = new HashSet<>();
            ListNode head = this;
            while (true) {
                nodes.add(head);
                if (nodes.contains(head.next)) {
                    head.next = null;
                    break;
                }
                    head = head.next;
            }
        }
    }

    @Override
    public String toString() {
        if (!hasCycle()) {
        StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) {
                sb.append(" -> ");
                sb.append(next.toString());
            }
            return sb.toString();
        }
        return "This ListNode has cycle";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return val;
    }
}
