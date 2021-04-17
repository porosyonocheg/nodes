package treeNodes;

import listNodes.ListNode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import treeNodes.binarySearchTree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    public void constructorsTest() {
        assertEquals(root, new TreeNode("0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, -7, -5, null, null, null, null, null, 7, null, null, null, null, 6"));
        assertEquals(new TreeNode(0), new TreeNode(""));
        assertEquals(new TreeNode(0), new TreeNode(new ArrayList<>()));
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(-2);
        list.add(2);
        list.add(-4);
        list.add(-1);
        list.add(1);
        list.add(4);
        list.add(-6);
        list.add(-3);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(3);
        list.add(5);
        list.add(-7);
        list.add(-5);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(7);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(6);
        assertEquals(root, new TreeNode(list));
    }

    @Test
    public void addAndRemoveNodesInTree() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(5);
        list.add(12);
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(7);
        list.add(10);
        list.add(6);
        list.add(6);
        list.add(7);
        TreeNode node = new TreeNode(list);
        System.out.println(node);
        node.removeNodes(7);
        System.out.println(node);
        node.insertNewNode(7);
        node.insertNewNode(5);
        node.insertNewNode(12);
        node.insertNewNode(8);
        node.insertNewNode(7);
        node.insertNewNode(10);
        node.insertNewNode(6);
        node.insertNewNode(7);
        System.out.println(node);
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
        assertEquals("7, 6", new FindElement(root, 7).execute().toString());
        assertEquals("-6, -7, -5", new FindElement(root, -6).execute().toString());
        assertEquals("3", new FindElement(root, 3).execute().toString());
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
    public void countNodes() {
        assertEquals(7, root1.countNodes());
        assertEquals(15, root.countNodes());
        assertEquals(1, new TreeNode(0).countNodes());
        assertEquals(5, new TreeNode(0, null, new TreeNode(1, new TreeNode(2, null, new TreeNode(3, new TreeNode(4), null)), null)).countNodes());
    }

    @Test
    public void sortedArrayToBST() {
        assertNull( new ConvertSortedArrayToBST(new int[]{}).execute());
        assertEquals(root1, new ConvertSortedArrayToBST(new int[]{2,3,4,5,6,7,8}).execute());
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
        assertEquals(root, new ConvertSortedArrayToBST(new int[]{-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7}).execute());
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
        assertEquals(list, new FindMode(root).execute());
        list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        assertEquals(list, new FindMode(root1).execute());
    }

    @Test
    public void findSumInBST() {
        assertFalse((Boolean) new FindSum(root, 14).execute());
        assertTrue((Boolean) new FindSum(root, -13).execute());
        assertTrue((Boolean) new FindSum(root1, 14).execute());
        assertFalse((Boolean) new FindSum(root1, 4).execute());
    }

    @Test
    public void rangeSumInBST() {
        assertEquals(15, new RangeSum(root1,4,6).execute());
        assertEquals(11, new RangeSum(root,-4,6).execute());
    }

    @Test
    public void minimumAbsoluteDifferenceInBST() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(4);
        list.add(16);
        list.add(1);
        list.add(7);
        list.add(13);
        list.add(18);
        root1 = new TreeNode(list);
        assertEquals(1, new MinimumAbsoluteDifference(root).execute());
        assertEquals(2, new MinimumAbsoluteDifference(root1).execute());
    }

    @Test
    public void convertToIncreasingOrderTree() {
        assertEquals("2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8", new ConvertToIncreasingOrderTree(root1).execute().toString());
        assertEquals("-7, null, -6, null, -5, null, -4, null, -3, null, -2, null, -1, null, 0, null, 1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7", new ConvertToIncreasingOrderTree(root).execute().toString());
    }

    @Test
    public void trimBST() {
        assertEquals("0, -1, 2, null, null, 1, 3", new Trim(root,-1,3).execute().toString());
        assertEquals("3, 2", new Trim(root1,2,3).execute().toString());
    }

    @Test
    public void insertNewNodeInBST() {
        assertEquals("0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, -7, -5, null, null, null, null, null, 7, null, null, null, null, 6, 8", new InsertNewNode(root, 8).execute().toString());
        assertEquals(root1.toString() + ", null, null, null, null, null, null, null, 9", new InsertNewNode(root1, 9).execute().toString());
    }

    @Test
    public void constructTreeFromPreorder() {
        assertEquals("8, 5, 10, 1, 7, null, 12", new ConstructTreeFromPreorder(new int[]{8,5,1,7,10,12}).execute().toString());
        assertEquals(root1, new ConstructTreeFromPreorder(new int[]{5,3,2,4,7,6,8}).execute());
    }

    @Test
    public void sumOfLeftLeaves() {
        assertEquals(3, new SumOfLeftLeaves(root).execute());
        assertEquals(8, new SumOfLeftLeaves(root1).execute());
    }

    @Test
    public void insertNewNode() {
        root.insertNewNode(10);
        root.insertNewNode(9);
        root.insertNewNode(8);
        assertEquals("0, -2, 2, -4, -1, 1, 4, -6, -3, 10, 9, 8, null, 3, 5, -7, -5, null, null, null, null, null, null, null, null, null, null, null, 7, null, null, null, null, 6", root.toString());
        root1.insertNewNode(1);
        root1.insertNewNode(2);
        root1.insertNewNode(3);
        assertEquals("5, 3, 7, 2, 4, 6, 8, 1, 2, 3", root1.toString());
    }

    @Test
    public void sumOfDeepestLeaves() {
        assertEquals(6, new SumOfDeepestLeaves(root).execute());
        assertEquals(20, new SumOfDeepestLeaves(root1).execute());
    }

    @Test
    public void convertToBalancedTree() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(null);
        list.add(3);
        list.add(null);
        list.add(4);
        list.add(null);
        list.add(5);
        list.add(null);
        list.add(6);
        list.add(null);
        list.add(7);
        TreeNode node = new TreeNode(list);
        assertEquals("4, 2, 6, 1, 3, 5, 7", new ConvertToBalancedTree(node).execute().toString());
    }
    @Test
    public void binaryTreeLevelTraversal() {
        assertEquals("[[0], [-2, 2], [-4, -1, 1, 4], [-6, -3, 3, 5], [-7, -5, 7], [6]]", new BinaryTreeLevelTraversal(root).execute().toString());
        assertEquals("[[5], [3, 7], [2, 4, 6, 8]]", new BinaryTreeLevelTraversal(root1).execute().toString());
    }

    @Test
    public void sumOfNodesWithOddOrEvenValuedGrandparent() {
        TreeNode node8 = new TreeNode(8, new TreeNode(1), new TreeNode(14));
        TreeNode node9 = new TreeNode(9, new TreeNode(4), new TreeNode(7));
        TreeNode node5 = new TreeNode(5, new TreeNode(10), new TreeNode(15));
        TreeNode node6 = new TreeNode(6, new TreeNode(3), node8);
        TreeNode node2 = new TreeNode(2, node6, node9);
        TreeNode node11 = new TreeNode(11, node5, new TreeNode(12));
        TreeNode root0 = new TreeNode(13, node2, node11);

        assertEquals(-6, new SumOfNodesWithOddOrEvenValuedGrandparent(root, true).execute());
        assertEquals(6, new SumOfNodesWithOddOrEvenValuedGrandparent(root, false).execute());
        assertEquals(37, new SumOfNodesWithOddOrEvenValuedGrandparent(root0, true).execute());
        assertEquals(57, new SumOfNodesWithOddOrEvenValuedGrandparent(root0, false).execute());
    }

    @Test
    public void lowestCommonAncestorInBST() {
        assertEquals(a, new LowestCommonAncestorInBST(root, -3, -7).execute());
        assertEquals(f, new LowestCommonAncestorInBST(root, 5, 6).execute());
        assertEquals(root, new LowestCommonAncestorInBST(root, -1, 1).execute());
        assertEquals(root, new LowestCommonAncestorInBST(root, -8, 6).execute());
        TreeNode node2 = new TreeNode(3, new TreeNode(1), new TreeNode(5));
        TreeNode node11 = new TreeNode(9, new TreeNode(7), new TreeNode(11));
        TreeNode root0 = new TreeNode(6, node2, node11);
        assertEquals(root0, new LowestCommonAncestorInBST(root0, 4, 8).execute());
        assertEquals(node2, new LowestCommonAncestorInBST(root0, 4, 2).execute());
        node2.right = new TreeNode(3);
        node11.right = new TreeNode(9);
        assertEquals(node2, new LowestCommonAncestorInBST(root0, 2, 4).execute());
        assertEquals(new TreeNode(9), new LowestCommonAncestorInBST(root0, 11, 10).execute());
    }

    @Test
    public void lowestCommonAncestor() {
        TreeNode node8 = new TreeNode(10, new TreeNode(13), new TreeNode(8));
        TreeNode node9 = new TreeNode(19, new TreeNode(14), new TreeNode(7));
        TreeNode node5 = new TreeNode(4, new TreeNode(12), new TreeNode(6));
        TreeNode node6 = new TreeNode(3, new TreeNode(0), node8);
        TreeNode node2 = new TreeNode(9, node6, node9);
        TreeNode node11 = new TreeNode(5, node5, new TreeNode(2));
        TreeNode root0 = new TreeNode(1, node2, node11);
        assertEquals(root0, new LowestCommonAncestor(root0, 6, 7).execute());
        assertEquals(node6, new LowestCommonAncestor(root0, 8, 0).execute());
        assertEquals(node2, new LowestCommonAncestor(root0, 9, 13).execute());
        assertEquals(node5, new LowestCommonAncestor(root0, 12, 6).execute());
    }

    @Test
    public void diameterOfBinaryTree() {
        assertEquals(9, new DiameterOfBinaryTree(root).execute());
        TreeNode node15 = new TreeNode(15, new TreeNode(17), new TreeNode(20));
        TreeNode node14 = new TreeNode(14, new TreeNode(10), new TreeNode(16));
        TreeNode node8 = new TreeNode(8, new TreeNode(1), node14);
        TreeNode node13 = new TreeNode(13, new TreeNode(7), node15);
        TreeNode node9 = new TreeNode(9, new TreeNode(4), node13);
        TreeNode node6 = new TreeNode(6, new TreeNode(3), node8);
        TreeNode node2 = new TreeNode(2, node6, node9);
        TreeNode node11 = new TreeNode(11, new TreeNode(5), new TreeNode(12));
        TreeNode root0 = new TreeNode(0, node2, node11);
        assertEquals(8, new DiameterOfBinaryTree(root0).execute());
    }

    @Test
    public void convertToGreaterTree() {
        assertEquals("26, 33, 15, 35, 30, 21, 8", new ConvertToGreaterTree(root1).execute().toString());
        assertEquals("28, 25, 27, 18, 27, 28, 22, 7, 22, null, null, null, null, 25, 18, 0, 13, null, null, null, null, null, 7, null, null, null, null, 13", new ConvertToGreaterTree(root).execute().toString());
        assertNull(new ConvertToGreaterTree(null).execute());
        assertEquals("3", new ConvertToGreaterTree(new TreeNode(3)).execute().toString());
    }

    @Test
    public void constructMaximumBinaryTree() {
        int[] nums = {1,2,3,4,5};
        assertEquals("5, 4, null, 3, null, 2, null, 1", new ConstructMaximumBinaryTree(nums).execute().toString());
        nums = new int[]{5,4,3,2,1};
        assertEquals("5, null, 4, null, 3, null, 2, null, 1", new ConstructMaximumBinaryTree(nums).execute().toString());
        nums = new int[]{3,2,1,6,0,5};
        assertEquals("6, 3, 5, null, 2, 0, null, null, 1", new ConstructMaximumBinaryTree(nums).execute().toString());
        nums = new int[]{};
        assertNull(new ConstructMaximumBinaryTree(nums).execute());
        nums = new int[]{0};
        assertEquals(new TreeNode(0), new ConstructMaximumBinaryTree(nums).execute());
    }

    @Test
    public void countGoodNodes() {
        assertEquals(5, new CountGoodNodes(root).execute());
        TreeNode node8 = new TreeNode(8, new TreeNode(1), new TreeNode(14));
        TreeNode node9 = new TreeNode(4, new TreeNode(3), new TreeNode(7));
        TreeNode node5 = new TreeNode(4, new TreeNode(10), new TreeNode(3));
        TreeNode node6 = new TreeNode(3, new TreeNode(3), node8);
        TreeNode node2 = new TreeNode(2, node6, node9);
        TreeNode node11 = new TreeNode(5, node5, new TreeNode(7));
        TreeNode root0 = new TreeNode(1, node2, node11);
        assertEquals(11, new CountGoodNodes(root0).execute());
        assertEquals(1, new CountGoodNodes(new TreeNode(5)).execute());
        assertEquals(0, new CountGoodNodes(null).execute());
    }

    @Test
    public void addNewRow(){
        assertEquals(new TreeNode(5, new TreeNode(0), null), new AddNewRow(new TreeNode(0),5,1).execute());
        assertEquals("0, -2, 2, -4, -1, 1, 4, 8, 8, 8, 8, 8, 8, 8, 8, -6, null, null, -3, null, null, null, null, null, null, null, null, 3, null, null, 5, -7, -5, null, null, null, null, null, 7, null, null, null, null, 6", new AddNewRow(root,8,4).execute().toString());
        assertEquals("5, 3, 7, 2, 4, 6, 8, 1, 1, 1, 1, 1, 1, 1, 1" , new AddNewRow(root1, 1,4).execute().toString());
    }

    @Test
    public void deleteNodeInBST(){
        assertEquals(new TreeNode(-1), new DeleteNode(new TreeNode(1, new TreeNode(-1), null), 1).execute());
        assertEquals(new TreeNode(2), new DeleteNode(new TreeNode(1, null, new TreeNode(2)), 1).execute());
        assertEquals(new TreeNode(1), new DeleteNode(new TreeNode(1, null, new TreeNode(2)), 2).execute());
        assertNull(new DeleteNode(null, 2).execute());
        assertEquals("0, -2, 2, -4, -1, 1, 5, -6, -3, null, null, null, null, 3, 7, -7, -5, null, null, null, null, 6", new DeleteNode(root, 4).execute().toString());
        assertEquals(root1, new DeleteNode(root1, 9).execute());
    }

    @Test
    public void maximumAncestorNodeDifference() {
        assertEquals(7, new MaximumAncestorNodeDifference(root).execute());
        assertEquals(3, new MaximumAncestorNodeDifference(root1).execute());
        assertEquals(0, new MaximumAncestorNodeDifference(new TreeNode(1, null, new TreeNode(1))).execute());
        assertEquals(1, new MaximumAncestorNodeDifference(new TreeNode(0, new TreeNode(1), null)).execute());
        assertEquals(2, new MaximumAncestorNodeDifference(new TreeNode(0, new TreeNode(1), new TreeNode(2))).execute());
        assertEquals(8, new MaximumAncestorNodeDifference(new TreeNode(9, new TreeNode(1), new TreeNode(2))).execute());
        TreeNode node8 = new TreeNode(3, new TreeNode(4), new TreeNode(6));
        TreeNode node9 = new TreeNode(4, new TreeNode(7), new TreeNode(10));
        TreeNode node5 = new TreeNode(12, new TreeNode(6), new TreeNode(15));
        TreeNode node6 = new TreeNode(5, new TreeNode(12), node8);
        TreeNode node2 = new TreeNode(9, node6, node9);
        TreeNode node11 = new TreeNode(7, node5, new TreeNode(3));
        TreeNode root0 = new TreeNode(8, node2, node11);
        assertEquals(8, new MaximumAncestorNodeDifference(root0).execute());
        node5.right = new TreeNode(9);
        assertEquals(7, new MaximumAncestorNodeDifference(root0).execute());
    }

    @Test
    public void isEvenOddTree() {
        assertTrue((Boolean) new IsEvenOddTree(new TreeNode(1)).execute());
        assertFalse((Boolean) new IsEvenOddTree(new TreeNode(2)).execute());
        TreeNode node8 = new TreeNode(8, new TreeNode(1), new TreeNode(9));
        TreeNode node9 = new TreeNode(7, new TreeNode(6), new TreeNode(4));
        TreeNode node5 = new TreeNode(13, new TreeNode(2), new TreeNode(0));
        TreeNode node6 = new TreeNode(5, new TreeNode(12), node8);
        TreeNode node2 = new TreeNode(8, node6, node9);
        TreeNode node11 = new TreeNode(6, node5, new TreeNode(17));
        TreeNode root0 = new TreeNode(3, node2, node11);
        assertTrue((Boolean) new IsEvenOddTree(root0).execute());
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(3); //should be greater than previous one
        list.add(7);
        TreeNode node = new TreeNode(list);
        assertFalse((Boolean) new IsEvenOddTree(node).execute());
        list = new ArrayList<>();
        list.add(5);
        list.add(9); //should be even
        list.add(1); //should be even too
        list.add(3);
        list.add(5);
        list.add(7);
        node = new TreeNode(list);
        assertFalse((Boolean) new IsEvenOddTree(node).execute());
    }

    @Test
    public void allNodesDistanceK() {
        assertEquals("[-7, -5, 1, 4]",new AllNodesDistanceK(root, -2, 3).execute().toString());
        assertEquals("[]",new AllNodesDistanceK(root1, 2, 5).execute().toString()); //there is no nodes in such distance
        assertEquals("[]",new AllNodesDistanceK(root1, 9, 0).execute().toString()); //there is no target
        assertEquals("[7]",new AllNodesDistanceK(root1, 7, 0).execute().toString());
    }

    @Test
    public void isValidBST() {
        assertTrue((Boolean) new IsValidBST(root).execute());
        assertTrue((Boolean) new IsValidBST(root1).execute());
        assertTrue((Boolean) new IsValidBST(new TreeNode(1)).execute());
        assertTrue((Boolean) new IsValidBST(new TreeNode(1, null, new TreeNode(2,null, new TreeNode(3)))).execute());
        assertTrue((Boolean) new IsValidBST(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null)).execute());
        right23.val = 7;
        assertFalse((Boolean) new IsValidBST(root1).execute());
        TreeNode node8 = new TreeNode(160, new TreeNode(150), new TreeNode(200));
        TreeNode node9 = new TreeNode(130, new TreeNode(120), new TreeNode(135)); // 120 <= root0.val -> false
        TreeNode node5 = new TreeNode(100, new TreeNode(75), new TreeNode(110));
        TreeNode node6 = new TreeNode(50, new TreeNode(20), new TreeNode(55));
        TreeNode node2 = new TreeNode(70, node6, node5);
        TreeNode node11 = new TreeNode(140, node9, node8);
        TreeNode root0 = new TreeNode(120, node2, node11);
        assertFalse((Boolean) new IsValidBST(root0).execute());
        node8 = new TreeNode(15, new TreeNode(13), new TreeNode(16));
        node9 = new TreeNode(10, new TreeNode(9), new TreeNode(11));
        node5 = new TreeNode(8, new TreeNode(6), new TreeNode(7));// 8 >= root0.val -> false
        node6 = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        node2 = new TreeNode(5, node6, node5);
        node11 = new TreeNode(12, node9, node8);
        root0 = new TreeNode(8, node2, node11);
        assertFalse((Boolean) new IsValidBST(root0).execute());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void kthSmallestElement() {
        assertEquals(3, new KthSmallestElement(root, 11).execute());
        TreeNode node8 = new TreeNode(160, new TreeNode(150), new TreeNode(200));
        TreeNode node9 = new TreeNode(130, new TreeNode(121), new TreeNode(135));
        TreeNode node5 = new TreeNode(100, new TreeNode(75), new TreeNode(110));
        TreeNode node6 = new TreeNode(50, new TreeNode(20), new TreeNode(55));
        TreeNode node2 = new TreeNode(70, node6, node5);
        TreeNode node11 = new TreeNode(140, node9, node8);
        TreeNode root0 = new TreeNode(120, node2, node11);
        assertEquals(20, new KthSmallestElement(root0, 1).execute());
        assertEquals(200, new KthSmallestElement(root0, 15).execute());
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Incorrect k");
        new KthSmallestElement(root0, 16).execute();
        new KthSmallestElement(root0, 0).execute();
    }

    @Test
    public void numberOfGoodLeafPairs() {
        TreeNode node8 = new TreeNode(160, new TreeNode(150), new TreeNode(200));
        TreeNode node9 = new TreeNode(130, new TreeNode(121), new TreeNode(135));
        TreeNode node5 = new TreeNode(100, new TreeNode(75), new TreeNode(110));
        TreeNode node6 = new TreeNode(50, new TreeNode(20), new TreeNode(55));
        TreeNode node2 = new TreeNode(70, node6, node5);
        TreeNode node11 = new TreeNode(140, node9, node8);
        TreeNode root0 = new TreeNode(120, node2, node11);
        assertEquals(12, new NumberOfGoodLeafPairs(root0, 4).execute());
        assertEquals(9, new NumberOfGoodLeafPairs(root, 4).execute());
        assertEquals(2, new NumberOfGoodLeafPairs(root1, 2).execute());
        assertEquals(0, new NumberOfGoodLeafPairs(root1, 1).execute());
        assertEquals(6, new NumberOfGoodLeafPairs(root1, 5).execute());
    }

    @Test
    public void doesTreeContainListNode() {
        assertTrue((Boolean) new DoesTreeContainListNode(root, null).execute());
        assertTrue((Boolean) new DoesTreeContainListNode(null, null).execute());
        assertFalse((Boolean) new DoesTreeContainListNode(null, new ListNode(0)).execute());
        assertFalse((Boolean) new DoesTreeContainListNode(root, new ListNode("3 -> 4 -> 5 -> 7 -> 6")).execute());
        assertTrue((Boolean) new DoesTreeContainListNode(root, new ListNode("2 -> 4 -> 5 -> 7 -> 6")).execute());
        assertTrue((Boolean) new DoesTreeContainListNode(root, new ListNode("-2 -> -4 -> -6")).execute());
    }

    @Test
    public void sumRootToLeafNumbers() {
        assertEquals(1, new SumRootToLeafNumbers(new TreeNode(1)).execute());
        assertEquals(3, new SumRootToLeafNumbers(new TreeNode(0, new TreeNode(1), new TreeNode(2))).execute());
        assertEquals(2220, new SumRootToLeafNumbers(root1).execute());
        TreeNode g = new TreeNode(5,null,null);
        TreeNode j = new TreeNode(4,null,new TreeNode(7));
        TreeNode i = new TreeNode(2,null,null);
        TreeNode f = new TreeNode(6,i,g);
        TreeNode e = new TreeNode(3,null,null);
        TreeNode d = new TreeNode(8, e, null);
        TreeNode c = new TreeNode(1, null, j);
        TreeNode b = new TreeNode(5, f, null);
        TreeNode a = new TreeNode(2, null, d);
        TreeNode left1 = new TreeNode(0, a, b);
        TreeNode right1 = new TreeNode(3, c, null);
        TreeNode root = new TreeNode(1, left1, right1);
        assertEquals(44557, new SumRootToLeafNumbers(root).execute());
    }

    @Test
    public void maximumWidthOfBinaryTree() {
        assertEquals(0, new MaximumWidthOfBinaryTree(null).execute());
        assertEquals(1, new MaximumWidthOfBinaryTree(new TreeNode(0)).execute());
        assertEquals(1, new MaximumWidthOfBinaryTree(new TreeNode(0, null, new TreeNode(1, null, new TreeNode(2)))).execute());
        assertEquals(1, new MaximumWidthOfBinaryTree(new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), null)).execute());
        assertEquals(16, new MaximumWidthOfBinaryTree(root).execute()); // -7 -> 7
        k.right = new TreeNode(-9);
        assertEquals(30, new MaximumWidthOfBinaryTree(root).execute()); // -9 -> 6
        TreeNode g = new TreeNode(5,null,null);
        TreeNode j = new TreeNode(4,null,new TreeNode(7));
        TreeNode i = new TreeNode(2,null,null);
        TreeNode f = new TreeNode(6,i,g);
        TreeNode e = new TreeNode(3,null,null);
        TreeNode d = new TreeNode(8, e, null);
        TreeNode c = new TreeNode(1, null, j);
        TreeNode b = new TreeNode(5, f, null);
        TreeNode a = new TreeNode(2, null, d);
        TreeNode left1 = new TreeNode(0, a, b);
        TreeNode right1 = new TreeNode(3, c, null);
        TreeNode root = new TreeNode(1, left1, right1);
        assertEquals(10, new MaximumWidthOfBinaryTree(root).execute());
        root = new TreeNode("0, 0, 0, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0");
        assertEquals(2, new MaximumWidthOfBinaryTree(root).execute());
    }

    @Test
    public void recoverBST() {
        assertEquals(new TreeNode(1, new TreeNode(-2147483648), new TreeNode(2147483647)), new RecoverBST(new TreeNode(1, new TreeNode(2147483647), new TreeNode(-2147483648))).execute());
        TreeNode root0 = new TreeNode("0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, 7, -5, null, null, null, null, null, -7, null, null, null, null, 6");
        assertEquals(root, new RecoverBST(root0).execute());
        root0 = new TreeNode("5, 3, 9, -2147483648, 2");
        TreeNode sample = new TreeNode("5, 2, 9, -2147483648, 3");
        assertEquals(sample, new RecoverBST(root0).execute());
        TreeNode node8 = new TreeNode(160, new TreeNode(150), new TreeNode(200));
        TreeNode node9 = new TreeNode(130, new TreeNode(119), new TreeNode(135));
        TreeNode node5 = new TreeNode(100, new TreeNode(75), new TreeNode(110));
        TreeNode node6 = new TreeNode(50, new TreeNode(20), new TreeNode(55));
        TreeNode node2 = new TreeNode(70, node6, node5);
        TreeNode node11 = new TreeNode(140, node9, node8);
        root0 = new TreeNode(120, node2, node11);
        sample = new TreeNode("119, 70, 140, 50, 100, 130, 160, 20, 55, 75, 110, 120, 135, 150, 200");
        assertEquals(sample, new RecoverBST(root0).execute());
    }

    @Test
    public void isComplete() {
        assertTrue((Boolean) new IsComplete(root1).execute());
        assertFalse((Boolean) new IsComplete(root).execute());
        TreeNode node8 = new TreeNode(160, null, null);
        TreeNode node9 = new TreeNode(130, new TreeNode(119), null);
        TreeNode node5 = new TreeNode(100, new TreeNode(75), new TreeNode(110));
        TreeNode node6 = new TreeNode(50, new TreeNode(20), new TreeNode(55));
        TreeNode node2 = new TreeNode(70, node6, node5);
        TreeNode node11 = new TreeNode(140, node9, node8);
        TreeNode root0 = new TreeNode(120, node2, node11);
        assertTrue((Boolean) new IsComplete(root0).execute());
        node8.left = new TreeNode(180);
        node8.right = new TreeNode(200);
        assertFalse((Boolean) new IsComplete(root0).execute());
    }

    @Test
    public void distributeCoinsInBinaryTree() {
        TreeNode node = new TreeNode("3, 0, 0");
        assertEquals(2, new DistributeCoinsInBinaryTree(node).execute());
        node = new TreeNode("0, 3, 0");
        assertEquals(3, new DistributeCoinsInBinaryTree(node).execute());
        node = new TreeNode("1, 0, 2");
        assertEquals(2, new DistributeCoinsInBinaryTree(node).execute());
        node = new TreeNode("1, 0, 0, null, 3");
        assertEquals(4, new DistributeCoinsInBinaryTree(node).execute());
        node = new TreeNode("1");
        assertEquals(0, new DistributeCoinsInBinaryTree(node).execute());
        node = new TreeNode("1, 1, 1, 1, null, 1, 1, null, 1, 1, 1, 1, null, null, 1, 1, 1");
        assertEquals(0, new DistributeCoinsInBinaryTree(node).execute());
        node = new TreeNode("0, 1, 0, 1, null, 1, 1, null, 1, 1, 1, 0, null, null, 2, 1, 3");
        assertEquals(12, new DistributeCoinsInBinaryTree(node).execute());
    }

    @Test
    public void deleteLeavesByValue() {
        assertNull(new DeleteLeavesByValue(null,1).execute());
        assertNull(new DeleteLeavesByValue(new TreeNode("1, 1, 1, 1, 1, 1, 1, 1, 1, 1"),1).execute());
        assertEquals(new TreeNode("1, 2, 3, 4, 5, 6, 7, 8"), new DeleteLeavesByValue(new TreeNode("1, 2, 3, 4, 5, 6, 7, 8"),1).execute());
        assertEquals(new TreeNode("1, 2, 3, 8, null, null, null, 4"), new DeleteLeavesByValue(new TreeNode("1, 2, 3, 8, 8, 8, 8, 4"),8).execute());
        assertEquals(new TreeNode("3, 3, 6, 6, null, 5"), new DeleteLeavesByValue(new TreeNode("3, 3, 6, 6, 3, 5"), 3).execute());
        assertEquals(new TreeNode("5, 5, 5, 5, 5, 5"), new DeleteLeavesByValue(new TreeNode("5, 5, 5, 5, 5, 5"), 1).execute());
        assertEquals(new TreeNode("2, null, 3"), new DeleteLeavesByValue(new TreeNode("2, null, 3, null, 2, null, 2, null, 2, null, 2"), 2).execute());
    }

    @Test
    public void binaryTreeTilt() {
        assertEquals(155, new BinaryTreeTilt(root).execute());
        assertEquals(16, new BinaryTreeTilt(root1).execute());
        assertEquals(15, new BinaryTreeTilt(new TreeNode("4, 2, 9, 3, 5, null, 7")).execute());
        assertEquals(9, new BinaryTreeTilt(new TreeNode("21, 7, 14, 1, 1, 2, 2, 3, 3")).execute());
    }

    @Test
    public void createForestByDeletingValues() {
        List<TreeNode> answer = new ArrayList<>();
        answer.add(k);
        answer.add(l);
        answer.add(h);
        answer.add(j);
        answer.add(new TreeNode("4, 3, 5"));
        answer.add(new TreeNode("0, -2, null, -4, -1, null, -3"));
        assertEquals(answer, new CreateForestByDeletingValues(root, new int[]{2,-6,7}).execute());
        answer = new ArrayList<>();
        answer.add(left13);
        answer.add(right13);
        answer.add(left23);
        answer.add(right23);
        answer.add(new TreeNode(5));
        assertEquals(answer, new CreateForestByDeletingValues(root1, new int[]{7,3}).execute());

        root = new TreeNode("1, 2, 3, 4, 5, 6, 7");
        answer = new ArrayList<>();
        answer.add(new TreeNode(6));
        answer.add(new TreeNode(7));
        answer.add(new TreeNode("1, 2, null, 4"));
        assertEquals(answer, new CreateForestByDeletingValues(root, new int[]{3,5}).execute());

        root = new TreeNode("1, 1, 1, 1, 1, 1, 1");
        answer = new ArrayList<>();
        assertEquals(answer, new CreateForestByDeletingValues(root, new int[]{1}).execute());

        root = new TreeNode("1, 2, 3, 1, 1, null, 6, 2, 3, null, 8, 4, 5, 6, 8, 2, 5, 3");
        answer.add(new TreeNode("2, 6, 8"));
        answer.add(new TreeNode("3, 2, 5"));
        answer.add(new TreeNode("8, 3"));
        answer.add(new TreeNode(2));
        answer.add(new TreeNode("3, null, 6, 4, 5"));
        assertEquals(answer, new CreateForestByDeletingValues(root, new int[]{1}).execute());
    }

    @Test
    public void smallestSubtreeWithAllTheDeepestNodes() {
        assertEquals(new TreeNode(1), new SmallestSubtreeWithAllTheDeepestNodes(new TreeNode(1)).execute());
        assertEquals(new TreeNode(6), new SmallestSubtreeWithAllTheDeepestNodes(root).execute());
        root = new TreeNode("3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, 11, 9");
        assertEquals(root, new SmallestSubtreeWithAllTheDeepestNodes(root).execute());
        root = new TreeNode("3, 5, 1, 6, 2, 0, 8, null, null, 7, 4");
        assertEquals(new TreeNode("2, 7, 4"), new SmallestSubtreeWithAllTheDeepestNodes(root).execute());
    }

    @Test
    public void insufficientNodesInRootToLeafPaths() {
        assertNull(new InsufficientNodesInRootToLeafPaths(null, 11).execute());
        assertEquals(new TreeNode("5, null, 7, null, 8"),new InsufficientNodesInRootToLeafPaths(root1, 19).execute());
        root1 = new TreeNode("1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14");
        assertEquals(new TreeNode("1, 2, 3, 4, null, null, 7, 8, 9, null, 14"),new InsufficientNodesInRootToLeafPaths(root1, 1).execute());
        root1 = new TreeNode("5, 4, 8, 11, null, 17, 4, 7, 1, null, null, 5, 3");
        assertEquals(new TreeNode("5, 4, 8, 11, null, 17, 4, 7, null, null, null, 5"),new InsufficientNodesInRootToLeafPaths(root1, 22).execute());
        root1 = new TreeNode("1, 2, -3, -5, null, 4");
        assertEquals(new TreeNode("1, null, -3, 4"),new InsufficientNodesInRootToLeafPaths(root1, -1).execute());
    }

    @Test
    public void allPossibleFullBinaryTrees() {
        List<TreeNode> result = new ArrayList<>();
        assertEquals(result, new AllPossibleFullBinaryTrees().allPossibleFBT(20));
        result.add(new TreeNode());
        assertEquals(result, new AllPossibleFullBinaryTrees().allPossibleFBT(1));
        assertEquals("[0, 0, 0]", new AllPossibleFullBinaryTrees().allPossibleFBT(3).toString());
        assertEquals("[0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0]", new AllPossibleFullBinaryTrees().allPossibleFBT(5).toString());
        result = new ArrayList<>();
        result.add(new TreeNode("0, 0, 0, null, null, 0, 0, null, null, 0, 0"));
        result.add(new TreeNode("0, 0, 0, null, null, 0, 0, 0, 0"));
        result.add(new TreeNode("0, 0, 0, 0, 0, 0, 0"));
        result.add(new TreeNode("0, 0, 0, 0, 0, null, null, null, null, 0, 0"));
        result.add(new TreeNode("0, 0, 0, 0, 0, null, null, 0, 0"));
        assertEquals(result, new AllPossibleFullBinaryTrees().allPossibleFBT(7));
        assertEquals("[0, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, 0, 0, 0, null, null, 0, " +
                        "0, null, null, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, " +
                        "0, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, " +
                        "0, 0, 0, 0, 0, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, " +
                        "null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, " +
                        "0, 0, null, null, null, null, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, " +
                        "0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, null, " +
                        "null, null, null, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, null, null, 0, 0]",
                            new AllPossibleFullBinaryTrees().allPossibleFBT(9).toString());
    }

    @Test
    public void maxLevelSum() {
        assertEquals(0, new MaximumLevelSum(null).execute());
        assertEquals(1, new MaximumLevelSum(new TreeNode(-100, new TreeNode(-99), new TreeNode(-1))).execute());
        assertEquals(6, new MaximumLevelSum(root).execute());
        root = new TreeNode("989, null, 10250, 98693, -89388, null, null, null, -32127");
        assertEquals(2, new MaximumLevelSum(root).execute());
        root = new TreeNode("-100, -200, -300, -20, -5, -10");
        assertEquals(3, new MaximumLevelSum(root).execute());
    }

    @Test
    public void binaryTreeColoringGame() {
        assertTrue((Boolean) new BinaryTreeColoringGame(root,-2,15).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15");
        assertTrue((Boolean) new BinaryTreeColoringGame(root,3,15).execute());
        assertFalse((Boolean) new BinaryTreeColoringGame(new TreeNode(1),1,1).execute());
        assertFalse((Boolean) new BinaryTreeColoringGame(root,1,15).execute());
    }

    @Test
    public void binaryTreeRightSideView() {
        assertEquals("[0, 2, 4, 5, 7, 6]", new BinaryTreeRightSideView(root).execute().toString());
        assertEquals("[]", new BinaryTreeRightSideView(null).execute().toString());
        assertEquals("[1, 2]", new BinaryTreeRightSideView(new TreeNode(1, new TreeNode(2), null)).execute().toString());
        root = new TreeNode("1, 2, 3, 4, 5, null, null, 6, 7, 8, 9, 10, 11, null, null, 12, null, 13, null, 14, null, null, 15, null, 16, null, null, null, 17, 18, null, null, null, null, 19");
        assertEquals("[1, 3, 5, 9, 13, 16, 18, 19]", new BinaryTreeRightSideView(root).execute().toString());
    }

    @Test
    public void pseudoPalindromicPaths() {
        assertEquals(1, new PseudoPalindromicPaths(new TreeNode(1)).execute());
        assertEquals(0, new PseudoPalindromicPaths(new TreeNode(1, new TreeNode(2), new TreeNode(2))).execute());
        root = new TreeNode("1, 1, 1, 1, 1, 1, 1");
        assertEquals(4, new PseudoPalindromicPaths(root).execute());
        root = new TreeNode("2, 3, 1, 3, 1, null, 1");
        assertEquals(2, new PseudoPalindromicPaths(root).execute());
        root = new TreeNode("1, 1, 1, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1, null, null, 1, 1");
        assertEquals(1024, new PseudoPalindromicPaths(root).execute());
    }

    @Test
    public void allElementsFromListOfTrees() {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        nodes.add(root1);
        assertEquals("[-7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8]", AllElementsFromListOfTrees.getAllElements(nodes).toString());
        nodes = new ArrayList<>();
        nodes.add(new TreeNode(0));
        nodes.add(null);
        nodes.add(new TreeNode(-2, new TreeNode(-11), new TreeNode(-22)));
        assertEquals("[-22, -11, -2, 0]", AllElementsFromListOfTrees.getAllElements(nodes).toString());
        nodes = new ArrayList<>();
        nodes.add(null);
        assertEquals("[]", AllElementsFromListOfTrees.getAllElements(nodes).toString());
    }

    @Test
    public void maxNodeOfEachLevel() {
        assertEquals("[]", new MaxNodeOfEachLevel(null).execute().toString());
        assertEquals("[-2147483648]", new MaxNodeOfEachLevel(new TreeNode(-2147483648)).execute().toString());
        assertEquals("[0, 2, 4, 5, 7, 6]", new MaxNodeOfEachLevel(root).execute().toString());
        root = new TreeNode("2147483647, null, 1, 1, 2147483647, 1, null, 1");
        assertEquals("[2147483647, 1, 2147483647, 1]", new MaxNodeOfEachLevel(root).execute().toString());
    }

    @Test
    public void bstIterator() {
        BSTIterator bstIterator = new BSTIterator(root);
        assertTrue(bstIterator.hasNext());
        assertEquals(-7, bstIterator.next());
        assertEquals(-6, bstIterator.next());
        assertEquals(-5, bstIterator.next());
        assertEquals(-4, bstIterator.next());
        assertEquals(-3, bstIterator.next());
        assertEquals(-2, bstIterator.next());
        assertEquals(-1, bstIterator.next());
        assertEquals(0, bstIterator.next());
        assertEquals(1, bstIterator.next());
        assertEquals(2, bstIterator.next());
        assertEquals(3, bstIterator.next());
        assertEquals(4, bstIterator.next());
        assertEquals(5, bstIterator.next());
        assertEquals(6, bstIterator.next());
        assertEquals(7, bstIterator.next());
        assertFalse(bstIterator.hasNext());
        exceptionRule.expect(NoSuchElementException.class);
        exceptionRule.expectMessage("There are no nodes anymore");
        bstIterator.next();
    }
}