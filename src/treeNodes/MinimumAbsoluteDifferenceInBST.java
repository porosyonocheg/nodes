package treeNodes;

/** Подсчитывает минимальную разницу между значениями узлов в бинарном дереве поиска
 * @author Сергей Шершавин*/

public class MinimumAbsoluteDifferenceInBST extends Command {

    public MinimumAbsoluteDifferenceInBST(TreeNode root) {
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
    Object execute() {
        return getMinimumDifference(root);
    }
}
