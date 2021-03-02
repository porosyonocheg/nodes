package listNodes;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListNodeTest {
    ListNode base;
    public ListNodeTest() {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        base = new ListNode(5);
        base.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;
        node1.next = node;
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
        ListNode n = new ListNode(6);
        ListNode o = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode l = new ListNode(6);
        ListNode i = new ListNode(6);
        ListNode s = new ListNode(7);
        ListNode t = new ListNode(8);
        t.next = s;
        s.next = i;
        i.next = l;
        l.next = e;
        e.next = d;
        d.next = o;
        o.next = n;
        assertEquals("8 -> 7 -> 4 -> 3 -> 2", t.removeElements(6).toString());
        assertEquals("7 -> 4 -> 3 -> 2", t.removeElements(8).toString());
    }

    @Test
    public void deleteDuplicatesFromSortedList() {
        ListNode n = new ListNode(3);
        ListNode o = new ListNode(4);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode l = new ListNode(5);
        ListNode i = new ListNode(5);
        ListNode s = new ListNode(6);
        ListNode t = new ListNode(7);
        t.next = s;
        s.next = i;
        i.next = l;
        l.next = e;
        e.next = d;
        d.next = o;
        o.next = n;
        assertEquals("7 -> 6 -> 5 -> 4 -> 3", t.deleteDuplicatesFromSortedList().toString());
        assertEquals("3", n.deleteDuplicatesFromSortedList().toString());
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
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
}
