package treeNodes;

/**Определяет являются ли все значения узлов данного дерева одинаковыми
 * @author Сергей Шершавин*/

public class UnivalentBinaryTree extends Command {

    public UnivalentBinaryTree(TreeNode root) {
        super(root);
    }

    private boolean isUnivalentTree(TreeNode node, int val) {
        if (node.val != val) return false;
        if (node.right != null && node.left != null) {
            return isUnivalentTree(node.left, val) && isUnivalentTree(node.right, val);
        }
        if (node.right != null)
            return isUnivalentTree(node.right, val);
        if (node.left != null)
            return isUnivalentTree(node.left, val);
        return true;
    }

    @Override
    Object execute() {
        if (root.left == null && root.right == null) return true;
        if (root.left == null) return isUnivalentTree(root.right, root.val);
        if (root.right == null) return isUnivalentTree(root.left, root.val);
        return isUnivalentTree(root.left, root.val) && isUnivalentTree(root.right, root.val);
    }
}
