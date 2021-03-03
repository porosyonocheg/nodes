package listNodes;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListNodeTest {
    ListNode base;
    public ListNodeTest() {
        base = new ListNode("5 -> 4 -> 3 -> 2 -> 1 -> 0");
    }

    @Test
    public void listNodeToString() {
        assertEquals("5 -> 4 -> 3 -> 2 -> 1 -> 0", base.toString());
    }

    @Test
    public void deleteNode() {
        ListNode n = new ListNode(3);
        ListNode o = new ListNode(2);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(0);
        n.next = o;
        o.next = d;
        d.next = e;
        n.deleteNode(d);
        assertEquals("3 -> 2 -> 0", n.toString());
    }

    @Test
    public void removeElements() {
        assertEquals("5 -> 4 -> 2 -> 1 -> 0", base.removeElements(3).toString());
        ListNode t = new ListNode("8 -> 7 -> 6 -> 6 -> 4 -> 3 -> 2 -> 6");
        assertEquals("8 -> 7 -> 4 -> 3 -> 2", t.removeElements(6).toString());
        assertEquals("7 -> 4 -> 3 -> 2", t.removeElements(8).toString());
    }

    @Test
    public void deleteDuplicatesFromSortedList() {
        ListNode t = new ListNode("7 -> 6 -> 5 -> 5 -> 4 -> 4 -> 3 -> 3");
        assertEquals("7 -> 6 -> 5 -> 4 -> 3", t.deleteDuplicatesFromSortedList().toString());
        t = new ListNode(3);
        assertEquals("3", t.deleteDuplicatesFromSortedList().toString());
        ListNode node = new ListNode("1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 4 -> 4 -> 4");
        assertEquals("1 -> 2 -> 3 -> 4", node.deleteDuplicatesFromSortedList().toString());
    }

    @Test
    public void middleNode() {
        assertEquals("2 -> 1 -> 0", base.middleNode().toString());
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(11);
        ListNode node8 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        assertEquals("7 -> 2 -> 6 -> 11 -> 4", node.middleNode().toString());
        assertEquals("4", node8.middleNode().toString());
        assertEquals("4", node7.middleNode().toString());
        assertEquals("11 -> 4", node6.middleNode().toString());
        assertEquals("11 -> 4", node5.middleNode().toString());
    }

    @Test
    public void deleteDuplicates() {
        ListNode newNode = new ListNode("1 -> 2 -> 1 -> 5 -> 2 -> 5 -> 3 -> 4 -> 2 -> 2");
        assertEquals("1 -> 2 -> 1 -> 5 -> 2 -> 5 -> 3 -> 4 -> 2 -> 2", newNode.toString()); // проверка нового конструктора
        assertEquals("1 -> 2 -> 5 -> 3 -> 4", newNode.deleteDuplicates(5).toString());
        newNode = new ListNode("11 -> 312 -> 72 -> 11 -> 11 -> 72 -> 312 -> 121");
        assertEquals("11 -> 312 -> 72 -> 121", newNode.deleteDuplicates(312).toString());
    }

    @Test
    public void reverseList() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5", base.reverseList().toString());
        assertEquals("5 -> 6", new ListNode("6 -> 5").reverseList().toString());
        assertEquals("3", new ListNode(3).reverseList().toString());
    }
}
