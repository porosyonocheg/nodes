package listNodes;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**Двусвязный список. Каждый узел содержит целочисленное значение и ссылки на следующий (next) и предыдущий (previous) узлы
 * @author Сергей Шершавин*/

public class DoublyLinkedListNode {
    public int val;
    public DoublyLinkedListNode previous;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int val) {
        this.val = val;
    }

    public int getLength() {
        int length = 0;
        Set<DoublyLinkedListNode> nodes = new HashSet<>();
        DoublyLinkedListNode current = this;
        while (current != null && !nodes.contains(current)) {
            nodes.add(current);
            current = current.next;
            length++;
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyLinkedListNode current = this;
        if (previous == null) sb.append("null <-> ");
        else sb.append(previous.val).append(" <-> ");
        for (int i = 0; i < getLength(); i++) {
            sb.append(current.val).append(" <-> ");
            current = current.next;
        }
        if (current == null) sb.append("null");
        else sb.append(current.val);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoublyLinkedListNode)) return false;
        DoublyLinkedListNode that = (DoublyLinkedListNode) o;
        return val == that.val && Objects.equals(previous, that.previous) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
