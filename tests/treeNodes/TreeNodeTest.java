package treeNodes;

import listNodes.ListNode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import treeNodes.binarySearchTree.*;

import java.util.*;

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

    @Test
    public void areTreesEqualAfterFlipping() {
        TreeNode root0 = new TreeNode("0, 2, -2, 4, 1, -4, -1, 3, 5, null, null, -3, -6, null, null, null, null, 7, null, null, null, -7, -5, null, 6");
        assertTrue((Boolean) new AreTreesEqualAfterFlipping(root, root0).execute());
        assertFalse((Boolean) new AreTreesEqualAfterFlipping(new TreeNode(0), null).execute());
        assertTrue((Boolean) new AreTreesEqualAfterFlipping(null, null).execute());
        assertFalse((Boolean) new AreTreesEqualAfterFlipping(new TreeNode("1, 2, 3, 4, 5"), new TreeNode("1, 2, 3, 4, 5, 6")).execute());
        assertTrue((Boolean) new AreTreesEqualAfterFlipping(new TreeNode(1), new TreeNode(1)).execute());
        assertFalse((Boolean) new AreTreesEqualAfterFlipping(new TreeNode("1, 2, 3, 4, 5, 6, 7"), new TreeNode("1, 3, 2, 4, 5, 6, 7")).execute());
    }
    @Test
    public void allPossibleBST() {
        List<TreeNode> result = new ArrayList<>();
        result.add(null);
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(0));
        result = new ArrayList<>();
        result.add(new TreeNode(1));
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(1));
        result = new ArrayList<>();
        result.add(new TreeNode(1, null, new TreeNode(2)));
        result.add(new TreeNode(2, new TreeNode(1), null));
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(2));
        result = new ArrayList<>();
        result.add(new TreeNode("1, null, 2, null, 3"));
        result.add(new TreeNode("1, null, 3, 2"));
        result.add(new TreeNode("2, 1, 3"));
        result.add(new TreeNode("3, 1, null, null, 2"));
        result.add(new TreeNode("3, 2, null, 1"));
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(3));
        result = new ArrayList<>();
        result.add(new TreeNode("1, null, 2, null, 3, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 4, 3"));
        result.add(new TreeNode("1, null, 3, 2, 4"));
        result.add(new TreeNode("1, null, 4, 2, null, null, 3"));
        result.add(new TreeNode("1, null, 4, 3, null, 2"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4"));
        result.add(new TreeNode("2, 1, 4, null, null, 3"));
        result.add(new TreeNode("3, 1, 4, null, 2"));
        result.add(new TreeNode("3, 2, 4, 1"));
        result.add(new TreeNode("4, 1, null, null, 2, null, 3"));
        result.add(new TreeNode("4, 1, null, null, 3, 2"));
        result.add(new TreeNode("4, 2, null, 1, 3"));
        result.add(new TreeNode("4, 3, null, 1, null, null, 2"));
        result.add(new TreeNode("4, 3, null, 2, null, 1"));
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(4));
        result = new ArrayList<>();
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 5, 4"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 5"));
        result.add(new TreeNode("1, null, 2, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 5, 4, null, 3"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 4, 2, 5, null, 3"));
        result.add(new TreeNode("1, null, 4, 3, 5, 2"));
        result.add(new TreeNode("1, null, 5, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("1, null, 5, 2, null, null, 4, 3"));
        result.add(new TreeNode("1, null, 5, 3, null, 2, 4"));
        result.add(new TreeNode("1, null, 5, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("1, null, 5, 4, null, 3, null, 2"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 5"));
        result.add(new TreeNode("2, 1, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("2, 1, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 5"));
        result.add(new TreeNode("3, 1, 5, null, 2, 4"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 5"));
        result.add(new TreeNode("3, 2, 5, 1, null, 4"));
        result.add(new TreeNode("4, 1, 5, null, 2, null, null, null, 3"));
        result.add(new TreeNode("4, 1, 5, null, 3, null, null, 2"));
        result.add(new TreeNode("4, 2, 5, 1, 3"));
        result.add(new TreeNode("4, 3, 5, 1, null, null, null, null, 2"));
        result.add(new TreeNode("4, 3, 5, 2, null, null, null, 1"));
        result.add(new TreeNode("5, 1, null, null, 2, null, 3, null, 4"));
        result.add(new TreeNode("5, 1, null, null, 2, null, 4, 3"));
        result.add(new TreeNode("5, 1, null, null, 3, 2, 4"));
        result.add(new TreeNode("5, 1, null, null, 4, 2, null, null, 3"));
        result.add(new TreeNode("5, 1, null, null, 4, 3, null, 2"));
        result.add(new TreeNode("5, 2, null, 1, 3, null, null, null, 4"));
        result.add(new TreeNode("5, 2, null, 1, 4, null, null, 3"));
        result.add(new TreeNode("5, 3, null, 1, 4, null, 2"));
        result.add(new TreeNode("5, 3, null, 2, 4, 1"));
        result.add(new TreeNode("5, 4, null, 1, null, null, 2, null, 3"));
        result.add(new TreeNode("5, 4, null, 1, null, null, 3, 2"));
        result.add(new TreeNode("5, 4, null, 2, null, 1, 3"));
        result.add(new TreeNode("5, 4, null, 3, null, 1, null, null, 2"));
        result.add(new TreeNode("5, 4, null, 3, null, 2, null, 1"));
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(5));
        result = new ArrayList<>();
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 8, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 7, 6, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 8, 7, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 6, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 6, 5, 8, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 7, 5, 8, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 7, 6, 8, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 8, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 8, 5, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 8, 6, null, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 8, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 4, null, 8, 7, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 5, 4, 6, null, null, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 5, 4, 6, null, null, null, 8, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 5, 4, 7, null, null, 6, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 5, 4, 8, null, null, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 5, 4, 8, null, null, 7, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 6, 4, 7, null, 5, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 6, 4, 8, null, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 6, 5, 7, 4, null, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 6, 5, 8, 4, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 7, 4, 8, null, 5, null, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 7, 4, 8, null, 6, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 7, 5, 8, 4, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 7, 6, 8, 4, null, null, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 7, 6, 8, 5, null, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 4, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 4, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 4, null, null, 6, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 4, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 4, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 5, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 5, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 6, null, 4, 7, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 6, null, 5, 7, 4"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 7, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 7, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 7, null, 5, null, 4, 6"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 7, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 3, null, 8, 7, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 5, null, null, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 5, null, null, null, 6, null, 8, 7"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 5, null, null, null, 7, 6, 8"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 5, null, null, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 5, null, null, null, 8, 7, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 6, null, null, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 6, null, null, 5, 8, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 7, null, null, 5, 8, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 7, null, null, 6, 8, 5"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 8, null, null, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 8, null, null, 5, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 8, null, null, 6, null, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 8, null, null, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 4, 3, 8, null, null, 7, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 5, 3, 6, null, 4, null, 7, null, null, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 5, 3, 6, null, 4, null, 8, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 5, 3, 7, null, 4, 6, 8"));
        result.add(new TreeNode("1, null, 2, null, 5, 3, 8, null, 4, 6, null, null, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 5, 3, 8, null, 4, 7, null, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 5, 4, 6, 3, null, null, 7, null, null, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 5, 4, 6, 3, null, null, 8, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 5, 4, 7, 3, null, 6, 8"));
        result.add(new TreeNode("1, null, 2, null, 5, 4, 8, 3, null, 6, null, null, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 5, 4, 8, 3, null, 7, null, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 6, 3, 7, null, 4, null, 8, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 6, 3, 8, null, 4, 7, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 6, 3, 7, null, 5, null, 8, 4"));
        result.add(new TreeNode("1, null, 2, null, 6, 3, 8, null, 5, 7, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 6, 4, 7, 3, 5, null, 8"));
        result.add(new TreeNode("1, null, 2, null, 6, 4, 8, 3, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 6, 5, 7, 3, null, null, 8, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 6, 5, 8, 3, null, 7, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 6, 5, 7, 4, null, null, 8, 3"));
        result.add(new TreeNode("1, null, 2, null, 6, 5, 8, 4, null, 7, null, 3"));
        result.add(new TreeNode("1, null, 2, null, 7, 3, 8, null, 4, null, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 7, 3, 8, null, 4, null, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 2, null, 7, 3, 8, null, 5, null, null, 4, 6"));
        result.add(new TreeNode("1, null, 2, null, 7, 3, 8, null, 6, null, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 7, 3, 8, null, 6, null, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 7, 4, 8, 3, 5, null, null, null, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 7, 4, 8, 3, 6, null, null, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 7, 5, 8, 3, 6, null, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 7, 5, 8, 4, 6, null, null, 3"));
        result.add(new TreeNode("1, null, 2, null, 7, 6, 8, 3, null, null, null, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 7, 6, 8, 3, null, null, null, null, 5, 4"));
        result.add(new TreeNode("1, null, 2, null, 7, 6, 8, 4, null, null, null, 3, 5"));
        result.add(new TreeNode("1, null, 2, null, 7, 6, 8, 5, null, null, null, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 7, 6, 8, 5, null, null, null, 4, null, 3"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 4, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 4, null, 5, null, 7, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 4, null, 6, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 4, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 4, null, 7, 6, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 5, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 5, 4, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 6, 4, 7, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 6, 5, 7, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 7, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 7, 4, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 7, 5, null, 4, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 7, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 3, null, null, 7, 6, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 4, null, 3, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 4, null, 3, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 4, null, 3, 6, null, null, 5, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 4, null, 3, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 4, null, 3, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 5, null, 3, 6, null, 4, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 5, null, 3, 7, null, 4, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 5, null, 4, 6, 3, null, null, 7"));
        result.add(new TreeNode("1, null, 2, null, 8, 5, null, 4, 7, 3, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 6, null, 3, 7, null, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 6, null, 3, 7, null, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 6, null, 4, 7, 3, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 6, null, 5, 7, 3, null, null, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 6, null, 5, 7, 4, null, null, null, 3"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 3, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 3, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 3, null, null, 5, 4, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 3, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 3, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 4, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 4, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 5, null, 3, 6, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 5, null, 4, 6, 3"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 6, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 6, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 6, null, 4, null, 3, 5"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 6, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 2, null, 8, 7, null, 6, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 5, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 5, null, 6, null, 8, 7"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 5, null, 7, 6, 8"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 5, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 5, null, 8, 7, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 6, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 6, 5, 8, null, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 7, 5, 8, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 7, 6, 8, 5"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 8, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 8, 5, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 8, 6, null, 5, 7"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 8, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 4, null, null, null, 8, 7, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 5, null, null, 4, 6, null, null, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 3, 2, 5, null, null, 4, 6, null, null, null, 8, 7"));
        result.add(new TreeNode("1, null, 3, 2, 5, null, null, 4, 7, null, null, 6, 8"));
        result.add(new TreeNode("1, null, 3, 2, 5, null, null, 4, 8, null, null, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 5, null, null, 4, 8, null, null, 7, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 6, null, null, 4, 7, null, 5, null, 8"));
        result.add(new TreeNode("1, null, 3, 2, 6, null, null, 4, 8, null, 5, 7"));
        result.add(new TreeNode("1, null, 3, 2, 6, null, null, 5, 7, 4, null, null, 8"));
        result.add(new TreeNode("1, null, 3, 2, 6, null, null, 5, 8, 4, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 7, null, null, 4, 8, null, 5, null, null, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 7, null, null, 4, 8, null, 6, null, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 7, null, null, 5, 8, 4, 6"));
        result.add(new TreeNode("1, null, 3, 2, 7, null, null, 6, 8, 4, null, null, null, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 7, null, null, 6, 8, 5, null, null, null, 4"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 4, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 4, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 4, null, null, 6, 5, 7"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 4, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 4, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 5, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 5, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 6, null, 4, 7, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 6, null, 5, 7, 4"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 7, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 7, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 7, null, 5, null, 4, 6"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 7, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 3, 2, 8, null, null, 7, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 4, 2, 5, null, 3, null, 6, null, null, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 4, 2, 5, null, 3, null, 6, null, null, null, 8, 7"));
        result.add(new TreeNode("1, null, 4, 2, 5, null, 3, null, 7, null, null, 6, 8"));
        result.add(new TreeNode("1, null, 4, 2, 5, null, 3, null, 8, null, null, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 4, 2, 5, null, 3, null, 8, null, null, 7, null, 6"));
        result.add(new TreeNode("1, null, 4, 2, 6, null, 3, 5, 7, null, null, null, null, null, 8"));
        result.add(new TreeNode("1, null, 4, 2, 6, null, 3, 5, 8, null, null, null, null, 7"));
        result.add(new TreeNode("1, null, 4, 2, 7, null, 3, 5, 8, null, null, null, 6"));
        result.add(new TreeNode("1, null, 4, 2, 7, null, 3, 6, 8, null, null, 5"));
        result.add(new TreeNode("1, null, 4, 2, 8, null, 3, 5, null, null, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 4, 2, 8, null, 3, 5, null, null, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 4, 2, 8, null, 3, 6, null, null, null, 5, 7"));
        result.add(new TreeNode("1, null, 4, 2, 8, null, 3, 7, null, null, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 4, 2, 8, null, 3, 7, null, null, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 4, 3, 5, 2, null, null, 6, null, null, null, 7, null, 8"));
        result.add(new TreeNode("1, null, 4, 3, 5, 2, null, null, 6, null, null, null, 8, 7"));
        result.add(new TreeNode("1, null, 4, 3, 5, 2, null, null, 7, null, null, 6, 8"));
        result.add(new TreeNode("1, null, 4, 3, 5, 2, null, null, 8, null, null, 6, null, null, 7"));
        result.add(new TreeNode("1, null, 4, 3, 5, 2, null, null, 8, null, null, 7, null, 6"));
        result.add(new TreeNode("1, null, 4, 3, 6, 2, null, 5, 7, null, null, null, null, null, 8"));
        result.add(new TreeNode("1, null, 4, 3, 6, 2, null, 5, 8, null, null, null, null, 7"));
        result.add(new TreeNode("1, null, 4, 3, 7, 2, null, 5, 8, null, null, null, 6"));
        result.add(new TreeNode("1, null, 4, 3, 7, 2, null, 6, 8, null, null, 5"));
        result.add(new TreeNode("1, null, 4, 3, 8, 2, null, 5, null, null, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 4, 3, 8, 2, null, 5, null, null, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 4, 3, 8, 2, null, 6, null, null, null, 5, 7"));
        result.add(new TreeNode("1, null, 4, 3, 8, 2, null, 7, null, null, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 4, 3, 8, 2, null, 7, null, null, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 5, 2, 6, null, 3, null, 7, null, 4, null, 8"));
        result.add(new TreeNode("1, null, 5, 2, 6, null, 3, null, 8, null, 4, 7"));
        result.add(new TreeNode("1, null, 5, 2, 7, null, 3, 6, 8, null, 4"));
        result.add(new TreeNode("1, null, 5, 2, 8, null, 3, 6, null, null, 4, null, 7"));
        result.add(new TreeNode("1, null, 5, 2, 8, null, 3, 7, null, null, 4, 6"));
        result.add(new TreeNode("1, null, 5, 2, 6, null, 4, null, 7, 3, null, null, 8"));
        result.add(new TreeNode("1, null, 5, 2, 6, null, 4, null, 8, 3, null, 7"));
        result.add(new TreeNode("1, null, 5, 2, 7, null, 4, 6, 8, 3"));
        result.add(new TreeNode("1, null, 5, 2, 8, null, 4, 6, null, 3, null, null, 7"));
        result.add(new TreeNode("1, null, 5, 2, 8, null, 4, 7, null, 3, null, 6"));
        result.add(new TreeNode("1, null, 5, 3, 6, 2, 4, null, 7, null, null, null, null, null, 8"));
        result.add(new TreeNode("1, null, 5, 3, 6, 2, 4, null, 8, null, null, null, null, 7"));
        result.add(new TreeNode("1, null, 5, 3, 7, 2, 4, 6, 8"));
        result.add(new TreeNode("1, null, 5, 3, 8, 2, 4, 6, null, null, null, null, null, null, 7"));
        result.add(new TreeNode("1, null, 5, 3, 8, 2, 4, 7, null, null, null, null, null, 6"));
        result.add(new TreeNode("1, null, 5, 4, 6, 2, null, null, 7, null, 3, null, 8"));
        result.add(new TreeNode("1, null, 5, 4, 6, 2, null, null, 8, null, 3, 7"));
        result.add(new TreeNode("1, null, 5, 4, 7, 2, null, 6, 8, null, 3"));
        result.add(new TreeNode("1, null, 5, 4, 8, 2, null, 6, null, null, 3, null, 7"));
        result.add(new TreeNode("1, null, 5, 4, 8, 2, null, 7, null, null, 3, 6"));
        result.add(new TreeNode("1, null, 5, 4, 6, 3, null, null, 7, 2, null, null, 8"));
        result.add(new TreeNode("1, null, 5, 4, 6, 3, null, null, 8, 2, null, 7"));
        result.add(new TreeNode("1, null, 5, 4, 7, 3, null, 6, 8, 2"));
        result.add(new TreeNode("1, null, 5, 4, 8, 3, null, 6, null, 2, null, null, 7"));
        result.add(new TreeNode("1, null, 5, 4, 8, 3, null, 7, null, 2, null, 6"));
        result.add(new TreeNode("1, null, 6, 2, 7, null, 3, null, 8, null, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 6, 2, 8, null, 3, 7, null, null, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 6, 2, 7, null, 3, null, 8, null, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 2, 8, null, 3, 7, null, null, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 2, 7, null, 4, null, 8, 3, 5"));
        result.add(new TreeNode("1, null, 6, 2, 8, null, 4, 7, null, 3, 5"));
        result.add(new TreeNode("1, null, 6, 2, 7, null, 5, null, 8, 3, null, null, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 2, 8, null, 5, 7, null, 3, null, null, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 2, 7, null, 5, null, 8, 4, null, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 2, 8, null, 5, 7, null, 4, null, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 3, 7, 2, 4, null, 8, null, null, null, 5"));
        result.add(new TreeNode("1, null, 6, 3, 8, 2, 4, 7, null, null, null, null, 5"));
        result.add(new TreeNode("1, null, 6, 3, 7, 2, 5, null, 8, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 3, 8, 2, 5, 7, null, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 4, 7, 2, 5, null, 8, null, 3"));
        result.add(new TreeNode("1, null, 6, 4, 8, 2, 5, 7, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 4, 7, 3, 5, null, 8, 2"));
        result.add(new TreeNode("1, null, 6, 4, 8, 3, 5, 7, null, 2"));
        result.add(new TreeNode("1, null, 6, 5, 7, 2, null, null, 8, null, 3, null, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 5, 8, 2, null, 7, null, null, 3, null, null, null, 4"));
        result.add(new TreeNode("1, null, 6, 5, 7, 2, null, null, 8, null, 4, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 5, 8, 2, null, 7, null, null, 4, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 5, 7, 3, null, null, 8, 2, 4"));
        result.add(new TreeNode("1, null, 6, 5, 8, 3, null, 7, null, 2, 4"));
        result.add(new TreeNode("1, null, 6, 5, 7, 4, null, null, 8, 2, null, null, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 5, 8, 4, null, 7, null, 2, null, null, null, null, 3"));
        result.add(new TreeNode("1, null, 6, 5, 7, 4, null, null, 8, 3, null, null, null, 2"));
        result.add(new TreeNode("1, null, 6, 5, 8, 4, null, 7, null, 3, null, null, null, 2"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 3, null, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 3, null, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 3, null, null, null, 5, 4, 6"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 3, null, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 3, null, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 4, null, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 4, null, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 5, null, null, 3, 6, null, 4"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 5, null, null, 4, 6, 3"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 6, null, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 6, null, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 6, null, null, 4, null, 3, 5"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 6, null, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 7, 2, 8, null, 6, null, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("1, null, 7, 3, 8, 2, 4, null, null, null, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 7, 3, 8, 2, 4, null, null, null, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 7, 3, 8, 2, 5, null, null, null, null, 4, 6"));
        result.add(new TreeNode("1, null, 7, 3, 8, 2, 6, null, null, null, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 7, 3, 8, 2, 6, null, null, null, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 7, 4, 8, 2, 5, null, null, null, 3, null, 6"));
        result.add(new TreeNode("1, null, 7, 4, 8, 2, 6, null, null, null, 3, 5"));
        result.add(new TreeNode("1, null, 7, 4, 8, 3, 5, null, null, 2, null, null, 6"));
        result.add(new TreeNode("1, null, 7, 4, 8, 3, 6, null, null, 2, null, 5"));
        result.add(new TreeNode("1, null, 7, 5, 8, 2, 6, null, null, null, 3, null, null, null, 4"));
        result.add(new TreeNode("1, null, 7, 5, 8, 2, 6, null, null, null, 4, null, null, 3"));
        result.add(new TreeNode("1, null, 7, 5, 8, 3, 6, null, null, 2, 4"));
        result.add(new TreeNode("1, null, 7, 5, 8, 4, 6, null, null, 2, null, null, null, null, 3"));
        result.add(new TreeNode("1, null, 7, 5, 8, 4, 6, null, null, 3, null, null, null, 2"));
        result.add(new TreeNode("1, null, 7, 6, 8, 2, null, null, null, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 7, 6, 8, 2, null, null, null, null, 3, null, 5, 4"));
        result.add(new TreeNode("1, null, 7, 6, 8, 2, null, null, null, null, 4, 3, 5"));
        result.add(new TreeNode("1, null, 7, 6, 8, 2, null, null, null, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 7, 6, 8, 2, null, null, null, null, 5, 4, null, 3"));
        result.add(new TreeNode("1, null, 7, 6, 8, 3, null, null, null, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 7, 6, 8, 3, null, null, null, 2, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 7, 6, 8, 4, null, null, null, 2, 5, null, 3"));
        result.add(new TreeNode("1, null, 7, 6, 8, 4, null, null, null, 3, 5, 2"));
        result.add(new TreeNode("1, null, 7, 6, 8, 5, null, null, null, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("1, null, 7, 6, 8, 5, null, null, null, 2, null, null, 4, 3"));
        result.add(new TreeNode("1, null, 7, 6, 8, 5, null, null, null, 3, null, 2, 4"));
        result.add(new TreeNode("1, null, 7, 6, 8, 5, null, null, null, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("1, null, 7, 6, 8, 5, null, null, null, 4, null, 3, null, 2"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 4, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 4, null, 5, null, 7, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 4, null, 6, 5, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 4, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 4, null, 7, 6, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 5, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 5, 4, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 6, 4, 7, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 6, 5, 7, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 7, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 7, 4, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 7, 5, null, 4, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 7, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 3, null, 7, 6, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 4, 3, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 4, 3, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 4, 3, 6, null, null, 5, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 4, 3, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 4, 3, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 5, 3, 6, null, 4, null, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 5, 3, 7, null, 4, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 5, 4, 6, 3, null, null, 7"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 5, 4, 7, 3, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 6, 3, 7, null, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 6, 3, 7, null, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 6, 4, 7, 3, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 6, 5, 7, 3, null, null, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 6, 5, 7, 4, null, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 3, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 3, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 3, null, null, 5, 4, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 3, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 3, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 4, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 4, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 5, null, 3, 6, null, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 5, null, 4, 6, 3"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 6, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 6, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 6, null, 4, null, 3, 5"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 6, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 2, null, null, 7, 6, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 4, null, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 4, null, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 4, null, null, null, 6, 5, 7"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 4, null, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 4, null, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 5, null, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 5, null, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 6, null, null, 4, 7, null, 5"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 6, null, null, 5, 7, 4"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 7, null, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 7, null, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 7, null, null, 5, null, 4, 6"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 7, null, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 3, null, 2, 7, null, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 8, 4, null, 2, 5, null, 3, null, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 8, 4, null, 2, 5, null, 3, null, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 4, null, 2, 6, null, 3, 5, 7"));
        result.add(new TreeNode("1, null, 8, 4, null, 2, 7, null, 3, 5, null, null, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 4, null, 2, 7, null, 3, 6, null, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 4, null, 3, 5, 2, null, null, 6, null, null, null, 7"));
        result.add(new TreeNode("1, null, 8, 4, null, 3, 5, 2, null, null, 7, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 4, null, 3, 6, 2, null, 5, 7"));
        result.add(new TreeNode("1, null, 8, 4, null, 3, 7, 2, null, 5, null, null, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 4, null, 3, 7, 2, null, 6, null, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 5, null, 2, 6, null, 3, null, 7, null, 4"));
        result.add(new TreeNode("1, null, 8, 5, null, 2, 7, null, 3, 6, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 5, null, 2, 6, null, 4, null, 7, 3"));
        result.add(new TreeNode("1, null, 8, 5, null, 2, 7, null, 4, 6, null, 3"));
        result.add(new TreeNode("1, null, 8, 5, null, 3, 6, 2, 4, null, 7"));
        result.add(new TreeNode("1, null, 8, 5, null, 3, 7, 2, 4, 6"));
        result.add(new TreeNode("1, null, 8, 5, null, 4, 6, 2, null, null, 7, null, 3"));
        result.add(new TreeNode("1, null, 8, 5, null, 4, 7, 2, null, 6, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 5, null, 4, 6, 3, null, null, 7, 2"));
        result.add(new TreeNode("1, null, 8, 5, null, 4, 7, 3, null, 6, null, 2"));
        result.add(new TreeNode("1, null, 8, 6, null, 2, 7, null, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 8, 6, null, 2, 7, null, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("1, null, 8, 6, null, 2, 7, null, 4, null, null, 3, 5"));
        result.add(new TreeNode("1, null, 8, 6, null, 2, 7, null, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 6, null, 2, 7, null, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("1, null, 8, 6, null, 3, 7, 2, 4, null, null, null, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 6, null, 3, 7, 2, 5, null, null, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 6, null, 4, 7, 2, 5, null, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 6, null, 4, 7, 3, 5, null, null, 2"));
        result.add(new TreeNode("1, null, 8, 6, null, 5, 7, 2, null, null, null, null, 3, null, 4"));
        result.add(new TreeNode("1, null, 8, 6, null, 5, 7, 2, null, null, null, null, 4, 3"));
        result.add(new TreeNode("1, null, 8, 6, null, 5, 7, 3, null, null, null, 2, 4"));
        result.add(new TreeNode("1, null, 8, 6, null, 5, 7, 4, null, null, null, 2, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 6, null, 5, 7, 4, null, null, null, 3, null, 2"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 3, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 3, null, 4, null, 6, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 3, null, 5, 4, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 3, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 3, null, 6, 5, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 4, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 4, 3, 6, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 5, 3, 6, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 5, 4, 6, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 6, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 6, 3, null, null, 5, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 6, 4, null, 3, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 6, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 2, null, null, 6, 5, null, 4, null, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 3, null, 2, 4, null, null, null, 5, null, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 3, null, 2, 4, null, null, null, 6, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 3, null, 2, 5, null, null, 4, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 3, null, 2, 6, null, null, 4, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 3, null, 2, 6, null, null, 5, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 4, null, 2, 5, null, 3, null, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 4, null, 2, 6, null, 3, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 4, null, 3, 5, 2, null, null, 6"));
        result.add(new TreeNode("1, null, 8, 7, null, 4, null, 3, 6, 2, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 5, null, 2, 6, null, 3, null, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 5, null, 2, 6, null, 4, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 5, null, 3, 6, 2, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 5, null, 4, 6, 2, null, null, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 5, null, 4, 6, 3, null, null, null, 2"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 2, null, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 2, null, null, 3, null, 5, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 2, null, null, 4, 3, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 2, null, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 2, null, null, 5, 4, null, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 3, null, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 3, null, 2, 5, null, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 4, null, 2, 5, null, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 4, null, 3, 5, 2"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 5, null, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 5, null, 2, null, null, 4, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 5, null, 3, null, 2, 4"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 5, null, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("1, null, 8, 7, null, 6, null, 5, null, 4, null, 3, null, 2"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 5, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 5, null, 6, null, 8, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 5, null, 7, 6, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 5, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 5, null, 8, 7, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 6, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 6, 5, 8, null, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 7, 5, 8, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 7, 6, 8, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 8, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 8, 5, null, null, 7, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 8, 6, null, 5, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 8, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 4, null, 8, 7, null, 6, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 5, 4, 6, null, null, null, 7, null, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 5, 4, 6, null, null, null, 8, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 5, 4, 7, null, null, 6, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 5, 4, 8, null, null, 6, null, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 5, 4, 8, null, null, 7, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 6, 4, 7, null, 5, null, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 6, 4, 8, null, 5, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 6, 5, 7, 4, null, null, 8"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 6, 5, 8, 4, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 7, 4, 8, null, 5, null, null, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 7, 4, 8, null, 6, null, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 7, 5, 8, 4, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 7, 6, 8, 4, null, null, null, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 7, 6, 8, 5, null, null, null, 4"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 4, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 4, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 4, null, null, 6, 5, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 4, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 4, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 5, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 5, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 6, null, 4, 7, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 6, null, 5, 7, 4"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 7, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 7, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 7, null, 5, null, 4, 6"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 7, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("2, 1, 3, null, null, null, 8, 7, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 5, null, null, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 5, null, null, null, 6, null, 8, 7"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 5, null, null, null, 7, 6, 8"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 5, null, null, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 5, null, null, null, 8, 7, null, 6"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 6, null, null, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 6, null, null, 5, 8, null, null, 7"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 7, null, null, 5, 8, null, 6"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 7, null, null, 6, 8, 5"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 8, null, null, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 8, null, null, 5, null, null, 7, 6"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 8, null, null, 6, null, 5, 7"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 8, null, null, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("2, 1, 4, null, null, 3, 8, null, null, 7, null, 6, null, 5"));
        result.add(new TreeNode("2, 1, 5, null, null, 3, 6, null, 4, null, 7, null, null, null, 8"));
        result.add(new TreeNode("2, 1, 5, null, null, 3, 6, null, 4, null, 8, null, null, 7"));
        result.add(new TreeNode("2, 1, 5, null, null, 3, 7, null, 4, 6, 8"));
        result.add(new TreeNode("2, 1, 5, null, null, 3, 8, null, 4, 6, null, null, null, null, 7"));
        result.add(new TreeNode("2, 1, 5, null, null, 3, 8, null, 4, 7, null, null, null, 6"));
        result.add(new TreeNode("2, 1, 5, null, null, 4, 6, 3, null, null, 7, null, null, null, 8"));
        result.add(new TreeNode("2, 1, 5, null, null, 4, 6, 3, null, null, 8, null, null, 7"));
        result.add(new TreeNode("2, 1, 5, null, null, 4, 7, 3, null, 6, 8"));
        result.add(new TreeNode("2, 1, 5, null, null, 4, 8, 3, null, 6, null, null, null, null, 7"));
        result.add(new TreeNode("2, 1, 5, null, null, 4, 8, 3, null, 7, null, null, null, 6"));
        result.add(new TreeNode("2, 1, 6, null, null, 3, 7, null, 4, null, 8, null, 5"));
        result.add(new TreeNode("2, 1, 6, null, null, 3, 8, null, 4, 7, null, null, 5"));
        result.add(new TreeNode("2, 1, 6, null, null, 3, 7, null, 5, null, 8, 4"));
        result.add(new TreeNode("2, 1, 6, null, null, 3, 8, null, 5, 7, null, 4"));
        result.add(new TreeNode("2, 1, 6, null, null, 4, 7, 3, 5, null, 8"));
        result.add(new TreeNode("2, 1, 6, null, null, 4, 8, 3, 5, 7"));
        result.add(new TreeNode("2, 1, 6, null, null, 5, 7, 3, null, null, 8, null, 4"));
        result.add(new TreeNode("2, 1, 6, null, null, 5, 8, 3, null, 7, null, null, 4"));
        result.add(new TreeNode("2, 1, 6, null, null, 5, 7, 4, null, null, 8, 3"));
        result.add(new TreeNode("2, 1, 6, null, null, 5, 8, 4, null, 7, null, 3"));
        result.add(new TreeNode("2, 1, 7, null, null, 3, 8, null, 4, null, null, null, 5, null, 6"));
        result.add(new TreeNode("2, 1, 7, null, null, 3, 8, null, 4, null, null, null, 6, 5"));
        result.add(new TreeNode("2, 1, 7, null, null, 3, 8, null, 5, null, null, 4, 6"));
        result.add(new TreeNode("2, 1, 7, null, null, 3, 8, null, 6, null, null, 4, null, null, 5"));
        result.add(new TreeNode("2, 1, 7, null, null, 3, 8, null, 6, null, null, 5, null, 4"));
        result.add(new TreeNode("2, 1, 7, null, null, 4, 8, 3, 5, null, null, null, null, null, 6"));
        result.add(new TreeNode("2, 1, 7, null, null, 4, 8, 3, 6, null, null, null, null, 5"));
        result.add(new TreeNode("2, 1, 7, null, null, 5, 8, 3, 6, null, null, null, 4"));
        result.add(new TreeNode("2, 1, 7, null, null, 5, 8, 4, 6, null, null, 3"));
        result.add(new TreeNode("2, 1, 7, null, null, 6, 8, 3, null, null, null, null, 4, null, 5"));
        result.add(new TreeNode("2, 1, 7, null, null, 6, 8, 3, null, null, null, null, 5, 4"));
        result.add(new TreeNode("2, 1, 7, null, null, 6, 8, 4, null, null, null, 3, 5"));
        result.add(new TreeNode("2, 1, 7, null, null, 6, 8, 5, null, null, null, 3, null, null, 4"));
        result.add(new TreeNode("2, 1, 7, null, null, 6, 8, 5, null, null, null, 4, null, 3"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 4, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 4, null, 5, null, 7, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 4, null, 6, 5, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 4, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 4, null, 7, 6, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 5, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 5, 4, 7, null, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 6, 4, 7, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 6, 5, 7, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 7, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 7, 4, null, null, 6, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 7, 5, null, 4, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 7, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 3, null, null, 7, 6, null, 5, null, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 4, null, 3, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 4, null, 3, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 4, null, 3, 6, null, null, 5, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 4, null, 3, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 4, null, 3, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 5, null, 3, 6, null, 4, null, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 5, null, 3, 7, null, 4, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 5, null, 4, 6, 3, null, null, 7"));
        result.add(new TreeNode("2, 1, 8, null, null, 5, null, 4, 7, 3, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 6, null, 3, 7, null, 4, null, null, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 6, null, 3, 7, null, 5, null, null, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 6, null, 4, 7, 3, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 6, null, 5, 7, 3, null, null, null, null, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 6, null, 5, 7, 4, null, null, null, 3"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 3, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 3, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 3, null, null, 5, 4, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 3, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 3, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 4, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 4, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 5, null, 3, 6, null, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 5, null, 4, 6, 3"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 6, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 6, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 6, null, 4, null, 3, 5"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 6, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("2, 1, 8, null, null, 7, null, 6, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 5, null, null, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 5, null, null, null, 6, null, 8, 7"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 5, null, null, null, 7, 6, 8"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 5, null, null, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 5, null, null, null, 8, 7, null, 6"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 6, null, null, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 6, null, null, 5, 8, null, null, 7"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 7, null, null, 5, 8, null, 6"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 7, null, null, 6, 8, 5"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 8, null, null, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 8, null, null, 5, null, null, 7, 6"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 8, null, null, 6, null, 5, 7"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 8, null, null, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("3, 1, 4, null, 2, null, 8, null, null, 7, null, 6, null, 5"));
        result.add(new TreeNode("3, 1, 5, null, 2, 4, 6, null, null, null, null, null, 7, null, 8"));
        result.add(new TreeNode("3, 1, 5, null, 2, 4, 6, null, null, null, null, null, 8, 7"));
        result.add(new TreeNode("3, 1, 5, null, 2, 4, 7, null, null, null, null, 6, 8"));
        result.add(new TreeNode("3, 1, 5, null, 2, 4, 8, null, null, null, null, 6, null, null, 7"));
        result.add(new TreeNode("3, 1, 5, null, 2, 4, 8, null, null, null, null, 7, null, 6"));
        result.add(new TreeNode("3, 1, 6, null, 2, 4, 7, null, null, null, 5, null, 8"));
        result.add(new TreeNode("3, 1, 6, null, 2, 4, 8, null, null, null, 5, 7"));
        result.add(new TreeNode("3, 1, 6, null, 2, 5, 7, null, null, 4, null, null, 8"));
        result.add(new TreeNode("3, 1, 6, null, 2, 5, 8, null, null, 4, null, 7"));
        result.add(new TreeNode("3, 1, 7, null, 2, 4, 8, null, null, null, 5, null, null, null, 6"));
        result.add(new TreeNode("3, 1, 7, null, 2, 4, 8, null, null, null, 6, null, null, 5"));
        result.add(new TreeNode("3, 1, 7, null, 2, 5, 8, null, null, 4, 6"));
        result.add(new TreeNode("3, 1, 7, null, 2, 6, 8, null, null, 4, null, null, null, null, 5"));
        result.add(new TreeNode("3, 1, 7, null, 2, 6, 8, null, null, 5, null, null, null, 4"));
        result.add(new TreeNode("3, 1, 8, null, 2, 4, null, null, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("3, 1, 8, null, 2, 4, null, null, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("3, 1, 8, null, 2, 4, null, null, null, null, 6, 5, 7"));
        result.add(new TreeNode("3, 1, 8, null, 2, 4, null, null, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("3, 1, 8, null, 2, 4, null, null, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("3, 1, 8, null, 2, 5, null, null, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("3, 1, 8, null, 2, 5, null, null, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("3, 1, 8, null, 2, 6, null, null, null, 4, 7, null, 5"));
        result.add(new TreeNode("3, 1, 8, null, 2, 6, null, null, null, 5, 7, 4"));
        result.add(new TreeNode("3, 1, 8, null, 2, 7, null, null, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("3, 1, 8, null, 2, 7, null, null, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("3, 1, 8, null, 2, 7, null, null, null, 5, null, 4, 6"));
        result.add(new TreeNode("3, 1, 8, null, 2, 7, null, null, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("3, 1, 8, null, 2, 7, null, null, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 5, null, null, null, 6, null, 7, null, 8"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 5, null, null, null, 6, null, 8, 7"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 5, null, null, null, 7, 6, 8"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 5, null, null, null, 8, 6, null, null, 7"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 5, null, null, null, 8, 7, null, 6"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 6, null, null, 5, 7, null, null, null, 8"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 6, null, null, 5, 8, null, null, 7"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 7, null, null, 5, 8, null, 6"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 7, null, null, 6, 8, 5"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 8, null, null, 5, null, null, 6, null, 7"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 8, null, null, 5, null, null, 7, 6"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 8, null, null, 6, null, 5, 7"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 8, null, null, 7, null, 5, null, null, 6"));
        result.add(new TreeNode("3, 2, 4, 1, null, null, 8, null, null, 7, null, 6, null, 5"));
        result.add(new TreeNode("3, 2, 5, 1, null, 4, 6, null, null, null, null, null, 7, null, 8"));
        result.add(new TreeNode("3, 2, 5, 1, null, 4, 6, null, null, null, null, null, 8, 7"));
        result.add(new TreeNode("3, 2, 5, 1, null, 4, 7, null, null, null, null, 6, 8"));
        result.add(new TreeNode("3, 2, 5, 1, null, 4, 8, null, null, null, null, 6, null, null, 7"));
        result.add(new TreeNode("3, 2, 5, 1, null, 4, 8, null, null, null, null, 7, null, 6"));
        result.add(new TreeNode("3, 2, 6, 1, null, 4, 7, null, null, null, 5, null, 8"));
        result.add(new TreeNode("3, 2, 6, 1, null, 4, 8, null, null, null, 5, 7"));
        result.add(new TreeNode("3, 2, 6, 1, null, 5, 7, null, null, 4, null, null, 8"));
        result.add(new TreeNode("3, 2, 6, 1, null, 5, 8, null, null, 4, null, 7"));
        result.add(new TreeNode("3, 2, 7, 1, null, 4, 8, null, null, null, 5, null, null, null, 6"));
        result.add(new TreeNode("3, 2, 7, 1, null, 4, 8, null, null, null, 6, null, null, 5"));
        result.add(new TreeNode("3, 2, 7, 1, null, 5, 8, null, null, 4, 6"));
        result.add(new TreeNode("3, 2, 7, 1, null, 6, 8, null, null, 4, null, null, null, null, 5"));
        result.add(new TreeNode("3, 2, 7, 1, null, 6, 8, null, null, 5, null, null, null, 4"));
        result.add(new TreeNode("3, 2, 8, 1, null, 4, null, null, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("3, 2, 8, 1, null, 4, null, null, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("3, 2, 8, 1, null, 4, null, null, null, null, 6, 5, 7"));
        result.add(new TreeNode("3, 2, 8, 1, null, 4, null, null, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("3, 2, 8, 1, null, 4, null, null, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("3, 2, 8, 1, null, 5, null, null, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("3, 2, 8, 1, null, 5, null, null, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("3, 2, 8, 1, null, 6, null, null, null, 4, 7, null, 5"));
        result.add(new TreeNode("3, 2, 8, 1, null, 6, null, null, null, 5, 7, 4"));
        result.add(new TreeNode("3, 2, 8, 1, null, 7, null, null, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("3, 2, 8, 1, null, 7, null, null, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("3, 2, 8, 1, null, 7, null, null, null, 5, null, 4, 6"));
        result.add(new TreeNode("3, 2, 8, 1, null, 7, null, null, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("3, 2, 8, 1, null, 7, null, null, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("4, 1, 5, null, 2, null, 6, null, 3, null, 7, null, null, null, 8"));
        result.add(new TreeNode("4, 1, 5, null, 2, null, 6, null, 3, null, 8, null, null, 7"));
        result.add(new TreeNode("4, 1, 5, null, 2, null, 7, null, 3, 6, 8"));
        result.add(new TreeNode("4, 1, 5, null, 2, null, 8, null, 3, 6, null, null, null, null, 7"));
        result.add(new TreeNode("4, 1, 5, null, 2, null, 8, null, 3, 7, null, null, null, 6"));
        result.add(new TreeNode("4, 1, 6, null, 2, 5, 7, null, 3, null, null, null, 8"));
        result.add(new TreeNode("4, 1, 6, null, 2, 5, 8, null, 3, null, null, 7"));
        result.add(new TreeNode("4, 1, 7, null, 2, 5, 8, null, 3, null, 6"));
        result.add(new TreeNode("4, 1, 7, null, 2, 6, 8, null, 3, 5"));
        result.add(new TreeNode("4, 1, 8, null, 2, 5, null, null, 3, null, 6, null, null, null, 7"));
        result.add(new TreeNode("4, 1, 8, null, 2, 5, null, null, 3, null, 7, null, null, 6"));
        result.add(new TreeNode("4, 1, 8, null, 2, 6, null, null, 3, 5, 7"));
        result.add(new TreeNode("4, 1, 8, null, 2, 7, null, null, 3, 5, null, null, null, null, 6"));
        result.add(new TreeNode("4, 1, 8, null, 2, 7, null, null, 3, 6, null, null, null, 5"));
        result.add(new TreeNode("4, 1, 5, null, 3, null, 6, 2, null, null, 7, null, null, null, 8"));
        result.add(new TreeNode("4, 1, 5, null, 3, null, 6, 2, null, null, 8, null, null, 7"));
        result.add(new TreeNode("4, 1, 5, null, 3, null, 7, 2, null, 6, 8"));
        result.add(new TreeNode("4, 1, 5, null, 3, null, 8, 2, null, 6, null, null, null, null, 7"));
        result.add(new TreeNode("4, 1, 5, null, 3, null, 8, 2, null, 7, null, null, null, 6"));
        result.add(new TreeNode("4, 1, 6, null, 3, 5, 7, 2, null, null, null, null, 8"));
        result.add(new TreeNode("4, 1, 6, null, 3, 5, 8, 2, null, null, null, 7"));
        result.add(new TreeNode("4, 1, 7, null, 3, 5, 8, 2, null, null, 6"));
        result.add(new TreeNode("4, 1, 7, null, 3, 6, 8, 2, null, 5"));
        result.add(new TreeNode("4, 1, 8, null, 3, 5, null, 2, null, null, 6, null, null, null, 7"));
        result.add(new TreeNode("4, 1, 8, null, 3, 5, null, 2, null, null, 7, null, null, 6"));
        result.add(new TreeNode("4, 1, 8, null, 3, 6, null, 2, null, 5, 7"));
        result.add(new TreeNode("4, 1, 8, null, 3, 7, null, 2, null, 5, null, null, null, null, 6"));
        result.add(new TreeNode("4, 1, 8, null, 3, 7, null, 2, null, 6, null, null, null, 5"));
        result.add(new TreeNode("4, 2, 5, 1, 3, null, 6, null, null, null, null, null, 7, null, 8"));
        result.add(new TreeNode("4, 2, 5, 1, 3, null, 6, null, null, null, null, null, 8, 7"));
        result.add(new TreeNode("4, 2, 5, 1, 3, null, 7, null, null, null, null, 6, 8"));
        result.add(new TreeNode("4, 2, 5, 1, 3, null, 8, null, null, null, null, 6, null, null, 7"));
        result.add(new TreeNode("4, 2, 5, 1, 3, null, 8, null, null, null, null, 7, null, 6"));
        result.add(new TreeNode("4, 2, 6, 1, 3, 5, 7, null, null, null, null, null, null, null, 8"));
        result.add(new TreeNode("4, 2, 6, 1, 3, 5, 8, null, null, null, null, null, null, 7"));
        result.add(new TreeNode("4, 2, 7, 1, 3, 5, 8, null, null, null, null, null, 6"));
        result.add(new TreeNode("4, 2, 7, 1, 3, 6, 8, null, null, null, null, 5"));
        result.add(new TreeNode("4, 2, 8, 1, 3, 5, null, null, null, null, null, null, 6, null, 7"));
        result.add(new TreeNode("4, 2, 8, 1, 3, 5, null, null, null, null, null, null, 7, 6"));
        result.add(new TreeNode("4, 2, 8, 1, 3, 6, null, null, null, null, null, 5, 7"));
        result.add(new TreeNode("4, 2, 8, 1, 3, 7, null, null, null, null, null, 5, null, null, 6"));
        result.add(new TreeNode("4, 2, 8, 1, 3, 7, null, null, null, null, null, 6, null, 5"));
        result.add(new TreeNode("4, 3, 5, 1, null, null, 6, null, 2, null, 7, null, null, null, 8"));
        result.add(new TreeNode("4, 3, 5, 1, null, null, 6, null, 2, null, 8, null, null, 7"));
        result.add(new TreeNode("4, 3, 5, 1, null, null, 7, null, 2, 6, 8"));
        result.add(new TreeNode("4, 3, 5, 1, null, null, 8, null, 2, 6, null, null, null, null, 7"));
        result.add(new TreeNode("4, 3, 5, 1, null, null, 8, null, 2, 7, null, null, null, 6"));
        result.add(new TreeNode("4, 3, 6, 1, null, 5, 7, null, 2, null, null, null, 8"));
        result.add(new TreeNode("4, 3, 6, 1, null, 5, 8, null, 2, null, null, 7"));
        result.add(new TreeNode("4, 3, 7, 1, null, 5, 8, null, 2, null, 6"));
        result.add(new TreeNode("4, 3, 7, 1, null, 6, 8, null, 2, 5"));
        result.add(new TreeNode("4, 3, 8, 1, null, 5, null, null, 2, null, 6, null, null, null, 7"));
        result.add(new TreeNode("4, 3, 8, 1, null, 5, null, null, 2, null, 7, null, null, 6"));
        result.add(new TreeNode("4, 3, 8, 1, null, 6, null, null, 2, 5, 7"));
        result.add(new TreeNode("4, 3, 8, 1, null, 7, null, null, 2, 5, null, null, null, null, 6"));
        result.add(new TreeNode("4, 3, 8, 1, null, 7, null, null, 2, 6, null, null, null, 5"));
        result.add(new TreeNode("4, 3, 5, 2, null, null, 6, 1, null, null, 7, null, null, null, 8"));
        result.add(new TreeNode("4, 3, 5, 2, null, null, 6, 1, null, null, 8, null, null, 7"));
        result.add(new TreeNode("4, 3, 5, 2, null, null, 7, 1, null, 6, 8"));
        result.add(new TreeNode("4, 3, 5, 2, null, null, 8, 1, null, 6, null, null, null, null, 7"));
        result.add(new TreeNode("4, 3, 5, 2, null, null, 8, 1, null, 7, null, null, null, 6"));
        result.add(new TreeNode("4, 3, 6, 2, null, 5, 7, 1, null, null, null, null, 8"));
        result.add(new TreeNode("4, 3, 6, 2, null, 5, 8, 1, null, null, null, 7"));
        result.add(new TreeNode("4, 3, 7, 2, null, 5, 8, 1, null, null, 6"));
        result.add(new TreeNode("4, 3, 7, 2, null, 6, 8, 1, null, 5"));
        result.add(new TreeNode("4, 3, 8, 2, null, 5, null, 1, null, null, 6, null, null, null, 7"));
        result.add(new TreeNode("4, 3, 8, 2, null, 5, null, 1, null, null, 7, null, null, 6"));
        result.add(new TreeNode("4, 3, 8, 2, null, 6, null, 1, null, 5, 7"));
        result.add(new TreeNode("4, 3, 8, 2, null, 7, null, 1, null, 5, null, null, null, null, 6"));
        result.add(new TreeNode("4, 3, 8, 2, null, 7, null, 1, null, 6, null, null, null, 5"));
        result.add(new TreeNode("5, 1, 6, null, 2, null, 7, null, 3, null, 8, null, 4"));
        result.add(new TreeNode("5, 1, 6, null, 2, null, 8, null, 3, 7, null, null, 4"));
        result.add(new TreeNode("5, 1, 7, null, 2, 6, 8, null, 3, null, null, null, null, null, 4"));
        result.add(new TreeNode("5, 1, 8, null, 2, 6, null, null, 3, null, 7, null, 4"));
        result.add(new TreeNode("5, 1, 8, null, 2, 7, null, null, 3, 6, null, null, 4"));
        result.add(new TreeNode("5, 1, 6, null, 2, null, 7, null, 4, null, 8, 3"));
        result.add(new TreeNode("5, 1, 6, null, 2, null, 8, null, 4, 7, null, 3"));
        result.add(new TreeNode("5, 1, 7, null, 2, 6, 8, null, 4, null, null, null, null, 3"));
        result.add(new TreeNode("5, 1, 8, null, 2, 6, null, null, 4, null, 7, 3"));
        result.add(new TreeNode("5, 1, 8, null, 2, 7, null, null, 4, 6, null, 3"));
        result.add(new TreeNode("5, 1, 6, null, 3, null, 7, 2, 4, null, 8"));
        result.add(new TreeNode("5, 1, 6, null, 3, null, 8, 2, 4, 7"));
        result.add(new TreeNode("5, 1, 7, null, 3, 6, 8, 2, 4"));
        result.add(new TreeNode("5, 1, 8, null, 3, 6, null, 2, 4, null, 7"));
        result.add(new TreeNode("5, 1, 8, null, 3, 7, null, 2, 4, 6"));
        result.add(new TreeNode("5, 1, 6, null, 4, null, 7, 2, null, null, 8, null, 3"));
        result.add(new TreeNode("5, 1, 6, null, 4, null, 8, 2, null, 7, null, null, 3"));
        result.add(new TreeNode("5, 1, 7, null, 4, 6, 8, 2, null, null, null, null, null, null, 3"));
        result.add(new TreeNode("5, 1, 8, null, 4, 6, null, 2, null, null, 7, null, 3"));
        result.add(new TreeNode("5, 1, 8, null, 4, 7, null, 2, null, 6, null, null, 3"));
        result.add(new TreeNode("5, 1, 6, null, 4, null, 7, 3, null, null, 8, 2"));
        result.add(new TreeNode("5, 1, 6, null, 4, null, 8, 3, null, 7, null, 2"));
        result.add(new TreeNode("5, 1, 7, null, 4, 6, 8, 3, null, null, null, null, null, 2"));
        result.add(new TreeNode("5, 1, 8, null, 4, 6, null, 3, null, null, 7, 2"));
        result.add(new TreeNode("5, 1, 8, null, 4, 7, null, 3, null, 6, null, 2"));
        result.add(new TreeNode("5, 2, 6, 1, 3, null, 7, null, null, null, 4, null, 8"));
        result.add(new TreeNode("5, 2, 6, 1, 3, null, 8, null, null, null, 4, 7"));
        result.add(new TreeNode("5, 2, 7, 1, 3, 6, 8, null, null, null, 4"));
        result.add(new TreeNode("5, 2, 8, 1, 3, 6, null, null, null, null, 4, null, 7"));
        result.add(new TreeNode("5, 2, 8, 1, 3, 7, null, null, null, null, 4, 6"));
        result.add(new TreeNode("5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, 8"));
        result.add(new TreeNode("5, 2, 6, 1, 4, null, 8, null, null, 3, null, 7"));
        result.add(new TreeNode("5, 2, 7, 1, 4, 6, 8, null, null, 3"));
        result.add(new TreeNode("5, 2, 8, 1, 4, 6, null, null, null, 3, null, null, 7"));
        result.add(new TreeNode("5, 2, 8, 1, 4, 7, null, null, null, 3, null, 6"));
        result.add(new TreeNode("5, 3, 6, 1, 4, null, 7, null, 2, null, null, null, 8"));
        result.add(new TreeNode("5, 3, 6, 1, 4, null, 8, null, 2, null, null, 7"));
        result.add(new TreeNode("5, 3, 7, 1, 4, 6, 8, null, 2"));
        result.add(new TreeNode("5, 3, 8, 1, 4, 6, null, null, 2, null, null, null, 7"));
        result.add(new TreeNode("5, 3, 8, 1, 4, 7, null, null, 2, null, null, 6"));
        result.add(new TreeNode("5, 3, 6, 2, 4, null, 7, 1, null, null, null, null, 8"));
        result.add(new TreeNode("5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7"));
        result.add(new TreeNode("5, 3, 7, 2, 4, 6, 8, 1"));
        result.add(new TreeNode("5, 3, 8, 2, 4, 6, null, 1, null, null, null, null, 7"));
        result.add(new TreeNode("5, 3, 8, 2, 4, 7, null, 1, null, null, null, 6"));
        result.add(new TreeNode("5, 4, 6, 1, null, null, 7, null, 2, null, 8, null, 3"));
        result.add(new TreeNode("5, 4, 6, 1, null, null, 8, null, 2, 7, null, null, 3"));
        result.add(new TreeNode("5, 4, 7, 1, null, 6, 8, null, 2, null, null, null, null, null, 3"));
        result.add(new TreeNode("5, 4, 8, 1, null, 6, null, null, 2, null, 7, null, 3"));
        result.add(new TreeNode("5, 4, 8, 1, null, 7, null, null, 2, 6, null, null, 3"));
        result.add(new TreeNode("5, 4, 6, 1, null, null, 7, null, 3, null, 8, 2"));
        result.add(new TreeNode("5, 4, 6, 1, null, null, 8, null, 3, 7, null, 2"));
        result.add(new TreeNode("5, 4, 7, 1, null, 6, 8, null, 3, null, null, null, null, 2"));
        result.add(new TreeNode("5, 4, 8, 1, null, 6, null, null, 3, null, 7, 2"));
        result.add(new TreeNode("5, 4, 8, 1, null, 7, null, null, 3, 6, null, 2"));
        result.add(new TreeNode("5, 4, 6, 2, null, null, 7, 1, 3, null, 8"));
        result.add(new TreeNode("5, 4, 6, 2, null, null, 8, 1, 3, 7"));
        result.add(new TreeNode("5, 4, 7, 2, null, 6, 8, 1, 3"));
        result.add(new TreeNode("5, 4, 8, 2, null, 6, null, 1, 3, null, 7"));
        result.add(new TreeNode("5, 4, 8, 2, null, 7, null, 1, 3, 6"));
        result.add(new TreeNode("5, 4, 6, 3, null, null, 7, 1, null, null, 8, null, 2"));
        result.add(new TreeNode("5, 4, 6, 3, null, null, 8, 1, null, 7, null, null, 2"));
        result.add(new TreeNode("5, 4, 7, 3, null, 6, 8, 1, null, null, null, null, null, null, 2"));
        result.add(new TreeNode("5, 4, 8, 3, null, 6, null, 1, null, null, 7, null, 2"));
        result.add(new TreeNode("5, 4, 8, 3, null, 7, null, 1, null, 6, null, null, 2"));
        result.add(new TreeNode("5, 4, 6, 3, null, null, 7, 2, null, null, 8, 1"));
        result.add(new TreeNode("5, 4, 6, 3, null, null, 8, 2, null, 7, null, 1"));
        result.add(new TreeNode("5, 4, 7, 3, null, 6, 8, 2, null, null, null, null, null, 1"));
        result.add(new TreeNode("5, 4, 8, 3, null, 6, null, 2, null, null, 7, 1"));
        result.add(new TreeNode("5, 4, 8, 3, null, 7, null, 2, null, 6, null, 1"));
        result.add(new TreeNode("6, 1, 7, null, 2, null, 8, null, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("6, 1, 8, null, 2, 7, null, null, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("6, 1, 7, null, 2, null, 8, null, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("6, 1, 8, null, 2, 7, null, null, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("6, 1, 7, null, 2, null, 8, null, 4, null, null, 3, 5"));
        result.add(new TreeNode("6, 1, 8, null, 2, 7, null, null, 4, null, null, 3, 5"));
        result.add(new TreeNode("6, 1, 7, null, 2, null, 8, null, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("6, 1, 8, null, 2, 7, null, null, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("6, 1, 7, null, 2, null, 8, null, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("6, 1, 8, null, 2, 7, null, null, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("6, 1, 7, null, 3, null, 8, 2, 4, null, null, null, null, null, 5"));
        result.add(new TreeNode("6, 1, 8, null, 3, 7, null, 2, 4, null, null, null, null, null, 5"));
        result.add(new TreeNode("6, 1, 7, null, 3, null, 8, 2, 5, null, null, null, null, 4"));
        result.add(new TreeNode("6, 1, 8, null, 3, 7, null, 2, 5, null, null, null, null, 4"));
        result.add(new TreeNode("6, 1, 7, null, 4, null, 8, 2, 5, null, null, null, 3"));
        result.add(new TreeNode("6, 1, 8, null, 4, 7, null, 2, 5, null, null, null, 3"));
        result.add(new TreeNode("6, 1, 7, null, 4, null, 8, 3, 5, null, null, 2"));
        result.add(new TreeNode("6, 1, 8, null, 4, 7, null, 3, 5, null, null, 2"));
        result.add(new TreeNode("6, 1, 7, null, 5, null, 8, 2, null, null, null, null, 3, null, 4"));
        result.add(new TreeNode("6, 1, 8, null, 5, 7, null, 2, null, null, null, null, 3, null, 4"));
        result.add(new TreeNode("6, 1, 7, null, 5, null, 8, 2, null, null, null, null, 4, 3"));
        result.add(new TreeNode("6, 1, 8, null, 5, 7, null, 2, null, null, null, null, 4, 3"));
        result.add(new TreeNode("6, 1, 7, null, 5, null, 8, 3, null, null, null, 2, 4"));
        result.add(new TreeNode("6, 1, 8, null, 5, 7, null, 3, null, null, null, 2, 4"));
        result.add(new TreeNode("6, 1, 7, null, 5, null, 8, 4, null, null, null, 2, null, null, 3"));
        result.add(new TreeNode("6, 1, 8, null, 5, 7, null, 4, null, null, null, 2, null, null, 3"));
        result.add(new TreeNode("6, 1, 7, null, 5, null, 8, 4, null, null, null, 3, null, 2"));
        result.add(new TreeNode("6, 1, 8, null, 5, 7, null, 4, null, null, null, 3, null, 2"));
        result.add(new TreeNode("6, 2, 7, 1, 3, null, 8, null, null, null, 4, null, null, null, 5"));
        result.add(new TreeNode("6, 2, 8, 1, 3, 7, null, null, null, null, 4, null, null, null, 5"));
        result.add(new TreeNode("6, 2, 7, 1, 3, null, 8, null, null, null, 5, null, null, 4"));
        result.add(new TreeNode("6, 2, 8, 1, 3, 7, null, null, null, null, 5, null, null, 4"));
        result.add(new TreeNode("6, 2, 7, 1, 4, null, 8, null, null, 3, 5"));
        result.add(new TreeNode("6, 2, 8, 1, 4, 7, null, null, null, 3, 5"));
        result.add(new TreeNode("6, 2, 7, 1, 5, null, 8, null, null, 3, null, null, null, null, 4"));
        result.add(new TreeNode("6, 2, 8, 1, 5, 7, null, null, null, 3, null, null, null, null, 4"));
        result.add(new TreeNode("6, 2, 7, 1, 5, null, 8, null, null, 4, null, null, null, 3"));
        result.add(new TreeNode("6, 2, 8, 1, 5, 7, null, null, null, 4, null, null, null, 3"));
        result.add(new TreeNode("6, 3, 7, 1, 4, null, 8, null, 2, null, 5"));
        result.add(new TreeNode("6, 3, 8, 1, 4, 7, null, null, 2, null, 5"));
        result.add(new TreeNode("6, 3, 7, 1, 5, null, 8, null, 2, 4"));
        result.add(new TreeNode("6, 3, 8, 1, 5, 7, null, null, 2, 4"));
        result.add(new TreeNode("6, 3, 7, 2, 4, null, 8, 1, null, null, 5"));
        result.add(new TreeNode("6, 3, 8, 2, 4, 7, null, 1, null, null, 5"));
        result.add(new TreeNode("6, 3, 7, 2, 5, null, 8, 1, null, 4"));
        result.add(new TreeNode("6, 3, 8, 2, 5, 7, null, 1, null, 4"));
        result.add(new TreeNode("6, 4, 7, 1, 5, null, 8, null, 2, null, null, null, null, null, 3"));
        result.add(new TreeNode("6, 4, 8, 1, 5, 7, null, null, 2, null, null, null, null, null, 3"));
        result.add(new TreeNode("6, 4, 7, 1, 5, null, 8, null, 3, null, null, null, null, 2"));
        result.add(new TreeNode("6, 4, 8, 1, 5, 7, null, null, 3, null, null, null, null, 2"));
        result.add(new TreeNode("6, 4, 7, 2, 5, null, 8, 1, 3"));
        result.add(new TreeNode("6, 4, 8, 2, 5, 7, null, 1, 3"));
        result.add(new TreeNode("6, 4, 7, 3, 5, null, 8, 1, null, null, null, null, null, null, 2"));
        result.add(new TreeNode("6, 4, 8, 3, 5, 7, null, 1, null, null, null, null, null, null, 2"));
        result.add(new TreeNode("6, 4, 7, 3, 5, null, 8, 2, null, null, null, null, null, 1"));
        result.add(new TreeNode("6, 4, 8, 3, 5, 7, null, 2, null, null, null, null, null, 1"));
        result.add(new TreeNode("6, 5, 7, 1, null, null, 8, null, 2, null, null, null, 3, null, 4"));
        result.add(new TreeNode("6, 5, 8, 1, null, 7, null, null, 2, null, null, null, 3, null, 4"));
        result.add(new TreeNode("6, 5, 7, 1, null, null, 8, null, 2, null, null, null, 4, 3"));
        result.add(new TreeNode("6, 5, 8, 1, null, 7, null, null, 2, null, null, null, 4, 3"));
        result.add(new TreeNode("6, 5, 7, 1, null, null, 8, null, 3, null, null, 2, 4"));
        result.add(new TreeNode("6, 5, 8, 1, null, 7, null, null, 3, null, null, 2, 4"));
        result.add(new TreeNode("6, 5, 7, 1, null, null, 8, null, 4, null, null, 2, null, null, 3"));
        result.add(new TreeNode("6, 5, 8, 1, null, 7, null, null, 4, null, null, 2, null, null, 3"));
        result.add(new TreeNode("6, 5, 7, 1, null, null, 8, null, 4, null, null, 3, null, 2"));
        result.add(new TreeNode("6, 5, 8, 1, null, 7, null, null, 4, null, null, 3, null, 2"));
        result.add(new TreeNode("6, 5, 7, 2, null, null, 8, 1, 3, null, null, null, null, null, 4"));
        result.add(new TreeNode("6, 5, 8, 2, null, 7, null, 1, 3, null, null, null, null, null, 4"));
        result.add(new TreeNode("6, 5, 7, 2, null, null, 8, 1, 4, null, null, null, null, 3"));
        result.add(new TreeNode("6, 5, 8, 2, null, 7, null, 1, 4, null, null, null, null, 3"));
        result.add(new TreeNode("6, 5, 7, 3, null, null, 8, 1, 4, null, null, null, 2"));
        result.add(new TreeNode("6, 5, 8, 3, null, 7, null, 1, 4, null, null, null, 2"));
        result.add(new TreeNode("6, 5, 7, 3, null, null, 8, 2, 4, null, null, 1"));
        result.add(new TreeNode("6, 5, 8, 3, null, 7, null, 2, 4, null, null, 1"));
        result.add(new TreeNode("6, 5, 7, 4, null, null, 8, 1, null, null, null, null, 2, null, 3"));
        result.add(new TreeNode("6, 5, 8, 4, null, 7, null, 1, null, null, null, null, 2, null, 3"));
        result.add(new TreeNode("6, 5, 7, 4, null, null, 8, 1, null, null, null, null, 3, 2"));
        result.add(new TreeNode("6, 5, 8, 4, null, 7, null, 1, null, null, null, null, 3, 2"));
        result.add(new TreeNode("6, 5, 7, 4, null, null, 8, 2, null, null, null, 1, 3"));
        result.add(new TreeNode("6, 5, 8, 4, null, 7, null, 2, null, null, null, 1, 3"));
        result.add(new TreeNode("6, 5, 7, 4, null, null, 8, 3, null, null, null, 1, null, null, 2"));
        result.add(new TreeNode("6, 5, 8, 4, null, 7, null, 3, null, null, null, 1, null, null, 2"));
        result.add(new TreeNode("6, 5, 7, 4, null, null, 8, 3, null, null, null, 2, null, 1"));
        result.add(new TreeNode("6, 5, 8, 4, null, 7, null, 3, null, null, null, 2, null, 1"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 3, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 3, null, 4, null, 6, 5"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 3, null, 5, 4, 6"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 3, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 3, null, 6, 5, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 4, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 4, 3, 6, null, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 5, 3, 6, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 5, 4, 6, 3"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 6, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 6, 3, null, null, 5, 4"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 6, 4, null, 3, 5"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 6, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 2, null, null, null, 6, 5, null, 4, null, 3"));
        result.add(new TreeNode("7, 1, 8, null, 3, null, null, 2, 4, null, null, null, 5, null, 6"));
        result.add(new TreeNode("7, 1, 8, null, 3, null, null, 2, 4, null, null, null, 6, 5"));
        result.add(new TreeNode("7, 1, 8, null, 3, null, null, 2, 5, null, null, 4, 6"));
        result.add(new TreeNode("7, 1, 8, null, 3, null, null, 2, 6, null, null, 4, null, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 3, null, null, 2, 6, null, null, 5, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 4, null, null, 2, 5, null, 3, null, 6"));
        result.add(new TreeNode("7, 1, 8, null, 4, null, null, 2, 6, null, 3, 5"));
        result.add(new TreeNode("7, 1, 8, null, 4, null, null, 3, 5, 2, null, null, 6"));
        result.add(new TreeNode("7, 1, 8, null, 4, null, null, 3, 6, 2, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 5, null, null, 2, 6, null, 3, null, null, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 5, null, null, 2, 6, null, 4, null, null, 3"));
        result.add(new TreeNode("7, 1, 8, null, 5, null, null, 3, 6, 2, 4"));
        result.add(new TreeNode("7, 1, 8, null, 5, null, null, 4, 6, 2, null, null, null, null, 3"));
        result.add(new TreeNode("7, 1, 8, null, 5, null, null, 4, 6, 3, null, null, null, 2"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 2, null, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 2, null, null, 3, null, 5, 4"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 2, null, null, 4, 3, 5"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 2, null, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 2, null, null, 5, 4, null, 3"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 3, null, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 3, null, 2, 5, null, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 4, null, 2, 5, null, 3"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 4, null, 3, 5, 2"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 5, null, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 5, null, 2, null, null, 4, 3"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 5, null, 3, null, 2, 4"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 5, null, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("7, 1, 8, null, 6, null, null, 5, null, 4, null, 3, null, 2"));
        result.add(new TreeNode("7, 2, 8, 1, 3, null, null, null, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("7, 2, 8, 1, 3, null, null, null, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("7, 2, 8, 1, 3, null, null, null, null, null, 5, 4, 6"));
        result.add(new TreeNode("7, 2, 8, 1, 3, null, null, null, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("7, 2, 8, 1, 3, null, null, null, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("7, 2, 8, 1, 4, null, null, null, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("7, 2, 8, 1, 4, null, null, null, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("7, 2, 8, 1, 5, null, null, null, null, 3, 6, null, 4"));
        result.add(new TreeNode("7, 2, 8, 1, 5, null, null, null, null, 4, 6, 3"));
        result.add(new TreeNode("7, 2, 8, 1, 6, null, null, null, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("7, 2, 8, 1, 6, null, null, null, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("7, 2, 8, 1, 6, null, null, null, null, 4, null, 3, 5"));
        result.add(new TreeNode("7, 2, 8, 1, 6, null, null, null, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("7, 2, 8, 1, 6, null, null, null, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("7, 3, 8, 1, 4, null, null, null, 2, null, 5, null, null, null, 6"));
        result.add(new TreeNode("7, 3, 8, 1, 4, null, null, null, 2, null, 6, null, null, 5"));
        result.add(new TreeNode("7, 3, 8, 1, 5, null, null, null, 2, 4, 6"));
        result.add(new TreeNode("7, 3, 8, 1, 6, null, null, null, 2, 4, null, null, null, null, 5"));
        result.add(new TreeNode("7, 3, 8, 1, 6, null, null, null, 2, 5, null, null, null, 4"));
        result.add(new TreeNode("7, 3, 8, 2, 4, null, null, 1, null, null, 5, null, null, null, 6"));
        result.add(new TreeNode("7, 3, 8, 2, 4, null, null, 1, null, null, 6, null, null, 5"));
        result.add(new TreeNode("7, 3, 8, 2, 5, null, null, 1, null, 4, 6"));
        result.add(new TreeNode("7, 3, 8, 2, 6, null, null, 1, null, 4, null, null, null, null, 5"));
        result.add(new TreeNode("7, 3, 8, 2, 6, null, null, 1, null, 5, null, null, null, 4"));
        result.add(new TreeNode("7, 4, 8, 1, 5, null, null, null, 2, null, 6, null, 3"));
        result.add(new TreeNode("7, 4, 8, 1, 6, null, null, null, 2, 5, null, null, 3"));
        result.add(new TreeNode("7, 4, 8, 1, 5, null, null, null, 3, null, 6, 2"));
        result.add(new TreeNode("7, 4, 8, 1, 6, null, null, null, 3, 5, null, 2"));
        result.add(new TreeNode("7, 4, 8, 2, 5, null, null, 1, 3, null, 6"));
        result.add(new TreeNode("7, 4, 8, 2, 6, null, null, 1, 3, 5"));
        result.add(new TreeNode("7, 4, 8, 3, 5, null, null, 1, null, null, 6, null, 2"));
        result.add(new TreeNode("7, 4, 8, 3, 6, null, null, 1, null, 5, null, null, 2"));
        result.add(new TreeNode("7, 4, 8, 3, 5, null, null, 2, null, null, 6, 1"));
        result.add(new TreeNode("7, 4, 8, 3, 6, null, null, 2, null, 5, null, 1"));
        result.add(new TreeNode("7, 5, 8, 1, 6, null, null, null, 2, null, null, null, 3, null, 4"));
        result.add(new TreeNode("7, 5, 8, 1, 6, null, null, null, 2, null, null, null, 4, 3"));
        result.add(new TreeNode("7, 5, 8, 1, 6, null, null, null, 3, null, null, 2, 4"));
        result.add(new TreeNode("7, 5, 8, 1, 6, null, null, null, 4, null, null, 2, null, null, 3"));
        result.add(new TreeNode("7, 5, 8, 1, 6, null, null, null, 4, null, null, 3, null, 2"));
        result.add(new TreeNode("7, 5, 8, 2, 6, null, null, 1, 3, null, null, null, null, null, 4"));
        result.add(new TreeNode("7, 5, 8, 2, 6, null, null, 1, 4, null, null, null, null, 3"));
        result.add(new TreeNode("7, 5, 8, 3, 6, null, null, 1, 4, null, null, null, 2"));
        result.add(new TreeNode("7, 5, 8, 3, 6, null, null, 2, 4, null, null, 1"));
        result.add(new TreeNode("7, 5, 8, 4, 6, null, null, 1, null, null, null, null, 2, null, 3"));
        result.add(new TreeNode("7, 5, 8, 4, 6, null, null, 1, null, null, null, null, 3, 2"));
        result.add(new TreeNode("7, 5, 8, 4, 6, null, null, 2, null, null, null, 1, 3"));
        result.add(new TreeNode("7, 5, 8, 4, 6, null, null, 3, null, null, null, 1, null, null, 2"));
        result.add(new TreeNode("7, 5, 8, 4, 6, null, null, 3, null, null, null, 2, null, 1"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 2, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 2, null, 3, null, 5, 4"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 2, null, 4, 3, 5"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 2, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 2, null, 5, 4, null, 3"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 3, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 3, 2, 5, null, null, 4"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 4, 2, 5, null, 3"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 4, 3, 5, 2"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 5, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 5, 2, null, null, 4, 3"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 5, 3, null, 2, 4"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 5, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("7, 6, 8, 1, null, null, null, null, 5, 4, null, 3, null, 2"));
        result.add(new TreeNode("7, 6, 8, 2, null, null, null, 1, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("7, 6, 8, 2, null, null, null, 1, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("7, 6, 8, 2, null, null, null, 1, 4, null, null, 3, 5"));
        result.add(new TreeNode("7, 6, 8, 2, null, null, null, 1, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("7, 6, 8, 2, null, null, null, 1, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("7, 6, 8, 3, null, null, null, 1, 4, null, 2, null, 5"));
        result.add(new TreeNode("7, 6, 8, 3, null, null, null, 1, 5, null, 2, 4"));
        result.add(new TreeNode("7, 6, 8, 3, null, null, null, 2, 4, 1, null, null, 5"));
        result.add(new TreeNode("7, 6, 8, 3, null, null, null, 2, 5, 1, null, 4"));
        result.add(new TreeNode("7, 6, 8, 4, null, null, null, 1, 5, null, 2, null, null, null, 3"));
        result.add(new TreeNode("7, 6, 8, 4, null, null, null, 1, 5, null, 3, null, null, 2"));
        result.add(new TreeNode("7, 6, 8, 4, null, null, null, 2, 5, 1, 3"));
        result.add(new TreeNode("7, 6, 8, 4, null, null, null, 3, 5, 1, null, null, null, null, 2"));
        result.add(new TreeNode("7, 6, 8, 4, null, null, null, 3, 5, 2, null, null, null, 1"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 1, null, null, 2, null, 3, null, 4"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 1, null, null, 2, null, 4, 3"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 1, null, null, 3, 2, 4"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 1, null, null, 4, 2, null, null, 3"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 1, null, null, 4, 3, null, 2"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 2, null, 1, 3, null, null, null, 4"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 2, null, 1, 4, null, null, 3"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 3, null, 1, 4, null, 2"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 3, null, 2, 4, 1"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 4, null, 1, null, null, 2, null, 3"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 4, null, 1, null, null, 3, 2"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 4, null, 2, null, 1, 3"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 4, null, 3, null, 1, null, null, 2"));
        result.add(new TreeNode("7, 6, 8, 5, null, null, null, 4, null, 3, null, 2, null, 1"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 4, null, 5, null, 7, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 4, null, 6, 5, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 4, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 4, null, 7, 6, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 5, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 5, 4, 7, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 6, 4, 7, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 6, 5, 7, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 7, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 7, 4, null, null, 6, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 7, 5, null, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 7, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 3, null, 7, 6, null, 5, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 4, 3, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 4, 3, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 4, 3, 6, null, null, 5, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 4, 3, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 4, 3, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 5, 3, 6, null, 4, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 5, 3, 7, null, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 5, 4, 6, 3, null, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 5, 4, 7, 3, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 6, 3, 7, null, 4, null, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 6, 3, 7, null, 5, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 6, 4, 7, 3, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 6, 5, 7, 3, null, null, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 6, 5, 7, 4, null, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 3, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 3, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 3, null, null, 5, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 3, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 3, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 4, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 4, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 5, null, 3, 6, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 5, null, 4, 6, 3"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 6, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 6, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 6, null, 4, null, 3, 5"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 6, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 2, null, 7, 6, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 4, null, null, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 4, null, null, null, 5, null, 7, 6"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 4, null, null, null, 6, 5, 7"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 4, null, null, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 4, null, null, null, 7, 6, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 5, null, null, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 5, null, null, 4, 7, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 6, null, null, 4, 7, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 6, null, null, 5, 7, 4"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 7, null, null, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 7, null, null, 4, null, null, 6, 5"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 7, null, null, 5, null, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 7, null, null, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 3, 2, 7, null, null, 6, null, 5, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 4, 2, 5, null, 3, null, 6, null, null, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 4, 2, 5, null, 3, null, 7, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 4, 2, 6, null, 3, 5, 7"));
        result.add(new TreeNode("8, 1, null, null, 4, 2, 7, null, 3, 5, null, null, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 4, 2, 7, null, 3, 6, null, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 4, 3, 5, 2, null, null, 6, null, null, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 4, 3, 5, 2, null, null, 7, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 4, 3, 6, 2, null, 5, 7"));
        result.add(new TreeNode("8, 1, null, null, 4, 3, 7, 2, null, 5, null, null, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 4, 3, 7, 2, null, 6, null, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 5, 2, 6, null, 3, null, 7, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 5, 2, 7, null, 3, 6, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 5, 2, 6, null, 4, null, 7, 3"));
        result.add(new TreeNode("8, 1, null, null, 5, 2, 7, null, 4, 6, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 5, 3, 6, 2, 4, null, 7"));
        result.add(new TreeNode("8, 1, null, null, 5, 3, 7, 2, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 5, 4, 6, 2, null, null, 7, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 5, 4, 7, 2, null, 6, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 5, 4, 6, 3, null, null, 7, 2"));
        result.add(new TreeNode("8, 1, null, null, 5, 4, 7, 3, null, 6, null, 2"));
        result.add(new TreeNode("8, 1, null, null, 6, 2, 7, null, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 6, 2, 7, null, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("8, 1, null, null, 6, 2, 7, null, 4, null, null, 3, 5"));
        result.add(new TreeNode("8, 1, null, null, 6, 2, 7, null, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 6, 2, 7, null, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 6, 3, 7, 2, 4, null, null, null, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 6, 3, 7, 2, 5, null, null, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 6, 4, 7, 2, 5, null, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 6, 4, 7, 3, 5, null, null, 2"));
        result.add(new TreeNode("8, 1, null, null, 6, 5, 7, 2, null, null, null, null, 3, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 6, 5, 7, 2, null, null, null, null, 4, 3"));
        result.add(new TreeNode("8, 1, null, null, 6, 5, 7, 3, null, null, null, 2, 4"));
        result.add(new TreeNode("8, 1, null, null, 6, 5, 7, 4, null, null, null, 2, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 6, 5, 7, 4, null, null, null, 3, null, 2"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 3, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 3, null, 4, null, 6, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 3, null, 5, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 3, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 3, null, 6, 5, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 4, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 4, 3, 6, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 5, 3, 6, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 5, 4, 6, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 6, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 6, 3, null, null, 5, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 6, 4, null, 3, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 6, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 2, null, null, 6, 5, null, 4, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 3, null, 2, 4, null, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 3, null, 2, 4, null, null, null, 6, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 3, null, 2, 5, null, null, 4, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 3, null, 2, 6, null, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 3, null, 2, 6, null, null, 5, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 4, null, 2, 5, null, 3, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 4, null, 2, 6, null, 3, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 4, null, 3, 5, 2, null, null, 6"));
        result.add(new TreeNode("8, 1, null, null, 7, 4, null, 3, 6, 2, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 5, null, 2, 6, null, 3, null, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 5, null, 2, 6, null, 4, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 5, null, 3, 6, 2, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 5, null, 4, 6, 2, null, null, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 5, null, 4, 6, 3, null, null, null, 2"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 2, null, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 2, null, null, 3, null, 5, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 2, null, null, 4, 3, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 2, null, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 2, null, null, 5, 4, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 3, null, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 3, null, 2, 5, null, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 4, null, 2, 5, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 4, null, 3, 5, 2"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 5, null, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 5, null, 2, null, null, 4, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 5, null, 3, null, 2, 4"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 5, null, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("8, 1, null, null, 7, 6, null, 5, null, 4, null, 3, null, 2"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 4, null, 5, null, 6, null, 7"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 4, null, 5, null, 7, 6"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 4, null, 6, 5, 7"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 4, null, 7, 5, null, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 4, null, 7, 6, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 5, 4, 6, null, null, null, 7"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 5, 4, 7, null, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 6, 4, 7, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 6, 5, 7, 4"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 7, 4, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 7, 4, null, null, 6, 5"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 7, 5, null, 4, 6"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 7, 6, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 3, null, null, null, 7, 6, null, 5, null, 4"));
        result.add(new TreeNode("8, 2, null, 1, 4, null, null, 3, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("8, 2, null, 1, 4, null, null, 3, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("8, 2, null, 1, 4, null, null, 3, 6, null, null, 5, 7"));
        result.add(new TreeNode("8, 2, null, 1, 4, null, null, 3, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 4, null, null, 3, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 5, null, null, 3, 6, null, 4, null, 7"));
        result.add(new TreeNode("8, 2, null, 1, 5, null, null, 3, 7, null, 4, 6"));
        result.add(new TreeNode("8, 2, null, 1, 5, null, null, 4, 6, 3, null, null, 7"));
        result.add(new TreeNode("8, 2, null, 1, 5, null, null, 4, 7, 3, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 6, null, null, 3, 7, null, 4, null, null, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 6, null, null, 3, 7, null, 5, null, null, 4"));
        result.add(new TreeNode("8, 2, null, 1, 6, null, null, 4, 7, 3, 5"));
        result.add(new TreeNode("8, 2, null, 1, 6, null, null, 5, 7, 3, null, null, null, null, 4"));
        result.add(new TreeNode("8, 2, null, 1, 6, null, null, 5, 7, 4, null, null, null, 3"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 3, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 3, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 3, null, null, 5, 4, 6"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 3, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 3, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 4, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 4, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 5, null, 3, 6, null, 4"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 5, null, 4, 6, 3"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 6, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 6, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 6, null, 4, null, 3, 5"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 6, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 2, null, 1, 7, null, null, 6, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("8, 3, null, 1, 4, null, 2, null, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("8, 3, null, 1, 4, null, 2, null, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("8, 3, null, 1, 4, null, 2, null, 6, null, null, 5, 7"));
        result.add(new TreeNode("8, 3, null, 1, 4, null, 2, null, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("8, 3, null, 1, 4, null, 2, null, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("8, 3, null, 1, 5, null, 2, 4, 6, null, null, null, null, null, 7"));
        result.add(new TreeNode("8, 3, null, 1, 5, null, 2, 4, 7, null, null, null, null, 6"));
        result.add(new TreeNode("8, 3, null, 1, 6, null, 2, 4, 7, null, null, null, 5"));
        result.add(new TreeNode("8, 3, null, 1, 6, null, 2, 5, 7, null, null, 4"));
        result.add(new TreeNode("8, 3, null, 1, 7, null, 2, 4, null, null, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 3, null, 1, 7, null, 2, 4, null, null, null, null, 6, 5"));
        result.add(new TreeNode("8, 3, null, 1, 7, null, 2, 5, null, null, null, 4, 6"));
        result.add(new TreeNode("8, 3, null, 1, 7, null, 2, 6, null, null, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 3, null, 1, 7, null, 2, 6, null, null, null, 5, null, 4"));
        result.add(new TreeNode("8, 3, null, 2, 4, 1, null, null, 5, null, null, null, 6, null, 7"));
        result.add(new TreeNode("8, 3, null, 2, 4, 1, null, null, 5, null, null, null, 7, 6"));
        result.add(new TreeNode("8, 3, null, 2, 4, 1, null, null, 6, null, null, 5, 7"));
        result.add(new TreeNode("8, 3, null, 2, 4, 1, null, null, 7, null, null, 5, null, null, 6"));
        result.add(new TreeNode("8, 3, null, 2, 4, 1, null, null, 7, null, null, 6, null, 5"));
        result.add(new TreeNode("8, 3, null, 2, 5, 1, null, 4, 6, null, null, null, null, null, 7"));
        result.add(new TreeNode("8, 3, null, 2, 5, 1, null, 4, 7, null, null, null, null, 6"));
        result.add(new TreeNode("8, 3, null, 2, 6, 1, null, 4, 7, null, null, null, 5"));
        result.add(new TreeNode("8, 3, null, 2, 6, 1, null, 5, 7, null, null, 4"));
        result.add(new TreeNode("8, 3, null, 2, 7, 1, null, 4, null, null, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 3, null, 2, 7, 1, null, 4, null, null, null, null, 6, 5"));
        result.add(new TreeNode("8, 3, null, 2, 7, 1, null, 5, null, null, null, 4, 6"));
        result.add(new TreeNode("8, 3, null, 2, 7, 1, null, 6, null, null, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 3, null, 2, 7, 1, null, 6, null, null, null, 5, null, 4"));
        result.add(new TreeNode("8, 4, null, 1, 5, null, 2, null, 6, null, 3, null, 7"));
        result.add(new TreeNode("8, 4, null, 1, 5, null, 2, null, 7, null, 3, 6"));
        result.add(new TreeNode("8, 4, null, 1, 6, null, 2, 5, 7, null, 3"));
        result.add(new TreeNode("8, 4, null, 1, 7, null, 2, 5, null, null, 3, null, 6"));
        result.add(new TreeNode("8, 4, null, 1, 7, null, 2, 6, null, null, 3, 5"));
        result.add(new TreeNode("8, 4, null, 1, 5, null, 3, null, 6, 2, null, null, 7"));
        result.add(new TreeNode("8, 4, null, 1, 5, null, 3, null, 7, 2, null, 6"));
        result.add(new TreeNode("8, 4, null, 1, 6, null, 3, 5, 7, 2"));
        result.add(new TreeNode("8, 4, null, 1, 7, null, 3, 5, null, 2, null, null, 6"));
        result.add(new TreeNode("8, 4, null, 1, 7, null, 3, 6, null, 2, null, 5"));
        result.add(new TreeNode("8, 4, null, 2, 5, 1, 3, null, 6, null, null, null, null, null, 7"));
        result.add(new TreeNode("8, 4, null, 2, 5, 1, 3, null, 7, null, null, null, null, 6"));
        result.add(new TreeNode("8, 4, null, 2, 6, 1, 3, 5, 7"));
        result.add(new TreeNode("8, 4, null, 2, 7, 1, 3, 5, null, null, null, null, null, null, 6"));
        result.add(new TreeNode("8, 4, null, 2, 7, 1, 3, 6, null, null, null, null, null, 5"));
        result.add(new TreeNode("8, 4, null, 3, 5, 1, null, null, 6, null, 2, null, 7"));
        result.add(new TreeNode("8, 4, null, 3, 5, 1, null, null, 7, null, 2, 6"));
        result.add(new TreeNode("8, 4, null, 3, 6, 1, null, 5, 7, null, 2"));
        result.add(new TreeNode("8, 4, null, 3, 7, 1, null, 5, null, null, 2, null, 6"));
        result.add(new TreeNode("8, 4, null, 3, 7, 1, null, 6, null, null, 2, 5"));
        result.add(new TreeNode("8, 4, null, 3, 5, 2, null, null, 6, 1, null, null, 7"));
        result.add(new TreeNode("8, 4, null, 3, 5, 2, null, null, 7, 1, null, 6"));
        result.add(new TreeNode("8, 4, null, 3, 6, 2, null, 5, 7, 1"));
        result.add(new TreeNode("8, 4, null, 3, 7, 2, null, 5, null, 1, null, null, 6"));
        result.add(new TreeNode("8, 4, null, 3, 7, 2, null, 6, null, 1, null, 5"));
        result.add(new TreeNode("8, 5, null, 1, 6, null, 2, null, 7, null, 3, null, null, null, 4"));
        result.add(new TreeNode("8, 5, null, 1, 7, null, 2, 6, null, null, 3, null, null, null, 4"));
        result.add(new TreeNode("8, 5, null, 1, 6, null, 2, null, 7, null, 4, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 1, 7, null, 2, 6, null, null, 4, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 1, 6, null, 3, null, 7, 2, 4"));
        result.add(new TreeNode("8, 5, null, 1, 7, null, 3, 6, null, 2, 4"));
        result.add(new TreeNode("8, 5, null, 1, 6, null, 4, null, 7, 2, null, null, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 1, 7, null, 4, 6, null, 2, null, null, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 1, 6, null, 4, null, 7, 3, null, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 1, 7, null, 4, 6, null, 3, null, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 2, 6, 1, 3, null, 7, null, null, null, 4"));
        result.add(new TreeNode("8, 5, null, 2, 7, 1, 3, 6, null, null, null, null, 4"));
        result.add(new TreeNode("8, 5, null, 2, 6, 1, 4, null, 7, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 2, 7, 1, 4, 6, null, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 3, 6, 1, 4, null, 7, null, 2"));
        result.add(new TreeNode("8, 5, null, 3, 7, 1, 4, 6, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 3, 6, 2, 4, null, 7, 1"));
        result.add(new TreeNode("8, 5, null, 3, 7, 2, 4, 6, null, 1"));
        result.add(new TreeNode("8, 5, null, 4, 6, 1, null, null, 7, null, 2, null, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 4, 7, 1, null, 6, null, null, 2, null, null, null, 3"));
        result.add(new TreeNode("8, 5, null, 4, 6, 1, null, null, 7, null, 3, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 4, 7, 1, null, 6, null, null, 3, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 4, 6, 2, null, null, 7, 1, 3"));
        result.add(new TreeNode("8, 5, null, 4, 7, 2, null, 6, null, 1, 3"));
        result.add(new TreeNode("8, 5, null, 4, 6, 3, null, null, 7, 1, null, null, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 4, 7, 3, null, 6, null, 1, null, null, null, null, 2"));
        result.add(new TreeNode("8, 5, null, 4, 6, 3, null, null, 7, 2, null, null, null, 1"));
        result.add(new TreeNode("8, 5, null, 4, 7, 3, null, 6, null, 2, null, null, null, 1"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 2, null, null, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 2, null, null, null, 3, null, 5, 4"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 2, null, null, null, 4, 3, 5"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 2, null, null, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 2, null, null, null, 5, 4, null, 3"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 3, null, null, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 3, null, null, 2, 5, null, null, 4"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 4, null, null, 2, 5, null, 3"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 4, null, null, 3, 5, 2"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 5, null, null, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 5, null, null, 2, null, null, 4, 3"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 5, null, null, 3, null, 2, 4"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 5, null, null, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("8, 6, null, 1, 7, null, 5, null, null, 4, null, 3, null, 2"));
        result.add(new TreeNode("8, 6, null, 2, 7, 1, 3, null, null, null, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 6, null, 2, 7, 1, 3, null, null, null, null, null, 5, 4"));
        result.add(new TreeNode("8, 6, null, 2, 7, 1, 4, null, null, null, null, 3, 5"));
        result.add(new TreeNode("8, 6, null, 2, 7, 1, 5, null, null, null, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 6, null, 2, 7, 1, 5, null, null, null, null, 4, null, 3"));
        result.add(new TreeNode("8, 6, null, 3, 7, 1, 4, null, null, null, 2, null, 5"));
        result.add(new TreeNode("8, 6, null, 3, 7, 1, 5, null, null, null, 2, 4"));
        result.add(new TreeNode("8, 6, null, 3, 7, 2, 4, null, null, 1, null, null, 5"));
        result.add(new TreeNode("8, 6, null, 3, 7, 2, 5, null, null, 1, null, 4"));
        result.add(new TreeNode("8, 6, null, 4, 7, 1, 5, null, null, null, 2, null, null, null, 3"));
        result.add(new TreeNode("8, 6, null, 4, 7, 1, 5, null, null, null, 3, null, null, 2"));
        result.add(new TreeNode("8, 6, null, 4, 7, 2, 5, null, null, 1, 3"));
        result.add(new TreeNode("8, 6, null, 4, 7, 3, 5, null, null, 1, null, null, null, null, 2"));
        result.add(new TreeNode("8, 6, null, 4, 7, 3, 5, null, null, 2, null, null, null, 1"));
        result.add(new TreeNode("8, 6, null, 5, 7, 1, null, null, null, null, 2, null, 3, null, 4"));
        result.add(new TreeNode("8, 6, null, 5, 7, 1, null, null, null, null, 2, null, 4, 3"));
        result.add(new TreeNode("8, 6, null, 5, 7, 1, null, null, null, null, 3, 2, 4"));
        result.add(new TreeNode("8, 6, null, 5, 7, 1, null, null, null, null, 4, 2, null, null, 3"));
        result.add(new TreeNode("8, 6, null, 5, 7, 1, null, null, null, null, 4, 3, null, 2"));
        result.add(new TreeNode("8, 6, null, 5, 7, 2, null, null, null, 1, 3, null, null, null, 4"));
        result.add(new TreeNode("8, 6, null, 5, 7, 2, null, null, null, 1, 4, null, null, 3"));
        result.add(new TreeNode("8, 6, null, 5, 7, 3, null, null, null, 1, 4, null, 2"));
        result.add(new TreeNode("8, 6, null, 5, 7, 3, null, null, null, 2, 4, 1"));
        result.add(new TreeNode("8, 6, null, 5, 7, 4, null, null, null, 1, null, null, 2, null, 3"));
        result.add(new TreeNode("8, 6, null, 5, 7, 4, null, null, null, 1, null, null, 3, 2"));
        result.add(new TreeNode("8, 6, null, 5, 7, 4, null, null, null, 2, null, 1, 3"));
        result.add(new TreeNode("8, 6, null, 5, 7, 4, null, null, null, 3, null, 1, null, null, 2"));
        result.add(new TreeNode("8, 6, null, 5, 7, 4, null, null, null, 3, null, 2, null, 1"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 3, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 3, null, 4, null, 6, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 3, null, 5, 4, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 3, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 3, null, 6, 5, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 4, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 4, 3, 6, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 5, 3, 6, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 5, 4, 6, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 6, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 6, 3, null, null, 5, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 6, 4, null, 3, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 6, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 2, null, 6, 5, null, 4, null, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 3, 2, 4, null, null, null, 5, null, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 3, 2, 4, null, null, null, 6, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 3, 2, 5, null, null, 4, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 3, 2, 6, null, null, 4, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 3, 2, 6, null, null, 5, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 4, 2, 5, null, 3, null, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 4, 2, 6, null, 3, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 4, 3, 5, 2, null, null, 6"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 4, 3, 6, 2, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 5, 2, 6, null, 3, null, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 5, 2, 6, null, 4, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 5, 3, 6, 2, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 5, 4, 6, 2, null, null, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 5, 4, 6, 3, null, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 2, null, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 2, null, null, 3, null, 5, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 2, null, null, 4, 3, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 2, null, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 2, null, null, 5, 4, null, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 3, null, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 3, null, 2, 5, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 4, null, 2, 5, null, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 4, null, 3, 5, 2"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 5, null, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 5, null, 2, null, null, 4, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 5, null, 3, null, 2, 4"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 5, null, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 1, null, null, 6, 5, null, 4, null, 3, null, 2"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 3, null, null, null, 4, null, 5, null, 6"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 3, null, null, null, 4, null, 6, 5"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 3, null, null, null, 5, 4, 6"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 3, null, null, null, 6, 4, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 3, null, null, null, 6, 5, null, 4"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 4, null, null, 3, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 4, null, null, 3, 6, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 5, null, null, 3, 6, null, 4"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 5, null, null, 4, 6, 3"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 6, null, null, 3, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 6, null, null, 3, null, null, 5, 4"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 6, null, null, 4, null, 3, 5"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 6, null, null, 5, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 2, null, 1, 6, null, null, 5, null, 4, null, 3"));
        result.add(new TreeNode("8, 7, null, 3, null, 1, 4, null, 2, null, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 7, null, 3, null, 1, 4, null, 2, null, 6, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 3, null, 1, 5, null, 2, 4, 6"));
        result.add(new TreeNode("8, 7, null, 3, null, 1, 6, null, 2, 4, null, null, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 3, null, 1, 6, null, 2, 5, null, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 3, null, 2, 4, 1, null, null, 5, null, null, null, 6"));
        result.add(new TreeNode("8, 7, null, 3, null, 2, 4, 1, null, null, 6, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 3, null, 2, 5, 1, null, 4, 6"));
        result.add(new TreeNode("8, 7, null, 3, null, 2, 6, 1, null, 4, null, null, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 3, null, 2, 6, 1, null, 5, null, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 4, null, 1, 5, null, 2, null, 6, null, 3"));
        result.add(new TreeNode("8, 7, null, 4, null, 1, 6, null, 2, 5, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 4, null, 1, 5, null, 3, null, 6, 2"));
        result.add(new TreeNode("8, 7, null, 4, null, 1, 6, null, 3, 5, null, 2"));
        result.add(new TreeNode("8, 7, null, 4, null, 2, 5, 1, 3, null, 6"));
        result.add(new TreeNode("8, 7, null, 4, null, 2, 6, 1, 3, 5"));
        result.add(new TreeNode("8, 7, null, 4, null, 3, 5, 1, null, null, 6, null, 2"));
        result.add(new TreeNode("8, 7, null, 4, null, 3, 6, 1, null, 5, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 4, null, 3, 5, 2, null, null, 6, 1"));
        result.add(new TreeNode("8, 7, null, 4, null, 3, 6, 2, null, 5, null, 1"));
        result.add(new TreeNode("8, 7, null, 5, null, 1, 6, null, 2, null, null, null, 3, null, 4"));
        result.add(new TreeNode("8, 7, null, 5, null, 1, 6, null, 2, null, null, null, 4, 3"));
        result.add(new TreeNode("8, 7, null, 5, null, 1, 6, null, 3, null, null, 2, 4"));
        result.add(new TreeNode("8, 7, null, 5, null, 1, 6, null, 4, null, null, 2, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 5, null, 1, 6, null, 4, null, null, 3, null, 2"));
        result.add(new TreeNode("8, 7, null, 5, null, 2, 6, 1, 3, null, null, null, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 5, null, 2, 6, 1, 4, null, null, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 5, null, 3, 6, 1, 4, null, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 5, null, 3, 6, 2, 4, null, null, 1"));
        result.add(new TreeNode("8, 7, null, 5, null, 4, 6, 1, null, null, null, null, 2, null, 3"));
        result.add(new TreeNode("8, 7, null, 5, null, 4, 6, 1, null, null, null, null, 3, 2"));
        result.add(new TreeNode("8, 7, null, 5, null, 4, 6, 2, null, null, null, 1, 3"));
        result.add(new TreeNode("8, 7, null, 5, null, 4, 6, 3, null, null, null, 1, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 5, null, 4, 6, 3, null, null, null, 2, null, 1"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 2, null, 3, null, 4, null, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 2, null, 3, null, 5, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 2, null, 4, 3, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 2, null, 5, 3, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 2, null, 5, 4, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 3, 2, 4, null, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 3, 2, 5, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 4, 2, 5, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 4, 3, 5, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 5, 2, null, null, 3, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 5, 2, null, null, 4, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 5, 3, null, 2, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 5, 4, null, 2, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 1, null, null, 5, 4, null, 3, null, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 2, null, 1, 3, null, null, null, 4, null, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 2, null, 1, 3, null, null, null, 5, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 2, null, 1, 4, null, null, 3, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 2, null, 1, 5, null, null, 3, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 2, null, 1, 5, null, null, 4, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 3, null, 1, 4, null, 2, null, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 3, null, 1, 5, null, 2, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 3, null, 2, 4, 1, null, null, 5"));
        result.add(new TreeNode("8, 7, null, 6, null, 3, null, 2, 5, 1, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 4, null, 1, 5, null, 2, null, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 4, null, 1, 5, null, 3, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 4, null, 2, 5, 1, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 4, null, 3, 5, 1, null, null, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 4, null, 3, 5, 2, null, null, null, 1"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 1, null, null, 2, null, 3, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 1, null, null, 2, null, 4, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 1, null, null, 3, 2, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 1, null, null, 4, 2, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 1, null, null, 4, 3, null, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 2, null, 1, 3, null, null, null, 4"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 2, null, 1, 4, null, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 3, null, 1, 4, null, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 3, null, 2, 4, 1"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 4, null, 1, null, null, 2, null, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 4, null, 1, null, null, 3, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 4, null, 2, null, 1, 3"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 4, null, 3, null, 1, null, null, 2"));
        result.add(new TreeNode("8, 7, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1"));
        assertEquals(result, AllPossibleBST.getBinarySearchTrees(8));
    }
    @Test
    public void findBottomLeftValue() {
        assertEquals(1, new FindBottomLeftTreeValue(new TreeNode(1)).execute());
        assertEquals(2, new FindBottomLeftTreeValue(root1).execute());
        assertEquals(6, new FindBottomLeftTreeValue(root).execute());
        TreeNode node = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, 8, null, null, 9, null, 10, 11, null, null, 12");
        assertEquals(12, new FindBottomLeftTreeValue(node).execute());
        node = new TreeNode("0, 2, -2, 4, 1, -4, -1, 3, 5, null, null, -3, -6, null, null, null, null, null, null, null, 7, -7, -5");
        assertEquals(7, new FindBottomLeftTreeValue(node).execute());
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Nothing to look for");
        new FindBottomLeftTreeValue(null).execute();
    }

    @Test
    public void checkValidPreorderSerialization() {
        assertTrue(CheckValidPreorderSerialization.isValidSerialization("#"));
        assertFalse(CheckValidPreorderSerialization.isValidSerialization("1"));
        assertTrue(CheckValidPreorderSerialization.isValidSerialization("11,#,99,#,#"));
        assertFalse(CheckValidPreorderSerialization.isValidSerialization("1,2,3,#,#,#,4,#,#,5,#"));
        assertTrue(CheckValidPreorderSerialization.isValidSerialization("1,2,3,#,#,#,4,#,5,#,#"));
        assertFalse(CheckValidPreorderSerialization.isValidSerialization("1,2,3,#,#,#,#,4,#,#"));
        assertTrue(CheckValidPreorderSerialization.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertFalse(CheckValidPreorderSerialization.isValidSerialization("#,1,#,#"));
    }

    @Test
    public void constructBinaryTreeFromPreorderAndInorderTraversal() {
        assertNull(ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[]{}, new int[]{}));
        assertEquals(new TreeNode(0), ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[]{0}, new int[]{0}));
        int[] preorder = {0,-2,-4,-6,-7,-5,-3,-1,2,1,4,3,5,7,6};
        int[] inorder = {-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7};
        assertEquals(root, ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder));
        preorder = new int[]{1,2,4,8,5,3,6,7};
        inorder = new int[]{8,4,2,5,1,6,3,7};
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder));
        preorder = new int[]{1,2,3,5,6,4,7,8};
        inorder = new int[]{1,3,5,6,2,7,4,8};
        root = new TreeNode("1, null, 2, 3, 4, null, 5, 7, 8, null, 6");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder));
        preorder = new int[]{1,2,3,4,5,6};
        inorder = new int[]{1,2,3,4,5,6};
        root = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder));
        preorder = new int[]{1,2,3,4,5,6};
        inorder = new int[]{6,5,4,3,2,1};
        root = new TreeNode("1, 2, null, 3, null, 4, null, 5, null, 6");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder));
    }

    @Test
    public void mostFrequentSubtreeSum() {
        List<Integer> list = new ArrayList<>();
        assertEquals(list, new MostFrequentSubtreeSum(null).execute());
        list.add(2);
        assertEquals(list, new MostFrequentSubtreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-5))).execute());
        list = new ArrayList<>();
        list.add(-1);
        root = deserialize("1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1,1,-1");
        assertEquals(list, new MostFrequentSubtreeSum(root).execute());
        list = new ArrayList<>();
        list.add(76458);
        list.add(63062);
        root = deserialize("43728,59900,34829,87672,56368,28058,62372,26367,75851,49119,94490,92599,59243,56527,60869,61799,20761,96773,28483,38514,77339,27126,65889,75242,33997,87415,59534,1103,40871,61829,41722,18594,41375,94476,54043,13418,96671,73277,62361,62370,15482,50826,59857,17299,40254,27940,43171,89382,40759,85885,23336,57227,44478,16660,37989,74809,89424,67194,64247,60763,19554,82968,92683,9285,55512,9320,11984,74697,64172,84551,71169,46653,19284,37993,31644,51069,92521,88281,94919,83022,39292,22368,93463,2178,46953,24178,61961,98776,94338,13291,64141,68736,31064,48709,36397,20159,22616,50473,23554,70310,22960,92810,24450,82100,30291,26462,35387,32176,53463,95019,78053,98889,66784,20285,25187,7742,59044,45117,92003,74376,89030,38679,44368,40673,44219,88658,85687,8312,61964,27778,23669,35859,13198,67791,85404,80478,67522,43160,44590,33367,55546,98753,48297,19247,19399,91137,82314,4524,95611,11432,93895,86215,5846,79187,98644,14257,40505,1385,34314,33546,7766,38407,88450,18846,86379,69704,19093,15661,64370,5889,8166,93221,67780,51123,35717,61931,83670,79904,39828,6949,59842,55751,31811,41992,20065,85785,69190,93048,68086,74828,50045,80344,66285,15401,81415,78769,65576,25886,91757,1852,31969,28106,2881,72491,62229,37719,50297,14815,6128,26072,42580,25862,16011,538,80135,63220,25776,41867,11673,15332,20802,31708,92721,4842,97977,1204,24670,12222,30700,32467,95130,96807,47582,48715,10789,35459,5515,35995,12500,95289,87930,49675,88979,6127,87228,72250,60282,952,36759,5538,85150,47970,42179,99938,57319,6800,24609,46198,95101,2990,28753,81025,95759,30055,67977,86844,21681,56279,75318,98175,8834,34728,4491,62327,39683,89227,78198,40503,2510,76501,12364,76899,67004,5246,54429,8030,42021,26577,61397,32237,45563,97147,9078,10248,9317,56123,67805,21636,60521,50322,1881,59164,72422,87967,50109,3258,51295,853,22970,82224,32736,47164,8387,90330,92891,92710,12454,5510,41281,67103,74131,21186,51074,3157,83619,82598,99922,32760,2979,97033,39891,30532,34517,69460,88566,67772,7595,349,35047,63513,57694,70820,84356,96944,52953,31780,21677,76031,82851,8326,63889,40849,61301,28450,80008,16967,12172,85963,4452,24155,99054,51559,37429,88767,33108,53063,25312,4316,42903,56166,40498,34120,18374,90330,35060,52274,47394,81046,25385,74843,47916,69257,76041,41805,61232,21515,90281,72107,12635,60325,81861,29164,64605,73107,98274,2146,84615,90383,89019,29647,24760,58996,64221,66595,63620,74591,68648,22737,92122,79063,4129,81592,34647,73324,69402,42447,84209,43481,50546,14789,96271,49416,87498,34528,29608,78725,62503,64402,44575,26155,4927,87163,69292,18885,83499,99463,22407,71397,61844,66791,37519,20188,26062,5383,68750,58200,54174,15712,69605,61596,86386,4000,27954,77379,72420,93103,8815,19398,17578,42227,3611,2346,22716,66085,9652,28668,15010,68451,66823,31655,96117,82492,59805,69482,92312,40829,53638,59624,77162,81974,68014,40790,51500,36606,11425,50429,7711,27075,90136,9838,75782,56617,78932,16063,47083,60929,90656,50008,98525,44087,9826,23551,94496,23215,61924,5000,26928,61898,74443,81803,64841,81011,48377,42217,23901,97446,99547,83511,33797,56188,48018,83263,76664,89223,30839,2470,93299,55979,88403,24428,5593,94293,27998,71707,83383,38375,99419,85073,91820,40763,27011,92829,91423,68980,30111,46782,27102,34427,29559,51964,34763,50962,81821,71187,14479,13700,4226,42690,67779,34759,54908,9350,73240,71989,9298,21340,79374,39156,31313,40595,26699,91644,71912,45087,71919,40390,40238,3681,76309,58628,83329,68177,37668,10921,79201,8205,90630,52049,95089,96721,73652,14508,87734,39128,62653,27686,25816,27428,1073,89226,95988,92305,14018,39661,13441,20666,80213,75075,95515,3933,49615,69393,72608,83251,36864,67811,4485,61775,91107,55970,42025,61344,41320,5648,24615,11081,42876,47086,31528,68861,5909,20466,12063,93077,68918,14682,3624,1766,92120,10168,9561,78918,84189,4431,49285,13658,43312,13826,12051,87005,88933,13207,42739,53034,84030,96262,63087,96534,99500,13677,85048,87610,51951,73687,4271,95200,54162,70164,71221,66112,53461,37067,24989,23913,97465,14911,40638,92906,58896,54829,84711,6437,71602,78897,95545,15867,78441,61562,5121,76847,68352,96336,97383,52881,84727,64358,54344,42668,20084,27009,75727,7363,73122,23418,70532,46621,33339,65563,9592,48192,75740,88572,97083,14837,93520,31916,65874,54436,70184,98365,26745,4454,94194,61919,4689,50278,49039,73325,76883,88461,69526,42406,86382,80521,41124,60077,43172,40713,33357,59772,39970,2067,527,7926,3975,8973,53449,56228,77773,91756,4436,84565,72678,88895,14404,12866,66019,95963,25779,62536,20247,36833,47778,3681,86170,72342,71688,33092,15272,84362,32906,89680,46747,99093,3813,29096,53762,42404,96947,47233,30414,52176,81481,63603,75956,7856,67675,49795,86084,75817,93746,15759,92422,10595,57526,47145,823,96745,71305,20668,66700,63773,82407,11281,11306,57508,94344,44848,26765,5266,43808,43114,39593,69289,37281,53943,2564,43199,27705,59098,63002,9596,16462,4314,11908,43403,98785,1938,52830,15226,31797,15146,41963,21723,93505,44516,41689,45880,18372,2730,98630,29055,40507,81184,4237,18844,49036,83545,21063,42001,61885,25544,61054,40097,53989,77784,83593,97040,33847,58883,40433,82262,48387,69970,32331,31098,10263,98378,57854,84771,83974,8296,28707,16413,37638,79234,97909,76652,65757,49333,97216,2587,14995,69870,8438,47314,99746,79747,99634,3703,77219,64327,41638,15728,62765,71665,82972,93420,5350,21002,1926,73398,10364,53327,73430,95913,92356,41881,85308,1501,63830,1673,13623,85563,17891,11385,20020,87598,42322,88495,65335,33288,10566,38994,43214,92301,31152,36805,25073,62392,1234,74768,73454,41289,2213,69055,24693,1845,95821,91917,63775,43062,27580,53842,14346,49859,21202,55564,45092,57821,52298,82754,50026,85674,22652,21831,94702,67874,17370,33990,32977,92426,16374,36394,89661,24948,48962,4385,73233,79000,25635,26653,29798,74802,54840,16503,74538,13756,54015,6645,40125,84533,94058,32413,62943,8011,74279,38851,87412,22965,10907,30812,6307,12180,36409,22039,70702,69511,49144,29117,97003,12455,23289,99272,70515,51892,87519,57176,95074,40923,7571,5229,66520,38122,62609,14241,54106,37001,88234,96990,58433,33127,69981,65838,77094,23095,10355,37397,49914,55408,59694,62170,74559,82361,96598,25170,80215,94119,67164,84711,22176,51455,43954,90878,13364,71976,45396,52612,40196,66186,64224,2945,19636,64359,89610,45571,41911,22930,71788,52795,9074,50024,70269,24804,23430,43723,47148,13309,1848,93796,15528,58763,92046,57908,29784,89710,45187,86641,9117,85228,55440,38234,18822,7029,11672,93514,94677,66432,18997,54293,85043,3291,38649,84359,2566,18844,63506,31190,22734,22564,93524,48671,40140,24261,495,26329,94907,26998,74708,18985,11542,53841,27481,62221,50407,72014,82986,53711,57995,61728,30388,78183,16403,13774,23053,54686,34632,29899,5407,88838,94802,43068,20018,19837,64867,70881,97567,62298,16089,64767,60598,56352,38330,19974,78266,55918,29103,66981,93810,4747,43377,73625,9046,72517,30286,49056,50900,49212,50188,55589,63873,24955,60894,2561,69275,14643,85481,17523,7173,21959,25703,64395,30226,75728,64842,5648,49917,13077,11726,86168,45178,28501,73697,50121,30988,55673,10445,88977,50254,99741,12940,58764,96131,91828,72082,97738,93913,94606,50227,21779,71718,48055,45424,74206,27419,7898,42958,59101,55615,95715,81719,92815,32919,49352,23962,67022,72414,35021,6151,28495,48892,58330,65899,45731,65285,90524,85416,50598,77728,8316,65389,14407,21729,30965,44920,42070,85211,26608,12896,45510,55479,51397,14098,88014,26668,79584,39376,74907,91836,80458,3389,2791,59547,98952,55695,69470,28688,680,41364,89789,27195,49353,25856,58804,70486,94738,25542,52999,23603,62722,40029,62719,57440,55528,65392,4556,73870,89796,78403,71108,37207,22945,21049,37362,90170,44155,81893,57865,51321,35285,66250,56957,87976,39190,70689,35480,33648,8131,29015,91750,72309,43386,76695,81954,43127,78628,88583,25778,28779,4314,80841,96680,78053,78039,32117,23118,79181,16722,71312,66920,44176,20468,99700,38092,86421,35109,63686,51527,73886,20639,71134,30413,18517,56186,49021,13553,18739,78628,73050,29414,6466,21603,60882,58374,62595,94434,9866,16484,55724,16331,77339,58984,27632,279,47082,19879,96073,63107,98949,75096,70508,23533,447,41020,79638,38310,68736,97683,90929,18146,9507,56436,61821,59672,25181,75606,99884,27488,99046,64494,24916,21218,4249,5974,19834,66477,56943,71045,29171,75810,31453,94867,14091,35896,81956,33132,1064,90703,69985,20066,67679,6779,79950,4908,93560,26489,15921,52436,66930,37767,12080,54889,78110,14833,56515,17597,50073,13317,23459,48701,53155,35381,32608,4520,26105,15658,5802,16445,78917,17235,71152,52700,84183,68383,72591,48831,73224,15388,78881,74538,40825,14573,50251,91217,28139,37501,13131,94574,97165,17329,13867,29699,32169,21427,70827,12213,3549,95628,20957,88384,7809,88855,61669,19583,53723,33363,21806,81991,99186,25481,56503,31169,55878,24482,49894,92928,69579,63086,26923,6860,52826,42111,20915,66972,93568,63916,17095,75050,88575,44534,93918,46698,53590,32753,13836,87435,43548,55951,73072,86806,75655,7067,5955,62148,85741,84882,53590,20474,63995,646,48872,96870,10059,68106,40297,70884,19416,1083,75533,58555,63117,53054,92396,27064,51106,46522,19641,81420,75754,56502,72912,28175,16678,32044,42201,29824,50538,62500,6354,25403,50200,21097,77422,7699,76523,47395,73097,15581,62994,62340,38964,21147,68522,44853,94010,65679,26951,37314,52568,25869,53163,88767,83832,72323,75147,89316,6066,16050,48997,96948,76829,25462,79509,8870,32804,36344,12922,83477,53231,70332,90304,76186,69480,23606,50178,12619,19974,86861,47220,86006,54420,10004,10200,32188,24266,30654,96800,5207,57301,44157,15574,49249,3477,4689,75988,38573,56348,11932,96374,36054,99886,55882,46571,3121,4010,63555,27142,79096,93795,15646,90267,36354,47134,78660,88775,9177,33518,28592,99225,88866,92652,25924,2583,75377,65769,38516,21713,76654,34800,98936,8798,50821,94966,25800,47750,93549,84883,34925,86771,83122,24958,15383,44454,9157,69596,48004,39159,27404,61698,99434,75867,2684,88925,33553,87330,24791,80377,43861,67022,8053,49641,25400,50288,14245,85527,72821,97025,70697,15398,12431,4349,90660,17619,50337,30908,41417,39458,46264,45865,47082,84672,3193,25029,57698,71053,96640,4236,63969,22368,54232,65770,87871,51399,36166,77494,33355,11224,60201,26317,38517,40388,61045,87715,30837,4301,73281,51273,50497,39956,79448,78525,73252,43993,70451,3875,34004,5161,24150,1966,24945,71390,19819,35579,18025,58970,71088,67002,40524,56749,78058,62787,14601,51788,70466,46897,56978,4579,38096,60466,23283,31724,22067,67770,73065,11852,71203,7437,26168,16634,51388,25565,78843,82868,32595,43098,48910,83931,68263,3709,23256,29275,24724,20340,88090,19199,14596,88734,32641,8775,37372,64430,30343,89611,32856,6111,18073,81015,8704,72619,13634,33183,11969,23576,34414,84195,76412,14252,6059,79859,92249,94205,78970,60896,13091,16127,2584,45458,36011,36509,42651,86648,64999,42885,65090,64500,95502,73812,51511,79762,38320,7197,56134,52912,34797,80178,61567,95920,2100,69499,41802,16643,87289,5151,94786,36065,1960,12050,64051,47201,55433,74578,29137,21088,3769,97088,7937,70119,84361,89776,80580,11834,11373,43826,14101,37380,66031,72313,39908,77944,27563,84080,11927,79808,55533,26660,52311,44044,52387,81269,73741,60432,6203,17999,52566,66804,37974,22582,15463,94863,55182,87419,93737,21371,43989,19044,94077,29677,16063,51809,32276,708,62879,73277,77341,94823,60262,60672,57422,56337,9030,99701,86091,71087,93756,7156,77780,34016,91001,6951,34567,38609,60833,15550,2975,82852,10947,77274,19124,97478,31488,52517,83272,41385,60395,2666,30729,76423,54109,34335,95051,29136,6500,62526,91637,70602,80089,27397,85028,97148,87933,52575,41634,74528,92018,64251,11114,16041,64526,99829,24231,1121,92076,22436,42803,5074,89827,23370,48214,2924,32282,38385,8973,30759,706,25691,24928,36480,93239,53655,6002,28521,43143,24383,6692,35909,43006,15756,4079,25924,78351,58918,76730,86666,32746,80841,14608,70987,38355,32313,66018,15538,10789,90522,6589,94097,25201,72417,97430,37856,61752,20079,84876,57038,72894,22606,82572,27968,2348,20328,68193,67653,16242,96645,21702,3963,90539,414,29800,63643,35725,57472,82123,42692,29658,23792,88712,94048,72536,4694,55441,66063,74156,14665,64337,51883,32936,80535,19069,64669,68604,97139,32455,36486,26065,29017,52387,49721,76589,14371,45400,49062,4341,68137,82928,49341,81159,99964,4350,49965,600,59796,62998,90201,63436,98883,96619,31207,81103,87269,2104,30540,91062,60149,35830,82729,58572,74948,5598,35571,73099,48593,67867,55951,34367,10157,94913,11288,63029,47910,30496,53095,63973,51777,9788,37699,16502,52307,79545,95820,64914,35473,17879,67487,35464,68987,19533,51679,11257,10260,82125,81134,55308,78754,1641,21898,83824,66200,61294,14498,56695,26982,76907,19017,70271,37978,44061,99886,8667,42242,17552,87888,34164,94130,42042,86613,74724,4825,44312,48562,97196,46688,92152,32088,38470,12449,22671,64564,3684,41005,43691,79416,30493,15394,15895,65089,61496,10530,30535,62556,63119,18356,7738,74616,78530,6297,53846,5034,4659,71262,32736,28476,38901,35885,25662,3233,49820,96324,76957,77875,87974,71633,48779,10281,67895,23597,37107,12887,20382,12860,33310,61532,35387,32306,50885,56945,90161,11856,75308,7692,84701,20198,36479,11335,87164,98426,47849,46560,25555,48204,4078,53210,48868,62728,79957,69444,20730,32663,27314,15645,1739,81191,23778,63237,22823,82368,87506,3242,51281,95272,35370,34176,3629,2717,28605,21804,64905,77811,19528,44311,32798,14225,85733,25596,16787,46761,14001,76687,87404,57658,75195,10699,88811,11049,13530,70255,99068,83066,58868,7992,46783,58340,59059,90538,70285,44965,20853,54249,36024,19468,42546,27056,16577,50957,19272,44897,65497,69293,2728,33534,16126,36026,1120,96927,74612,48767,12269,51901,73528,59801,93039,75487,1830,17948,81647,86104,29301,49027,5922,62670,99239,74759,30190,16748,71794,32537,16235,72008,62207,99225,99655,72570,33132,40965,11940,37188,68280,7986,10722,99787,75846,68480,15914,28521,44451,28823,87810,95300,1819,18809,24758,75650,6945,29982,2601,94797,40199,82800,25884,43,42664,64051,11660,31760,95901,19805,80767,85770,26425,11164,88545,8388,65372,40145,87255,42078,93136,31290,75793,44457,51216,10913,58837,36288,9053,60377,7180,95135,32363,32402,83739,531,11254,10112,75641,53762,71387,57392,51761,40825,9474,56073,47236,80607,65640,50600,61726,2025,69440,24023,46562,23637,73823,10520,47451,67149,21842,9128,64000,22281,74649,952,85115,94601,66097,87854,60176,10242,39232,64461,69917,21813,63021,7309,68045,58346,23838,15042,74924,88806,35574,61799,17973,23443,14652,32265,29994,60199,21807,91368,36217,94406,81189,4144,83654,49180,49146,62077,92186,51197,19996,91018,35848,71943,24170,12793,94886,78064,95281,7692,54421,86127,57008,78254,63926,96841,8116,46120,13243,91751,64503,23182,25477,11403,50851,85881,14862,98179,21286,47191,8590,79264,28377,64718,85571,85615,52891,45275,42244,51353,52884,6417,55792,14653,90064,33637,78526,45971,43752,28269,63651,62403,28396,75612,92330,47953,89214,75403,44644,88690,62427,67469,32970,49041,51432,54246,95292,60860,88358,68840,28084,70499,21635,62366,23656,90698,94517,87560,65245,33967,56945,36989,24624,61981,83709,53660,1640,71587,55541,69424,42841,52172,96607,42302,77229,91401,51802,57691,11191,76785,30305,30409,31768,39047,38066,94596,77708,9916,71192,96756,51083,21772,44648,13529,58812,59479,86272,291,92991,85759,34753,39252,81760,645,42088,96453,68252,62810,95935,15931,4207,96008,45369,76244,76959,27373,34729,9700,23753,55990,24560,37831,25725,29953,6107,7989,15390,18003,96366,25442,76100,97907,34400,62921,59716,47881,86451,95311,99565,19644,7306,51008,49824,92107,98438,93452,39531,53245,49663,46437,89745,34330,50338,55018,5703,25522,8584,30197,22346,34710,22573,60017,51229,12521,6631,82323,49560,55597,86697,5142,7996,17502,44642,29506,32855,2055,8999,76490,80483,87393,60873,45361,86821,30756,48086,32933,23555,33747,78076,25591,3766,5751,90623,34900,54592,49211,95173,85332,72220,4642,94344,78347,75334,35527,5144,50934,77228,3665,32488,18668,3847,84073,45799,43450,95332,95196,58803,94325,41988,74972,15043,76094,22116,16211,37243,84954,28766,85772,7298,12937,95233,91194,5521,63714,54992,25717,52709,61103,772,18029,66634,28652,39599,36634,65790,93736,75884,50375,27525,22833,93033,26432,35126,25998,45532,55052,29003,78023,18101,26249,10798,91368,56281,47948,36073,41671,23663,87248,71155,90502,95000,36963,82810,71968,51567,58087,75576,9928,5370,25505,90927,10738,42213,9070,34873,32836,40101,55052,6164,68942,89132,94008,55960,89225,11728,90307,21650,84542,57984,65785,42438,17681,29894,75446,82376,37509,70343,86666,57738,36051,38007,14979,89913,31720,77693,99353,82458,43270,87149,57749,51524,78537,75988,49797,22531,99610,10150,87576,42813,41800,36194,77799,49882,57629,83694,49060,78033,29034,51195,16401,82188,41066,91367,62061,7220,38608,24451,66087,33408,93960,25525,3382,84272,97627,50799,34815,91702,47252,90877,59152,75125,50319,64794,59887,6398,75152,97679,76433,166,81677,56971,52678,90635,38503,57418,67577,30014,86137,83428,32236,71322,37450,18883,45831,78826,16035,19113,38780,43068,20640,7522,95713,64252,69630,30210,43085,7705,23251,55954,6683,28192,3446,66018,92810,6058,31090,38554,23609,37486,78698,95697,61739,73597,93045,47975,92558,8690,76583,40299,92991,76612,29147,76519,5414,26060,42177,75450,52186,10555,6502,90234,71854,46910,41730,5082,31602,67183,80378,8634,72182,13451,43097,31615,71322,2147,22690,27928,69551,15294,54102,72962,88399,59671,85163,50661,85076,71714,78567,1763,30056,35957,69438,9632,64362,27846,74803,7228,91918,87952,1378,99014,88959,83946,26307,4992,67318,19127,31845,50535,11265,1849,59434,45352,18672,98910,11222,17628,16377,57771,67823,95304,86948,97395,9921,55441,39434,35604,28327,94744,80243,41996,82180,9587,91932,79827,18218,12242,7482,27660,95372,51535,75559,52186,68436,50772,48258,37295,72131,23529,87044,61284,12644,78791,74824,54056,17528,80919,42550,59210,16854,87051,67258,72111,28590,44810,75111,24366,99397,96550,87811,37550,8406,2904,83643,74614,75984,67992,5458,76067,32100,21433,37045,79895,89652,88165,86667,89048,36924,56078,61885,68461,10335,33618,93398,24724,33754,74747,67217,45849,13838,37029,54352,56016,62239,30134,85018,70756,74977,6654,484,21712,36870,44907,29778,56935,34652,74251,80796,12626,56245,97465,5750,95274,25619,71868,99422,9374,72790,21102,15376,15177,66718,62882,40028,3405,45196,54523,47415,29408,60340,77689,68535,57935,20841,6549,48266,31521,52881,29419,30190,90413,20476,22949,5031,40032,42957,10087,81982,83176,22415,68252,93806,8457,47148,92560,26448,53921,68514,60459,71738,45378,58030,88720,37856,42633,39204,21524,16347,13653,54265,39241,96794,96623,69829,31507,40636,2932,47512,35341,74183,60302,5572,99282,37511,94606,75932,97922,30727,1345,17225,87703,32007,63339,79037,64477,22806,29869,25066,56098,44862,84312,13669,59154,30844,92284,3122,8006,95932,40333,95854,46376,51157,46447,61066,57024,970,47945,78314,93399,17300,49757,26029,48676,40296,46674,98391,92207,41927,16840,71581,1176,2854,20559,56159,16122,95179,28461,66158,52993,34185,46105,7472,11539,60622,98306,38184,30089,41831,85798,81738,50150,34740,29261,80177,70744,36676,71324,59163,92079,61008,15854,39081,70835,13749,45630,67245,35290,14560,74477,65105,37475,1008,57972,81271,51678,78454,8043,16330,63904,29604,31089,38599,35223,77572,36705,41348,63504,4159,44637,1471,12601,61153,51302,87198,25858,76559,4037,28144,91650,49983,71137,4873,82708,51796,88867,37083,48062,89250,12767,49652,96743,79347,99940,73997,75717,73093,1408,98528,11067,8634,49212,16483,51028,31845,81629,32001,22272,12064,61662,76030,86697,97997,8951,52496,64980,4169,83271,82163,75283,91896,29003,36671,20768,10360,14269,58493,47941,93185,75875,43892,89344,63814,11754,25421,98767,89014,46308,28122,84882,34009,30857,89286,50094,15024,31354,25506,45398,15417,98569,2701,59169,30135,12165,14909,68062,29879,39387,5859,91574,91136,51529,73678,8333,21174,96913,83566,11795,18104,37812,75882,5805,45291,20543,97764,66325,66669,62933,5317,24670,84935,11391,80319,59696,48130,41029,80520,21661,41764,46597,95836,48825,63450,99426,14067,79400,84893,26138,9259,6065,42140,98587,53422,68008,59156,11303,18031,26364,2040,62647,75601,22893,81670,48965,33580,78897,71030,27204,32917,51594,80191,790,21886,28592,36669,35982,72067,7570,51794,21520,37909,77916,14791,43025,73834,93840,45384,55484,13631,4327,53066,2049,85668,84340,96561,45460,84487,93770,10542,49608,44401,75914,68345,73041,63943,95627,79185,13694,11385,8807,76291,74644,992,49485,38439,4435,67288,18567,1486,2294,80332,59137,58810,68510,38842,7238,19977,23337,49993,14191,95491,13935,54791,46736,2110,78214,86174,84690,38060,36863,53310,52301,60322,40434,30060,39114,7246,7019,88159,88912,48893,47896,56384,61183,14785,93441,5847,98561,44165,99695,58500,65824,27390,37136,91054,61272,58760,37549,59727,39713,842,2315,2590,27754,68299,56000,85742,56764,75219,62841,47159,86584,54146,10511,57772,43980,47276,5517,63177,53811,90684,17619,91363,98029,61007,56882,11928,97865,30652,66270,10486,77958,82379,65129,98314,37664,67043,84490,11748,24423,49274,93801,68466,76817,75089,30512,38469,80829,12650,8898,56482,61803,62852,2528,49398,16773,9928,66046,77560,77023,83916,86175,91828,79180,36637,29353,89786,14611,90726,83932,13874,21516,7310,78608,71848,81905,32063,95524,75691,86476,21675,86451,88942,34453,23185,43522,44382,42542,77126,72167,44127,47457,42149,63238,82371,99785,93516,63730,37408,63541,30818,1084,64004,55316,41268,24753,79800,79734,4090,90518,80151,43777,88839,27977,34650,61558,95838,99731,15559,93250,10527,81930,83469,97114,95100,70204,8734,11989,20666,42420,38557,29052,51023,90283,29116,56354,25199,65483,49665,27321,50074,72913,31311,55350,6659,83427,76987,90589,94049,31661,71141,92147,83576,10634,27718,89215,32371,74188,93287,67980,10307,10725,78465,87680,27219,57293,25285,98829,8333,81767,30769,9348,54984,72670,37638,20244,45008,41132,72006,31468,72576,57542,54816,731,803,16667,38924,23287,2100,49275,26909,89080,91040,75807,6096,65182,12407,28147,96688,46018,33143,49278,46545,11696,1050,17395,21857,35592,75421,31017,36803,86358,5143,34677,37250,76662,28391,60976,3685,21197,94655,14112,66735,79901,64665,22415,35028,78823,26645,43004,19604,20686,78413,10358,1665,19980,63954,82428,31207,23275,20419,52834,62904,4447,86880,65789,32590,56664,49741,91544,52781,38193,51329,94510,58917,67508,68000,53604,69329,4660,71992,74987,31424,496,27303,70997,14168,43087,34020,65950,72689,81581,27820,29376,54641,61734,61760,30366,39969,64442,46039,52859,5793,98933,98027,11041,86373,65578,59696,56463,54437,69829,72450,74038,84650,38422,60415,22800,72590,61706,62406,89073,73328,61867,70060,84702,92529,65810,75050,41014,10009,43588,1821,20387,40741,58526,3957,91635,41546,63559,32052,92829,53040,69826,38905,35763,25900,8154,73863,89963,18091,1871,32296,20944,65420,70216,68506,47364,21645,85651,50741,24799,36326,15495,35543,60046,88709,88559,65326,9178,24151,40835,47832,15020,45951,10798,59070,95276,99915,74512,22335,1244,51585,33488,55091,28837,96791,94098,42775,78623,65012,6394,93999,29599,72035,62263,55143,12679,53473,88142,14027,44109,63935,5881,2083,6549,57993,76823,12421,46055,78557,88855,87161,86937,65868,93874,91599,53256,66046,54033,85047,25676,61971,9130,18600,55451,71250,34611,38610,3524,56132,19936,51332,72018,68428,60423,8949,47851,8873,22199,10145,83780,14820,9492,69380,844,2749,36293,98230,8027,82828,80247,59386,99877,31564,75685,99375,10894,55591,84790,39550,76690,4735,71189,6585,76244,95697,88604,13492,7007,89063,88726,60078,75190,21826,47090,7807,67249,35176,3489,98183,5401,53069,14336,26051,79962,60913,18405,49651,94324,5688,24489,17752,54627,88913,39776,20890,85473,52101,71137,28500,55462,60678,47993,56646,51924,76838,35087,22098,52886,74367,26223,77641,6148,89242,35923,90818,40268,18596,34943,23690,335,77682,7744,94755,22600,99504,45227,55806,36334,15044,24470,96312,8749,83356,68663,95809,29369,50254,25099,80815,63919,1940,46807,6960,94657,45620,14319,79292,3957,93030,88044,44133,51072,44735,38855,34414,38161,73185,64769,27035,60999,80730,64944,75631,92217,65136,8758,15000,50512,59620,7333,94497,67908,27036,67638,86863,79031,78526,85186,36225,21241,55846,10327,54441,52576,63525,5289,48466,65624,62099,94355,63116,99778,36916,97954,53338,31746,38336,32944,58066,54785,48629,55997,33722,40786,68458,24737,19628,16188,31588,52192,49835,72601,50271,34075,96333,76129,65759,35595,27097,35533,28485,34706,89115,38720,60663,32109,81313,69475,60435,54816,65212,71911,91122,99706,72176,38829,61789,86281,5281,61955,45994,13677,1117,97012,4503,46018,12235,64609,74669,82311,94509,29139,64305,2339,35318,72208,41098,18392,38248,4520,39949,4183,87941,40755,20102,16899,54717,95629,91528,76137,62790,46169,95743,14307,38163,45167,70096,67117,72713,63830,46523,29876,89485,87870,35877,65606,70919,90555,27160,14320,16465,58703,87311,19354,28995,53169,81726,56244,90445,44069,48217,22402,76251,72774,47903,21739,75479,57694,85333,57349,28918,78893,37123,27539,70956,47806,53500,5731,62717,92608,355,73105,33730,67268,90750,64423,7297,22842,14317,82048,70765,63293,10569,30933,66084,44915,47862,28280,18299,68385,63608,45494,90031,55536,93313,47271,48567,99148,66084,2840,58801,23339,72516,57811,70076,94609,17169,71554,47891,79144,52366,44671,12454,50680,52600,83886,85224,15042,29580,77545,11903,32415,6803,83922,25698,86476,69480,66672,38246,70696,80779,47000,97246,36447,8549,80520,29609,74990,38025,8264,96887,85979,55534,75933,25729,18817,75751,63248,40308,60001,50850,16119,15932,79567,43670,28372,93474,42763,69060,76884,42767,39316,7605,74253,39803,81952,74191,66487,27334,78266,80208,69712,61398,85628,62656,9526,7314,17468,66027,99374,37872,81137,53544,70218,3707,92452,93206,42742,91266,30122,11042,15500,57316,64417,29079,27652,30590,18795,8766,43303,967,610,1919,95983,74484,67598,70750,26421,58502,80554,76116,44523,55540,29388,48871,47348,86543,9734,53035,28873,34774,70304,21469,24475,62,47420,94845,43295,79783,52439,22933,55053,47751,80233,93550,14371,85093,62471,39013,25284,28225,98117,32524,71391,38214,55386,27632,62963,63065,54351,12787,81335,59929,7433,49945,33036,67719,16235,41303,61360,72310,97457,21444,1478,86274,38105,3560,6666,73002,60750,17831,17880,81123,13300,67702,96648,19269,84551,95469,92130,93529,86738,92472,67210,50339,39354,11140,65589,16114,34730,36237,62141,1539,65141,50899,2133,43284,43683,89359,1438,88759,56707,2781,49485,90602,44315,77176,29470,66740,17192,33126,46186,99130,83050,5867,30878,89728,73979,51287,74634,65754,37205,48447,27083,27972,76092,72495,85552,65508,5627,93182,91324,18623,17233,13633,44300,56910,31418,1674,45081,54517,53601,81695,74398,86327,38387,48887,23803,39376,10636,39695,98672,32391,87864,42371,24818,62934,97818,59786,3401,56464,87528,42971,75312,74509,75680,98357,75855,50195,8881,34257,83278,58535,44156,52876,90623,96156,95011,12969,59319,40565,46418,85247,45118,82589,65289,97724,22198,77266,7338,21431,69644,38283,48628,78252,26027,8924,50716,62125,62423,78580,1963,52444,71976,77965,64411,64229,24971,78543,95574,23450,92411,42015,7526,77904,98207,14291,71912,54116,20332,35018,78771,48953,24701,38519,9544,1017,82013,54913,90166,21315,87432,81220,48885,75347,75738,81406,15203,99427,461,91628,61338,2942,24506,52331,5623,55213,51907,62386,68486,80689,15619,52137,95941,89489,24607,1972,42988,51597,65023,90998,39865,82518,44868,46376,47804,45796,69310,78076,47741,93509,34687,26073,95397,59719,33253,17437,19177,93807,67829,29273,33561,70743,85786,80159,89970,43546,55175,27499,89494,9547,22300,31120,37502,46536,9694,54479,28780,37467,36157,14004,13710,43140,66469,54384,10904,1087,27311,23026,99809,25910,58137,40428,47955,61364,923,14904,1878,87755,71153,29834,98137,19523,93866,39581,31468,37390,33252,46193,50754,87014,92002,93221,40363,41855,7523,5227,84288,71769,26134,21995,3644,80842,93458,24974,4225,78055,59516,30163,70178,22623,60386,26403,92257,42159,4802,70984,24706,56324,63680,15487,23520,51195,33352,23953,30625,40321,19116,62742,33480,17281,64755,86888,47654,51520,35791,21241,41141,4363,49481,36391,43479,45290,32978,49139,60182,29947,82538,35176,43557,60807,91317,27699,54693,89004,11043,89807,88186,31589,13725,90860,21135,72311,23572,87341,91010,85967,96418,7339,3160,76509,34204,64400,18077,47280,35447,81301,70948,28118,99137,87190,31607,68539,19118,62600,21689,68796,28769,45972,67599,61346,81700,82622,82855,74101,83131,92518,41427,3811,18816,56720,24898,3017,63573,74049,558,37256,89890,19289,15028,517,38579,42181,68537,86453,58057,82465,68692,421,66621,40398,49381,63169,42925,34491,80409,822,3917,98554,86512,37790,86565,18746,40600,9342,10012,87932,95392,88775,58140,59460,70047,80486,89045,15377,13968,64718,47547,25134,28627,92346,29617,60001,40105,18782,23475,45673,79961,34953,31133,81000,50113,258,56259,24256,18617,7500,29521,50079,17532,13039,30929,9948,91510,46738,60206,87011,76310,75749,840,22085,70137,33793,21242,1842,97505,43306,57276,42431,55288,51665,24486,72259,73664,74687,15414,16129,20875,90695,47704,9634,30015,56653,42046,27473,28522,24243,25504,92267,6610,18202,75446,41495,69551,1857,41982,69326,80567,95516,12770,27400,16003,32193,12976,64032,22535,32172,65381,4857,87349,52951,70811,29561,6551,24375,7496,79165,64512,10100,89442,36221,17398,45985,68535,56307,7858,93646,12859,93393,24629,13093,44568,53906,60781,2220,74677,34756,17380,72933,29257,49104,45536,33738,21770,20321,19132,26873,89666,29377,82955,24418,79863,33784,26538,22258,37355,37301,92682,83402,23965,78705,41481,72878,70118,25283,55578,95253,41525,2048,90483,92822,84790,61277,44929,87602,1219,98577,50619,53475,86477,51500,58094,86198,65240,74639,26070,98439,44635,71153,5251,4632,7997,74842,44459,76129,71359,19185,36857,41004,29102,144,67105,74824,22296,38093,16485,78796,73550,70873,32347,69929,45551,64782,70665,14207,96961,13186,76065,18207,29002,3508,72372,57238,38794,72490,98545,58768,21384,36909,39806,78768,91420,82344,71835,5563,27562,16141,57104,903,77935,42336,6721,41150,3367,96144,48617,52861,76609,83481,23466,46506,385,7044,63403,39646,54872,24636,95464,26644,36097,77703,51565,95800,709,48448,59935,16804,89763,52452,39096,21473,64365,50359,14809,78979,49423,66997,32837,23102,48255,39182,45939,23548,60428,74537,12225,5934,7959,92756,53781,15778,50880,38092,89448,90697,52198,97202,73688,51957,34367,30064,44657,51646,54686,23299,8948,14934,15395,5054,67869,98276,15736,18485,20721,43821,47903,36929,64217,47961,36526,18007,44000,77625,22246,36185,4163,61777,93906,3738,23744,57585,81047,88591,25340,40780,28634,64164,90333,97967,89299,81152,17642,5015,84945,34066,18467,60085,9113,6395,48226,2496,64331,17422,38660,89320,54503,61000,8038,20453,81420,22016,95473,99903,26594,79785,86528,96087,34867,59305,71622,17214,54650,71066,6188,49112,31114,88027,22095,12384,93309,44407,73541,83347,23943,5095,87434,88938,51411,46774,28240,29620,57687,12263,80308,6281,52819,48105,96910,27255,27004,12110,64528,49752,54622,42325,83367,66404,91099,11834,70639,82045,73098,54803,51864,38489,5289,38378,17227,35747,92848,72281,85002,67024,57796,93416,32093,31755,59475,36284,22947,16078,24659,1694,92421,33350,81207,66030,15588,98646,80666,31256,28091,70686,89849,1853,44285,32195,29179,89071,57271,95459,36463,85152,94842,13652,38760,20566,48431,50524,22156,15894,88351,11090,99475,66588,27922,64227,89378,53668,1535,94396,36776,56313,77254,4214,24111,53321,33255,52164,45847,39612,89227,50484,44341,51186,98788,67100,34309,87394,77035,72456,75214,42913,58551,47187,86160,13434,55502,19801,36249,18930,12885,34888,84869,96210,38585,61834,91017,48540,19555,41648,58485,4269,22278,35190,34663,28669,15599,79961,34666,53618,47070,84593,19665,38290,50176,90259,18522,50674,59083,6449,45229,64528,60035,84914,31152,99286,14045,30051,60696,91471,44272,56584,71776,75332,93230,96148,58362,67693,19988,23197,91341,97429,25505,17654,56105,93515,65514,6822,90505,47244,34630,32254,95193,94010,82820,68704,79882,17947,55948,81674,3683,68771,35770,47720,65432,94304,91609,77393,789,34467,45846,74522,46909,92938,98459,37540,42612,1182,51998,58639,42223,16263,27752,4763,34632,48576,66242,70802,75649,98615,60805,79821,61331,92863,81665,67747,92729,48091,9755,30674,8368,60637,14464,31781,89798,12611,77548,61836,77664,10557,86670,22359,70996,23723,96299,53742,20818,68898,81186,61945,70666,96666,88174,6919,41218,69996,25793,3424,4039,90198,17928,50710,40259,17602,87753,51326,34077,54717,31234,1314,8044,8142,85655,34138,67383,22186,97959,78925,83965,81930,50147,49946,17051,16370,4508,18715,37560,93320,90189,32711,95368,86914,64395,35442,45019,15829,46471,11398,24236,95766,41173,26443,61750,23246,38637,59269,76221,9470,2859,22775,16386,12733,37951,55569,84114,75836,52002,23272,76618,60943,22053,6895,81892,88508,538,71288,62258,29172,93444,503,64973,67949,83561,58885,5912,58547,68329,86815,82657,12342,31156,68229,86656,21281,67478,13406,639,96949,42439,84978,87112,19005,65729,57721,96488,25421,30943,43399,49304,44186,81787,30792,75981,61582,35481,88004,29691,45661,14946,49235,23185,95210,15641,61462,78769,64289,60384,97764,22174,20316,76042,53550,95629,29739,59671,29518,13275,29451,88504,70907,32861,34443,68129,76444,71732,52548,6255,12368,52201,25707,45678,67013,21679,93816,89334,59632,56303,82018,2826,73535,23310,45205,85317,18034,47032,64542,58423,36332,96143,79953,34517,67186,85667,59851,90832,37036,66261,54735,93787,6255,55409,54875,89162,18286,50431,73924,98082,3639,51574,10099,36181,72080,14972,94486,3903,85813,49872,22037,79584,44051,72292,75025,83777,25101,28159,90970,73221,25931,2953,97480,65912,11153,42053,34989,94956,33476,16184,15012,38156,15878,79802,16350,72772,92107,86702,4573,60419,86608,46798,71144,75787,77536,30767,27699,54682,27265,55128,58324,51798,83652,9327,28011,66745,52268,18545,69079,18010,14917,71167,18966,18850,22990,78266,62584,36589,25547,73942,40367,97312,1485,9968,19141,31670,52749,45993,87137,44321,81288,87383,26725,29469,16261,76821,38884,48029,80025,2889,41941,28140,81481,49132,43769,50076,3621,70470,91436,29011,8439,50322,35193,14705,16855,61456,4737,85845,33884,26306,84817,28580,80037,48410,94581,53769,58740,65578,20432,25477,36573,57584,25710,44501,38213,26389,62195,54967,61172,55297,38171,19530,96803,44945,55748,39244,3480,18664,16132,77875,15493,87497,5728,87236,86888,66032,18221,20078,63368,34230,38198,60129,47290,47538,10420,95057,70956,7839,45495,7468,21556,21174,67507,61474,67522,84670,92035,17946,20480,64735,34086,20246,29615,51337,84561,54053,45977,99067,61204,99851,13101,94686,35383,64692,37285,22979,59574,1057,65979,38010,72096,94938,55947,85227,35425,32728,44220,61399,72310,37046,44330,43958,99988,95337,77908,69120,26897,91884,17456,88994,68639,93835,59950,91913,60284,34891,72903,27361,90711,86505,54610,37093,61286,5746,28538,57449,75990,1457,48139,24361,3022,65846,22869,82181,8917,77396,88776,70195,55406,92765,37749,36605,66501,10294,88362,8723,18735,5816,28227,30279,80971,12634,82860,61979,31908,41871,69296,29851,13168,16832,74024,97400,33754,25560,54303,32221,27715,79509,99497,35499,81028,3014,4802,3673,85949,68234,3596,95561,51553,33270,76587,85375,97660,37379,6057,92288,86051,56496,71711,90630,97638,24746,90995,21256,47162,83167,91210,44274,38047,25578,63352,96098,99173,73330,88338,39607,12637,25619,45103,25286,36972,115,7058,13251,53820,99849,8470,41411,17744,16608,15554,63324,68611,8543,68429,20851,73922,70250,69538,61326,4471,47287,81757,56715,10910,33888,65115,33115,61038,32601,24906,72955,18091,47622,65967,9377,88792,29799,47941,92541,46642,90595,14630,70974,40648,54737,26838,97579,32665,26854,62617,39560,67504,6081,61389,44272,69155,94438,79172,88862,73754,9739,90978,20616,55311,31819,23395,77005,73785,82105,25513,59711,76722,60844,89529,25285,15473,43738,13752,46584,94925,70326,60160,93771,61687,40133,96313,81420,49868,69404,27092,29132,45835,51222,15621,87085,3781,4834,64685,85073,42441,96233,80059,73825,79972,61339,65387,40784,18791,65568,4589,99050,75073,89165,72261,67771,58654,36322,75116,85077,48240,27978,68248,20486,74097,53090,8844,82733,15835,21248,6940,51122,46401,80715,7911,93697,5085,40256,94631,73982,62106,60594,28545,89484,45265,61870,58411,29803,35196,27200,13033,89963,99886,69222,60062,25424,31435,66461,56745,89276,68433,69441,40531,49199,35871,22620,7488,42085,11147,47566,4738,87535,29535,85239,19463,48004,75381,787,81488,92951,66328,12972,9076,97131,27037,22162,18256,79047,66142,75750,84885,64553,15609,27939,95602,42775,65193,22027,48927,66726,26331,47627,70991,39401,89625,2715,91718,17620,97964,20958,86774,60547,43357,8460,28163,47511,9731,70889,2108,90711,26223,1893,46671,72316,65905,46761,33569,42648,23405,51498,68710,26372,31586,56784,14226,97001,32171,98738,41093,96522,98166,33968,5948,96583,16944,15083,8247,20435,82001,4653,24705,70694,8716,30569,36734,37015,84814,53768,63628,89858,89811,40550,89294,1822,69332,5968,23592,76382,30029,22256,70662,5363,28686,66792,86097,21124,65177,17824,92445,57178,53075,92965,88196,81851,34002,65423,29307,23580,22226,86010,84257,63594,14546,85128,63737,31961,77148,28293,4304,6376,25937,51168,41661,79548,49711,5641,43717,30713,86633,7208,86166,9495,53558,85688,44047,16278,45127,6290,41604,42209,64865,46075,49721,14107,24144,82077,45333,74795,46465,71651,50394,17755,44327,83048,49376,86515,93862,64815,43718,43785,18443,26271,39243,13150,6629,38144,78296,96969,32115,52415,22198,78152,13729,83434,61576,20618,52104,88618,82235,93481,6257,36312,42466,57401,28144,50868,24017,68022,56129,80546,3428,71074,79363,42533,53058,86455,24230,61204,21804,4478,81286,30677,64405,46496,86538,792,85170,74228,94454,6815,37086,67370,31732,37523,70453,27457,663,63722,56594,7432,8817,29846,21593,11027,37838,44971,12672,53806,28259,96386,85511,28580,49572,48813,44654,71953,45168,85431,91153,85831,90322,93051,31648,28037,78026,93102,81367,49492,52301,72544,49805,21998,41486,74357,32388,70212,5068,65994,43957,94214,96760,15960,20690,44928,63833,73639,85876,93638,48098,65564,21973,19021,27496,92501,16433,20314,38889,36040,52053,53660,52440,60836,93905,80150,25893,29196,84414,8726,53074,28412,95719,14846,35115,48036,4199,16716,45173,34271,45875,94865,27847,91677,83387,48004,72999,98605,65327,88334,30383,52094,86947,92860,86238,60387,67592,43777,5932,56807,44709,10610,57768,17410,46834,49555,72236,26668,48738,21338,58260,50353,30709,57920,93419,42879,60961,40506,28646,37537,95224,86555,99568,42388,40825,81895,16448,91999,63882,35512,12575,85802,27743,79255,67013,77522,38370,82418,81756,66949,38100,2049,85637,85273,33072,43857,57743,58249,61575,65686,11616,77683,10652,15806,58196,11010,66561,61636,70234,31205,40989,31022,3819,54814,49431,57815,93697,34601,30721,96269,28219,65112,87425,44623,27042,24392,95669,97275,90114,93186,79925,27044,60020,64109,73401,84313,41403,77609,87877,88179,50986,98996,98204,76288,29617,81343,6130,74615,33792,42796,85733,46237,38274,23621,28458,79017,23722,78261,99598,76109,93635,754,90033,20334,63462,78036,97156,93739,91398,14993,97101,47003,75139,77542,76775,29893,21831,55603,78646,13561,9426,56519,73834,58279,96864,1276,19798,6027,7752,10849,77725,6410,7656,38029,61742,16468,18609,21312,67121,50218,66156,11726,77916,92137,33987,50913,85785,30305,9164,59372,61240,9554,36948,27422,6165,52716,68419,88307,82152,48950,76352,92760,53068,62136,35221,97449,2227,69436,9757,25886,84653,393,73110,59726,53120,10313,80502,70806,53028,88165,57107,9835,15625,68896,19991,26368,91703,92767,43047,6470,58594,30245,91197,79462,2171,69931,95505,63162,22495,49204,14395,88278,36885,92446,27841,66865,57375,10130,41146,47262,895,3570,32880,28437,49980,14699,67544,90403,19396,58088,7726,34150,99813,73192,2743,14502,43486,38915,1254,92371,28892,99637,33777,29054,91361,62134,37770,94563,34961,36215,52694,64394,47244,8357,95368,34728,22942,57303,37015,94731,65290,43300,42492,56451,74372,28552,99535,57737,50752,15467,61232,21684,39604,21397,48480,77299,15661,43830,10850,20387,62534,8379,24042,21105,31287,33392,10070,65209,72621,89675,2296,49685,24655,81531,41636,40304,3956,26228,82528,38550,91371,63010,7657,98458,26161,79863,98981,80086,22029,6552,89255,25650,96877,85781,23033,96816,64464,853,89037,17183,70598,7830,46834,22697,69120,92948,59892,34553,23632,51926,64403,34077,89791,66797,48645,37154,79945,38035,91211,36952,37006,14999,8075,8005,47652,56087,88264,42182,6322,41514,55810,17603,928,56232,81692,85278,28795,58294,83627,95061,67100,48812,93881,72426,15881,63695,45653,677,3689,14447,27134,59372,96057,15588,79005,19050,75158,49630,65910,94821,65399,37032,35369,16914,64147,98212,88622,84984,99404,17419,27036,34806,76946,44174,5042,60903,98312,96972,15915,6726,27983,66076,60304,55226,63198,47490,99037,26916,13084,78570,71535,20033,25095,87232,69067,7907,6276,11372,88123,42388,74414,92821,53332,98976,39897,1085,91640,39233,62936,96081,59889,59145,52777,96253,76435,38277,75628,78663,84152,3872,16259,1053,76913,76523,94557,2390,54576,69564,72822,7998,32516,73061,2162,38177,20935,65069,47076,95056,6421,57782,96165,81443,13696,4267,13887,87573,98968,62642,13356,66886,28009,38919,33411,10375,21840,7124,84555,20521,10825,35905,87785,80470,24005,34534,67987,11879,54668,67989,79253,15705,85438,80782,33347,94239,26562,12260,74498,59803,19637,82264,93829,45797,85641,75391,4920,49138,50954,54520,8364,49663,67947,89838,57659,71672,57744,98280,1353,75569,41945,50146,17104,93410,97366,14551,72150,51185,63258,83482,41665,52795,54034,35385,91564,35927,82141,73547,85566,48412,75548,1971,7637,35162,82212,82003,438,70402,89904,46679,7985,17677,53963,36551,76458,50972,17821,60716,10938,24327,31543,79820,7821,34397,22178,54019,82775,80737,46357,98176,92293,91896,60390,39029,3292,51958,75978,74623,99620,31783,30742,94995,26993,1951,91894,34918,68557,80277,28677,94439,12147,45819,34605,81044,17280,33359,54076,98424,15000,7649,69584,31187,76954,5075,35538,52268,71383,21867,2624,10351,83210,22672,62663,38350,13003,40996,58076,60754,85305,43952,42378,67636,90671,37714,48501,66151,57739,97245,20299,16575,1736,14085,89252,9214,24070,69383,33154,41001,43984,55871,36497,6116,27723,92068,83289,23691,43286,94810,52205,87465,9527,2028,51261,37200,27235,66743,24602,19716,76782,75347,87538,28637,42059,78499,97619,86207,73582,61365,49324,58008,35066,21400,87849,71973,87190,66529,73525,46768,49885,94314,92525,21449,50220,63599,1865,18224,6775,24106,17029,63233,23389,26588,99176,36438,65262,96415,75464,21036,68604,16830,30872,75254,91377,34619,42784,54948,47161,70575,90624,74104,76746,89893,62022,2193,2805,63485,94253,62227,81818,30252,35101,11473,14430,52438,80856,57940,477,41462,50776,90081,28179,20020,87179,74613,68319,77709,28194,7888,3708,72102,86257,89970,61847,24927,79612,27373,34384,63887,6326,60370,60863,64669,20771,53823,26181,54821,71042,86713,71308,51407,82448,24839,45034,17763,26997,63593,30829,41158,1702,83308,67432,52791,49575,68353,44324,34329,96335,2953,93995,81050,43141,71686,21755,20665,51068,60635,10816,19028,76589,76408,15458,39190,68964,74514,8328,58637,20264,16053,79256,91042,66606,52237,92462,3518,75279,69934,96604,68079,16547,18279,47861,36927,11225,76297,50067,85156,65543,14578,37921,21623,53309,50228,29359,28964,82098,93617,51413,57130,84926,37935,242,61313,11818,48068,30462,44764,56684,64057,81531,39757,44106,46176,39649,35829,17893,53638,2479,43449,18703,66983,60992,63358,11537,35401,37798,17124,25595,54565,24583,82799,98747,57976,42599,71082,76804,35406,9635,72029,3787,75705,34495,82,53572,68052,75719,66098,95565,85683,95155,9030,57460,19187,8939,27079,46699,22656,88551,58345,18873,85278,92831,74428,36131,43438,18189,66903,41529,3912,38728,26234,86331,57468,70563,35446,86392,23988,35384,26755,51080,85162,17124,78346,23568,28889,2594,60639,94873,50690,72009,76618,5706,31776,58600,79195,29933,40829,27803,90063,41397,87154,36031,89138,1875,86521,16606,91447,72091,87842,6158,79170,40016,48790,68659,10592,81064,41489,96210,84805,13363,15646,65805,1283,87922,45776,9540,16825,58280,41623,12039,68862,7189,6454,83387,3748,68857,86591,68428,21425,74470,67343,44013,23715,66002,35484,24653,32496,68711,46441,43967,26173,86261,5582,4446,28066,84088,97293,91259,68753,56385,72986,27181,35901,30012,39736,5192,19724,44664,74934,72896,60001,62789,29187,58634,1428,5039,69588,23001,68103,77442,58600,91479,75074,55013,59945,73941,5113,13208,12233,5079,92285,53364,13498,46079,70366,51231,15370,72399,63794,68694,34308,35069,21606,7964,49141,23668,20673,54813,69097,77978,93562,52794,24567,92291,68484,73987,54043,31431,44025,3408,34994,30790,59757,34052,33874,84027,65316,77419,31027,31524,35164,30426,9940,50324,24021,3758,87134,11983,8798,9012,98878,18617,16910,22357,54040,49391,97939,91038,8520,49813,55897,25633,16062,74401,22696,25822,62687,49643,19962,20293,97518,58650,25924,62484,31507,61490,36909,12970,87359,55922,88799,56644,48892,52089,82857,48213,76160,81705,42439,53079,23825,87377,12345,52336,24612,40898,978,10395,77093,20746,56958,61658,7649,38427,66463,58708,60101,40971,55352,38628,3368,32551,80973,6353,37418,52080,2572,4373,20857,15611,26362,36638,39689,82427,31549,41167,86098,31995,96992,60664,18551,45235,64685,43345,30065,68081,95875,17212,60206,97881,98387,20179,48172,73919,29588,35732,39277,72175,8467,79226,25202,1432,2373,3435,19591,72916,89286,43668,44860,68889,34796,2506,33546,66971,64533,82157,28097,86414,57374,8458,96670,10167,32536,54683,69337,2309,54535,65647,39050,84230,33983,2975,64750,54950,59334,80942,60240,41069,54961,38965,51715,40013,24280,1599,39313,76653,3191,9810,3613,27810,18698,68321,56676,81743,20349,43001,49082,90495,27993,59543,9305,41754,18376,79,9891,23904,55216,67950,26039,83020,52649,92455,76558,73791,50325,75240,14560,87698,69926,37868,65860,1238,17526,16151,96717,24614,93933,60992,29375,46990,76084,47770,13820,68292,36499,66698,7196,79494,75005,65138,8563,3431,47125,39500,45959,36393,86963,29159,15188,37117,38876,47693,25320,94258,31881,97844,14566,66012,53491,55696,62036,26306,5540,76894,35802,70795,53592,73129,85765,32887,13616,30635,11028,35129,54901,94121,5757,54485,36539,19336,15016,11400,36328,5380,12550,2020,75548,53909,46253,80515,90852,66533,83829,64205,55358,84015,31111,78008,5063,91252,88576,76721,83804,60593,57766,83732,80260,82684,8666,62987,93867,38821,71503,97390,33005,1704,22033,81274,18477,12529,88032,47185,38013,71491,16560,37952,73463,96083,6484,3843,1274,46968,28828,51608,49068,94747,28699,97276,76295,2596,26862,77824,35396,29544,16469,58163,61357,17054,81024,29369,32196,7633,43358,31693,40670,58318,92180,51571,18364,54216,22758,35759,57328,97645,71296,37635,81568,46985,18809,60847,30938,5994,89592,93683,33365,19137,71821,33906,57835,11383,43402,88261,60222,21959,94857,93446,56752,20712,2877,46098,85821,63012,23091,48143,47852,34552,38672,70875,45032,60912,22609,16209,78001,8436,45761,6763,94965,82747,90274,67801,30189,39142,8511,73512,13473,55124,1300,17721,79961,79515,76175,34837,60498,64872,86183,40687,86783,10309,42917,84884,2665,90420,43622,6431,33207,22594,51536,62533,26501,29855,21073,56896,49741,89226,65015,28298,90671,16683,19578,72789,88300,28903,75035,63608,92628,39310,4505,1768,32154,91322,41606,77209,50064,5251,28847,45520,55228,16947,82944,28482,22549,16090,716,27989,68679,49914,59737,2413,23760,44206,51668,92046,17618,7578,22946,96007,99672,27275,87513,96826,15879,35227,19277,889,73121,21564,28235,13043,31717,99467,73466,91875,80118,80047,68676,38508,62338,98809,91516,56270,48312,46336,16612,81142,60134,94958,54031,23659,92977,80461,89878,81744,98535,93331,93778,80962,30939,57503,79162,73766,90347,26316,76636,82508,37811,5102,8126,2384,96486,17782,30048,89905,98938,70859,47488,50111,87981,32368,88136,1469,29439,35631,64706,41223,49152,38053,47616,55967,63740,13762,15899,22272,34844,35533,53641,20459,39980,6231,11659,40937,19611,32912,59736,96986,29697,97767,13381,70497,1737,69237,30937,7877,88162,13928,41759,52169,49996,15368,84302,44448,25775,79152,4089,52598,6022,5729,85916,88846,25896,41822,72014,58750,80201,79428,48537,43810,59511,57332,66357,57485,3961,34280,99027,30113,72119,45191,30680,72063,26351,22243,9701,36458,43236,61168,215,52859,67817,39776,12741,31575,43899,50497,97794,44549,69036,91648,41812,73311,42567,73164,13435,77030,97727,31699,70024,74452,34809,17277,49215,52347,1312,9084,38380,10063,97161,41553,36076,24882,18327,73501,93842,76099,90563,12925,54192,97083,86468,17924,81169,34064,63735,30280,13560,77984,10162,62367,57662,1463,31921,50369,76435,76796,75561,7175,24954,72846,31352,56868,28256,28829,25842,9373,96986,81172,74856,38636,28712,76003,34708,60582,48315,34287,58974,68175,99577,49227,40979,70024,11889,86270,97993,96302,30958,24905,32158,81118,20433,28413,85279,4053,12601,52829,89880,75199,10580,9597,7302,77844,21895,77738,35112,40863,33903,20846,60742,98882,25201,1796,36011,12467,43970,3799,48071,62871,74175,60260,66325,6277,53572,67891,51990,71002,3691,7608,27225,7812,81267,25988,14134,58257,63035,36379,70464,88863,31378,83259,68409,50041,36992,76012,85751,57738,76577,39036,4370,63153,38469,43923,40231,71219,37217,86438,61028,92120,79308,46114,82959,61766,76526,19517,76464,46899,50910,49553,52262,58478,55823,82699,43663,32966,71325,73610,48881,5323,18894,22280,47936,89820,80440,72808,62777,5151,99655,24745,86332,28896,89915,8152,66500,43023,72267,51673,94435,36920,19499,29303,13006,67343,87813,6000,30925,35711,76366,14867,810,32336,66707,89397,95301,14457,59125,43059,94379,30371,40958,35538,79154,75466,93123,90006,12634,67649,65432,29012,76385,59419,28703,77971,23478,61772,42256,44657,2755,41137,59043,20735,7212,64715,27511,67074,148,11879,39225,38430,76757,39699,14333,75085,25965,89180,13169,39073,67553,45500,11588,915,53008,20255,80075,89071,35031,6704,62245,98836,30263,69977,57018,19964,22556,73411,70599,83070,79971,9446,19323,43668,87720,98923,32469,19697,31370,46171,25384,73490,99889,88920,87529,82336,16511,61868,57537,73171,46874,639,37903,6370,78523,48902,35659,81233,13643,95580,2164,1477,67731,61379,85109,82883,20947,74244,98886,7235,26011,21917,65668,26762,36747,46427,78873,1564,84776,50092,93102,8773,98353,15585,50231,96770,26977,3590,10017,70280,8145,80776,65396,82965,88521,48079,87604,82936,90775,84709,64279,3608,99484,96812,64962,17394,24746,61406,92657,72967,90520,85971,57602,18189,86244,61992,39959,70227,14850,76790,91792,32034,68133,62139,65580,70043,61224,441,46378,61810,61985,79661,7871,94287,58246,86727,8723,43515,16046,55802,94936,94756,95457,42581,76406,68420,7029,78703,1387,1611,11558,71391,61313,97734,88619,52589,20192,97310,25171,49171,77778,41997,4586,41174,43757,798,8523,98582,21392,2511,79392,38809,73383,71732,29453,26838,70142,97040,24188,47887,1241,69483,12119,18485,64504,17069,21086,66019,33999,26707,91807,99102,48148,88870,73598,11498,52251,22234,64227,10910,75870,35654,36141,40563,24883,63042,54693,66321,20424,63069,60481,34984,22513,10093,57561,70435,34862,15301,22026,63482,99154,7777,21343,28513,52052,74064,13843,45500,36237,1754,79858,79423,27992,97729,21304,70833,68133,54934,54834,21086,60572,22852,15235,53646,33313,96385,80336,18943,40424,75393,26475,24385,20297,62911,24425,13442,15495,63859,89724,88104,2514,18088,8420,67576,75993,51662,69575,2713,81238,58509,49171,20483,91335,30945,6626,55680,80717,42003,74728,38114,55745,45143,46547,42680,64649,97607,88788,77003,24150,32551,40012,76732,68144,2045,84328,2141,44990,88151,26372,81312,64311,32476,31795,24971,21612,65983,38969,45986,9611,30293,92260,52522,58870,69308,94971,48057,37113,35725,30917,63705,76576,838,57635,68748,91800,78010,31320,53765,96447,70295,83868,57445,27069,30905,35753,12936,34179,81569,94998,22501,6542,68307,62112,30282,53302,46735,33624,52131,80368,79736,72710,38765,62444,99196,94457,93898,30116,30452,95367,42541,62651,3222,42028,46328,1429,75984,22206,92507,76407,82148,53154,41141,68566,65809,36524,1107,14980,12489,47065,19638,99972,95979,43135,12427,65756,56257,91067,31752,19030,95430,2581,68574,6186,28718,94642,11266,79110,55768,94595,38371,75987,23884,29871,5738,97090,39276,61208,99384,64248,44985,41077,64626,14454,24915,4891,89278,93073,12190,31564,14142,80134,77090,42128,67545,4401,44855,40364,72344,74228,46936,37795,53593,81652,40545,46859,82987,16729,40901,70760,32232,62831,98111,66193,71642,30413,16380,6071,42562,26731,57080,23341,52609,52023,89176,74136,91281,58887,50623,18744,40122,10892,62546,82278,56427,28901,94377,23391,42384,19146,12604,9069,72575,35804,58363,66239,41930,42620,89841,56818,13500,3071,94303,1871,90841,46641,21531,62606,13319,29948,15556,71265,74323,35806,24785,93273,92138,30719,51982,93584,21169,31902,65027,74728,77206,18568,26971,51862,64616,59110,19646,30987,35603,15656,28909,60490,82114,30629,31599,33325,59473,96074,74359,27376,67526,55861,62726,84927,69815,93303,85203,48691,14266,12303,81542,91440,29851,28821,27026,99073,12903,51283,45280,92805,83992,43495,81001,5185,91735,31672,60933,56769,63401,38414,46544,15528,53856,739,35081,59463,24187,56782,96996,4381,89225,66253,47258,3435,9240,63528,35613,72774,65263,28999,6621,48531,49711,4266,24111,34380,24484,69849,76695,56021,47168,50246,81052,99213,42678,10507,77956,71342,2444,60939,72315,93026,26163,92091,3019,95875,82170,20901,40938,75301,51626,40680,4190,23119,39045,32542,48582,43717,77052,13978,38162,39676,26820,71454,25885,37992,77286,48214,77602,16423,76045,35938,53985,80985,82709,49449,24410,40266,21571,47364,24457,19952,24572,98404,84409,61871,97836,83006,49942,55843,15486,62963,88232,59752,42941,47997,22734,73535,18595,37489,68173,46120,77544,18042,43586,10891,83938,53095,25763,64868,49577,9530,68004,29528,55524,28003,49849,57106,60801,58682,42290,75197,77629,52147,69921,94605,16226,16384,26608,40657,53833,25143,54475,6567,62400,90338,27328,68935,37320,91779,89161,50105,5586,91171,85920,59864,55939,44161,94492,99813,25846,64151,96671,67793,560,84652,67875,56829,28047,13146,50466,3348,30232,68759,59724,2776,95795,48459,26932,77149,72656,72086,18436,48976,39331,15193,82185,48367,23497,50512,63978,56316,53384,83779,4451,66007,73040,87734,74869,26178,26015,9308,34838,15814,13720,49297,98300,87798,64452,91307,75511,10698,7024,87277,18180,32462,28946,90609,32543,87550,13295,64741,40862,69931,90651,84935,65705,98358,12947,94126,83312,7468,54551,69860,42463,8509,72610,8687,73496,76878,13449,36776,18442,40157,34715,11143,97747,59942,24030,84508,91631,23565,34037,68673,54867,87627,21021,46217,2588,44300,69723,48385,1751,13489,10450,38235,77913,99169,86296,12427,279,86625,8036,62473,39254,98799,42179,16849,253,74596,13716,19032,25113,79743,69227,83379,18138,11688,38325,10673,97718,14001,51810,38245,96375,72917,23448,45778,32222,28851,78939,37185,53037,99163,20453,71443,10498,74885,47965,20781,56587,23822,19734,93345,66802,5126,23359,69270,85498,76369,46166,64024,57553,53131,79099,50959,57520,63222,61788,46215,52515,22966,78163,83390,38339,51295,41745,82889,69634,28942,67661,51396,64406,4642,14483,30609,793,48000,93108,51197,39697,49563,82235,37887,771,72646,60363,54650,91170,68580,62789,75136,36641,77312,98744,12835,92683,48664,18579,47897,19903,36051,3839,43070,92148,34112,64092,49955,68592,54436,63524,68543,1673,59453,67629,37998,71647,3575,95704,4657,35464,62781,88408,34456,52794,69114,51301,11272,5255,4912,15059,90157,56211,53134,60991,54943,8030,44735,96488,63453,1243,91820,29219,50327,65799,46178,81164,97433,78437,76803,3992,74884,2198,17143,5810,1895,84150,93054,75989,76012,65680,5839,99545,71689,16004,11236,85476,14768,34052,4869,94465,98090,76458,97392,40562,15300,60139,38490,58696,54832,56751,27858,75308,14144,43331,33417,92932,65449,98491,22311,1190,28518,36778,98565,56468,83560,55152,32814,30456,87759,25005,64136,13746,42740,747,51776,74872,97041,31705,55418,17435,57623,57933,26694,48384,27514,42484,1699,69051,82862,42834,94591,27203,52008,52315,5690,23144,61610,48821,74017,45842,70438,72471,23837,26053,20135,16543,77521,32603,94054,56709,32923,5260,90240,62443,32479,13044,82675,31452,83345,50351,66100,63062,23169,34938,54050,39759,64454,51596,27176,17358,91975,93234,9484,33829,32356,87171,83841,34336,62633,58540,44869,75813,75562,75038,27351,18235,73378,37648,41264,31698,18873,30486,90820,48554,32916,19605,54160,68034,90894,95364,52812,77167,37085,85861,45580,86258,5574,30018,40227,89798,9110,87992,28139,54390,33146,83940,12078,4132,51337,21531,15220,20867,60878,86150,30847,1810,21340,49407,96399,20274,69012,21327,53014,16587,70291,53525,82258,5740,72279,82707,95441,25915,6479,17979,87733,67773,2402,17756,59220,18210,71872,72444,48133,24282,31944,7643,17645,33080,44621,49230,86971,91573,64924,46515,99939,96775,5376,32537,79750,71066,44576,11613,27381,113,30329,3426,82839,11509,53632,40212,83475,91174,98852,8999,21590,31452,7547,54435,24789,79999,28641,9334,56824,11747,66032,99931,64131,77579,76240,80668,73837,92840,13293,89443,82669,16388,65847,78354,63062,36617,82372,67286,52663,24739,34282,88106,86524,37575,23974,35734,77440,52209,5026,19049,49240,93080,45175,9358,80244,68423,29192,17079,19691,67480,68400,88300,98620,82437,56354,2069,68515,9836,86056,66526,65951,55005,23094,57417,19560,10040,11226,16055,86813,991,72176,25459,32441,3080,49794,13187,37762,4182,40230,87272,60728,56223,44409,97749,50219,91782,76840,30360,54924,98885,65673,81366,57072,40841,82926,32766,4366,79937,50932,45779,9654,13893,81303,17101,37182,62237,16089,97223,96723,46062,57328,53026,22452,89133,90793,67883,22092,30905,32498,11683,43723,82710,52425,80441,22550,77260,58908,612,37997,58551,59259,16729,32713,34360,47465,32650,19347,66772,8183,56510,28442,7477,67724,7339,31306,94098,67389,77392,5477,11371,82258,8356,97151,86745,59394,31903,74921,33801,3454,45480,62243,78875,94818,42728,82211,6363,85602,94614,47555,36393,82280,82139,81233,4934,90197,14372,58517,50840,64813,26627,20201,26963,87327,42749,18348,43161,58196,2740,20957,17903,81036,2401,19980,62111,91583,65170,58319,44026,71568,68026,15745,87049,75824,73074,71131,33903,92364,74387,88945,69914,49868,55667,61647,35804,84720,68479,76458,76124,80643,83092,64890,63290,97981,34354,36514,9170,16789,83587,94629,26256,28171,44131,80786,28682,21660,72958,97619,69704,32954,13692,14929,96717,35956,87385,72731,67493,85795,66596,56721,12042,45405,35564,36629,43345,57245,34710,25931,17182,53854,11211,42623,16373,36207,49082,25067,87985,87196,31939,84343,93381,29099,99579,55139,40486,78485,95517,40873,55228,99791,66778,35575,14828,9667,69547,44992,9494,38206,54668,22443,20996,10282,55546,81152,6737,70490,77632,44097,56150,38561,93478,44841,42582,48620,80267,98416,28308,95283,97724,19969,92937,82360,93523,80750,46146,45792,40530,55918,54579,1448,55702,36736,59685,50575,23930,50902,88378,60895,51819,59102,61629,29767,6174,73264,87439,27307,49843,72627,84120,12002,73663,77365,17411,9107,37335,76368,50671,42979,74421,95698,1241,18542,87000,37318,68051,54142,54102,13872,45626,78386,4665,54625,67882,16866,60571,60098,31446,11210,38206,38511,32712,32538,8049,65830,15425,74117,50924,73041,66337,33926,16859,79194,15296,26835,87903,56869,93126,98213,69771,37843,75737,46058,88863,41120,96133,97113,50983,32885,37339,23920,26004,8523,28736,34432,58726,20527,55873,13498,70389,62965,59596,46485,7534,63062,44117,9234,15353,23584,35679,65744,61182,5852,33523,75166,10467,42552,73123,73125,62305,21951,77973,58857,84577,90685,10703,89283,49728,80987,46894,53914,61416,80024,85669,80328,79502,23974,80012,98993,96325,17524,16719,78333,90677,50667,985,26164,87590,8995,3869,42044,81832,51121,12201,96552,40900,57433,79995,8162,89352,38079,18004,86118,90463,24880,73803,8603,83499,61842,48602,9493,5279,51961,68997,54122,23271,14255,81933,94738,34089,54228,69408,9690,36073,53450,85756,46935,67524,39466,4861,12015,13218,5987,27221,63488,20960,15079,37520,4597,37262,28042,22199,89032,66591,79730,53512,90717,82208,32258");
        assertEquals(list, new MostFrequentSubtreeSum(root).execute());
    }

    @Test
    public void flattenToLinkedList() {
        TreeNode root0 = new TreeNode(1);
        FlattenToLinkedList.flatten(root0);
        assertEquals(new TreeNode(1), root0);
        FlattenToLinkedList.flatten(root);
        root0 = new TreeNode("0, null, -2, null, -4, null, -6, null, -7, null, -5, null, -3, null, -1, null, 2, null, 1, null, 4, null, 3, null, 5, null, 7, null, 6");
        assertEquals(root0, root);
        FlattenToLinkedList.flatten(root1);
        root0 = new TreeNode("5, null, 3, null, 2, null, 4, null, 7, null, 6, null, 8");
        assertEquals(root0, root1);
        root = new TreeNode("1, 2, null, 3, null, 4, null, 5, null, 6, null, 7");
        root0 = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7");
        FlattenToLinkedList.flatten(root);
        assertEquals(root0, root);
    }

    @Test
    public void ifIsPreorderTraversalAfterSwappingNodes() {
        assertEquals(Collections.singletonList(-1), new IfIsPreorderTraversalAfterSwappingNodes(new TreeNode(1, new TreeNode(2), null), new int[]{2, 1}).execute());
        assertEquals(new ArrayList<>(), new IfIsPreorderTraversalAfterSwappingNodes(root, new int[]{0, -2, -4, -6, -7, -5, -3, -1, 2, 1, 4, 3, 5, 7, 6}).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27");
        assertEquals(Arrays.asList(1,3,7,6,13,12,2,5,11,10,8), new IfIsPreorderTraversalAfterSwappingNodes(root, new int[]{1,3,7,15,14,6,13,27,26,12,25,24,2,5,11,23,22,10,21,20,4,8,17,16,9,18,19}).execute());
    }

    @Test
    public void constructBinaryTreeFromPreorderAndPostorderTraversal() {
        assertNull(ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(new int[]{}, new int[]{}));
        assertEquals(new TreeNode(0), ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(new int[]{0}, new int[]{0}));
        int[] preorder = {0,-2,-4,-6,-7,-5,-3,-1,2,1,4,3,5,7,6};
        int[] postorder = {-7,-5,-6,-3,-4,-1,-2,1,3,6,7,5,4,2,0};
        root = new TreeNode("0, -2, 2, -4, -1, 1, 4, -6, -3, null, null, null, null, 3, 5, -7, -5, null, null, null, null, 7, null, null, null, null, null, 6");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(preorder, postorder));
        preorder = new int[]{1,2,4,8,5,3,6,7};
        postorder = new int[]{8,4,5,2,6,7,3,1};
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(preorder, postorder));
        preorder = new int[]{1,2,3,5,6,4,7,8};
        postorder = new int[]{6,5,3,7,8,4,2,1};
        root = new TreeNode("1, 2, null, 3, 4, 5, null, 7, 8, 6");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(preorder, postorder));
        preorder = new int[]{3, 0, 5, 12, 8, 1, 9, 16, 7, 6, 4, 18, 13, 2, 14, 10, 15, 11, 17};
        postorder = new int[]{12, 1, 16, 9, 8, 5, 6, 4, 7, 0, 10, 14, 15, 2, 11, 13, 17, 18, 3};
        root = new TreeNode("3, 0, 18, 5, 7, 13, 17, 12, 8, 6, 4, 2, 11, null, null, null, null, 1, 9, null, null, null, null, 14, 15, null, null, null, null, 16, null, 10");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(preorder, postorder));
        preorder = new int[]{1,2,3,4,5,6};
        postorder = new int[]{6,5,4,3,2,1};
        root = new TreeNode("1, 2, null, 3, null, 4, null, 5, null, 6");
        assertEquals(root, ConstructBinaryTreeFromPreorderAndPostorderTraversal.buildTree(preorder, postorder));
    }

    @Test
    public void maxPathSum() {
        assertEquals(25, new MaximumPathSum(root).execute());
        root = new TreeNode("-10, 9, 20, null, null, 15, 7");
        assertEquals(42, new MaximumPathSum(root).execute());
        root = new TreeNode("-1, -3, -2, -6, -4, -11, -5");
        assertEquals(-1, new MaximumPathSum(root).execute());
        root = new TreeNode("-3, -2, 0, -4, 3, -3, 3, null, null, -4, 1, 3, 3, -2, 3");
        assertEquals(6, new MaximumPathSum(root).execute());
    }

    @Test
    public void recoverTreeFromPreorderTraversal() {
        assertEquals(new TreeNode(1), RecoverTreeFromPreorderTraversal.recover("1"));
        assertNull(RecoverTreeFromPreorderTraversal.recover(""));
        assertEquals(new TreeNode("1, 2, 5, 3, null, 6, null, 4, null, 7"), RecoverTreeFromPreorderTraversal.recover("1-2--3---4-5--6---7"));
        assertEquals(new TreeNode("1, 2, 5, 3, 4, 6, 7"), RecoverTreeFromPreorderTraversal.recover("1-2--3--4-5--6--7"));
        assertEquals(new TreeNode("1, 401, null, 349, 88, 90"), RecoverTreeFromPreorderTraversal.recover("1-401--349---90--88"));
        assertEquals(new TreeNode("8, 5, 10, 1, 7, 9, 15, 6, 12, null, null, null, null, 13, 14, 5, 10, null, null, 7, 9, null, null, null, null, 8"), RecoverTreeFromPreorderTraversal.recover("8-5--1---6----5----10-----8---12--7-10--9--15---13----7----9---14"));
    }

    @Test
    public void maximumSumOfBinarySearchSubtree() {
        assertEquals(0, new MaximumSumOfBinarySearchSubtree(new TreeNode("-8, -3, -11, -1, -5, -9, -12")).execute());
        assertEquals(28, new MaximumSumOfBinarySearchSubtree(root).execute());
        assertEquals(20, new MaximumSumOfBinarySearchSubtree(new TreeNode("1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6")).execute());
        assertEquals(74, new MaximumSumOfBinarySearchSubtree(new TreeNode("8, 5, 10, 15, 7, 9, 17, 6, 16, null, null, null, null, 13, 16, 5, 10, null, null, 7, 9, null, null, null, null, 74, 13")).execute());
    }

    @Test
    public void binaryTreeZigzagLevelOrderTraversal() {
        assertEquals("[]", new BinaryTreeZigzagLevelOrderTraversal(null).execute().toString());
        assertEquals("[[1]]", new BinaryTreeZigzagLevelOrderTraversal(new TreeNode(1)).execute().toString());
        assertEquals("[[0], [2, -2], [-4, -1, 1, 4], [5, 3, -3, -6], [-7, -5, 7], [6]]", new BinaryTreeZigzagLevelOrderTraversal(root).execute().toString());
        root = new TreeNode("8, 5, 10, 15, 7, 9, 17, 6, 16, null, null, null, null, 13, 18, 5, 10, null, null, 7, 9, null, null, null, null, 74, 13, 55, null, 22, null, 7");
        assertEquals("[[8], [10, 5], [15, 7, 9, 17], [18, 13, 16, 6], [5, 10, 7, 9], [22, 55, 13, 74], [7]]", new BinaryTreeZigzagLevelOrderTraversal(root).execute().toString());
    }

    @Test
    public void constructBinaryTreeFromInorderAndPostorderTraversal() {
        assertNull(ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{}, new int[]{}));
        assertEquals(new TreeNode(-1), ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{-1}, new int[]{-1}));
        assertEquals(root, ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7}, new int[]{-7,-5,-6,-3,-4,-1,-2,1,3,6,7,5,4,2,0}));
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8");
        assertEquals(root, ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{8,4,2,5,1,6,3,7}, new int[]{8,4,5,2,6,7,3,1}));
        root = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6");
        assertEquals(root, ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{1,2,3,4,5,6}, new int[]{6,5,4,3,2,1}));
        root = new TreeNode("1, 2, null, 3, 4, 5, null, 7, 8, 6");
        assertEquals(root, ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{6, 5, 3, 2, 7, 4, 8, 1}, new int[]{6, 5, 3, 7, 8, 4, 2, 1}));
        root = new TreeNode("3, 0, 18, 5, 7, 13, 17, 12, 8, 6, 4, 2, 11, null, null, null, null, 1, 9, null, null, null, null, 14, 15, null, null, null, null, 16, null, 10");
        assertEquals(root, ConstructBinaryTreeFromInorderAndPostorderTraversal.buildTree(new int[]{12, 5, 1, 8, 16, 9, 0, 6, 7, 4, 3, 10, 14, 2, 15, 13, 11, 18, 17}, new int[]{12, 1, 16, 9, 8, 5, 6, 4, 7, 0, 10, 14, 15, 2, 11, 13, 17, 18, 3}));
    }

    @Test
    public void longestUnivaluePath() {
        assertEquals(0, new LongestUnivaluePath(null).execute());
        assertEquals(1, new LongestUnivaluePath(new TreeNode(1, new TreeNode(1), new TreeNode(-1))).execute());
        root = new TreeNode("1, 1, 1, 2, 3, 4, 1, 1");
        assertEquals(3, new LongestUnivaluePath(root).execute());
        root = new TreeNode("1, 2, 3, 4, 2, 3, 6, null, null, 2, null, 3, 7, null, null, null, null, null, 3");
        assertEquals(3, new LongestUnivaluePath(root).execute());
        root = new TreeNode("1, 1, 1, 2, 2, 3, 3, 2, null, 2, 2, null, 3, null, 3, 2, 3, null, 2, 3, 2, null, 3, 3, 2, 1, null, 2, 3, 1, 2, null, null, 3, null, 3, null, null, null, null, null, null, null, null, null, null, null, 3, 1, 1, 3, null, 3, null, null, null, null, 2, 1");
        assertEquals(5, new LongestUnivaluePath(root).execute());
    }

    @Test
    public void findDuplicateSubtrees() {
        List<TreeNode> result = new ArrayList<>();
        assertEquals(result, new FindDuplicateSubtrees(null).execute());
        assertEquals(result, new FindDuplicateSubtrees(root).execute());
        result.add(new TreeNode(3));
        result.add(new TreeNode(2, new TreeNode(3), null));
        assertEquals(result, new FindDuplicateSubtrees(new TreeNode("2, 2, 2, 3, null, 3")).execute());
        result = new ArrayList<>();
        result.add(new TreeNode(7));
        result.add(new TreeNode(1));
        result.add(new TreeNode(5, new TreeNode(7), new TreeNode(1)));
        result.add(new TreeNode(4));
        assertEquals(result, new FindDuplicateSubtrees(new TreeNode("2, 3, 12, 5, 12, 6, 4, 7, 1, 6, 4, 3, 5, null, null, null, null, null, null, null, null, null, null, null, null, 7, 1")).execute());
    }

    @Test
    public void smallestStringStartingFromLeaf() {
        root = new TreeNode("2, 2, 1, null, 1, 0, null, 0");
        assertEquals("abc", new SmallestStringStartingFromLeaf(root).execute());
        root = new TreeNode("25, 1, 3, 1, 3, 0, 2");
        assertEquals("adz", new SmallestStringStartingFromLeaf(root).execute());
        root = new TreeNode("25, 1, null, 0, 0, 1, null, null, null, 0");
        assertEquals("ababz", new SmallestStringStartingFromLeaf(root).execute());
        root = new TreeNode("0, null, 0, 0, 0, 0, 0, null, 0, 0, null, null, null, 0, 0, null, null, 0, null, null, 0");
        assertEquals("aaaa", new SmallestStringStartingFromLeaf(root).execute());
        root = new TreeNode("0, 1, 2, null, null, 0, 1, 1, null, null, 0, null, 0");
        assertEquals("abaca", new SmallestStringStartingFromLeaf(root).execute());
    }

    @Test
    public void longestZigZagPath() {
        assertEquals(0, new LongestZigZagPath(null).execute());
        assertEquals(0, new LongestZigZagPath(new TreeNode(5)).execute());
        assertEquals(2, new LongestZigZagPath(root).execute());
        root = new TreeNode("1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1");
        assertEquals(3, new LongestZigZagPath(root).execute());
        root = new TreeNode("1, 1, 1, null, 1, null, null, 1, 1, null, 1");
        assertEquals(4, new LongestZigZagPath(root).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, null, null, null, null, null, null,24, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,25,26, null, null,27,28");
        assertEquals(6, new LongestZigZagPath(root).execute());
    }

    @Test
    public void insertNodeInMaximumBinaryTree(){
        assertEquals(new TreeNode(5), InsertNodeInMaximumBinaryTree.insertNode(null, 5));
        assertEquals(new TreeNode(7, null, new TreeNode(5)), InsertNodeInMaximumBinaryTree.insertNode(new TreeNode(7), 5));
        root = new TreeNode("4, 1, 3, null, null, 2");
        assertEquals(new TreeNode("5, 4, null, 1, 3, null, null, 2"), InsertNodeInMaximumBinaryTree.insertNode(root, 5));
        root = new TreeNode("5, 2, 4, null, 1");
        assertEquals(new TreeNode("5, 2, 4, null, 1, null, 3"), InsertNodeInMaximumBinaryTree.insertNode(root, 3));
        root = new TreeNode("5, 2, 3, null, 1");
        assertEquals(new TreeNode("5, 2, 4, null, 1, 3"), InsertNodeInMaximumBinaryTree.insertNode(root, 4));
        root = new ConstructMaximumBinaryTree(new int[]{1,2,3,4,6,7}).execute();
        assertEquals(new TreeNode("7, 6, 5, 4, null, null, null, 3, null, 2, null, 1"), InsertNodeInMaximumBinaryTree.insertNode(root, 5));
    }

    @Test
    public void countNumberOfSumsOfPathsValues() {
        assertEquals(0, new CountNumberOfSumsOfPathsValues(null, 5).execute());
        assertEquals(3, new CountNumberOfSumsOfPathsValues(root, -6).execute());
        root = new TreeNode("1, null, 2, null, 3, null, 4, null, 5");
        assertEquals(2, new CountNumberOfSumsOfPathsValues(root, 3).execute());
        root = new TreeNode("1, -2, -3, 1, 3, -2, null, -1");
        assertEquals(4, new CountNumberOfSumsOfPathsValues(root, -1).execute());
        root = new TreeNode("10, 5, -3, 3, 2, null, 11, 3, -2, null, 1");
        assertEquals(3, new CountNumberOfSumsOfPathsValues(root, 8).execute());
        root = new TreeNode("5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1");
        assertEquals(3, new CountNumberOfSumsOfPathsValues(root, 22).execute());
    }

    @Test
    public void RootLeafPathsEqualTargetSum() {
        assertEquals(new ArrayList<>(), new RootLeafPathsEqualTargetSum(null, 1).execute());
        assertEquals(new ArrayList<>(), new RootLeafPathsEqualTargetSum(new TreeNode(1, new TreeNode(2), null), 1).execute());
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(5,4,11,2));
        result.add(Arrays.asList(5,8,4,5));
        root = new TreeNode("5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1");
        assertEquals(result, new RootLeafPathsEqualTargetSum(root, 22).execute());
        result = new ArrayList<>();
        result.add(Arrays.asList(1,3,2,1,0,1));
        result.add(Arrays.asList(1,3,2,2));
        result.add(Arrays.asList(1,3,4));
        root = new TreeNode("1, 2, 3, 4, 5, 2, 4, null, null, 1, null, 1, 2, null, null, null, null, 3, 0, null, null, null, null, 2, 1");
        assertEquals(result, new RootLeafPathsEqualTargetSum(root, 8).execute());
    }

    @Test
    public void binaryTreeCameras() {
        assertEquals(0, new BinaryTreeCameras(null).execute());
        assertEquals(1, new BinaryTreeCameras(new TreeNode("1, 2, null, 3, 4")).execute());
        assertEquals(2, new BinaryTreeCameras(new TreeNode("1, 2, null, 3, null, 4, null, null, 5")).execute());
        assertEquals(6, new BinaryTreeCameras(root).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 2, 4, null, null, 1, null, 1, 2, null, null, null, null, 3, 0, null, null, null, null, 2, 1");
        assertEquals(6, new BinaryTreeCameras(root).execute());
    }

    @Test
    public void countUnivalueSubtrees() {
        assertEquals(0, new CountUnivalueSubtrees(null).execute());
        assertEquals(1, new CountUnivalueSubtrees(new TreeNode(5)).execute());
        assertEquals(2, new CountUnivalueSubtrees(new TreeNode(5, new TreeNode(1), new TreeNode(3))).execute());
        assertEquals(5, new CountUnivalueSubtrees(new TreeNode("5, 4, 5, 4, 4, 5")).execute());
        assertEquals(8, new CountUnivalueSubtrees(new TreeNode("2, 1, 2, 2, 1, 3, 2, null, null, null, null, 3, 2, 2, 2, null, null, null, null, null, null, null, 2")).execute());
    }

    @Test
    public void houseRobber() {
        assertEquals(0, new HouseRobber(null).execute());
        assertEquals(5, new HouseRobber(new TreeNode(5)).execute());
        assertEquals(6, new HouseRobber(new TreeNode(5, new TreeNode(5), new TreeNode(1))).execute());
        root = new TreeNode("3, 2, 3, null, 3, null, 1");
        assertEquals(7, new HouseRobber(root).execute());
        root = new TreeNode("3, 4, 5, 1, 3, null, 1");
        assertEquals(9, new HouseRobber(root).execute());
        assertEquals(25, new HouseRobber(root1).execute());
        root = new TreeNode("11, 2, 5, 6, 9, 4, 12, 3, 8, 4, 7, 2, 3, null, null, null, null, 1, 5");
        assertEquals(51, new HouseRobber(root).execute());
    }

    @Test
    public void upsideDown() {
       assertEquals(new TreeNode(1), new UpsideDown(new TreeNode(1)).execute());
       assertEquals(new TreeNode("4, 5, 2, null, null, 3, 1"), new UpsideDown(new TreeNode("1, 2, 3, 4, 5")).execute());
       assertEquals(new TreeNode("6, 7, 5, null, null, null, 4, null, 2, 3, 1"), new UpsideDown(new TreeNode("1, 2, 3, 4, null, null, null, 5, null, 6, 7")).execute());
       assertEquals(new TreeNode("8, null, 7, null, 5, 6, 3, null, null, 4, 2, null, null, null, 1"), new UpsideDown(new TreeNode("1, 2, null, 3, 4, 5, 6, null, null, 7, null, null, null, 8")).execute());
    }

    @Test
    public void equalTreePartition() {
        assertFalse((Boolean) new EqualTreePartition(new TreeNode(1)).execute());
        assertTrue((Boolean) new EqualTreePartition(new TreeNode("5, 10, 10, 2, 3")).execute());
        assertFalse((Boolean) new EqualTreePartition(new TreeNode("5, 2, 11, 6, 9, 5, 12, 3, 8, 4, 7, 15, 10, null, null, null, null, 1, 17")).execute());
        assertTrue((Boolean) new EqualTreePartition(root).execute());
        assertFalse((Boolean) new EqualTreePartition(new TreeNode("1, 2, 3, 4, 5, 6, 7")).execute());
        assertTrue((Boolean) new EqualTreePartition(new TreeNode("1, null, 2, null, 3, null, 4, 1, null, 5, null, 6")).execute());
    }

    @Test
    public void longestConsecutiveSequence() {
        assertEquals(0, new LongestConsecutiveSequence(null).execute());
        assertEquals(1, new LongestConsecutiveSequence(new TreeNode(-1)).execute());
        assertEquals(2, new LongestConsecutiveSequence(new TreeNode(5, new TreeNode(4), new TreeNode(6))).execute());
        assertEquals(2, new LongestConsecutiveSequence(root).execute());
        root = new TreeNode("1, 2, 6, 7, 3, 4, 7, null, null, 4, 5, null, null, 5, 8, 1, 5, null, null, null, null, 9, 7, null, null, null, null, 10, 8, null, null, 7, 11");
        assertEquals(6, new LongestConsecutiveSequence(root).execute());
        root = new TreeNode("1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, null, null, 5, 5, null, 5, 5, 4, 6, null, 5, null, 7, 5, 5, null, null, 6, null, 6, 6, null, 6, 7, 5, null, 5, 6, 6, 5, null, null, 8, 7, 6, null, 5, 6, 6, 7, null, 7, 6, 5, null, null, 8, 7, 6, 5, null, null, 7, null, null, 7, 6, 7, 9, 7, null, null, null, 7, 6, null, 7, null, 7, 7, 7, 8, 8, null, null, 7, 6, null, 9, null, 8, 7, 7, null, null, null, null, 8, 8, null, null, null, null, null, null, null, null, null, null, null, null, null, 8, null, 7, null, null, null, 8, null, null, 9, null, 9, null, null, null, null, null, 10, 9, null, 8, null, null, 8, 9, null, null, 9, 9, null, 8, null, null, null, 10, null, null, 10, 11, null, null, null, null, 9, null, 9, 10, null, null, 9, null, null, null, 8, 11, null, 10, null, null, 12, 10, null, null, 11, 9, null, 9, null, null, 12, null, null, 13, null, null, 10, 11, null, null, null, 9, null, null, null, 14, null, null, null, null, null, 10, null, null, 15");
        assertEquals(11, new LongestConsecutiveSequence(root).execute());
    }

    @Test
    public void serialization() {
        String serial = new Serialization().serialize(root);
        String serial1 = new Serialization().serialize(root1);
        assertEquals(root1, new Serialization().deserialize(serial1));
        assertEquals(root, new Serialization().deserialize(serial));
    }

    @Test
    public void boundaryOfBinaryTree() {
        assertEquals(new ArrayList<>(), new BoundaryOfBinaryTree(null).execute());
        assertEquals(Collections.singletonList(5), new BoundaryOfBinaryTree(new TreeNode(5)).execute());
        List<Integer> list = Arrays.asList(0,-2,-4,-6,-7,-5,-3,-1,1,3,6,7,5,4,2);
        assertEquals(list, new BoundaryOfBinaryTree(root).execute());
        root = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6");
        list = Arrays.asList(1,6,5,4,3,2);
        assertEquals(list, new BoundaryOfBinaryTree(root).execute());
        root = new TreeNode("1, 2, null, 3, null, 4, null, 5, null, 6");
        list = Arrays.asList(1,2,3,4,5,6);
        assertEquals(list, new BoundaryOfBinaryTree(root).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, null, 8, 9, 10, 11, 12, 13, null, null, 14, null, 15, 16, 17, 18, 19, 20, 21, 22, null, 23, 24, null, 25, 26, null, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, null, null, null, 38, 39, null, null, 40, null, 41, 42, null, null, null, null, 43, 44, null, null, 45, 46, 47, 48, null, null, 49, null, null, 50, null, null, null, null, 51, 52, 53, 54, null, 55, null, null, 56, 57, null, null, null, null, 58, null, null, 59, null, null, 60, 61, null, null, 62, null, null, null, 63, 64, null, null, null, null, 65, 66, null, null, null, null, 67, null, null, null, 68, 69, null, null, 70");
        list = Arrays.asList(1,2,4,8,14,23,38,62,52,25,70,64,54,55,42,28,29,65,66,57,44,31,45,58,67,48,34,60,68,69,50,37,22,13,7,3);
        assertEquals(list, new BoundaryOfBinaryTree(root).execute());
    }

    @Test
    public void closestLeaf() {
        assertEquals(-1, new ClosestLeaf(null, 1).execute());
        assertEquals(1, new ClosestLeaf(new TreeNode(1), 1).execute());
        assertEquals(-1, new ClosestLeaf(new TreeNode(1), 0).execute());
        assertEquals(6, new ClosestLeaf(root, 5).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, null, null, 17, 18, 19, 20, 21, 22, 23, null, 24, null, 25, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 26, 27, null, 28, null, 29, null, null, 30, null, 31, null, 32, 33, null, 34, 35, 36, 37, 38, null, 39, 40, 41, 42, 43, 44, 45, 46, null, null, 47, 48, 49, 50, 51, 52, 53, 54, 55");
        assertEquals(15, new ClosestLeaf(root, 12).execute());
        assertEquals(50, new ClosestLeaf(root, 23).execute());
        assertEquals(-1, new ClosestLeaf(root, 56).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, null, 8, 9, 10, 11, 12, 13, null, null, 14, null, 15, 16, 17, 18, 19, 20, 21, 22, null, 23, 24, null, 25, 26, null, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, null, null, null, 38, 39, null, null, 40, null, 41, 42, null, null, null, null, 43, 44, null, null, 45, 46, 47, 48, null, null, 49, null, null, 50, null, null, null, null, 51, 52, 53, 54, null, 55, null, null, 56, 57, null, null, null, null, 58, null, null, 59, null, null, 60, 61, null, null, 62, null, null, null, 63, 64, null, null, null, null, 65, 66, null, null, null, null, 67, null, null, null, 68, 69, null, null, 70");
        assertEquals(23, new ClosestLeaf(root, 1).execute());
        assertEquals(29, new ClosestLeaf(root, 6).execute());
    }

    @Test
    public void leavesOfBinaryTree() {
        assertEquals(new ArrayList<>(), new LeavesOfBinaryTree(null ).execute());
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(-7, -5, -3, -1, 1, 3, 6));
        result.add(Arrays.asList(-6, 7));
        result.add(Arrays.asList(-4, 5));
        result.add(Arrays.asList(-2, 4));
        result.add(Collections.singletonList(2));
        result.add(Collections.singletonList(0));
        assertEquals(result, new LeavesOfBinaryTree(root).execute());
        root = new TreeNode("5, 2, 11, 6, 9, 5, 12, 3, 8, 4, 7, 15, 10, null, null, null, null, 1, 14");
        result = new ArrayList<>();
        result.add(Arrays.asList(3, 1, 14, 4, 7, 15, 10, 12));
        result.add(Arrays.asList(8, 9, 5));
        result.add(Arrays.asList(6, 11));
        result.add(Collections.singletonList(2));
        result.add(Collections.singletonList(5));
        assertEquals(result, new LeavesOfBinaryTree(root).execute());
        root = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6");
        result = new ArrayList<>();
        result.add(Collections.singletonList(6));
        result.add(Collections.singletonList(5));
        result.add(Collections.singletonList(4));
        result.add(Collections.singletonList(3));
        result.add(Collections.singletonList(2));
        result.add(Collections.singletonList(1));
        assertEquals(result, new LeavesOfBinaryTree(root).execute());

    }

    @Test
    public void isSequenceAPathFromRootToLeaf() {
        assertTrue(IsSequenceAPathFromRootToLeaf.check(null, new int[]{}));
        assertTrue(IsSequenceAPathFromRootToLeaf.check(new TreeNode("1, 2, 3"), new int[]{1, 3}));
        assertFalse(IsSequenceAPathFromRootToLeaf.check(null, new int[]{1, 2}));
        assertFalse(IsSequenceAPathFromRootToLeaf.check(new TreeNode("1, 2, 3"), new int[]{}));
        assertFalse(IsSequenceAPathFromRootToLeaf.check(new TreeNode(1), new int[]{1, 3, 5}));
        assertFalse(IsSequenceAPathFromRootToLeaf.check(root, new int[]{0, 2, 4, 5, 7}));
        assertFalse(IsSequenceAPathFromRootToLeaf.check(root, new int[]{0, 2, 4, 5, 8, 6}));
        assertTrue(IsSequenceAPathFromRootToLeaf.check(root, new int[]{0, -2, -4, -6, -5}));
        root = new TreeNode("1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, null, 1, null, 0, null, null, null, null, 1, null, null, 0, null, null, 0, null, null, null, 1");
        assertTrue(IsSequenceAPathFromRootToLeaf.check(root, new int[]{1,0,0,0,0}));
    }

    @Test
    public void splitBST() {
        assertArrayEquals(new TreeNode[]{null,null}, (TreeNode[]) new Split(null, 1).execute());
        root1 = new TreeNode("4, 2, 6, 1, 3, 5, 7");
        TreeNode[] result = new TreeNode[]{new TreeNode("2, 1"), new TreeNode("4, 3, 6, null, null, 5, 7")};
        assertArrayEquals(result, (TreeNode[]) new Split(root1, 2).execute());
        result = new TreeNode[]{new TreeNode("-2, -4, -1, -6, -3, null, null, -7, -5"), new TreeNode("0, null, 2, 1, 4, null, null, 3, 5, null, null, null, 7, 6")};
        assertArrayEquals(result, (TreeNode[]) new Split(root, -1).execute());
        result = new TreeNode[] {root, null};
        assertArrayEquals(result, (TreeNode[]) new Split(root, 8).execute());
        result = new TreeNode[] {null, root};
        assertArrayEquals(result, (TreeNode[]) new Split(root, -10).execute());
        root1 = new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7");
        result = new TreeNode[] {new TreeNode("1, null, 2, null, 3, null, 4, null, 5, null, 6"), new TreeNode(7)};
        assertArrayEquals(result, (TreeNode[])  new Split(root1, 6).execute());
    }

    @Test
    public void inorderSuccessor() {
        assertNull(new InorderSuccessor(new TreeNode(7), null).execute());
        assertNull(new InorderSuccessor(null, new TreeNode(1)).execute());
        assertNull(new InorderSuccessor(new TreeNode(1), new TreeNode(1)).execute());
        assertEquals(new TreeNode(6), new InorderSuccessor(root, new TreeNode("5, null, 7, 6")).execute());
        assertEquals(new TreeNode(1), new InorderSuccessor(root, root).execute());
        assertEquals(new TreeNode("-2, -4, -1, -6, -3, null, null, -7, -5"), new InorderSuccessor(root, new TreeNode(-3)).execute());
    }

    @Test
    public void largestBSTSubtree() {
        assertEquals(0, new LargestBSTSubtree(null).execute());
        assertEquals(1, new LargestBSTSubtree(new TreeNode(5)).execute());
        assertEquals(1, new LargestBSTSubtree(new TreeNode("2, -1, 1")).execute());
        assertEquals(7, new LargestBSTSubtree(new TreeNode("10, 3, 9, 1, 7, 2, 11, -2, 4, 5, 9, 1, 4, null, 13, -4, 0, 2, null, 3, 6, 8, 12")).execute());
        assertEquals(9, new LargestBSTSubtree(new TreeNode("8, 4, 15, 2, 7, 10, 25, null, null, 5, 9, 8, 13, 20, 27, 4, 6, 8, null, null, null, null, null, 16, 22")).execute());
        assertEquals(15, new LargestBSTSubtree(root).execute());
    }

    @Test
    public void twoSumBSTs() {
        assertFalse((Boolean) new TwoSum(null, new TreeNode(1), 1).execute());
        assertFalse((Boolean) new TwoSum(new TreeNode(2), null,0).execute());
        assertTrue((Boolean) new TwoSum(new TreeNode(1), new TreeNode(5), 6).execute());
        assertFalse((Boolean) new TwoSum(new TreeNode(2, new TreeNode(1), null), new TreeNode(2), 2).execute());
        assertTrue((Boolean) new TwoSum(root, root1, -5).execute());
        assertFalse((Boolean) new TwoSum(root, root1, 16).execute());
        root = new TreeNode("10, 3, 15, -1, 7, 11, 17, -3, 1, 5, 9, null, null, null, 19");
        root1 = new TreeNode("25, 13, 33, 9, 20, 28, 38, 7, 11, 15, 23, 27, 31, 42");
        assertTrue((Boolean) new TwoSum(root, root1, 29).execute());
        assertFalse((Boolean) new TwoSum(root, root1, 11).execute());
    }

    @Test
    public void recoverContaminatedBinaryTree() {
        RecoverContaminatedBinaryTree recoverContaminatedBinaryTree = new RecoverContaminatedBinaryTree(root);
        assertFalse(recoverContaminatedBinaryTree.find(9));
        assertTrue(recoverContaminatedBinaryTree.find(13));
        assertFalse(recoverContaminatedBinaryTree.find(12));
        assertTrue(recoverContaminatedBinaryTree.find(16));
        assertFalse(recoverContaminatedBinaryTree.find(17));
        assertTrue(recoverContaminatedBinaryTree.find(30));
        assertFalse(recoverContaminatedBinaryTree.find(29));
        assertTrue(recoverContaminatedBinaryTree.find(61));
        root = new TreeNode("-1, null, -1, -1, null, -1, -1, -1, null, null, -1, null, -1, -1, null, -1, -1, -1, -1");
        recoverContaminatedBinaryTree = new RecoverContaminatedBinaryTree(root);
        assertFalse(recoverContaminatedBinaryTree.find(1));
        assertTrue(recoverContaminatedBinaryTree.find(5));
        assertFalse(recoverContaminatedBinaryTree.find(24));
        assertTrue(recoverContaminatedBinaryTree.find(26));
        assertFalse(recoverContaminatedBinaryTree.find(47));
        assertTrue(recoverContaminatedBinaryTree.find(48));
        assertFalse(recoverContaminatedBinaryTree.find(54));
        assertTrue(recoverContaminatedBinaryTree.find(53));
        assertFalse(recoverContaminatedBinaryTree.find(100));
        assertTrue(recoverContaminatedBinaryTree.find(107));
    }

    @Test
    public void maximumAverageSubtree() {
        assertEquals(0.0, new MaximumAverageSubtree(null).execute());
        assertEquals(1.0, new MaximumAverageSubtree(new TreeNode(1)).execute());
        assertEquals(8.0, new MaximumAverageSubtree(root1).execute());
        assertEquals( 6.5, new MaximumAverageSubtree(root).execute());
        root = new TreeNode("22, 19, 18, 16, 20, 21, 14, null, 10, 5, 12, 10, 16, null, 13, 3, 12, null, -3, 11, 13, 12, 5, 8, 14, 2, -1, null, null, 6, null, null, null, 4, null, null, 8, 7, 5, null, null, null, null, 1, 9");
        assertEquals(10.5, new MaximumAverageSubtree(root).execute());
    }

    @Test
    public void distanceBetweenTwoNodes() {
        assertEquals(-1, new DistanceBetweenTwoNodes(null, 1, 2).execute());
        assertEquals(-1, new DistanceBetweenTwoNodes(new TreeNode(5), 1, 2).execute());
        assertEquals(0, new DistanceBetweenTwoNodes(new TreeNode(2), 2, 2).execute());
        assertEquals(2, new DistanceBetweenTwoNodes(new TreeNode(2, new TreeNode(1), new TreeNode(3)), 1, 3).execute());
        assertEquals(4, new DistanceBetweenTwoNodes(root, 6, 3).execute());
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, null, null, 17, 18, 19, 20, 21, 22, 23, null, 24, null, 25, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 26, 27, null, 28, null, 29, null, null, 30, null, 31, null, 32, 33, null, 34, 35, 36, 37, 38, null, 39, 40, 41, 42, 43, 44, 45, 46, null, null, 47, 48, 49, 50, 51, 52, 53, 54, 55");
        long t1 = System.nanoTime();
        int result = (int) new DistanceBetweenTwoNodes(root, 51, 46).execute();
        long t2 = System.nanoTime();
        System.out.println("Time for two recursive methods: " + (t2-t1));
        t1 = System.nanoTime();
        int result1 = (int) new DistanceBetweenTwoNodes(root, 51, 46, true).execute();
        t2 = System.nanoTime();
        System.out.println("Time for level traversal: " + (t2-t1));
        assertEquals(10, result);
        assertEquals(10, result1);
        root = new TreeNode("1, 2, 3, 4, 5, 6, 7, null, 8, 9, 10, 11, 12, 13, null, null, 14, null, 15, 16, 17, 18, 19, 20, 21, 22, null, 23, 24, null, 25, 26, null, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, null, null, null, 38, 39, null, null, 40, null, 41, 42, null, null, null, null, 43, 44, null, null, 45, 46, 47, 48, null, null, 49, null, null, 50, null, null, null, null, 51, 52, 53, 54, null, 55, null, null, 56, 57, null, null, null, null, 58, null, null, 59, null, null, 60, 61, null, null, 62, null, null, null, 63, 64, null, null, null, null, 65, 66, null, null, null, null, 67, null, null, null, 68, 69, null, null, 70");
        t1 = System.nanoTime();
        result = (int) new DistanceBetweenTwoNodes(root, 41, 62, true).execute();
        t2 = System.nanoTime();
        System.out.println("Time for level traversal: " + (t2-t1));
        t1 = System.nanoTime();
        result1 = (int) new DistanceBetweenTwoNodes(root, 41, 62).execute();
        t2 = System.nanoTime();
        System.out.println("Time for two recursive methods: " + (t2-t1));
        assertEquals(12, result1);
        assertEquals(12, result);
    }

    @Test
    public void printTNRC() {
        TreeNodeRightConnected left = new TreeNodeRightConnected(2, new TreeNodeRightConnected(4, new TreeNodeRightConnected(8), new TreeNodeRightConnected(9)), new TreeNodeRightConnected(5));
        TreeNodeRightConnected right = new TreeNodeRightConnected(3, new TreeNodeRightConnected(6), new TreeNodeRightConnected(7));
        TreeNodeRightConnected tnrc = new TreeNodeRightConnected(1, left, right);
        System.out.println(tnrc);
        System.out.println(TreeNodeRightConnected.connect(tnrc));
        tnrc = new TreeNodeRightConnected(root);
        System.out.println(tnrc);
    }

    private TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        List<Integer> values = new ArrayList<>();
        int prevIndex = 0;
        int indexOfNextComma = data.indexOf(',');
        while(indexOfNextComma != -1) {
            String currentNodeValue = data.substring(prevIndex, indexOfNextComma);
            if (currentNodeValue.equals("-")) values.add(null);
            else values.add(Integer.parseInt(currentNodeValue));
            prevIndex = indexOfNextComma + 1;
            indexOfNextComma = data.indexOf(',', prevIndex);
        }
        values.add(Integer.parseInt(data.substring(prevIndex)));
        return createTree(values);
    }

    private TreeNode createTree(List<Integer> values) {
        int index = 0;
        Integer current = values.get(index);
        if (current == null) return null;
        TreeNode node = new TreeNode(current);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.pop();
                if (2*index+1 >= values.size()) return node;
                current = values.get(2*index+1);
                if (current != null) {
                    currentNode.left = new TreeNode(current);
                    queue.offer(currentNode.left);
                }
                if (2*index+2 >= values.size()) return node;
                current = values.get(2*index+2);
                if (current != null) {
                    currentNode.right = new TreeNode(current);
                    queue.offer(currentNode.right);
                }
                index++;
            }
        }
    }
}