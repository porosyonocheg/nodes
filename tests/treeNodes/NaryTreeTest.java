package treeNodes;

import org.junit.Test;
import treeNodes.nAryTree.NaryToBinaryTreeAndBackConverter;
import treeNodes.nAryTree.NaryTree;
import treeNodes.nAryTree.Trie;

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

    @Test
    public void trieTest() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        assertTrue(trie.search("app"));
        assertFalse(trie.search("apps"));
        assertFalse(trie.search("ad")); //false
        assertFalse(trie.search("applepie")); //false
        assertFalse(trie.search("rest")); //false
        assertFalse(trie.search("jan")); //false
        assertFalse(trie.search("rent")); //false
        assertTrue(trie.search("beer")); //true
        assertTrue(trie.search("jam")); //true
        assertFalse(trie.startsWith("apps")); //false
        assertTrue(trie.startsWith("app")); //true
        assertTrue(trie.startsWith("ad")); //true
        assertFalse(trie.startsWith("applepie")); //false
        assertFalse(trie.startsWith("rest")); //false
        assertFalse(trie.startsWith("jan")); //false
        assertTrue(trie.startsWith("rent")); //true
        assertTrue(trie.startsWith("beer")); //true
        assertTrue(trie.startsWith("jam")); //true
    }

    @Test
    public void naryToBinaryTreeAndBackConverter() {
        assertNull(NaryToBinaryTreeAndBackConverter.toBinaryTree(null));
        assertNull(NaryToBinaryTreeAndBackConverter.toNaryTree(null));
        assertEquals(new TreeNode(5), NaryToBinaryTreeAndBackConverter.toBinaryTree(new NaryTree(5)));
        assertEquals(new NaryTree(1).toString(), NaryToBinaryTreeAndBackConverter.toNaryTree(new TreeNode(1)).toString());
        TreeNode root = new TreeNode("5, 1, null, null, 2, null, 3, null, 4, null, 10, 6, null, null, 7, null, 8, null, 9, null, 15, 11, null, null, 12, null, 13, null, 14");
        assertEquals(root, NaryToBinaryTreeAndBackConverter.toBinaryTree(base));
        assertEquals(base.toString(), NaryToBinaryTreeAndBackConverter.toNaryTree(root).toString());
        base.val = 0;
        base.children = new ArrayList<>();
        for (int i = 1; i < 7; i++)
        base.children.add(new NaryTree(i));
        for (int i = 7; i < 10; i++) base.children.get(0).children.add(new NaryTree(i));
        base.children.get(1).children.add(new NaryTree(10));
        base.children.get(2).children.add(new NaryTree(11));
        base.children.get(2).children.add(new NaryTree(12));
        for (int i = 13; i < 18; i++) base.children.get(3).children.add(new NaryTree(i));
        base.children.get(0).children.get(0).children.add(new NaryTree(18));
        base.children.get(0).children.get(2).children.add(new NaryTree(19));
        base.children.get(0).children.get(2).children.add(new NaryTree(20));
        base.children.get(2).children.get(0).children.add(new NaryTree(21));
        base.children.get(2).children.get(0).children.add(new NaryTree(22));
        base.children.get(2).children.get(0).children.add(new NaryTree(23));
        base.children.get(3).children.get(4).children.add(new NaryTree(24));
        base.children.get(3).children.get(4).children.add(new NaryTree(25));
        root = new TreeNode("0, 1, null, 7, 2, 18, 8, 10, 3, null, null, null, 9, null, null, 11, 4, 19, null, 21, 12, 13, 5, null, 20, null, 22, null, null, null, 14, null, 6, null, null, null, 23, null, 15, null, null, null, null, null, 16, null, 17, 24, null, null, 25");
        assertEquals(root, NaryToBinaryTreeAndBackConverter.toBinaryTree(base));
        assertEquals(base.toString(), NaryToBinaryTreeAndBackConverter.toNaryTree(root).toString());
    }
}
