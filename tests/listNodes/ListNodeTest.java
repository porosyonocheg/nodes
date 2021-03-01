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
        assertEquals("5 -> 4 -> 3 -> 2 -> 1 -> 0", base.listNodeToString());
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
        assertEquals("3 -> 2 -> 0", n.listNodeToString());
    }
}
