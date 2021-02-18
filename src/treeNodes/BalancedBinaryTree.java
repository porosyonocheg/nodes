package treeNodes;

/**Определяет является ли данное дерево сбалансированным. Сбалансированным считается дерево, левое и правое поддерево
 * каждого узла которого отличаются в глубину не более чем на 1*/

public class BalancedBinaryTree extends Command {
    public BalancedBinaryTree(TreeNode root) {
        super(root);
    }

    private int isBalancedBinaryTree(TreeNode node) {
        if (node == null) return 0;
        int left = isBalancedBinaryTree(node.left);
        if (left == -1) return -1;
        int right = isBalancedBinaryTree(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    @Override
    Object execute() {
        return isBalancedBinaryTree(root) != -1;
    }
}
