package listNodes;

/**Содержит метод, возвращающий узел, в котором происходит пересечение двух переданных списков, если оно имеется
 * и null, если пересечения нет.
 * @author Сергей Шершавин*/
public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentB = headB;
        ListNode currentA = headA;
        while (currentA != currentB) {
            if (currentA == null) {
                currentA = headB;
            }
            else currentA = currentA.next;

            if (currentB == null) {
                currentB = headA;
            }
            else currentB = currentB.next;

        }
        return currentA;
    }
}
