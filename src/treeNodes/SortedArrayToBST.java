package treeNodes;

public class SortedArrayToBST {
    private int[] nums;
    public SortedArrayToBST(int[] nums) {
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

    Object execute() {
        if (nums.length == 0) return null;
        return constructBinaryTree(nums, 0, nums.length-1);
    }
}
