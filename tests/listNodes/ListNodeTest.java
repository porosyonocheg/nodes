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
    public void swapPairs(){
        assertEquals(new ListNode("2 -> 1 -> 4 -> 3"), new ListNode("1 -> 2 -> 3 -> 4").swapPairs());
        assertEquals(new ListNode("1"), new ListNode("1").swapPairs());
        assertEquals(new ListNode("2 -> 1 -> 3"), new ListNode("1 -> 2 -> 3").swapPairs());
        assertEquals(new ListNode("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10"), new ListNode("2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 10 -> 9").swapPairs());
    }

    @Test
    public void swapNodes() {
        assertEquals(new ListNode("1 -> 3 -> 2 -> 4"), new ListNode("1 -> 2 -> 3 -> 4").swapNodes(2));
        assertEquals(new ListNode("1"), new ListNode("1").swapNodes(1));
        assertEquals(new ListNode("4 -> 2 -> 3 -> 1"), new ListNode("1 -> 2 -> 3 -> 4").swapNodes(4));
        assertEquals(new ListNode("1 -> 2 -> 3 -> 4 -> 5"), new ListNode("1 -> 2 -> 3 -> 4 -> 5").swapNodes(3));
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

    @Test
    public void isPalindrome() {
        assertTrue(new ListNode(5).isPalindrome());
        assertTrue(new ListNode("1 -> 1").isPalindrome());
        assertTrue(new ListNode("3 -> 3 -> 3").isPalindrome());
        assertFalse(base.isPalindrome());
        assertTrue(new ListNode("5 -> 2 -> 1 -> 2 -> 5").isPalindrome());
        assertTrue(new ListNode("5 -> 2 -> 2 -> 2 -> 3 -> 3 -> 2 -> 2 -> 2 -> 5").isPalindrome());
        assertFalse(new ListNode("5 -> 2 -> 2").isPalindrome());
    }

    @Test
    public void hasCycle() {
        assertFalse(base.hasCycle());
        assertFalse(new ListNode("3 -> 3 -> 3").hasCycle());
        ListNode n = new ListNode("7 -> 5 -> 3");
        ListNode n1 = new ListNode("5 -> 2 -> 6");
        ListNode n2 = new ListNode("1 -> 3 -> 4");
        ListNode node = new ListNode(12);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(15);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(17);
        ListNode node5 = new ListNode(14);
        ListNode node6 = new ListNode(16);
        ListNode node7 = new ListNode(11);
        ListNode node8 = new ListNode(10);
        n.next = n1;
        n1.next = n2;
        n2.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = n;
        assertTrue(n.hasCycle());
        n1.next = n2;
        n2.next = n1;
        assertTrue(n1.hasCycle());
    }

    @Test
    public void intersectionOfTwoLinkedLists(){
        ListNode n = new ListNode("7 -> 5 -> 3");
        ListNode n1 = new ListNode("5 -> 2 -> 6");
        ListNode n2 = new ListNode("1 -> 3 -> 4");
        n.next = n1;
        n1.next = n2;
        ListNode node5 = new ListNode(14);
        ListNode node6 = new ListNode(16);
        ListNode node7 = new ListNode(11);
        ListNode node8 = new ListNode(10);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = n2;
        assertEquals("1 -> 3 -> 4", IntersectionOfTwoLinkedLists.getIntersectionNode(n,node5).toString());
        assertEquals(node8, IntersectionOfTwoLinkedLists.getIntersectionNode(node7, node8));
        assertEquals(n1, IntersectionOfTwoLinkedLists.getIntersectionNode(n1, n1));
        assertNull(IntersectionOfTwoLinkedLists.getIntersectionNode(new ListNode("1 -> 2 -> 3"), new ListNode("1 -> 2 -> 3")));
        ListNode node = new ListNode(12);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(15);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(17);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        n.next = node4;
        assertEquals(node4, IntersectionOfTwoLinkedLists.getIntersectionNode(n, node));
    }

    @Test
    public void addingNodes() {
        base.addListNode(new ListNode("12 -> 3 -> 6"));
        assertEquals("5 -> 4 -> 3 -> 2 -> 1 -> 0 -> 12 -> 3 -> 6", base.toString());
        ListNode n = new ListNode(1);
        n.addListNode(null);
        assertEquals("1", n.toString());
        n.addListNode(base);
        assertEquals("1 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0 -> 12 -> 3 -> 6", n.toString());
        assertTrue(n.insertNewNode(0, 333));
        assertEquals("1 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0 -> 333 -> 12 -> 3 -> 6", n.toString());
        assertFalse(n.insertNewNode(55, 77));
        assertTrue(n.insertNewNode(3, 77));
        assertEquals("1 -> 5 -> 4 -> 3 -> 77 -> 2 -> 1 -> 0 -> 333 -> 12 -> 3 -> 6", n.toString());
        ListNode node = new ListNode("5 -> 1 -> 7 -> 10 -> 12");
        ListNode innerNode = new ListNode("6 -> 3 -> 22");
        assertFalse(node.insertListNode(innerNode, 77));
        assertTrue(node.insertListNode(innerNode, 7));
        assertEquals("5 -> 1 -> 7 -> 6 -> 3 -> 22 -> 10 -> 12", node.toString());
        ListNode newNode = new ListNode("22 -> 23 -> 21");
        node.insertListNode(newNode);
        assertEquals("5 -> 1 -> 7 -> 6 -> 3 -> 22 -> 23 -> 21 -> 10 -> 12", node.toString());
        node.insertListNode(new ListNode(13));
        assertEquals("5 -> 1 -> 7 -> 6 -> 3 -> 22 -> 23 -> 21 -> 10 -> 12 -> 13", node.toString());
        node.insertListNode(new ListNode(1));
        assertEquals("5 -> 1 -> 7 -> 6 -> 3 -> 22 -> 23 -> 21 -> 10 -> 12 -> 13", node.toString());
        node.insertListNode(new ListNode("5 -> 5"));
        assertEquals("5 -> 5 -> 1 -> 7 -> 6 -> 3 -> 22 -> 23 -> 21 -> 10 -> 12 -> 13", node.toString());
    }

    @Test
    public void mergeTwoSortedLists() {
        ListNode n1 = new ListNode("2 -> 4 -> 6 -> 8");
        ListNode n2 = new ListNode("1 -> 3 -> 5 -> 7");
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8", MergeTwoSortedLists.mergeTwoLists(n1,n2).toString());
        n1 = new ListNode("3 -> 5 -> 7 -> 9");
        n2 = new ListNode("1 -> 1 -> 10");
        assertEquals("1 -> 1 -> 3 -> 5 -> 7 -> 9 -> 10", MergeTwoSortedLists.mergeTwoLists(n1,n2).toString());
        n1 = new ListNode("1 -> 10 -> 15 -> 20");
        n2 = new ListNode("2 -> 12 -> 17");
        assertEquals("1 -> 2 -> 10 -> 12 -> 15 -> 17 -> 20", MergeTwoSortedLists.mergeTwoLists(n1,n2).toString());
    }

    @Test
    public void sortListNode() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5", new SortListNode().sortList(base).toString());
        ListNode node = new ListNode("5 -> 4 -> 9 -> 6 -> 15 -> 3 -> 1 -> 11 -> 14 -> 2 -> 8 -> 7 -> 13 -> 10 -> 12");
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> 15", new SortListNode().sortList(node).toString());
        node = new ListNode("9 -> 5 -> 1 -> 9 -> 5 -> 9 -> 7 -> 5 -> 1 -> 9 -> 9 -> 1 -> 5 -> 7 -> 7 -> 9 -> 5 -> 1");
        assertEquals("1 -> 1 -> 1 -> 1 -> 5 -> 5 -> 5 -> 5 -> 5 -> 7 -> 7 -> 7 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9", new SortListNode().sortList(node).toString());
    }
}
