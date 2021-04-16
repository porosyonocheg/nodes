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

    @Test
    public void treeToList() {
        assertEquals("[5, 1, 2, 3, 4, 10, 6, 7, 8, 9, 15, 11, 12, 13, 14]", base.treeToList("").toString());
        assertEquals("[1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14, 15, 10, 5]", base.treeToList("post").toString());
        List<NaryTree> list = new ArrayList<>();
        list.add(new NaryTree(2));
        List<NaryTree> list11 = new ArrayList<>();
        list11.add(new NaryTree(14));
        List<NaryTree> list7 = new ArrayList<>();
        list7.add(new NaryTree(11, list11));
        List<NaryTree> list1 = new ArrayList<>();
        list1.add(new NaryTree(6));
        list1.add(new NaryTree(7, list7));
        List<NaryTree> list2 = new ArrayList<>();
        List<NaryTree> list8 = new ArrayList<>();
        list8.add(new NaryTree(12));
        list2.add(new NaryTree(8, list8));
        List<NaryTree> list3 = new ArrayList<>();
        List<NaryTree> list9 = new ArrayList<>();
        list9.add(new NaryTree(13));
        list3.add(new NaryTree(9, list9));
        list3.add(new NaryTree(10));
        list.add(new NaryTree(3, list1));
        list.add(new NaryTree(4, list2));
        list.add(new NaryTree(5, list3));
        NaryTree root = new NaryTree(1, list);
        assertEquals("[2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1]", root.treeToList("post").toString());
        assertEquals("[1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]", root.treeToList("pre").toString());
    }

    @Test
    public void levelOrder() {
        assertEquals("[[5], [1, 2, 3, 4, 10], [6, 7, 8, 9, 15], [11, 12, 13, 14]]", base.levelOrder().toString());
        assertEquals("[[0]]", new NaryTree(0).levelOrder().toString());
        List<NaryTree> list = new ArrayList<>();
        list.add(new NaryTree(2));
        List<NaryTree> list11 = new ArrayList<>();
        list11.add(new NaryTree(14));
        List<NaryTree> list7 = new ArrayList<>();
        list7.add(new NaryTree(11, list11));
        List<NaryTree> list1 = new ArrayList<>();
        list1.add(new NaryTree(6));
        list1.add(new NaryTree(7, list7));
        List<NaryTree> list2 = new ArrayList<>();
        List<NaryTree> list8 = new ArrayList<>();
        list8.add(new NaryTree(12));
        list2.add(new NaryTree(8, list8));
        List<NaryTree> list3 = new ArrayList<>();
        List<NaryTree> list9 = new ArrayList<>();
        list9.add(new NaryTree(13));
        list3.add(new NaryTree(9, list9));
        list3.add(new NaryTree(10));
        list.add(new NaryTree(3, list1));
        list.add(new NaryTree(4, list2));
        list.add(new NaryTree(5, list3));
        NaryTree root = new NaryTree(1, list);
        assertEquals("[[1], [2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13], [14]]", root.levelOrder().toString());
    }
}
