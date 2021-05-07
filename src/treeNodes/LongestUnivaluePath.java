package treeNodes;

/**Возвращает длину маскимального пути в дереве, состоящего из одинаковых значений узлов
 * @author Сергей Шершавин*/

public class LongestUnivaluePath extends Command {
    private int maxLength;
    public LongestUnivaluePath(TreeNode root) {
        super(root);
        maxLength = 0;
    }

    private int traversalTree(TreeNode node, int val) {
        if (node == null) return 0;
        int left = traversalTree(node.left, node.val);
        int right = traversalTree(node.right, node.val);
        maxLength = Math.max(maxLength, left + right);
        if (val == node.val) return Math.max(left, right) + 1;
        return 0;
    }

    @Override
    public Object execute() {
        if (root == null) return 0;
        traversalTree(root, root.val);
        return maxLength;
    }
}
