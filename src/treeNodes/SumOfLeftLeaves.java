package treeNodes;

/** Подсчёт суммы левых листьев дерева
 * @author Сергей Шершавин*/

public class SumOfLeftLeaves extends Command {
    private int summa = 0;

    public SumOfLeftLeaves(TreeNode root) {
        super(root);
    }

    private int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return summa;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            summa += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return summa;
    }

    @Override
    public Object execute() {
        return sumOfLeftLeaves(root);
    }
}
