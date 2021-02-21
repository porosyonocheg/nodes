package treeNodes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeNodeTest {

    TreeNode l = new TreeNode(-5);
    TreeNode k = new TreeNode(-7);
    TreeNode j = new TreeNode(1);
    TreeNode i = new TreeNode(3);
    TreeNode h = new TreeNode(6);
    TreeNode g = new TreeNode(7,h,null);
    TreeNode f = new TreeNode(5,null,g);
    TreeNode e = new TreeNode(4,i,f);
    TreeNode d = new TreeNode(-6, k, l);
    TreeNode c = new TreeNode(-3);
    TreeNode b = new TreeNode(-1);
    TreeNode a = new TreeNode(-4, d, c);
    TreeNode left1 = new TreeNode(-2, a, b);
    TreeNode right1 = new TreeNode(2, j, e);
    TreeNode root = new TreeNode(0, left1, right1);

    @Test
    public void testToString() {
        assertEquals("0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, -7, -5, null, null, null, null, null, 7, null, null, null, null, 6", root.toString());
    }

    @Test
    public void maxDepthOfTree() {
        assertEquals(6, new MaxDepthOfTree(root).execute()); // 0 -> 2 -> 4 -> 5 -> 7 -> 6
        assertEquals(5, new MaxDepthOfTree(right1).execute());
        assertEquals(4, new MaxDepthOfTree(left1).execute());
        assertEquals(3, new MaxDepthOfTree(f).execute());
    }

    @Test
    public void minDepthOfTree() {
        assertEquals(3, new MinDepthOfTree(root).execute()); // 0 -> 2 -> 1 или 0 -> -2 -> -1
        assertEquals(3, new MinDepthOfTree(f).execute());
        assertEquals(2, new MinDepthOfTree(left1).execute());
    }

    @Test
    public void invertBinaryTree() {
        assertEquals("0, 2, -2, 4, 1, -1, -4, 5, 3, null, null, null, null, -3, -6, 7, null, null, null, null, null, -5, -7, null, 6", new InvertTree(root).execute().toString());
    }

    @Test
    public void averageOfLevels() {
        assertEquals("[2.0, 2.5, 4.0, 7.0, 6.0]", new AverageOfLevels(right1).execute().toString());
        assertEquals("[0.0, 0.0, 0.0, -0.25, -1.6666666666666667, 6.0]", new AverageOfLevels(root).execute().toString());
    }

    @Test
    public void findElementInBST() {
        assertEquals("7, 6", new FindElementInBST(root, 7).execute().toString());
        assertEquals("-6, -7, -5", new FindElementInBST(root, -6).execute().toString());
        assertEquals("3", new FindElementInBST(root, 3).execute().toString());
    }

    @Test
    public void isCousins() {
        assertTrue((Boolean) new Cousins(root, 5, -6).execute());
        assertFalse((Boolean) new Cousins(root, -5, -7).execute());
        assertFalse((Boolean) new Cousins(root, 6, -7).execute());
        assertTrue((Boolean) new Cousins(root, -5, 7).execute());
    }

    @Test
    public void isBalanceBinaryTree() {
        assertTrue((Boolean) new BalancedBinaryTree(a).execute());
        assertFalse((Boolean) new BalancedBinaryTree(root).execute());
        assertFalse((Boolean) new BalancedBinaryTree(e).execute());
        assertTrue((Boolean) new BalancedBinaryTree(i).execute());
    }

    @Test
    public void symmetricTree() {
        assertFalse((Boolean) new SymmetricTree(root).execute());
        l.val = 6;
        k.val = 7;
        k.left = null;
        k.right = l;
        d.val = 5;
        d.left = k;
        d.right = null;
        c.val = 3;
        b.val = 1;
        a.val = 4;
        left1.val = 2;
        assertTrue((Boolean) new SymmetricTree(root).execute());
    }

    @Test
    public void sameTree() {
        assertFalse((Boolean) new SameTree(right1, left1).execute());
        assertTrue((Boolean) new SameTree(right1, right1).execute());
    }

    @Test
    public void subtreeOfAnotherTree() {
        assertTrue((Boolean) new SubtreeOfAnotherTree(root, f).execute());
        assertFalse((Boolean) new SubtreeOfAnotherTree(right1, left1).execute());
        assertFalse((Boolean) new SubtreeOfAnotherTree(b, left1).execute());
        assertTrue((Boolean) new SubtreeOfAnotherTree(root, root).execute());
    }

    @Test
    public void similarLeavesTrees() {
        assertFalse((Boolean) new SimilarLeavesTrees(right1, left1).execute());
        l.val = 6;
        k.val = 7;
        k.left = null;
        k.right = l;
        d.val = 5;
        d.left = k;
        d.right = null;
        c.val = 3;
        b.val = 1;
        a.val = 4;
        left1.val = 2;
        assertTrue((Boolean) new SimilarLeavesTrees(right1, right1).execute());
    }

    @Test
    public void binaryTreePaths() {
        List<String> testList = new ArrayList<>();
        testList.add("0 -> -2 -> -4 -> -6 -> -7");
        testList.add("0 -> -2 -> -4 -> -6 -> -5");
        testList.add("0 -> -2 -> -4 -> -3");
        testList.add("0 -> -2 -> -1");
        testList.add("0 -> 2 -> 1");
        testList.add("0 -> 2 -> 4 -> 3");
        testList.add("0 -> 2 -> 4 -> 5 -> 7 -> 6");
        assertEquals(testList, new BinaryTreePaths(root).execute());
    }

    @Test
    public void mergeTwoBinaryTrees() {
        TreeNode left12 = new TreeNode(-3, d, c);
        TreeNode right12 = new TreeNode(3, i, f);
        TreeNode root1 = new TreeNode(0, left12, right12);
        assertEquals(root1, new MergeTwoBinaryTrees(right1, left1).execute());
    }

    @Test
    public void univalentBinaryTree() {
        TreeNode left13 = new TreeNode(1);
        TreeNode left23 = new TreeNode(1);
        TreeNode right13 = new TreeNode(1);
        TreeNode right23 = new TreeNode(1);
        TreeNode left12 = new TreeNode(1,left13, right13);
        TreeNode right12 = new TreeNode(1, left23, right23);
        TreeNode root1 = new TreeNode(1, left12, right12);
        assertTrue((Boolean) new UnivalentBinaryTree(root1).execute());
        left23.val = 0;
        assertFalse((Boolean) new UnivalentBinaryTree(root1).execute());
    }
    TreeNode left13 = new TreeNode(2);
    TreeNode left23 = new TreeNode(6);
    TreeNode right13 = new TreeNode(4);
    TreeNode right23 = new TreeNode(8);
    TreeNode left12 = new TreeNode(3,left13, right13);
    TreeNode right12 = new TreeNode(7, left23, right23);
    TreeNode root1 = new TreeNode(5, left12, right12);
    @Test
    public void sortedArrayToBST() {
        assertNull( new SortedArrayToBST(new int[]{}).execute());
        assertEquals(root1, new SortedArrayToBST(new int[]{2,3,4,5,6,7,8}).execute());
        TreeNode l = new TreeNode(-5);
        TreeNode k = new TreeNode(-7);
        TreeNode j = new TreeNode(1);
        TreeNode i = new TreeNode(3);
        TreeNode g = new TreeNode(7);
        TreeNode f = new TreeNode(5);
        TreeNode h = new TreeNode(6, f, g);
        TreeNode d = new TreeNode(-6, k, l);
        TreeNode c = new TreeNode(-3);
        TreeNode b = new TreeNode(-1);
        TreeNode left1 = new TreeNode(-2, c, b);
        TreeNode a = new TreeNode(-4, d, left1);
        TreeNode right1 = new TreeNode(2, j, i);
        TreeNode e = new TreeNode(4, right1, h);
        TreeNode root = new TreeNode(0, a, e);
        assertEquals(root, new SortedArrayToBST(new int[]{-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7}).execute());
    }
    @Test
    public void findModeInBST() {
        TreeNode l = new TreeNode(-4);
        TreeNode k = new TreeNode(-4);
        TreeNode j = new TreeNode(1);
        TreeNode i = new TreeNode(3);
        TreeNode g = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode h = new TreeNode(4, f, g);
        TreeNode d = new TreeNode(-4, k, l);
        TreeNode c = new TreeNode(-3);
        TreeNode b = new TreeNode(-1);
        TreeNode left1 = new TreeNode(-2, c, b);
        TreeNode a = new TreeNode(-4, d, left1);
        TreeNode right1 = new TreeNode(1, j, i);
        TreeNode e = new TreeNode(4, right1, h);
        TreeNode root = new TreeNode(1, a, e);
        List<Integer> list = new ArrayList<>();
        list.add(-4);
        list.add(4);
        assertEquals(list, new FindModeInBST(root).execute());
        list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        assertEquals(list, new FindModeInBST(root1).execute());
    }
}