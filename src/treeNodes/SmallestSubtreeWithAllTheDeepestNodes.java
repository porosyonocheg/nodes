package treeNodes;

import java.util.ArrayList;
import java.util.List;

/**Возвращает поддерево, содержащее все узлы, находящиеся на максимальной глубине для данного дерева
 * @author Сергей Шершавин*/

public class SmallestSubtreeWithAllTheDeepestNodes extends Command {

    public SmallestSubtreeWithAllTheDeepestNodes(TreeNode root) {
        super(root);
    }

    private void deepestLeaves(TreeNode node, int depth, int maxDepth, List<TreeNode> nodes) {
        if (node.left != null) deepestLeaves(node.left, depth + 1, maxDepth, nodes);
        if (node.right != null) deepestLeaves(node.right, depth + 1, maxDepth, nodes);
        if (depth == maxDepth) nodes.add(node);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    @Override
    public Object execute() {
        TreeNode ancestor = null;
        List<TreeNode> deepestNodes = new ArrayList<>();
        int maxDepth = (int) new MaxDepthOfTree(root).execute();
        deepestLeaves(root, 1, maxDepth, deepestNodes);
        for (TreeNode n : deepestNodes) {
            ancestor = lowestCommonAncestor(root, ancestor, n);
        }
        return ancestor;
    }
}
