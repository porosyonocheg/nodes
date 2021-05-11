package treeNodes;

/**Возвращает поддерево, содержащее все узлы, находящиеся на максимальной глубине для данного дерева
 * @author Сергей Шершавин*/

public class SmallestSubtreeWithAllTheDeepestNodes extends Command {

    public SmallestSubtreeWithAllTheDeepestNodes(TreeNode root) {
        super(root);
    }

    private TreeNode lowestCommonAncestor(TreeNode node, int depth) {
        if (node == null) return null;
        if (depth == 1) return node;
        TreeNode left = lowestCommonAncestor(node.left, depth - 1), right = lowestCommonAncestor(node.right, depth - 1);
        if (left != null && right != null) return node;
        return left == null ? right : left;
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Override
    public Object execute() {
        return lowestCommonAncestor(root, maxDepth(root));
    }
}
