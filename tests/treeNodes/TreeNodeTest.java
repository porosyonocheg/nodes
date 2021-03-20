package treeNodes;

import org.junit.Test;
import treeNodes.binarySearchTree.*;

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

}