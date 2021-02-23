package treeNodes.binarySearchTree;

import treeNodes.TreeNode;

/** Создаёт бинарное дерево поиска из отсортированного массива
 * @author  Сергей Шершавин*/

public class ConvertSortedArrayToBST {
    private int[] nums;
    public ConvertSortedArrayToBST(int[] nums) {
        this.nums = nums;
    }

    private TreeNode constructBinaryTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = constructBinaryTree(nums, left, middle-1);
        root.right = constructBinaryTree(nums, middle+1, right);
        return root;
    }

    public Object execute() {
        if (nums.length == 0) return null;
        return constructBinaryTree(nums, 0, nums.length-1);
    }
}
