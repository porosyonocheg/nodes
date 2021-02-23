package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Подсчитывает минимальную разницу между значениями узлов в бинарном дереве поиска
 * @author Сергей Шершавин*/

public class MinimumAbsoluteDifference extends Command {

    public MinimumAbsoluteDifference(TreeNode root) {
        super(root);
    }

    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    private int getMinimumDifference(TreeNode root) {
        if (root == null) return minDiff;
        getMinimumDifference(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val-prev);
            if (minDiff == 0) return 0;
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return minDiff;
    }

    @Override
    public Object execute() {
        return getMinimumDifference(root);
    }
}
