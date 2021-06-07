package listNodes;

import java.util.Objects;

/**Связный список с указателем на случайный узел в данном списке. Узлы содержат целочисленные значения val, ссылку
 * на следующий узел next и ссылку на случайный узел - random (может быть null).
 * @author Сергей Шершавин*/

public class ListNodeWithRandomPointer {
    public int val;
    public ListNodeWithRandomPointer next;
    public ListNodeWithRandomPointer random;

    public ListNodeWithRandomPointer(int val) {
        this.val = val;
    }

    public ListNodeWithRandomPointer(int val, ListNodeWithRandomPointer next) {
        this.val = val;
        this.next = next;
    }

    /**Создание списка на основе массива целочисленных значений*/
    public ListNodeWithRandomPointer(int[] array) {
        ListNodeWithRandomPointer head = new ListNodeWithRandomPointer(array[0]), current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNodeWithRandomPointer(array[i]);
            current = current.next;
        }
        head.generateRandomPointers();
        this.val = head.val;
        this.next = head.next;
        this.random = head.random;
    }

    /**Создание списка на основе односвязного списка*/
    public ListNodeWithRandomPointer(ListNode head) {
        ListNodeWithRandomPointer randomHead = new ListNodeWithRandomPointer(head.val), current = randomHead;
        while (head.next != null) {
            current.next = new ListNodeWithRandomPointer(head.next.val);
            head = head.next;
            current = current.next;
        }
        randomHead.generateRandomPointers();
        this.val = randomHead.val;
        this.next = randomHead.next;
        this.random = randomHead.random;
    }

    /**@return длину списка (количество узлов, которые он содержит)*/
    public int getLength() {
        ListNodeWithRandomPointer head = this;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**Создаёт ссылки на случайные узлы для всех узлов данного списка*/
    public void generateRandomPointers() {
        int length = getLength();
        ListNodeWithRandomPointer head = this, current = this;
        while (head != null) {
            int index = (int) (Math.random() * length);
            for (int i = 0; i <= index; i++) current = current.next;
            head.random = current;
            head = head.next;
            current = this;
        }
    }

    /**Создаёт список по представлению в виде двумерного массива. representation[i][0] - значение i-го узла,
     * representation[i][1] - индекс узла для ссылки random i-го узла. Если индекс выходит за пределы от нуля до размера
     * списка, ссылке random i-го узла присваивается значение null*/
    public static ListNodeWithRandomPointer createList(int[][] representation) {
        if (representation == null || representation.length == 0) return null;
        ListNodeWithRandomPointer head = new ListNodeWithRandomPointer(representation[0][0]);
        ListNodeWithRandomPointer current = head;
        for (int i = 1; i < representation.length; i++) {
            current.next = new ListNodeWithRandomPointer(representation[i][0]);
            current = current.next;
        }
        current = head;
        ListNodeWithRandomPointer randomNode;
        for (int i = 0; i < representation.length; i++) {
            if (representation[i][1] >= 0 && representation[i][1] <= representation.length) {
                randomNode = head;
                for (int j = 0; j < representation[i][1]; j++) {
                    randomNode = randomNode.next;
                }
                current.random = randomNode;
            }
            current = current.next;
        }
        return head;
    }

    /**Создаёт глубокую копию переданного листа*/
    public static ListNodeWithRandomPointer copyList(ListNodeWithRandomPointer head) {
        if (head == null) return null;
        ListNodeWithRandomPointer current = head, next;
        /*Создаём копию каждого узла прямо в списке следом за текущим*/
        while (current != null) {
            next = new ListNodeWithRandomPointer(current.val);
            next.next = current.next;
            current.next = next;
            current = next.next;
        }

        /*Выставляем ссылки random для копий, учитывая, что все копии следуют за текущим элементом*/
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        /*Перебрасываем ссылки копий в отдельное поле, связывая их между собой, затираем ссылки на копии в оригинале,
        * связывая оригинальные узлы*/
        current = head;
        ListNodeWithRandomPointer copy = head.next;
        next = copy;
        while (next.next != null) {
            current.next = current.next.next;
            current = current.next;

            next.next = next.next.next;
            next = next.next;
        }
        current.next = current.next.next;
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNodeWithRandomPointer head = this;
        while (head.next != null) {
            sb.append('[').append(head.val).append(',');
            if (head.random == null) sb.append("null");
            else sb.append(head.random.val);
            sb.append(']').append(" -> ");
            head = head.next;
        }
        sb.append('[').append(head.val).append(',');
        if (head.random == null) sb.append("null");
        else sb.append(head.random.val);
        sb.append(']');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNodeWithRandomPointer)) return false;
        ListNodeWithRandomPointer that = (ListNodeWithRandomPointer) o;
        return val == that.val && Objects.equals(next, that.next) && (random == null && that.random == null) || (random != null && that.random != null && random.val == that.random.val);
    }

    @Override
    public int hashCode() {
        return random.val + val;
    }
}
