package treeNodes;

/** Находит максимальную абсолютную разницу между значениями предков и потомков в дереве
 * @author Сергей Шершавин*/

public class MaximumAncestorNodeDifference extends Command {
    private int minDiff = 0;

    public MaximumAncestorNodeDifference(TreeNode root) {
        super(root);
    }

    private void maxAncestorDiff(TreeNode node, int maxAncestor, int minDescendant) {
        if (node == null) return;
        if (node.val > maxAncestor) {
            maxAncestor = node.val;
            int minDiffLocal = Math.abs(maxAncestor - minDescendant);
            if (minDiffLocal > minDiff) {
                minDiff = minDiffLocal;
            }
        }
        if (node.val < minDescendant) {
            minDescendant = node.val;
            int minDiffLocal = Math.abs(maxAncestor - minDescendant);
            if (minDiffLocal > minDiff) {
                minDiff = minDiffLocal;
            }
        }
        maxAncestorDiff(node.left, maxAncestor, minDescendant);
        maxAncestorDiff(node.right, maxAncestor, minDescendant);
    }

    @Override
    public Object execute() {
        maxAncestorDiff(root.left, root.val, root.val);
        maxAncestorDiff(root.right, root.val, root.val);
        return minDiff;
    }
}
