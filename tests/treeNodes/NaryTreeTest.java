package treeNodes;

import org.junit.Test;
import treeNodes.nAryTree.NaryTree;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NaryTreeTest {
    private NaryTree base;

    public NaryTreeTest() {
    List<NaryTree> list = new ArrayList<>();
    List<NaryTree> list1 = new ArrayList<>();
    List<NaryTree> list2 = new ArrayList<>();
        list2.add(new NaryTree(11));
        list2.add(new NaryTree(12));
        list2.add(new NaryTree(13));
        list2.add(new NaryTree(14));
        list1.add(new NaryTree(6));
        list1.add(new NaryTree(7));
        list1.add(new NaryTree(8));
        list1.add(new NaryTree(9));
    NaryTree naryTree2 = new NaryTree(15, list2);
        list1.add(naryTree2);
        list.add(new NaryTree(1));
        list.add(new NaryTree(2));
        list.add(new NaryTree(3));
        list.add(new NaryTree(4));
    NaryTree naryTree1 = new NaryTree(10, list1);
        list.add(naryTree1);
    base = new NaryTree(5, list);
    }

    @Test
    public void testToString() {
        assertEquals("5 -> [1, 2, 3, 4, 10 -> [6, 7, 8, 9, 15 -> [11, 12, 13, 14]]]", base.toString());
    }

    @Test
    public void maxDepthOfTree() {
        assertEquals(1, new NaryTree(5).maximumDepthOfTree());
        List<NaryTree> list = new ArrayList<>();
        list.add(new NaryTree(5));
        assertEquals(2, new NaryTree(1, list).maximumDepthOfTree());
        assertEquals(4, base.maximumDepthOfTree());
    }
}
