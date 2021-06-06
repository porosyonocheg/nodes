package listNodes;

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
}
